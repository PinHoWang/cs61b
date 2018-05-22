package hw3.hash;

import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;

public class HashTableVisualizer {

    public static void main(String[] args) {
        /* scale: StdDraw scale
           N:     number of items
           M:     number of buckets */

        double scale = 1.0;
        int N = 50;
        int M = 10;

        HashTableDrawingUtility.setScale(scale);
        Set<Oomage> oomies = new HashSet<Oomage>();
        for (int i = 0; i < N; i += 1) {
            oomies.add(SimpleOomage.randomSimpleOomage());
        }
        visualize(oomies, M, scale);
    }

    public static void visualize(Set<Oomage> set, int M, double scale) {
        HashTableDrawingUtility.drawLabels(M);

        /* TODO: Create a visualization of the given hash table. Use
           du.xCoord and du.yCoord to figure out where to draw
           Oomages.
         */
        int[] count = new int[M];
        Arrays.fill(count, 1);

        for(Oomage o : set) {
          int code = (o.hashCode() & 0x7FFFFFFF) % M;
          o.draw(HashTableDrawingUtility.xCoord(count[code]), HashTableDrawingUtility.yCoord(code, M), scale);
          count[code]++;
        }

        /* When done with visualizer, be sure to try 
           scale = 0.5, N = 2000, M = 100. */           
    }
} 
