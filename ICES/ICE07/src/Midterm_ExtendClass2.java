import becker.robots.*;

public class Midterm_ExtendClass2 {
    public static void main(String[] args) {
        City playground = new City();
        new Wall(playground, 0, 4, Direction.WEST);
        new Wall(playground, 0, 4, Direction.NORTH);
        new Wall(playground, 0, 4, Direction.EAST);
        new Wall(playground, 2, 4, Direction.SOUTH);
        new Wall(playground, 3, 4, Direction.NORTH);
        new Wall(playground, 4, 4, Direction.WEST);
        new Wall(playground, 4, 4, Direction.SOUTH);
        new Wall(playground, 4, 4, Direction.EAST);
        new Thing(playground, 1, 4);
        new Thing(playground, 2, 4);
        new Thing(playground, 3, 4);
        new Robot(playground, 0, 4, Direction.SOUTH);
        new Robot(playground, 4, 4, Direction.NORTH);
    }
}
