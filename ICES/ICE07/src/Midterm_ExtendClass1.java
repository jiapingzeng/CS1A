import becker.robots.*;

class Seeker extends Robot {
    public Seeker(City c, int st, int ave, Direction dir, int num) {
        super(c, st, ave, dir, num);
    }

    public void turnRight() {
        for (int i = 0; i < 3; i++) {
            this.turnLeft();
        }
    }

    public void goAroundCorner() {
        // move to end of wall
        for (int i = 0; i < 5; i++) {
            this.move();
        }
        // move down and turn to face original direction
        this.turnRight();
        this.move();
        this.turnLeft();
    }

    public void celebrate() {
        // turn around 5 times
        for (int i = 0; i < 5; i++) {
            // rotate 360 degrees
            for (int j = 0; j < 4; j++) {
                this.turnLeft();
            }
        }
        System.out.println("HOORAY! I found you");
    }

    public void returnHome() {
        // move up corner 3 times
        for (int i = 0; i < 3; i++) {
            // turn at corner
            this.turnLeft();
            this.move();
            this.turnLeft();
            // move forward 5 times
            for (int j = 0; j < 5; j++) {
                this.move();
            }
            // turn around to face original direction
            this.turnLeft();
            this.turnLeft();
        }
    }
}

public class Midterm_ExtendClass1 {
    public static void main(String[] args) {
        City playground = new City();
        setupCity(playground);
        Seeker ian = new Seeker(playground,2, 0, Direction.EAST, 0);
        ian.goAroundCorner();
        ian.goAroundCorner();
        ian.goAroundCorner();
        ian.celebrate();
        ian.returnHome();
    }

    public static void setupCity(City city) {
        new Wall(city, 3, 5, Direction.WEST);
        new Wall(city, 4, 10, Direction.WEST);
        new Wall(city, 5, 15, Direction.WEST);
        for (int i = 0; i < 5; i++) {
            new Wall(city, 3, i, Direction.NORTH);
            new Wall(city, 4, 5 + i, Direction.NORTH);
            new Wall(city, 5, 10 + i, Direction.NORTH);
        }
    }
}