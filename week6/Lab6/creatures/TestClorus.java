

public class TestClorus {

    /* Replace with the magic word given in lab.
     * If you are submitting early, just put in "early" */
    public static final String MAGIC_WORD = "";

    @Test
    public void testBasics() {
        Clorus c = new Clorus(2);
        assertEquals(2, c.energy(), 0.01);
        assertEquals(new Color(99, 255, 76), c.color());
        c.move();
        assertEquals(1.85, c.energy(), 0.01);
        c.move();
        assertEquals(1.70, c.energy(), 0.01);
        c.stay();
        assertEquals(1.90, c.energy(), 0.01);
        c.stay();
        assertEquals(2.00, c.energy(), 0.01);
    }

    @Test
    public void testReplicate() {
        Plip p1 = new Plip(2);
        Plip p2;
        p2 = p1.replicate();
        assertNotSame("Two Plips are same object.", p1, p2);
    }

    @Test
    public void testChoose() {
        Plip p = new Plip(1.2);
        HashMap<Direction, Occupant> surrounded = new HashMap<Direction, Occupant>();
        surrounded.put(Direction.TOP, new Empty());
        surrounded.put(Direction.BOTTOM, new Impassible());
        surrounded.put(Direction.LEFT, new Impassible());
        surrounded.put(Direction.RIGHT, new Impassible());

        //You can create new empties with new Empty();
        //Despite what the spec says, you cannot test for Cloruses nearby yet.
        //Sorry!  

        Action actual = p.chooseAction(surrounded);
        Action expected = new Action(Action.ActionType.STAY);
        // Action expected = new Action(Action.ActionType.REPLICATE, Direction.TOP);

        assertEquals(expected, actual);
    }

    public static void main(String[] args) {
        System.exit(jh61b.junit.textui.runClasses(TestPlip.class));
    }
} 
