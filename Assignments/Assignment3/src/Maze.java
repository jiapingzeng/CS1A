// Jiaping Zeng, Zhili Zhao, Dylan Yanovsky, Eric Heldt
// Fall 2017 Foothill
// CS1A - Assignment 3 - "The Maze"
////////////////////////////////////////////////////////////////////////////////
import becker.robots.*;

class MazeBot extends RobotSE {
    // Instance Variables will be declared and initialized here
    // one each for totalMoves, movesWest, movesEast, movesSouth, and MovesNorth
    int totalMoves, movesNorth, movesEast, movesSouth, movesWest = 0;

    public MazeBot(City theCity, int str, int ave, Direction dir, int numThings) {
        super(theCity, str, ave, dir, numThings);
    }

    // <-- BIG HINT: You might want to create a new method here called
    // movesCounted() that will count everything it is supposed to by adding to
    // the instance variables before moving, and then use that instead of move()
    // in the NavigateMaze() method
    public void movesCounted() {
        // put thing at current position if robot has any and there isn't one already
        putThingIfPossible();
        Direction dir = this.getDirection();
        // check which side robot is facing and add one to the respective moves count
        if (dir == Direction.NORTH) {
            movesNorth++;
        } else if (dir == Direction.EAST) {
            movesEast++;
        } else if (dir == Direction.SOUTH) {
            movesSouth++;
        } else {
            movesWest++;
        }
        // add one to totalMoves regardless of the direction
        totalMoves++;
        // move
        this.move();
    }

    public void putThingIfPossible() {
        // if there are more than 0 things in backpack
        // and there isn't a thing at the current position
        if (countThingsInBackpack() > 0 && !canPickThing()) {
            // put a thing down
            putThing();
        }
    }

    public void printEverything()// Or printTotalNumberOfSpacesMoved(),
    // whichever you decide
    {
        System.out.println("The robot has moved " + totalMoves + " spaces");
        System.out.println("The robot has moved " + movesNorth + " spaces north");
        System.out.println("The robot has moved " + movesEast + " spaces east");
        System.out.println("The robot has moved " + movesSouth + " spaces south");
        System.out.println("The robot has moved " + movesWest + " spaces west");
    }

    // The isAtEndSpot() method below is what's called a 'helper method' It
    // exists just to make another command (in this case, NavigateMaze) easier
    // to understand. It does this by replacing some code that otherwise would
    // be in NavigateMaze with it's name, and doing that work here, instead.
    // Declaring it "private" means that only the MazeBot is allowed to call
    // upon it.
    private boolean isAtEndSpot() {
        return getAvenue() == 9 && getStreet() == 10;
    }

    // THIS IS THE ONE MAIN METHOD WILL DO EVERYTHING (ALTHOUGH IT CAN USE OTHER
    // METHODS LIKE isAtEndSpot, ETC)
    public void navigateMaze() {
        // While your robot hasn't yet reached the 'end spot', keep navigating
        // through the Maze and doing its thing
        while (!isAtEndSpot()) {
            // The robot will navigate the Maze until it gets to the end spot.
            // What will you have the robot do at each step?

            // check if left is clear, if so move, if not turn right and check again
            turnLeft();
            if (frontIsClear()) {
                // left side is clear
                movesCounted();
            } else {
                // left side is blocked
                // check if forward direction is clear, if so move
                turnRight();
                if (frontIsClear()) {
                    // forward direction is clear
                    movesCounted();
                } else {
                    // left and forward direction is blocked
                    // check if right side is clear, if so move
                    turnRight();
                    if (frontIsClear()) {
                        // right side is clear
                        movesCounted();
                    } else {
                        // all sides are blocked, turn around and move
                        turnRight();
                        movesCounted();
                    }
                }
            }
        }
        // movesCounted() puts down thing before moving
        // which means that there won't be a thing at the end spot
        // this line fixes that issue
        putThingIfPossible();
        // After completing Maze, print total number of spaces moved and how
        // many times robot moved East, South, West, North.
        printEverything();
    }

}

// ###################################################################################################
// NO NEED TO TOUCH ANYTHING FROM HERE ON DOWN, EXCEPT TO CHANGE NUMBER OF
// THINGS IN BACKPACK IN MAIN
// The NavigateMaze() method is already set up and called by don the robot down
// in main
// ###################################################################################################
public class Maze extends Object {
    private static void makeMaze(City theCity) {
        for (int i = 1; i < 11; i++) {
            // north wall
            new Wall(theCity, 1, i, Direction.NORTH);

            // Second to north wall
            if (i <= 9)
                new Wall(theCity, 1, i, Direction.SOUTH);

            // Third to north wall
            if (i >= 4)
                new Wall(theCity, 4, i, Direction.SOUTH);

            // south wall
            if (i != 9) // (9, 10, SOUTH), is where the 'exit' is
                new Wall(theCity, 10, i, Direction.SOUTH);

            // west wall
            if (i != 1) // (1,1, WEST) is where the 'entrance' is
                new Wall(theCity, i, 1, Direction.WEST);

            // second to west-most wall
            if (i >= 3 && i < 6)
                new Wall(theCity, i, 6, Direction.WEST);

            // east wall
            new Wall(theCity, i, 10, Direction.EAST);
        }

        // cul-de-sac
        new Wall(theCity, 3, 10, Direction.WEST);
        new Wall(theCity, 3, 10, Direction.SOUTH);

        new Wall(theCity, 2, 8, Direction.WEST);
        new Wall(theCity, 2, 8, Direction.SOUTH);

        new Wall(theCity, 10, 8, Direction.NORTH);
        new Wall(theCity, 10, 9, Direction.EAST);
        new Wall(theCity, 10, 9, Direction.NORTH);
        makeSpiral(theCity, 8, 9, 3);
        new Wall(theCity, 8, 10, Direction.SOUTH);

        makeSpiral(theCity, 10, 5, 4);
    }

    public static void makeSpiral(City theCity, int st, int ave, int size) {
        // We start out building the wall northward
        // the walls will be built on the east face of the current
        // intersection
        Direction facing = Direction.EAST;

        while (size > 0) {
            int spacesLeft = size;
            int aveChange = 0;
            int stChange = 0;
            switch (facing) {
                case EAST:
                    stChange = -1;
                    break;
                case NORTH:
                    aveChange = -1;
                    break;
                case WEST:
                    stChange = 1;
                    break;
                case SOUTH:
                    aveChange = 1;
                    break;
            }

            while (spacesLeft > 0) {
                new Wall(theCity, st, ave, facing);
                ave += aveChange;
                st += stChange;
                --spacesLeft;
            }
            // back up one space
            ave -= aveChange;
            st -= stChange;

            switch (facing) {
                case EAST:
                    facing = Direction.NORTH;
                    break;
                case NORTH:
                    facing = Direction.WEST;
                    size--;
                    break;
                case WEST:
                    facing = Direction.SOUTH;
                    break;
                case SOUTH:
                    facing = Direction.EAST;
                    size--;
                    break;
            }
        }
    }

    // ###########################################################################################
    // Main Method
    // ###########################################################################################
    public static void main(String[] args) {
        City calgary = new City(12, 12);
        MazeBot don = new MazeBot(calgary, 1, 1, Direction.EAST, 100); // <-- YOU
        // WILL
        // NEED
        // TO
        // CHANGE
        // THIS
        // FROM
        // ZERO

        Maze.makeMaze(calgary);

        don.navigateMaze(); // <-- HERE'S WHERE THE NavigateMaze() method is
        // called. NO NEED TO TOUCH AT ALL

    }
}