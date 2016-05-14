package uebungsblatt4;

import java.util.Random;
import java.util.Scanner;

public class StartKlasse {

	public static void main(String[] args) {		
		
		// Durch Abfrage die Array-Länge bestimmen
		Scanner input = new Scanner(System.in);
		System.out.println("Bitte geben Sie die Array-Länge ein");
		int laenge = input.nextInt();
		
		// Array erzeugen
		StockTickArray AktienArray = new StockTickArray(laenge);
		
		// Array mit den möglichen Firmen-Kürzel
		String[] Firmen = {"IBM", "CSCO", "HPQ", "GOOG", "ORCL", "GPRO", "BABA", "AAPL", "SAP", "MSFT"};
		
		for (int i = 0; i < AktienArray.Aktienkurse.length; i++) {
			Random zufall = new Random();
			int kursWerte = zufall.nextInt(11)+60; // bis 11, da zahlen von 0 bis 10
			int zähler = zufall.nextInt(10); // bis 9, da Array mit 0 beginnt
			AktienArray.Aktienkurse[i].setKurs(kursWerte);
			AktienArray.Aktienkurse[i].setSymbol(Firmen[zähler]);
		}
		
		AktienArray.getAktienkurse();
		
//		AktienArray.sortStockTickArray();
//		System.out.println("----- Algorithmus sortiert ------");
		
//		AktienArray.sortStockTickArray2();
//		System.out.println("----- Algorithmus sortiert ------");
		
		AktienArray.sortStockTickArray3();
		System.out.println("----- Algorithmus sortiert ------");
		
		AktienArray.getAktienkurse();
		
	}
	
}
