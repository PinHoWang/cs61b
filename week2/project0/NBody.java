
/* The "static" using here is just to satisfy the Testing codes.
 * Still need to check whether using "static" in these methods 
 * and variables */

public class NBody {

	public static int number;
	public static double radius;

	/* read the number of planets and scalar of the universe */
	public static double readRadius(String str) {
		In in = new In(str);
		number = in.readInt();
		radius = in.readDouble(); 
		return radius;
	}

	/* read the planets details */
	public static Planet[] readPlanets(String str) {
		In in = new In(str);
		number = in.readInt();
		radius = in.readDouble();
		Planet[] P = new Planet[number]; /* Just assign the memory to P
										  * Still need to allocate it */
		for(int i = 0; i < number; i++) {
			/*
			double xP = in.readDouble();
			double yP = in.readDouble();
			double xV = in.readDouble();
			double yV = in.readDouble();
			double m = in.readDouble();
			String s = in.readString();
			P[i] = new Planet(xP, yP, xV, yV, m, s);
			*/
			P[i] = new Planet(in.readDouble(), in.readDouble(), in.readDouble(),
								in.readDouble(), in.readDouble(), in.readString());
		}
		return P;
	}
}