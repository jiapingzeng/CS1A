import becker.robots.*;

class SmarterRobot extends Robot
{
    SmarterRobot(City c, int st, int ave, Direction dir, int num)
    {
        super(c, st, ave, dir, num);
    }

    public void moveMultiple(int numberOfIntersections) // Declared type int for numberOfIntersections
    {
        int counter = 0; // Initialize counter with value 0
        while(counter > numberOfIntersections)
        {
            this.move();
        }

    }
}

public class ICE_11_Errors_1 extends Object
{
    public static void main(String[] args)
    {
        City wallville = new City();
        SmarterRobot  rob = new SmarterRobot (wallville, 4, 0, Direction.EAST, 0);

        new Thing(wallville, 4, 1);
        new Thing(wallville, 4, 3);
        new Thing(wallville, 4, 5);

        rob.moveMultiple(3); // on this side, called an argument
        rob.turnLeft(); // Added semicolon
        rob.moveMultiple(2); // Added 2 as parameter
    }
}