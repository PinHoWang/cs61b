
import ParkingLot.*;

/* Assign parking lot to people */
public class plManner {

	public static void main(String[] args) {
		
		regularLot R = new regularLot();
		compactLot C = new compactLot();


		car r1 = new regular("AFQ-7237");
		R.entrance(r1);
		car c1 = new compact("QQQ-3843");
		C.entrance((c1);

	}
}