package uebungsblatt4;

import java.util.Scanner;

public class StartKlasse {

	public static void main(String[] args) {

		// Anlegen des Arrays mittels Benutzereingabe der Länge
		Scanner input = new Scanner(System.in);
		System.out.println("Bitte geben Sie die Array-Länge ein");
		int laenge = input.nextInt();
		StockTick[] Aktienkurse = new StockTick[laenge];
		if (laenge >= 0) {
			System.out.println("Array mit der Länge " + laenge
					+ " wurde erzeugt.");
		}
		
		Aktienkurse[0].setKurs(4);
		System.out.println(Aktienkurse[0].getKurs());
		

//		StockTickArray Test = new StockTickArray (laenge);
//		System.out.println(Test.laenge);
//		Test.getKurs();
		
	}

}
