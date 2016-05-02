package uebungsblatt2;

public class Aktienkursanalyse {

	public static void main(String[] args) {
		
//		// Der Anfangskurs wird festgelegt
//		double Anfangskurs  = 127.5;
//		
//		// Es wird ein Array mit Kursdifferenzen festgelegt und für den ersten Tag der Wert Null gesetzt
//		float [] kursDifferenzen = {0,-0.5f, 2, -1, 1, 3.5f, -13, 7, -2, -6, -9, -21, -17, -5, 0.5f, 4, -7, -12, 2.5f, -3, 2};
//		
		int Anfangskurs = (int) (Math.random()*100) +500;
		
		int [] kursDifferenzen = new int [21];
		
		kursDifferenzen[0] = 0;
		
		for (int i = 1; i < kursDifferenzen.length; i++){
			kursDifferenzen[i] = (int) (Math.random()*60) - 30;
		}
		
		for (int i = 0; i < kursDifferenzen.length; i++){
			System.out.print(kursDifferenzen[i] + "; ");
		}	
		
		// Es wird ein Array für die Objekte StockTick mit dem Aktienkurs pro Tag angelegt
		StockTick [] Aktienkurse = new StockTick[kursDifferenzen.length];
		
		// Der Aktienkurs für den Anfangskurs wird manuell gesetzt
		Aktienkurse[0] = new StockTick();
		Aktienkurse[0].setKurs(Anfangskurs, 0);
		
		// mittels for-Schleife werden die Objekte erzeugt und die Kurse durch die "getKurs" Methode berechnet
		for(int i = 1; i <= Aktienkurse.length-1; i++){
			Aktienkurse[i] = new StockTick();
			Aktienkurse[i].setKurs(Aktienkurse[i-1].getKurs(), kursDifferenzen[i]);
		}
		
		// der Anfangskurs wird ausgegeben
		System.out.println();
		System.out.println("Der Anfangskurs liegt bei " + Aktienkurse[0].getKurs() + " Euro");
		System.out.println();
		
		// mittels for-Schleife werden die restlichen Tage ausgegeben
		for(int i = 1; i < Aktienkurse.length; i ++) {
			System.out.println("Der Kurs veränderte sich um " + kursDifferenzen[i] + " Euro im Vergleich zum Vortag");
			System.out.println("Der Aktienkurs an Tag " + (i+1) + " liegt bei: " + Aktienkurse[i].getKurs()); 
			System.out.println();
		}	
		DifferenzenRechner3(Aktienkurse);
	}
	
	private static int x;
	private static int y;
	
	public static void DifferenzenRechner(StockTick[] array) {
		double differenz = 0;
		for(int i = 0; i< array.length-1; i++){
			for (int j = i+1; j < array.length; j++){
				if(((100/ array[i].getKurs() * array[j].getKurs()) -100) > differenz){
					differenz = ((100/ array[i].getKurs() * array[j].getKurs()) -100);
					x = i;
					y = j;
				}
			}
		}
		
		double prozentualeDifferenz = (((100/array[x].getKurs())*array[y].getKurs())-100);
		double tmp = Math.round(prozentualeDifferenz*100);
		prozentualeDifferenz = tmp/100;
		
		System.err.println("Ein bester Einkaufstag wäre der " + (x+1) + ". Börsentag gewesen. Kurs: "+ array[x].getKurs() );
		System.err.println("Ein dazugehöriger Verkaufstag der " + (y+1) + ". Börsentag. Kurs: " + array[y].getKurs());
		System.err.println("Der so realisierte Gewinn wäre " + prozentualeDifferenz  + " % vom eingesetzten Betrag gewesen.");	
	}
	
	public static void DifferenzenRechner2 (StockTick[] array) {
		int k = 0;
		double differenz = 0;
		for(int j = k+1; j< array.length-1; j++){
			if(((100/ array[k].getKurs() * array[j].getKurs()) -100) > differenz){
				differenz = ((100/ array[k].getKurs() * array[j].getKurs()) -100);
				x = k;
				y = j;
			}
			if(j == array.length-2 && k < array.length-2){
				k++;
				j=k+1;
			}
		}
		
		double prozentualeDifferenz = (((100/array[x].getKurs())*array[y].getKurs())-100);
		double tmp = Math.round(prozentualeDifferenz*100);
		prozentualeDifferenz = tmp/100;
		
		System.err.println("Ein bester Einkaufstag wäre der " + (x+1) + ". Börsentag gewesen. Kurs: "+ array[x].getKurs() );
		System.err.println("Ein dazugehöriger Verkaufstag der " + (y+1) + ". Börsentag. Kurs: " + array[y].getKurs());
		System.err.println("Der so realisierte Gewinn wäre " + prozentualeDifferenz  + " % vom eingesetzten Betrag gewesen.");	}
	
	public static void DifferenzenRechner3 (StockTick[] array) {
		double tmpEinkaufskurs = array[0].getKurs();
		double Einkaufskurs = 0;
		double differenz = 0;
		
		for(int i = 1; i < array.length; i++){
			if(array[i].getKurs() <= tmpEinkaufskurs){
				tmpEinkaufskurs = array[i].getKurs();
			} else {
				if(((100/ tmpEinkaufskurs * array[i].getKurs()) -100) > differenz){
					differenz = ((100/ tmpEinkaufskurs * array[i].getKurs()) -100);
					y = i;
					Einkaufskurs = tmpEinkaufskurs;
				}
			}
		}
		
		for (int j = 0; j < y; j++){
			if (array[j].getKurs() == Einkaufskurs){
				x = j;
			}
		}

		double prozentualeDifferenz = (((100/array[x].getKurs())*array[y].getKurs())-100);
		double tmp = Math.round(prozentualeDifferenz*100);
		prozentualeDifferenz = tmp/100;
		
		System.err.println("Ein bester Einkaufstag wäre der " + (x+1) + ". Börsentag gewesen. Kurs: "+ array[x].getKurs() );
		System.err.println("Ein dazugehöriger Verkaufstag der " + (y+1) + ". Börsentag. Kurs: " + array[y].getKurs());
		System.err.println("Der so realisierte Gewinn wäre " + prozentualeDifferenz  + " % vom eingesetzten Betrag gewesen.");	
	}

}
