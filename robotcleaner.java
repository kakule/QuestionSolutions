//Robot Room Cleaner
//Given a robot cleaner in a room modeled as a grid.
//Each cell in the grid can be empty or blocked.
//The robot cleaner with 4 given APIs can move forward, turn left or turn right. Each turn it made is 90 degrees.
//When it tries to move into a blocked cell, its bumper sensor detects the obstacle and it stays on the current cell.
//Design an algorithm to clean the entire room using only the 4 given APIs shown below.

/**
 * // This is the robot's control interface.
 * // You should not implement it, or speculate about its implementation
 * interface Robot {
 *     // Returns true if the cell in front is open and robot moves into the cell.
 *     // Returns false if the cell in front is blocked and robot stays in the current cell.
 *     public boolean move();
 *
 *     // Robot will stay in the same cell after calling turnLeft/turnRight.
 *     // Each turn will be 90 degrees.
 *     public void turnLeft();
 *     public void turnRight();
 *
 *     // Clean the current cell.
 *     public void clean();
 * }
 */
 
import  javafx.util.Pair;
class Solution {
    //  Pair -1,0 ---> up
    //  Pair  0,1 ---> right
    //  Pair  1,0 ---> down
    //  Pair  0,-1 ---> left

    private void returnToPrevious(Robot robot) {
        robot.turnLeft();
        robot.turnLeft();
        robot.move();
        robot.turnRight();
        robot.turnRight();
    }

    private Pair getPoint(int dir) {
        switch(dir) {
            case 0: //up
                return new Pair(-1, 0);
            case 1: //right
                return new Pair(0, 1);
            case 2: //down
                return new Pair(1, 0);
            case 3: //left
                return new Pair(0, -1);
            default:
                return null;
        }
    }
    
    public void cleanRoom(Robot robot) {
        Pair<Integer, Integer> p = new Pair<>(0,0);
        dfs(robot, p, 0, new HashSet<Pair>());
    }
    
    private void dfs(Robot robot, Pair <Integer, Integer> p,int dir, HashSet<Pair> visited) {

        visited.add(p);
        robot.clean();
        //forward (initially facing up)
        Pair <Integer, Integer> d = getPoint(dir);
        Pair <Integer, Integer> tmp = new Pair<>(p.getKey() + d.getKey(), p.getValue() + d.getValue());
        if(!visited.contains(tmp) && robot.move()) {
            dfs(robot, tmp, dir, visited);
            returnToPrevious(robot);
        }
        //clean right side
        robot.turnRight();
        d = getPoint((dir + 1) % 4);
        tmp = new Pair(p.getKey() + d.getKey(), p.getValue() + d.getValue());
        if(!visited.contains(tmp) && robot.move()) {
            dfs(robot, tmp, (dir + 1) % 4, visited);
            returnToPrevious(robot);
        }
        //clean down side
        robot.turnRight();
        d = getPoint((dir + 2) % 4);
        tmp = new Pair(p.getKey() + d.getKey(), p.getValue() + d.getValue());
        if(!visited.contains(tmp) && robot.move()) {
            dfs(robot, tmp, (dir + 2) % 4, visited);
            returnToPrevious(robot);
        }
        //clean left side
        robot.turnRight();
        d = getPoint((dir + 3) % 4);
        tmp = new Pair(p.getKey() + d.getKey(), p.getValue() + d.getValue());
        if(!visited.contains(tmp) && robot.move()) {
            dfs(robot, tmp, (dir + 3) % 4, visited);
            returnToPrevious(robot);
        }
        
        robot.turnRight();
    }
}
