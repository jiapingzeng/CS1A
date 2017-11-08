import becker.robots.*;

public class ICE_13_HarvestTask extends Object
{
    public static void main (String[] args)
    {
        City stLouis = new City("ICE_13_Harvest.txt");
        ICE_13_Harvester mark = new ICE_13_Harvester(stLouis, 1, 0, Direction.EAST, 0);

        // removed the extra move
        // mark.move ();
        mark.move ();
        mark.harvestField();
        mark.move ();
        mark.harvestTwoRows();
    }
}
