
package creatures;
import huglife.Creature;
import huglife.Direction;
import huglife.Action;
import huglife.Occupant;
import huglife.HugLifeUtils;
import java.awt.Color;
import java.util.Map;
import java.util.List;

/** An implementation of a motile pacifist photosynthesizer.
 *  @author Josh Hug
 */
public class Clorus extends Creature {

    /** red color. */
    private int r;
    /** green color. */
    private int g;
    /** blue color. */
    private int b;

    /** creates clorus with energy equal to E. */
    public Clorus(double e) {
        super("clorus");
        r = 0;
        g = 0;
        b = 0;
        energy = e;
    }

    /** creates a clorus with energy equal to 1. */
    public Clorus() {
        this(1);
    }

    /** Should return a color with red = 34, blue = 0, and green = 231 */
    public Color color() {
        r = 34;
        b = 231;
        g = 0;
        return color(r, g, b);
    }

    /** Do nothing with C, Plips are pacifists. */
    public void attack(Creature c) {
    	energy += c.energy();
    }

    /** Plips should lose 0.15 units of energy when moving. If you want to
     *  to avoid the magic number warning, you'll need to make a
     *  private static final variable. This is not required for this lab.
     */
    public void move() {
        energy -= 0.03;
    }


    /** Plips gain 0.2 energy when staying due to photosynthesis. */
    public void stay() {
        energy -= 0.01;
    }

    /** Plips and their offspring each get 50% of the energy, with none
     *  lost to the process. Now that's efficiency! Returns a baby
     *  Plip.
     */
    public Clorus replicate() {
        Clorus cl = new Clorus(energy / 2);
        this.energy = this.energy / 2;
        return cl;
    }

    /** Plips take exactly the following actions based on NEIGHBORS:
     *  1. If no empty adjacent spaces, STAY.
     *  2. Otherwise, if energy >= 1, REPLICATE.
     *  3. Otherwise, if any Cloruses, MOVE with 50% probability.
     *  4. Otherwise, if nothing else, STAY
     *
     *  Returns an object of type Action. See Action.java for the
     *  scoop on how Actions work. See SampleCreature.chooseAction()
     *  for an example to follow.
     */
    public Action chooseAction(Map<Direction, Occupant> neighbors) {
        
        List<Direction> empties = getNeighborsOfType(neighbors, "empty");
        List<Direction> plips = getNeighborsOfType(neighbors, "plip");

        if(empties.size() == 0) {
        	return new Action(Action.ActionType.STAY);
        }

        if(plips.size() > 0) {
        	Direction moveDir = HugLifeUtils.randomEntry(plips);
        	return new Action(Action.ActionType.ATTACK, moveDir);
        }

        if(energy >= 1) {
        	Direction moveDir = HugLifeUtils.randomEntry(empties);
        	return new Action(Action.ActionType.REPLICATE, moveDir);
        }

        Direction moveDir = HugLifeUtils.randomEntry(empties);
        return new Action(Action.ActionType.MOVE, moveDir);

    }

}
