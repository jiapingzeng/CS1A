import becker.robots.*;

public class CitySetup extends Object {
    public static void main(String[] args) {
        City seattle = new City();

        // ICE 02.1
        // Robot gretel = new Robot(seattle, 1, 2, Direction.EAST);

        // ICE 02.2
        // Robot gretel = new Robot(seattle, 1, 0, Direction.EAST);
        // new Thing(seattle, 1, 2);
        // new Wall(seattle, 1, 1, Direction.NORTH);
        // new Wall(seattle, 1, 1, Direction.EAST);
        // new Wall(seattle, 1, 1, Direction.SOUTH);
        // new Wall(seattle, 1, 1, Direction.WEST);

        // ICE 02.3
        Robot gretel = new Robot(seattle, 0, 0, Direction.NORTH);
        new Thing(seattle, 2, 4);
        new Wall(seattle, 1, 1, Direction.WEST);
        new Wall(seattle, 1, 2, Direction.EAST);
        new Wall(seattle, 2, 1, Direction.WEST);
        new Wall(seattle, 2, 2, Direction.EAST);
        new Wall(seattle, 2, 1, Direction.SOUTH);
        new Wall(seattle, 2, 2, Direction.SOUTH);
        new Wall(seattle, 3, 1, Direction.WEST);
        new Wall(seattle, 3, 2, Direction.EAST);
        new Wall(seattle, 4, 1, Direction.WEST);
        new Wall(seattle, 4, 2, Direction.EAST);
        new Wall(seattle, 3, 4, Direction.EAST);
        new Wall(seattle, 4, 4, Direction.EAST);
    }
}
