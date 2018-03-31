
package ParkingLot;

/* Regular Lot */
public class regularLot {
	
	public final int regularSpace = 15;
	private regular[] rSpace;
	private int rSize;

	public regularLot() {
		rSpace = new regular[regularSpace];
		rSize = 0;
	}

	public boolean isSpaceFree() {
		return rSize < regularSpace;
	}

	/* Add the entrance car to specific space and park the  
	 * place closest to the entrance (forward to the array) */
	public void entrance(regular c) {
		if(isSpaceFree()) {
			for(int i = 0; i < regularSpace; i++) {
				if(rSpace[i] == null) {
					rSpace[i] = c;
					rSize++;
					return;
				}
			}
		} else System.out.println("Regular parking lot is full!");
	}
}