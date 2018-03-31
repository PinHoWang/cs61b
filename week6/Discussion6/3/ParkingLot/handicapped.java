
package ParkingLot;

public class handicapped extends regular {

	private String carNum;
	
	public handicapped(String s) {
		carNum = s;
	}

	public handicapped() {
		carNum = "Anonymous";
	}

	@Override
	public String printCarNum() {
		return carNum;
}