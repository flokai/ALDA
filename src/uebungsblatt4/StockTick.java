package uebungsblatt4;

public class StockTick {

	private String symbol;
	private int kurs;
	
	public StockTick(int kurs, String symbol){
		this.kurs = kurs;
		this.symbol = symbol;
	}
	
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public int getKurs() {
		return kurs;
	}
	public void setKurs(int kurs) {
		this.kurs = kurs;
	}

}