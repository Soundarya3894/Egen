package demo;

import java.util.Scanner;

public class CostCalculator {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Length of the room:");
		int roomLength = sc.nextInt();
		System.out.println("Width of the room:");
		int roomWidth = sc.nextInt();
		System.out.println("Cost per sqaure foot:");
		int roomCost = sc.nextInt();
		String userChoice = sc.nextLine();
		System.out.println("Type of the Carpet-- Velvet, Saxony, Frieze, Shag, Cable ");
		RoomCarpet rc = new RoomCarpet(roomLength, roomWidth, userChoice);
		double cost = rc.carpetsCost();
		System.out.println("Total cost of the carpet is:"+cost);
		
	}
		
}


