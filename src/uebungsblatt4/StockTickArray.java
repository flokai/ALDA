package uebungsblatt4;

public class StockTickArray {
	
	private StockTick [] Aktienkurse;
	
	public StockTickArray(int laenge) {
		Aktienkurse = new StockTick [laenge];
	}
	
	public void getAktienkurse () {
		for (int i = 0; i < this.Aktienkurse.length; i++){
			System.out.println("Kurs " + (i+1) + Aktienkurse[i].getKurs());
		}
	}
	
	public void setAktienkurse () {
		for (int i = 0; i < this.Aktienkurse.length; i++){
			this.Aktienkurse[i].setSymbol("Test");
		}
	}

	
	public void sortStockTickArray() {
		
	}
}
