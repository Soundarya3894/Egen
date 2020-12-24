package demo;

public class RoomCarpet extends RoomDimension{
	
	double carpetCost;
	public CarpetStyle carpetStyle;
	
	

	public RoomCarpet(int roomLength, int roomWidth, String userChoice) {
		super(roomLength, roomWidth);
		this.carpetStyle = new CarpetStyle(userChoice);
		
	}

	public double carpetsCost() {
		double areaOfRoom = super.roomArea();
		double carpetCost = carpetStyle.getCarpetCost();
		return areaOfRoom * carpetCost;

	}

}
