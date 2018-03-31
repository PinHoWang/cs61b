
package ParkingLot;

public class compact extends regular {

	private String carNum;
	
	public compact(String s) {
		carNum = s;
	}

	public compact() {
		carNum = "Anonymous";
	}

	@Override
	public String printCarNum() {
		return carNum;
	}
}