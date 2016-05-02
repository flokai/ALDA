package test;

import uebungsblatt2.StockTick;

public class Aktien {
	
	StockTick [] Aktienkurse;
	
	private static int x;
	private static int y;

	public void AktienAnlegen(StockTick [] Aktienkurse, int x) {
		
		int Anfangskurs = (int) (Math.random()*100) +500;
		
		int [] kursDifferenzen = new int [x+1];
		
		kursDifferenzen[0] = 0;
		
		for (int i = 1; i < kursDifferenzen.length; i++){
			kursDifferenzen[i] = (int) (Math.random()*60) - 30;
		}
		
		for (int i = 0; i < kursDifferenzen.length; i++){
			System.out.print(kursDifferenzen[i] + "; ");
		}
		
		// Es wird ein Array für die Objekte StockTick mit dem Aktienkurs pro Tag angelegt
		StockTick [] tmp = new StockTick[kursDifferenzen.length];
		this.Aktienkurse = tmp;
		
		// Der Aktienkurs für den Anfangskurs wird manuell gesetzt
		this.Aktienkurse[0] = new StockTick();
		this.Aktienkurse [0].setKurs(Anfangskurs, 0);
		
		// mittels for-Schleife werden die Objekte erzeugt und die Kurse durch die "getKurs" Methode berechnet
		for(int i = 1; i <= this.Aktienkurse.length-1; i++){
			this.Aktienkurse[i] = new StockTick();
			this.Aktienkurse[i].setKurs(this.Aktienkurse[i-1].getKurs(), kursDifferenzen[i]);
		}
		
		// der Anfangskurs wird ausgegeben
		System.out.println();
		System.out.println("Der Anfangskurs liegt bei " + this.Aktienkurse[0].getKurs() + " Euro");
		System.out.println();
		
		// mittels for-Schleife werden die restlichen Tage ausgegeben
		for(int i = 1; i < this.Aktienkurse.length; i ++) {
			System.out.println("Der Kurs veränderte sich um " + kursDifferenzen[i] + " Euro im Vergleich zum Vortag");
			System.out.println("Der Aktienkurs an Tag " + i + " liegt bei: " + this.Aktienkurse[i].getKurs()); 
			System.out.println();
		}	
		
	}
	
	public void DifferenzenRechner (StockTick[] array) {
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
		System.err.println("Der so realisierte Gewinn wäre " + prozentualeDifferenz  + " % vom eingesetzten Betrag gewesen.");
	}
	
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
