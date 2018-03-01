
import java.lang.Math.*;

public class Planet {

	private static final double G = 6.67 * Math.pow(10, -11);

	/* instance variables */
	double xxPos;
	double yyPos;
	double xxVel;
	double yyVel;
	double mass;
	String imgFileName;

	/* Constructor */
	public Planet(double xP, double yP, double xV,
					double yV, double m, String img) {
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}

	public Planet(Planet P) {
		this.xxPos = P.xxPos;
		this.yyPos = P.yyPos;
		this.xxVel = P.xxVel;
		this.yyVel = P.yyVel;
		this.mass = P.mass;
		this.imgFileName = P.imgFileName;
	}

	/* Methods */
	/* compare two planet whether equal */
	public boolean equals(Planet P) {
		if(P == this) {
			return true;
		}
		else return false;
	}


	/* calculate the distance r */
	public double calcDistance(Planet P) {
		return Math.sqrt(Math.pow(P.xxPos - this.xxPos, 2) +
				Math.pow(P.yyPos - this.yyPos, 2));
	}

	/* calculate Force Exerted on this planet
	 * by the given planet */
	public double calcForceExertedBy(Planet P) {
		return G * P.mass * this.mass / 
				Math.pow(calcDistance(P), 2);
	}

	/* calculate the force exerted in the X and Y 
	 * directions */
	public double calcForceExertedByX(Planet P) {
		return calcForceExertedBy(P) * (P.xxPos - this.xxPos) /
				calcDistance(P);
	}

	public double calcForceExertedByY(Planet P) {
		return calcForceExertedBy(P) * (P.yyPos - this.yyPos) /
				calcDistance(P);
	}

	/* calculate the net XY force by given Planets array */
	public double calcNetForceExertedByX(Planet[] allPlanets) {
		double xF = 0.0;
		for(int i = 0; i < allPlanets.length; i++) {
			if(!(this.equals(allPlanets[i])))
				xF += calcForceExertedByX(allPlanets[i]);
		}
		return xF;
	}

	public double calcNetForceExertedByY(Planet[] allPlanets) {
		double yF = 0.0;
		for(int i = 0; i < allPlanets.length; i++) {
			if(!(this.equals(allPlanets[i])))
				yF += calcForceExertedByY(allPlanets[i]);
		}
		return yF;
	}

	/* Updata the position caused by force */
	public void update(double dt, double fX, double fY) {
		double aX = fX / this.mass;
		double aY = fY / this.mass;
		this.xxVel += dt * aX;
		this.yyVel += dt * aY;
		this.xxPos += dt * this.xxVel;
		this.yyPos += dt * this.yyVel;
	}





}