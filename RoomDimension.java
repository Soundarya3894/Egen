package demo;
public class RoomDimension {

		private int roomLength;
		private int roomWidth;
		
		public RoomDimension (int roomLength, int roomWidth) {
			this.roomLength = roomLength;
			this.roomWidth = roomWidth;
		
		}
		public int roomArea() {
			 
			return this.roomLength * this.roomWidth;
			
		}
	}
	

