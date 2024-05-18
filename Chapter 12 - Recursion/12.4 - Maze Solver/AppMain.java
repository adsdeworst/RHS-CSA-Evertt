import java.util.ArrayList;

public class AppMain {
    private static Maze maze = new Maze();

    public static void main(String[] args) {
        // Write a recursive method to solve the maze. It should make use of
        //  the instance member variable maze. It knows about the maze and
        //  can answer questions about open spaces, possible moves, etc.
        // On each step, you can only move in a cardinal direction (left/right/up/down).
        // Your solution should take the form of an array of Locations
        dfs(Maze.START);

        // Print out your solution, maze can do that for you (it's already written)
        // Location[] replaceWithYourSln = new Location[0];
        maze.printMazeAndPath(answer);
    }


    // Helper methods for marking locations as visited
    //  You are probably going to want to use: hasVisitedNode & markVisited.
    private static boolean[][] visited = null;
    private static boolean hasVisitedNode(Location loc) {
        if (!isValidVisitedLoc(loc)) {
            return true;
        }
        return visited[loc.getY()][loc.getX()];
    }
    private static void markVisited(Location loc) {
        if (!isValidVisitedLoc(loc)) {
            return;
        }
        visited[loc.getY()][loc.getX()] = !visited[loc.getY()][loc.getX()];
    }
    private static boolean isValidVisitedLoc(Location loc) {
        if (visited == null) {
            visited = new boolean[maze.getHeight()][maze.getWidth()];
        }
        if ((loc.getX() < 0) || (loc.getX() >= visited[0].length) ||
            (loc.getY() < 0) || (loc.getY() >= visited.length)) {
            return false;
        }
        return true;
    }

    private static Location[] answer;
    private static ArrayList<Location> moves_list = new ArrayList<Location>();
    private static Boolean dfs(Location node){
        // maze.printMazeAndPath(moves_list.toArray(new Location[0])); // remove later
        if(node.equals(Maze.EXIT)){
            // System.out.println(moves_list);
            moves_list.add(node);
            answer = moves_list.toArray(new Location[0]);
            return true;
        }
        else if(isValidVisitedLoc(node) && !hasVisitedNode(node)){
                markVisited(node);
                moves_list.add(new Location(node));
                if(maze.canGoRight(node) && !hasVisitedNode(new Location(node).incRight())){
                    if(dfs(new Location(node).incRight())){
                        return true;
                    }
                }
                if(maze.canGoLeft(node) && !hasVisitedNode(new Location(node).incLeft())){
                    if(dfs(new Location(node).incLeft())){
                        return true;
                    }
                }
                if(maze.canGoUp(node) && !hasVisitedNode(new Location(node).incUp())){
                    if(dfs(new Location(node).incUp())){
                        return true;
                    }
                }
                if(maze.canGoDown(node) && !hasVisitedNode(new Location(node).incDown())){
                    if(dfs(new Location(node).incDown())){
                        return true;
                    }
                }
                markVisited(node);
                moves_list.remove(moves_list.size() - 1);
                return false;
        }
        return null;
    }
}
