
package ParkingLot;

/* Parking Lot for regular */
public class regular implements car {
	
	private String carNum;

	public regular(String s) {
		carNum = s;
	}

	public regular() {
		carNum = "Anonymous";
	}

	@Override
	public String printCarNum() {
		return carNum;
	}
}