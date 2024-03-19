package ai;

import java.util.ArrayList;

import game.Game;
import game.GameObject;
import game.PowerUp;
import game.Tank;
import game.TankAIBase;
import game.Target;
import game.Vec2;

public class TankAI extends TankAIBase {

    int calculatePoints = 0;
    public String getPlayerName() {
        return "Advaith";  // <---- Put your first name here
    }
    public int getPlayerPeriod() {
        return 2;                // <---- Put your period here
    }
        
    // You are free to add member variables & methods to this class (and delete this comment).
    //  You should use the methods in its base class (TankAIBase) to query the world. 
    //  Note that you are not allowed to reach into game code directly or make any
    //  modifications to code in the game package. Use your judgement and ask your 
    //  teacher if you are not sure. If it feels like cheating, it probably is.

    public boolean updateAI() {
        // Target[] getPowerPos = this.getTargets();
        // Vec2[] powerPos = { getPowerPos[0].getPos(), getPowerPos[1].getPos(), getPowerPos[2].getPos() };
        // // String[] powerType = { getPowerPos[0].getType(), getPowerPos[1].getType(), getPowerPos[2].getType() };
        // double minDist = 100000;
        // int closestPowerup = 0;
        // Vec2 tankPos = this.getTankPos();
        // double timeRemaining = getLevelTimeRemaining();

        // if (timeRemaining > 40) {
        //     for (int i = 0; i < 3; i++) {
        //         if (getDistance(tankPos, powerPos[i]) < minDist) { //&& powerType[i] == "S")
        //             minDist = getDistance(tankPos, powerPos[i]);
        //             closestPowerup = i;
        //         }
        //     }
        //     int moveX = getDifference(powerPos[closestPowerup].x, tankPos.x);
        //     int moveY = getDifference(powerPos[closestPowerup].y, tankPos.y);
        //     // a is powerpos
        //     // b is tankpos
        //     if( getDifference(powerPos[closestPowerup].x, tankPos.x) > getTankShotRange()){
        //         if(powerPos[closestPowerup].x < getTankPos().x){
        //             moveX = (int)(-1 * getDifference(powerPos[closestPowerup].x, tankPos.x) + getTankShotRange());
        //         }
        //     }
        //     if( getDifference(powerPos[closestPowerup].y, tankPos.y) > getTankShotRange()){
        //         if(powerPos[closestPowerup].y < getTankPos().y){
        //             moveY = (int)(-1 * getDifference(powerPos[closestPowerup].y, tankPos.y) + getTankShotRange());
        //         }
        //     }
        //     queueCmd("shoot", new Vec2(, getDifference(powerPos[closestPowerup].y, tankPos.y)));
        // }

        // else {
        //     for (int i = 0; i < 3; i++) {
        //         if (getDistance(tankPos, powerPos[i]) < minDist) {
        //             minDist = getDistance(tankPos, powerPos[i]);
        //             closestPowerup = i;
        //         }
        //         queueCmd("move", new Vec2(getDifference(powerPos[closestPowerup].x, tankPos.x), 0));
        //         queueCmd("move", new Vec2(0, getDifference(powerPos[closestPowerup].y, tankPos.y)));
        //     }

        // }

        // return true;
        // if(calculatePoints > 620){
        //     return true;
        // }

        // ArrayList<GameObject> allobjects = new ArrayList<GameObject>();
        // for(GameObject each:getPowerUps()){
        //     allobjects.add(each);
        // }
        // for(GameObject each:getTargets()){
        //     allobjects.add(each);
        // }

        // double closestDistance = Integer.MAX_VALUE;
        // int objectNum = -1;
        // for(GameObject each:allobjects){
        //     if(getTankPos().distance(each.getPos()) < closestDistance){
        //         closestDistance = getTankPos().distance(each.getPos());
        //         objectNum = allobjects.indexOf(each);
        //     } 
        // }

        // if(allobjects.get(objectNum) instanceof PowerUp) {
        //     queueCmd("move", new Vec2(allobjects.get(objectNum).getPos().x - getTankPos().x, 0));
        //     queueCmd("move", new Vec2(0, allobjects.get(objectNum).getPos().y - getTankPos().y));
        //     calculatePoints -= 2;
        // }
        
        // if(allobjects.get(objectNum).getPos().x == getTankPos().x){
        //     queueCmd("move", new Vec2((int)(allobjects.get(objectNum).getPos().x - getTankShotRange()), 0));
        // }
        // else if(allobjects.get(objectNum).getPos().x == getTankPos().x){
        //     queueCmd("move", new Vec2(0,(int)(allobjects.get(objectNum).getPos().y - getTankShotRange())));
        // }

        // if(allobjects.get(objectNum) instanceof Target){
        //     if(getTankShotRange() >= allobjects.get(objectNum).getPos().distance(getTankPos())){
        //         queueCmd("shoot", new Vec2(allobjects.get(objectNum).getPos().x - getTankPos().x, allobjects.get(objectNum).getPos().y - getTankPos().y));
        //         calculatePoints += 23;
        // }
        //     else{
        //         queueCmd("move", new Vec2(allobjects.get(objectNum).getPos().x - getTankPos().x, 0));
        //         calculatePoints -= 1;
        //         if(getTankShotRange() >= allobjects.get(objectNum).getPos().distance(getTankPos())){
        //             queueCmd("shoot", new Vec2(allobjects.get(objectNum).getPos().x - getTankPos().x, allobjects.get(objectNum).getPos().y - getTankPos().y));
        //             calculatePoints += 23;
        //         }
        //         else{
        //             queueCmd("move", new Vec2(0,(int)((allobjects.get(objectNum).getPos().y - getTankShotRange()))));
        //             calculatePoints -= 2;
        //         }
        //     }
        // }

        // Target closestA = getTargets()[0];
        // Target closestB = getTargets()[1];
        // for(Target a: getTargets()){
        //     for(Target b:getTargets()){
        //         if(a.getPos().distance(b.getPos()) < closestA.getPos().distance(closestB.getPos())){
        //             closestA = a;
        //             closestB = b;
        //         }
        //     }
        // }

        // queueCmd("move", new Vec2((int)((closestA.getPos().x + closestB.getPos().x)/2), 0));
        // queueCmd("move", new Vec2(0, (int)((closestA.getPos().y + closestB.getPos().y)/2)));
        // queueCmd("shoot", new Vec2(closestA.getPos().x - getTankPos().x, closestA.getPos().y - getTankPos().y));
        // queueCmd("shoot", new Vec2(closestB.getPos().x - getTankPos().x, closestB.getPos().y - getTankPos().y));
        // System.out.println(closestA.getPos().x - getTankPos().x + " " + (closestA.getPos().y - getTankPos().y));
        // return true;
    }

    public double getDistance(Vec2 a, Vec2 b) {
        double distance = (2);
        // Math.sqrt(Math.pow(a.x - b.x,2)+Math.pow(a.y-b.y, 2))
        return distance;
    }

    public double getDifference(double a, double b) {
        return a - b;
    }
}