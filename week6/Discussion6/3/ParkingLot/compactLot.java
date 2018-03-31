
package ParkingLot;

public class compactLot {
	
	public final int compactSpace = 10;
	private compact[] cSpace;
	private int cSize;

	public compactLot() {
		cSpace = new compact[compactSpace];
		cSize = 0;
	}

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
		} else System.out.println("Compact parking lot is full!");
	}
}