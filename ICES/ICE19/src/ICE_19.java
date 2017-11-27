import becker.robots.*;

class RobotThatCanWalkDownAWall extends Robot
{
    RobotThatCanWalkDownAWall(City c, int st, int ave, Direction dir, int num)
    {
        super(c, st, ave, dir, num);
    }

    // Your code should go here:
    public boolean isNorthOfStreet(int st)
    {
        if (this.getStreet() < st) {
            return true;
        }
        return false;
    }

    public boolean isSouthOfStreet(int st) {
        if (this.getStreet() > st) {
            return true;
        }
        return false;
    }
}

public class ICE_19 extends Object
{
    public static void main(String[] args)
    {
        City wallingford = new City();
        RobotThatCanWalkDownAWall jo = new RobotThatCanWalkDownAWall(wallingford, 1, 2, Direction.SOUTH, 0);
        /* build tower*/
        new Wall(wallingford, 1, 1, Direction.EAST);
        new Wall(wallingford, 2, 1, Direction.EAST);
        new Wall(wallingford, 3, 1, Direction.EAST);
        System.out.println(jo.isNorthOfStreet(5));
        System.out.println(jo.isNorthOfStreet(2));
        System.out.println(jo.isNorthOfStreet(1));
        System.out.println(jo.isSouthOfStreet(0));
        System.out.println(jo.isSouthOfStreet(1));
    }
}