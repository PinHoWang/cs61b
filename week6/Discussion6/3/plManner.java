
import ParkingLot.*;

/* Assign parking lot to people */
public class plManner {

	public static void main(String[] args) {
		
		regularLot R = new regularLot();
		compactLot C = new compactLot();


		regular r1 = new regular("AFQ-7237");
		R.entrance(r1);
		compact c1 = new compact("QQQ-3843");
		try {
			C.entrance(r1);
			throw new Exception("Disobedient!");
		} catch(Exception e) {
			R.entrance(c1);
			System.out.println("Parking to regular.");
		}

	}
}