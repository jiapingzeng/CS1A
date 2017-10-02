import becker.robots.*;

// This file is the starting point for Lecture 2.
public class Flowchart extends Object
{
    public static void main(String[] args)
    {
        // Create a new city
        City MikeVille = new City();
        Robot Bob = new Robot(MikeVille, 1, 1, Direction.EAST, 0);
        new Thing(MikeVille, 1, 2);
        new Thing(MikeVille, 2, 2);
        new Thing(MikeVille, 3, 2);
        new Wall(MikeVille, 3, 2, Direction.EAST);

		/* Your code should go here: */
        Bob.move();
        Bob.turnLeft();
        Bob.turnLeft();
        Bob.turnLeft();
        Bob.pickThing();
        Bob.move();
        Bob.pickThing();
        Bob.move();
        Bob.pickThing();
        Bob.turnLeft();
        Bob.turnLeft();
        Bob.move();
        Bob.move();
        Bob.move();
        Bob.turnLeft();
        Bob.move();
    }
}


