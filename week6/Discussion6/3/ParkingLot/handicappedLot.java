
package ParkingLot;

/* Regular Lot */
public class handicappedLot {
	
	public final int handicappedSpace = 5;
	private regular[] hSpace;
	private int hSize;

	public handicappedLot() {
		hSpace = new handicapped[regularSpace];
		hSize = 0;
	}

	public boolean isSpaceFree() {
		return hSize < handicappedSpace;
	}

	/* Add the entrance car to specific space and park the  
	 * place closest to the entrance (forward to the array) */
	public void entrance(handicapped c) {
		if(isSpaceFree()) {
			for(int i = 0; i < handicappedSpace; i++) {
				if(hSpace[i] == null) {
					hSpace[i] = c;
					hSize++;
					return;
				}
			}
		} else System.out.println("handicapped parking lot is full!");
	}
}