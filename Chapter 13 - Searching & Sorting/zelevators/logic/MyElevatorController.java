package logic;

import game.ElevatorController;
import game.Game;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyElevatorController implements ElevatorController {

    private Game game;
    private Map<Integer, List<Integer>> elevatorFloorRequests;
    private Map<Integer, ElevatorController.Direction> elevatorDirections;

    public MyElevatorController() {
        elevatorFloorRequests = new HashMap<>();
        elevatorDirections = new HashMap<>();
    }

    public String getStudentName() {
        return "Advaith Vecham";
    }

    public int getStudentPeriod() {
        return 2;
    }

    public void onGameStarted(Game game) {
        this.game = game;
        int elevatorCount = game.getElevatorCount();
        for (int i = 0; i < elevatorCount; i++) {
            elevatorFloorRequests.put(i, new ArrayList<>());
            elevatorDirections.put(i, ElevatorController.Direction.Up);
        }
    }

    public void onElevatorRequestChanged(int floorIdx, ElevatorController.Direction dir, boolean reqEnable) {
        if (reqEnable) {
            int idleElevator = findIdleElevator(dir);
            if (idleElevator != -1) {
                gotoFloor(idleElevator, floorIdx);
                elevatorDirections.put(idleElevator, dir);
            }
        }
    }

    public void onFloorRequestChanged(int elevatorIdx, int floorIdx, boolean reqEnable) {
        if (reqEnable) {
            elevatorFloorRequests.get(elevatorIdx).add(floorIdx);
        } else {
            elevatorFloorRequests.get(elevatorIdx).remove((Integer) floorIdx);
        }
    }

    public void onElevatorArrivedAtFloor(int elevatorIdx, int floorIdx, ElevatorController.Direction travelDirection) {
        List<Integer> requests = elevatorFloorRequests.get(elevatorIdx);
        if (requests.contains(floorIdx)) {
            requests.remove((Integer) floorIdx);
        }

        if (requests.isEmpty()) {
            int nextFloor = findNearestRequest(elevatorIdx, floorIdx, travelDirection);
            if (nextFloor != -1) {
                gotoFloor(elevatorIdx, nextFloor);
            }
        } else {
            int nextFloor = requests.get(0);
            gotoFloor(elevatorIdx, nextFloor);
        }
    }

    public void onUpdate(double deltaTime) {
        if (game == null) {
            return;
        }

        int elevatorCount = game.getElevatorCount();
        for (int i = 0; i < elevatorCount; i++) {
            if (game.isElevatorIdle(i)) {
                int currentFloor = (int) game.getElevatorFloor(i);
                ElevatorController.Direction dir = elevatorDirections.get(i);
                int nextFloor = findNearestRequest(i, currentFloor, dir);
                if (nextFloor != -1) {
                    gotoFloor(i, nextFloor);
                }
            }
        }
    }

    private int findIdleElevator(ElevatorController.Direction dir) {
        int elevatorCount = game.getElevatorCount();
        for (int i = 0; i < elevatorCount; i++) {
            if (game.isElevatorIdle(i)) {
                return i;
            }
        }
        return -1;
    }

    private int findNearestRequest(int elevatorIdx, int currentFloor, ElevatorController.Direction dir) {
        List<Integer> requests = elevatorFloorRequests.get(elevatorIdx);
        int nearestFloor = -1;
        int minDistance = Integer.MAX_VALUE;

        for (int floor : requests) {
            int distance = Math.abs(floor - currentFloor);
            if (distance < minDistance) {
                minDistance = distance;
                nearestFloor = floor;
            }
        }

        return nearestFloor;
    }
}
