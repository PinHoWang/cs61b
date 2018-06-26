import java.util.Observable;
/** 
 *  @author Josh Hug
 */

public class MazeCycles extends MazeExplorer {
    /* Inherits public fields: 
    public int[] distTo;
    public int[] edgeTo;
    public boolean[] marked;
    */

    private int s;
    private Maze maze;
    private int[] timesRecord;

    public MazeCycles(Maze m) {
        super(m);
        maze = m;
        maze.xyTo1D(1, 1);
        timesRecord = new int[maze.V()];
    }

    public void detectCycle(int v) {
        marked[v] = true;
        timesRecord[v] += 1;
        announce();

        for (int w : maze.adj(v)) {
            if(timesRecord[w] > 1) {
                announce();
                return;
            }

            if (!marked[w]) {
                edgeTo[w] = v;
                announce();
                detectCycle(w);               
            }
        }
    }

    @Override
    public void solve() {
        detectCycle(s);
    }
} 

