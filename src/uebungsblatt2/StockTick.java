package uebungsblatt2;

public class StockTick {
	
	private double kurs;

	public double getKurs() {
		return kurs;
	}
	
	public void setKurs(double letzterKurs, float kursDiff) {
		double tmp = (letzterKurs + kursDiff);
		this.kurs = tmp;
	}
	
//	public void setKurs(double letzterKurs, float kursDiff) {
//		double tmp = 0;		
//		if(kursDiff > 0){
//			tmp = (letzterKurs + ((letzterKurs/100)*kursDiff));
//		}
//		if(kursDiff < 0){
//			tmp = (letzterKurs + ((letzterKurs/100)*kursDiff));
//		}
//		if(kursDiff == 0){
//			tmp = letzterKurs;
//		}
//		this.kurs = tmp;
//	}


}
