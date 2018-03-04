
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

	/* main function */
	public static void main(String[] args) {
		/* make sure 3 command line arguments */
		if(args.length != 3) {
			System.out.println("Error: need 3 arguments.");
			System.out.println("Usage: java NBody [ time loop ] [ time ] [ filename ]");
			System.exit(0);
		}

		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		int t = 0; /* time for animation til T with in
					* in dt interval */ 
		String filename = args[2];

		Planet[] P = NBody.readPlanets(filename);
		StdDraw.setScale(-radius, radius);
		
		StdDraw.clear();
		StdDraw.picture(0 ,0, "./images/starfield.jpg");
		/* Draw the planets each by each */
		for(int i = 0; i < number; i++) {
			StdDraw.picture(P[i].xxPos, P[i].yyPos, 
							"./images/" + P[i].imgFileName);
		}
		StdDraw.clear();


		/*			 *
		 * Animation *
		 *			 */

		while(t < T) {

			double[] xForces = new double[number];
			double[] yForces = new double[number];
			for(int i = 0; i < number; i++) {
				xForces[i] = P[i].calcNetForceExertedByX(P);
				yForces[i] = P[i].calcNetForceExertedByY(P);
				//System.out.println(xForces[i]);
				//System.out.println(yForces[i]);
				P[i].update(dt, xForces[i], yForces[i]);
			}
			

			StdDraw.clear();
			/* Draw background */
			StdDraw.picture(0 ,0, "./images/starfield.jpg");
			
			/* Draw the planets each by each */
			for(int j = 0; j < number; j++) {
				StdDraw.picture(P[j].xxPos, P[j].yyPos, 
							"./images/" + P[j].imgFileName);
			}
			
			t += dt;
			//System.out.println("ROLLING!");
			/* Pause the pictures of animation */
			StdDraw.show(50);
		}

		//System.out.println("END");
		
	}





}
