package uebungsblatt4;



public class StockTickArray {

	int laenge;
	public StockTick[] Aktienkurse =  new StockTick[3];;

	
	public StockTickArray (int laenge) {
		this.laenge = laenge;
		Aktienkurse = new StockTick[laenge];
	}
	
	public int getKurs() {
		int [] Ausgabe = new int [laenge];
		for (int i = 0; i < Aktienkurse.length; i++) {
			Ausgabe [i] = Aktienkurse[i].getKurs();
		}
		int a = 0;
		for (int i : Ausgabe) {
			a = a + i;
		}
		return a;
	}
	
	// Sortieren durch Einfügen mit sequentieller Suche
	public void sortStockTickArray() {
		int j;
		int x;
		StockTick[] Aktienkurse = new StockTick[this.laenge];
		for (int i = 0; i < Aktienkurse.length; i++) {
			x = Aktienkurse[i].getKurs();
			j = i;
			while(j > 0 && x < Aktienkurse[j-1].getKurs()){
				Aktienkurse[j] = Aktienkurse[j-1];
				j--;
			}
			Aktienkurse[j].setKurs(x);
		}
	}

	// Sortieren durch Einfügen mit binärer Suche.
	public void sortStockTickArray2() {
		

	}

}
