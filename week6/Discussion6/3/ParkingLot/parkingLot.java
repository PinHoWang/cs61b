package ParkingLot;

/* ParkingLot interface */
public interface parkingLot {
	/* parking Lot spaec */
	public final int regularSpace = 15;
	public final int compactSpace = 10;
	public final int handicappedSpace = 5;

	public boolean isSpaceFree();
	public void entrance(car c);

}