package uebungsblatt1;

import java.text.DateFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.Date;

public class Person {

	// Attribute
	String name = "Max";
	int telefonnummer = 1234567890;
	String geburtsdatum = "01.01.2000";

	// Getter und Setter Methoden
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setTelefonnummer(int telefonnummer) {
		this.telefonnummer = telefonnummer;
	}

	public int getTelefonnummer() {
		return this.telefonnummer;
	}

	public void setGeburtstdatum(String geburtsdatum) {
		this.geburtsdatum = geburtsdatum;
	}

	public String getGeburtsdatum() {
		return this.geburtsdatum;
	}

	// restliche Methoden
	public void read() {

		Scanner input = new Scanner(System.in);
		System.out.println("Bitte geben Sie den Namen ein: ");
		String name = input.next();
		this.setName(name);

		int x = 0;
		do {
			System.out.println("Bitte geben Sie das Geburtsdatum ein: ");
			String geburtsdatum = input.next();
			if (this.isDateCorrect(geburtsdatum) == true) {
				this.setGeburtstdatum(geburtsdatum);
				System.out.println("Datum ist korrekt");
				x = 2;
			} else {
				System.out.println("Datum ist nicht korrekt");
				x = 1;
			}
		} while (x == 1);

		System.out.println("Bitte geben Sie die Telefonnummer ein: ");
		int telefonnummer = input.nextInt();
		this.setTelefonnummer(telefonnummer);
	}

	public String toString() {
		String text;
		text = "Name: " + this.getName() + "\nGebursdatum: "
				+ this.getGeburtsdatum() + "\nTelefonnumer: "
				+ this.getTelefonnummer();
		return text;
	}

	public Date pruefeDatum(String datum) throws ParseException {
		// eine auf die Rechnerlokation abgestimmte Instanz der Klasse
		// DateFormat wird erzeugt.
		DateFormat df = DateFormat.getDateInstance();

		// strenge Datumsprüfung einschalten
		df.setLenient(false);

		// Datum überprüfen und in ein Date Objekt wandeln.
		// Die Methode parse() wirft eine ParseException, wenn in
		// datum kein gültiges Datum steht.
		Date d = df.parse(datum);
		return d;
	}

	public boolean isDateCorrect(String eingabe) {
		Date datum = null;
		try {
			datum = this.pruefeDatum(eingabe);
			return true;
		} catch (ParseException e) {
			return false;
		}
	}

}
