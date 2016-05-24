package uebungsblatt4;

import java.util.Arrays;

public class StockTickArray {

	int laenge;
	public StockTick[] Aktienkurse;
	
	// Konstruktor
	public StockTickArray (int laenge) {
		this.laenge = laenge;
		// Das Array wird erzeugt
		Aktienkurse = new StockTick[laenge];
		// für jede Stelle im Array wird ein Objekt vom Typ StockTick angelegt
		for (int i = 0; i < Aktienkurse.length; i++) {
			Aktienkurse[i] = new StockTick(0, "");
		}
	}
	
	public void getKurs() {
		for (int i = 0; i < Aktienkurse.length; i++) {
			System.out.println(Aktienkurse[i].getKurs());
		}
	}
	
	public void getSymbol() {
		for (int i = 0; i < Aktienkurse.length; i++) {
			System.out.println(Aktienkurse[i].getKurs());
		}
	}
	
	public void getAktienkurse() {
		for (int i = 0; i < Aktienkurse.length; i++) {
			System.out.println(Aktienkurse[i].getSymbol() + ": " + Aktienkurse[i].getKurs());
		}
	}	
	
	// Sortieren durch Einfügen mit sequentieller Suche
	// nach Kurswerten
	public int sortStockTickArray() {
		int j;
		int zähler = 0;
		StockTick Aktie = new StockTick(0,"");
		// zweites Array mit gleicher Länger anlegen
		StockTick[] Aktienkurse2 = new StockTick[this.laenge];
		for (int i = 0; i < Aktienkurse2.length; i++) {
			Aktienkurse2[i] = new StockTick(Aktienkurse[i].getKurs(),Aktienkurse[i].getSymbol());
		}
		// der Algorithmus
		// sortiert wird nach dem Aktienkurs
		for (int i = 1; i < Aktienkurse.length; i++) {
			Aktie = Aktienkurse[i];
			j = i;
			while(j > 0 && Aktie.getKurs() < Aktienkurse[j-1].getKurs()){
				Aktienkurse[j] = Aktienkurse[j-1];
				j--;
				zähler++; // Zur Zählung der Anzahl der Vergleiche
			}
			Aktienkurse[j] = Aktie;
		}
		
//		for (int i = 0; i < Aktienkurse2.length; i++) {
//			Aktienkurse[i] = Aktienkurse2[i];
//		}
		return zähler;
	}

	// Sortieren durch Einfügen mit sequentieller Suche
	// nach FirmenKürzel
	public int sortStockTickArray2() {
		int j;
		int zähler = 0;
		StockTick Aktie = new StockTick(0,"");
		// zweites Array mit gleicher Länge anlegen
		StockTick[] Aktienkurse2 = new StockTick[this.laenge];
		for (int i = 0; i < Aktienkurse2.length; i++) {
			Aktienkurse2[i] = new StockTick(Aktienkurse[i].getKurs(), Aktienkurse[i].getSymbol());
		}
		// der Algorithmus
		// sortiert wird nach dem Aktienkurs
		for (int i = 1; i < Aktienkurse.length; i++) {
			Aktie = Aktienkurse[i];
			j = i;
			while(j > 0 && (Aktie.getSymbol().compareTo(Aktienkurse[j-1].getSymbol()) < 0)){
				Aktienkurse[j] = Aktienkurse[j-1];
				j--;
				zähler++;
			}
			Aktienkurse[j] = Aktie;
		}
//		for (int i = 0; i < Aktienkurse.length; i++) {
//			Aktienkurse[i] = Aktienkurse[i];
//		}
		return zähler;
	}
	
	// Sortieren durch Einfügen mit binärer Suche.
	public int sortStockTickArray3() {
		
		int j, links, rechts, mitte;
		StockTick Aktie = new StockTick(0,"");
		int zähler = 0;

		// eigentlicher Algorithmus
		for (int i = 1; i < Aktienkurse.length; i++) {
			Aktie = Aktienkurse[i];
			links = 0;
			rechts = i-1;
			while (links <= rechts){
				mitte = ((links+rechts)/2);
				if(Aktie.getKurs() < Aktienkurse[mitte].getKurs()){
					rechts = (mitte - 1);// -1	0
					zähler++;
				} else
					links = (mitte + 1);// 0	1
					zähler++;
			}
			for (j = i-1; j >= links; j--) {
				Aktienkurse[(j+1)] = Aktienkurse[j]; 
				Aktienkurse[links] = Aktie;
			}
		}
		return zähler;
	}
	
	
	public void sortStockTickArray4() {
		

	}
	
	
	public boolean ArraySortiert (){
		boolean test = false;
		for (int i = 0; i < Aktienkurse.length-1; i++) {
			if(Aktienkurse[i].getKurs()<=Aktienkurse[i+1].getKurs()){
				test = true;
			}
		}
		return test;
	}
	
}
