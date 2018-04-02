

package creatures;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.HashMap;
import java.awt.Color;
import huglife.Direction;
import huglife.Action;
import huglife.Occupant;
import huglife.Impassible;
import huglife.Empty;



public class TestClorus {

    /* Replace with the magic word given in lab.
     * If you are submitting early, just put in "early" */
    public static final String MAGIC_WORD = "";


    //@Test
    public void testReplicate() {
        Clorus c1 = new Clorus(2);
        Clorus c2;
        c2 = c1.replicate();
        assertNotSame("Two Plips are same object.", c1, c2);
    }

    @Test
    public void testChoose() {
        Clorus c = new Clorus(0.2);
        HashMap<Direction, Occupant> surrounded = new HashMap<Direction, Occupant>();
        surrounded.put(Direction.TOP, new Impassible());
        surrounded.put(Direction.BOTTOM, new Empty());
        surrounded.put(Direction.LEFT, new Impassible());
        surrounded.put(Direction.RIGHT, new Impassible());

        //You can create new empties with new Empty();
        //Despite what the spec says, you cannot test for Cloruses nearby yet.
        //Sorry!  

        Action actual = c.chooseAction(surrounded);
        Action expected = new Action(Action.ActionType.MOVE, Direction.BOTTOM);
        // Action expected = new Action(Action.ActionType.REPLICATE, Direction.TOP);

        assertEquals(expected, actual);
    }

    public static void main(String[] args) {
        System.exit(jh61b.junit.textui.runClasses(TestClorus.class));
    }
} 
