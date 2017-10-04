// Jiaping Zeng
// Zhili Zhao
// Assignment 1.1
// 2017 Fall Quarter

import becker.robots.*;

public class A1_Part_5 extends Object {
    public static void main(String[] args) {
        // Initialize city and robot
        City toronto = new City();
        SmarterRobot jo = new SmarterRobot(toronto, 1, 1, Direction.EAST, 0);

		/* Your code should after here: */
		// Create walls
        new Wall(toronto, 2, 1, Direction.NORTH);
        new Wall(toronto, 2, 1, Direction.WEST);
        new Wall(toronto, 2, 2, Direction.NORTH);
        new Wall(toronto, 2, 2, Direction.EAST);
        new Wall(toronto, 3, 1, Direction.SOUTH);
        new Wall(toronto, 3, 1, Direction.WEST);
        new Wall(toronto, 3, 2, Direction.SOUTH);
        new Wall(toronto, 3, 2, Direction.EAST);

        // Move to upper right corner and turn right
        jo.move();
        jo.move();
        jo.turnRight();
        // Move down right side and turn right
        jo.move3();
        jo.turnRight();
        // Move across bottom side and turn right
        jo.move3();
        jo.turnRight();
        // Move up left side and turn right
        jo.move3();
        jo.turnRight();
        // Return to initial position
        jo.move();
    }
}

class SmarterRobot extends Robot {
    SmarterRobot(City c, int st, int ave, Direction dir, int num) {
        super(c, st, ave, dir, num);
    }
    public void move3() {
        this.move();
        this.move();
        this.move();
    }
    public void turnRight() {
        this.turnLeft();
        this.turnLeft();
        this.turnLeft();
    }
}