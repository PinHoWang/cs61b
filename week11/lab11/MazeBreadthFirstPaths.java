import java.util.Observable;
import java.util.ArrayDeque;
/**
 *  @author Josh Hug
 */

public class MazeBreadthFirstPaths extends MazeExplorer {
    /* Inherits public fields:
    public int[] distTo;
    public int[] edgeTo;
    public boolean[] marked;
    */

    private int s;
    private int t;
    private boolean targetFound = false;
    private Maze maze;
    private ArrayDeque<Integer> fringe;

    public MazeBreadthFirstPaths(Maze m, int sourceX, int sourceY, int targetX, int targetY) {
        super(m);
        maze = m;
        s = maze.xyTo1D(sourceX, sourceY);
        t = maze.xyTo1D(targetX, targetY);
        distTo[s] = 0;
        edgeTo[s] = s; 
        fringe = new ArrayDeque<Integer>();
    }

    /** Conducts a breadth first search of the maze starting at vertex x. */
    private void bfs(int s) {
        /* Your code here. */
        fringe.add(s);
        marked[s] = true;
        announce();

        while(fringe.peek() != null) {
        
            int v = fringe.removeFirst();
            if(fringe.contains(t)) {v = t;}
            
            for(int w : maze.adj(v)) {
                if(!marked[w]) {
                    marked[w] = true;
                    distTo[w] = distTo[v] + 1;
                    fringe.add(w);
                    edgeTo[w] = v;
                }
                if(v == t) return;
            }
            announce();
        }

    }


    @Override
    public void solve() {
        bfs(s);
    }
}

