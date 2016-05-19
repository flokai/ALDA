package uebungsblatt4;

import java.util.Random;
import java.util.Scanner;

public class StartKlasse {

	public static void main(String[] args) {

		// Array mit den möglichen Firmen-Kürzel
		String[] Firmen = { "IBM", "CSCO", "HPQ", "GOOG", "ORCL", "GPRO",
				"BABA", "AAPL", "SAP", "MSFT" };

		// Durch Abfrage die Array-Länge bestimmen
		Scanner input = new Scanner(System.in);
		System.out.println("Bitte geben Sie die Array-Länge ein");
		int laenge = input.nextInt();
		// Array erzeugen
		StockTickArray AktienArray = new StockTickArray(laenge);
		
		
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

		AktienArray.sortStockTickArray();
		System.out.println("----- Array wurde sortiert nach Kursen // Algorithmus mit sequientieller Suche ------");

		AktienArray.getAktienkurse();
		

		System.out.println("------ Teil 2 ------");
		
		
		int sortierenSequientiell = 0;
		int sortierenBinär = 0;
		int a = 0;
		int b = 0;

		for (int k = 1; k < 10; k++) {

			for (int i = 0; i < AktienArray.Aktienkurse.length; i++) {
				Random zufall = new Random();
				int kursWerte = zufall.nextInt(11) + 60;
				// bis 11, da zahlen von 0 bis 10
				int zähler = zufall.nextInt(10);
				// bis 9, da Array mit 0 beginnt
				AktienArray.Aktienkurse[i].setKurs(kursWerte);
				AktienArray.Aktienkurse[i].setSymbol(Firmen[zähler]);
			}

			sortierenSequientiell = +AktienArray.sortStockTickArray();
			sortierenBinär = +AktienArray.sortStockTickArray3();

			a = sortierenSequientiell / k;
			b = sortierenBinär / k;
		}

		System.out
				.println("Sortieren durch Einfügen mit sequientieller Suche hat folgende Durschnittswerte: "
						+ a);
		System.out
				.println("Sortieren durch Einfügen mit binärer Suche hat folgende Durschnittswerte: "
						+ b);

		
		System.out.println("------ Teil 3 ------");
		
		if (AktienArray.ArraySortiert() == true) {
			System.out.println("Das Array ist sortiert!");
		} else
			System.out.println("Achtung! Das Array ist nicht sortiert!");

		String Name;
		boolean richtig = false;

		do {
			System.out.println("Welche Aktie möchten Sie suchen?");
			Name = input.next();
			for (int i = 0; i < Firmen.length; i++) {
				if (Firmen[i].equals(Name)) {
					richtig = true;
				}
			}
		} while (richtig == false);

		for (int i = 0; i < AktienArray.Aktienkurse.length; i++) {
			if (AktienArray.Aktienkurse[i].getSymbol().equals(Name)) {
				System.out.println("Pos" + i + ": "
						+ AktienArray.Aktienkurse[i].toString());
			}

		}
	}

}
