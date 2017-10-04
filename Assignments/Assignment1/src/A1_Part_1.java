// Jiaping Zeng
// Zhili Zhao
// Assignment 1.1
// 2017 Fall Quarter

import becker.robots.*;

public class A1_Part_1 extends Object
{
    public static void main(String[] args)
    {
        // Initialize city, robot and things
        City theCity= new City( 11, 5);
        Robot karel = new Robot(theCity, 9, 1, Direction.NORTH, 0);
        new Thing(theCity, 1, 1);
        new Thing(theCity, 9, 2);

        // the 'backstop' for the robot:
        new Wall(theCity, 9, 1, Direction.SOUTH);

        // First build the west-most pipe
        // The west edge of the west-most pipe:
        new Wall(theCity, 1, 1, Direction.WEST);
        new Wall(theCity, 2, 1, Direction.WEST);
        new Wall(theCity, 3, 1, Direction.WEST);
        new Wall(theCity, 4, 1, Direction.WEST);
        new Wall(theCity, 5, 1, Direction.WEST);
        new Wall(theCity, 6, 1, Direction.WEST);
        new Wall(theCity, 7, 1, Direction.WEST);
        new Wall(theCity, 8, 1, Direction.WEST);
        new Wall(theCity, 9, 1, Direction.WEST);

        // The east edge of the west-most pipe:
        new Wall(theCity, 2, 1, Direction.EAST);
        new Wall(theCity, 3, 1, Direction.EAST);
        new Wall(theCity, 4, 1, Direction.EAST);
        new Wall(theCity, 5, 1, Direction.EAST);
        new Wall(theCity, 6, 1, Direction.EAST);
        new Wall(theCity, 7, 1, Direction.EAST);
        new Wall(theCity, 8, 1, Direction.EAST);
        new Wall(theCity, 9, 1, Direction.EAST);

        // the 'cap' at the top
        new Wall(theCity, 1, 1, Direction.NORTH);
        new Wall(theCity, 1, 2, Direction.NORTH);
        new Wall(theCity, 1, 2, Direction.EAST);

        // The west edge of the east-most pipe
        new Wall(theCity, 2, 2, Direction.WEST);
        new Wall(theCity, 3, 2, Direction.WEST);
        new Wall(theCity, 4, 2, Direction.WEST);
        new Wall(theCity, 5, 2, Direction.WEST);
        new Wall(theCity, 6, 2, Direction.WEST);
        new Wall(theCity, 7, 2, Direction.WEST);
        new Wall(theCity, 8, 2, Direction.WEST);
        new Wall(theCity, 9, 2, Direction.WEST);

        // The east edge of the east-most pipe
        new Wall(theCity, 1, 2, Direction.EAST);
        new Wall(theCity, 2, 2, Direction.EAST);
        new Wall(theCity, 3, 2, Direction.EAST);
        new Wall(theCity, 4, 2, Direction.EAST);
        new Wall(theCity, 5, 2, Direction.EAST);
        new Wall(theCity, 6, 2, Direction.EAST);
        new Wall(theCity, 7, 2, Direction.EAST);
        new Wall(theCity, 8, 2, Direction.EAST);
        new Wall(theCity, 9, 2, Direction.EAST);


        // that final stopping wall
        new Wall(theCity, 9, 2, Direction.SOUTH);

        /* PUT YOUR CODE HERE */
        // move up west pipe
        karel.move();
        karel.move();
        karel.move();
        karel.move();
        karel.move();
        karel.move();
        karel.move();
        karel.move();
        // turn right
        karel.turnLeft();
        karel.turnLeft();
        karel.turnLeft();
        // move from west pipe to east pipe
        karel.move();
        // turn right
        karel.turnLeft();
        karel.turnLeft();
        karel.turnLeft();
        // move down east pipe
        karel.move();
        karel.move();
        karel.move();
        karel.move();
        karel.move();
        karel.move();
        karel.move();
        karel.move();
        // pick up thing #1
        karel.pickThing();
        // turn around
        karel.turnLeft();
        karel.turnLeft();
        // move up east pipe
        karel.move();
        karel.move();
        karel.move();
        karel.move();
        karel.move();
        karel.move();
        karel.move();
        karel.move();
        // turn left
        karel.turnLeft();
        // move from east pipe to west pipe
        karel.move();
        // pick up thing #2
        karel.pickThing();
        // turn left
        karel.turnLeft();
        // move down west pipe
        karel.move();
        karel.move();
        karel.move();
        karel.move();
        karel.move();
        karel.move();
        karel.move();
        // put down thing #1
        karel.putThing();
        // move forward
        karel.move();
        // put down thing #2
        karel.putThing();
        // turn around
        karel.turnLeft();
        karel.turnLeft();
        // move up 2 blocks
        karel.move();
        karel.move();
    }
}