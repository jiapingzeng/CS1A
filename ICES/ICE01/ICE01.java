import becker.robots.*;

/*
Make sure that the name of the file is the same as the name of the class.
        The name of the class is found between the words "class", and "extends".
        For example, the name of this class is "Starting_Template", which is the name of the file.
        You'll notice that the name of the class has ".java" on the end, yet the name of the
        leaves the ".java" off.
*/

public class ICE01 extends Object {
	public static void main(String[] args) {
		City theCity = new City();
		Robot karel = new Robot(theCity, 1, 0, Direction.EAST, 0);
		Thing theThing = new Thing(theCity, 2, 2);

		new Wall(theCity, 2, 2, Direction.EAST);
		new Wall(theCity, 2, 2, Direction.NORTH);
		new Wall(theCity, 2, 2, Direction.WEST);

		new Wall(theCity, 3, 2, Direction.SOUTH);

		/* put your code after here */
		karel.move();
		karel.turnLeft();
		karel.turnLeft();
		karel.turnLeft();
		karel.move();
		karel.move();
		karel.turnLeft();
		karel.move();
		karel.turnLeft();
		karel.move();
		karel.pickThing();
		karel.putThing();
	}
}
