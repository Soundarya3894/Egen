package demo;

public class RoomCarpet extends RoomDimension{
	
	double carpetCost;
	public static RoomDimension roomDimension;
	
	

	public RoomCarpet(int roomLength, int roomWidth, int carpetCost) {
		super(roomLength, roomWidth);
		this.carpetCost = carpetCost;
		
	}

	public double carpetCost() {
		double areaOfRoom = super.roomArea();
		return areaOfRoom * carpetCost;

	}

}
