package uebungsblatt4;

import java.util.Random;
import java.util.Scanner;

public class StartKlasse {

	public static void main(String[] args) {

		// Array mit den möglichen Firmen-Kürzel
		String[] Firmen = { "IBM", "CSCO", "HPQ", "GOOG", "ORCL", "GPRO","BABA", "AAPL", "SAP", "MSFT" };

		// Durch Abfrage die Array-Länge bestimmen
		Scanner input = new Scanner(System.in);
		System.out.println("Bitte geben Sie die Array-Länge ein");
		int laenge = input.nextInt();
		// Array erzeugen
		StockTickArray AktienArray = new StockTickArray(laenge);
		StockTickArray AktienArray2 = new StockTickArray(laenge);
		
		System.out.println("------ Teil 1 ------");

		for (int i = 0; i < AktienArray.Aktienkurse.length; i++) {
			Random zufall = new Random();
			int kursWerte = zufall.nextInt(11) + 60;
			// bis 11, da zahlen von 0 bis 10
			int zähler = zufall.nextInt(10);
			// bis 9, da Array mit 0 beginnt
			AktienArray.Aktienkurse[i].setKurs(kursWerte);
			AktienArray.Aktienkurse[i].setSymbol(Firmen[zähler]);
		}

		AktienArray.getAktienkurse();
		
		System.out.print("\nWie möchten Sie die Aktien sortieren?");
		System.out.println("\n(1) Sequentielle Suche nach Kursen \n(2) Binäre Suche nach Kursen");

		int auswahl = input.nextInt();
		
		switch(auswahl){
			case 1: AktienArray.sortStockTickArray(); break;
			case 2: AktienArray.sortStockTickArray3(); break;
			default: System.out.println("Ungültige Auswahl");
		}
		
		System.out.println("----- Array wurde nach Kursen sortiert ------");
		AktienArray.getAktienkurse();
		
		System.out.print("\nWie möchten Sie die Aktien sortieren?");
		System.out.println("\n(1) Sequentielle Suche nach Firmen \n(2) Binäre Suche nach Firmen");

		auswahl = input.nextInt();
		
		switch(auswahl){
			case 1: AktienArray.sortStockTickArray2(); break;
			case 2: AktienArray.sortStockTickArray4(); break;
			default: System.out.println("Ungültige Auswahl");
		}
		
		System.out.println("----- Array wurde nach Firmen sortiert ------");
		AktienArray.getAktienkurse();
		

		System.out.println("\n------ Teil 2 ------");	
		
		int sortierenSequientiell = 0; int sortierenBinär = 0; int a = 0; int b = 0;
//		
//		for (int k = 1; k < 10; k++) {
//
//			for (int i = 0; i < AktienArray.Aktienkurse.length; i++) {
//				Random zufall = new Random();
//				int kursWerte = zufall.nextInt(11) + 60;
//				// bis 11, da zahlen von 0 bis 10
//				int zähler = zufall.nextInt(10);
//				// bis 9, da Array mit 0 beginnt
//				AktienArray.Aktienkurse[i].setKurs(kursWerte);
//				AktienArray.Aktienkurse[i].setSymbol(Firmen[zähler]);
//			}
//			
//			// zweites gleiches Array anelgen
//			for (int i = 0; i < AktienArray.Aktienkurse.length; i++) {
//				AktienArray2.Aktienkurse[i].setKurs(AktienArray.Aktienkurse[i].getKurs());
//				AktienArray2.Aktienkurse[i].setSymbol(AktienArray.Aktienkurse[i].getSymbol());
//			}
//
//			sortierenSequientiell = sortierenSequientiell + AktienArray.sortStockTickArray();
//			sortierenBinär = sortierenBinär + AktienArray2.sortStockTickArray3();
//
//			a = sortierenSequientiell/k;
//			b = sortierenBinär/k;
//		}
//
//		System.out.println("Sortieren durch Einfügen mit sequientieller Suche hat folgende Durschnittswerte: "+ a);
//		System.out.println("Sortieren durch Einfügen mit binärer Suche hat folgende Durschnittswerte: "+ b);
		
		System.out.println("\n------ Teil 3 ------");
		
		if (AktienArray.ArraySortiert() == true) {
			System.out.println("Das Array ist sortiert!");
		} else
			System.out.println("Achtung! Das Array ist nicht sortiert!");

		String Name;
		boolean richtig = false;

		do {
			System.out.println("Welche Aktie möchten Sie suchen?");
			Name = input.next();
			if(AktienArray.binäreSuche(Name) == true){
				richtig = true;
				System.out.println("Aktie gefunden");
			} else 
				System.out.println("Aktie nicht gefunden");
			
		} while (richtig == false);

		// Ausgabe der Kurse
		for (int i = 0; i < AktienArray.Aktienkurse.length; i++) {
			if (AktienArray.Aktienkurse[i].getSymbol().equals(Name)) {
				System.out.println("Pos " + i + ": "
						+ AktienArray.Aktienkurse[i].toString());
			}

		}
	}

}
