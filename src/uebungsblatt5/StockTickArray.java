package uebungsblatt5;

import java.util.Arrays;

public class StockTickArray {

	int laenge;
	public StockTick[] Aktienkurse;

	// Konstruktor
	public StockTickArray(int laenge) {
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
			System.out.println(Aktienkurse[i].getSymbol() + ": "
					+ Aktienkurse[i].getKurs());
		}
	}

	// Sortieren durch Einfügen mit sequentieller Suche
	// nach Kurswerten
	public int sortStockTickArray() {
		int j;
		int zähler = 0;
		StockTick Aktie = new StockTick(0, "");
		// sortiert wird nach dem Aktienkurs
		for (int i = 1; i < Aktienkurse.length; i++) {
			Aktie = Aktienkurse[i];
			j = i;
			while (j > 0 && Aktie.getKurs() < Aktienkurse[j - 1].getKurs()) {
				Aktienkurse[j] = Aktienkurse[j - 1];
				j--;
				zähler++; // Zur Zählung der Anzahl der Vergleiche
			}
			Aktienkurse[j] = Aktie;
		}
		return zähler;
	}

	// Sortieren durch Einfügen mit sequentieller Suche
	// nach FirmenKürzel
	public int sortStockTickArray2() {
		int j;
		int zähler = 0;
		StockTick Aktie = new StockTick(0, "");
		// sortiert wird nach dem Aktienkurs
		for (int i = 1; i < Aktienkurse.length; i++) {
			Aktie = Aktienkurse[i];
			j = i;
			while (j > 0
					&& (Aktie.getSymbol().compareTo(
							Aktienkurse[j - 1].getSymbol()) < 0)) {
				Aktienkurse[j] = Aktienkurse[j - 1];
				j--;
				zähler++;
			}
			Aktienkurse[j] = Aktie;
		}
		return zähler;
	}

	// Sortieren durch Einfügen mit binärer Suche.
	public int sortStockTickArray3() {

		int j, links, rechts, mitte;
		StockTick Aktie = new StockTick(0, "");
		int zähler = 0;

		// eigentlicher Algorithmus
		for (int i = 1; i < Aktienkurse.length; i++) {
			Aktie = Aktienkurse[i];
			links = 0;
			rechts = i - 1;
			while (links <= rechts) {
				mitte = ((links + rechts) / 2);
				if (Aktie.getKurs() < Aktienkurse[mitte].getKurs()) {
					rechts = (mitte - 1);// -1 0
					zähler++;
				} else
					links = (mitte + 1);// 0 1
				zähler++;
			}
			for (j = i - 1; j >= links; j--) {
				Aktienkurse[(j + 1)] = Aktienkurse[j];
			}
			Aktienkurse[links] = Aktie;
		}
		return zähler;
	}

	// Sortieren durch Einfügen mit binärer Suche.
	// nach Firmensymbol
	public int sortStockTickArray4() {

		int j, links, rechts, mitte;
		StockTick Aktie = new StockTick(0, "");
		int zähler = 0;

		// eigentlicher Algorithmus
		for (int i = 1; i < Aktienkurse.length; i++) {
			Aktie = Aktienkurse[i];
			links = 0;
			rechts = i - 1;
			while (links <= rechts) {
				mitte = ((links + rechts) / 2);
				if (Aktie.getSymbol().compareTo(Aktienkurse[mitte].getSymbol()) < 0) {
					rechts = (mitte - 1);// -1 0
					zähler++;
				} else
					links = (mitte + 1);// 0 1
				zähler++;
			}
			for (j = i - 1; j >= links; j--) {
				Aktienkurse[(j + 1)] = Aktienkurse[j];
			}
			Aktienkurse[links] = Aktie;
		}
		return zähler;
	}

	// Sortieren durch Einfügen mit binärer Suche mit beliebigen Grenzen.
	public int sortStockTickArray5(int left, int right) {

		int j, links, rechts, mitte;
		StockTick Aktie = new StockTick(0, "");
		int zähler = 0;

		// eigentlicher Algorithmus
		for (int i = 1; i < Aktienkurse.length; i++) {
			Aktie = Aktienkurse[i];
			links = left;
			rechts = right;
			while (links <= rechts) {
				mitte = ((links + rechts) / 2);
				if (Aktie.getKurs() < Aktienkurse[mitte].getKurs()) {
					rechts = (mitte - 1);// -1 0
					zähler++;
				} else
					links = (mitte + 1);// 0 1
				zähler++;
			}
			for (j = i - 1; j >= links; j--) {
				Aktienkurse[(j + 1)] = Aktienkurse[j];
			}
			Aktienkurse[links] = Aktie;
		}
		return zähler;
	}

	// binäre suche
	public boolean binäreSuche(String AktienSymbol) {

		int j, links, rechts, mitte;
		boolean test = false;

		// eigentlicher Algorithmus
		for (int i = 1; i < Aktienkurse.length + 1; i++) {
			links = 0;
			rechts = i - 1;
			while (links <= rechts) {
				mitte = ((links + rechts) / 2);
				if (AktienSymbol.compareTo(Aktienkurse[mitte].getSymbol()) < 0) {
					rechts = (mitte - 1);// -1 0
				}
				if (AktienSymbol.compareTo(Aktienkurse[mitte].getSymbol()) > 0) {
					links = (mitte + 1);// -1 0
				}
				if (AktienSymbol.compareTo(Aktienkurse[mitte].getSymbol()) == 0) {
					return true;
				}
			}
		}
		return false;
	}

	// prüft ob das Array sortiert ist
	public boolean ArraySortiert() {
		for (int i = 0; i < Aktienkurse.length - 1; i++) {
			if (Aktienkurse[i].getSymbol().compareTo(
					Aktienkurse[i + 1].getSymbol()) > 0) {
				return false;
			}
		}
		return true;
	}

	public void swap(int i, int j) {
		StockTick temp = Aktienkurse[i];
		Aktienkurse[i] = Aktienkurse[j];
		Aktienkurse[j] = temp;
	}

	public int quickSortKurse(int left, int right) {
		int zähler = 1;
		StockTick pivot = Aktienkurse[(left + right) / 2];
		zähler++;
		int i = left;
		int j = right;

		while (i <= j) {
			while (Aktienkurse[i].getKurs() < pivot.getKurs()) {
				i++;
			}
			while (pivot.getKurs() < Aktienkurse[j].getKurs()) {
				j--;
			}
			if (i <= j) {
				swap(i, j);
				zähler = (zähler + 3);
				i++;
				j--;
			}
		}
		if (left < j) {
			quickSortKurse(left, j);
		}
		if (i < right) {
			quickSortKurse(i, right);
		}
		return zähler;
	}

	public void quickSortSymbol(int left, int right) {
		StockTick pivot = Aktienkurse[(left + right) / 2];
		int i = left;
		int j = right;

		while (i <= j) {
			while (Aktienkurse[i].getSymbol().compareTo(pivot.getSymbol()) < 0) {
				i++;
			}
			while (pivot.getSymbol().compareTo(Aktienkurse[j].getSymbol()) < 0) {
				j--;
			}
			if (i <= j) {
				swap(i, j);
				i++;
				j--;
			}
		}
		if (left < j) {
			quickSortSymbol(left, j);
		}
		if (i < right) {
			quickSortSymbol(i, right);
		}
	}

	public int quickSortRandom(int left, int right) {
		int zähler = 1;
		StockTick pivot = Aktienkurse[(int) Math.random() * Aktienkurse.length];
		zähler++;
		int i = left;
		int j = right;

		while (i <= j) {
			while (Aktienkurse[i].getKurs() < pivot.getKurs()) {
				i++;
			}
			while (pivot.getKurs() < Aktienkurse[j].getKurs()) {
				j--;
			}
			if (i <= j) {
				swap(i, j);
				zähler = (zähler + 3);
				i++;
				j--;
			}
		}
		if (left < j) {
			quickSortKurse(left, j);
		}
		if (i < right) {
			quickSortKurse(i, right);
		}
		return zähler;
	}

	// Sortieren durch Einfügen mit binärer Suche.
	public int insertionSort(int left, int right) {

		int j, links, rechts, mitte;
		StockTick Aktie = new StockTick(0, "");
		int zähler = 0;

		// eigentlicher Algorithmus
		for (int i = 1; i < Aktienkurse.length; i++) {
			Aktie = Aktienkurse[i];
			links = left;
			rechts = right;
			while (links <= rechts) {
				mitte = ((links + rechts) / 2);
				if (Aktie.getKurs() < Aktienkurse[mitte].getKurs()) {
					rechts = (mitte - 1);// -1 0
					zähler++;
				} else
					links = (mitte + 1);// 0 1
				zähler++;
			}
			for (j = i - 1; j >= links; j--) {
				Aktienkurse[(j + 1)] = Aktienkurse[j];
			}
			Aktienkurse[links] = Aktie;
		}
		return zähler;
	}

	public int quickSortKurseMitBinaer(int left, int right) {
		int zähler = 1;

		StockTick pivot = Aktienkurse[(left + right) / 2];
		zähler++;
		int i = left;
		int j = right;

		while (i <= j) {
			while (Aktienkurse[i].getKurs() < pivot.getKurs()) {
				i++;
			}
			while (pivot.getKurs() < Aktienkurse[j].getKurs()) {
				j--;
			}
			if (i <= j) {
				swap(i, j);
				zähler = (zähler + 3);
				i++;
				j--;
			}
		}

		if ((j - i) > 5) {
			if (left < j) {
				quickSortKurse(left, j);
			}
			if (i < right) {
				quickSortKurse(i, right);
			}
		} else {
			this.insertionSort(left, right);
			zähler = zähler + 100;
		}

		return zähler;
	}

}
