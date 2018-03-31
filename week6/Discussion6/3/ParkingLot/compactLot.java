
package ParkingLot;

public class compactLot implements parkingLot {
	
	private compact[] cSpace;
	private int cSize;

	public compactLot() {
		cSpace = new compact[compactSpace];
		cSize = 0;
	}

	@Override
	public boolean isSpaceFree() {
		return cSize < compactSpace;
	}

	public void entrance(compact c) {
		if(isSpaceFree()) {
			for(int i = 0; i < compactSpace; i++) {
				if(cSpace[i] == null) {
					cSpace[i] = c;
					cSize++;
					return;
				}
			}
		} else System.out.println("Regular parking lot is full!");
	}
}