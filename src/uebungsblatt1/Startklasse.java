package uebungsblatt1;

import java.util.Scanner;

public class Startklasse {

	public static void main(String[] args) {
		
//		String datum = "29.02.2015";
//		Student student = new Student();
//		
//		System.out.println(student.isDateCorrect(datum));
		

		// Array mit den Studenten wir angelegt und befüllt
		Student[] StudentenArray = new Student[2];

		for (int i = 0; i < StudentenArray.length; i++) {
			StudentenArray[i] = new Student();
		}

		for (int i = 0; i < StudentenArray.length; i++) {
			StudentenArray[i].read();
		}

		// Schleife, welche die Informations-Abfrage wiederholt bis zum
		// manuellen Abbruch
		int entscheidung;

		do {

			System.out.println();
			Scanner eingabe = new Scanner(System.in);
			System.out
					.println("Bitte geben Sie die zu überprüfende Matrikelnummer ein:");
			int matrikelnummer = eingabe.nextInt();

			System.out.println();
			boolean result = false;
			int a = -1;
			// Die Matrikelnummer wird mit dem Array abgeglichen
			for (int i = 0; i < StudentenArray.length; i++) {
				if (StudentenArray[i].getMatrikelnummer() == matrikelnummer) {
					result = true;
					a = i;
				}
			}
			// Wenn es den Studenten gibt, dann werden seine Daten ausgegeben
			// Wenn es den Studenten nicht gibt, dann wird ein Hinweis
			// ausgegeben
			if (result == true) {
				System.out.println("Der Student mit der Matrikelnummer "
						+ matrikelnummer + " hat folgende Daten \n"
						+ StudentenArray[a].toString());
			} else {
				System.out.println("Der Student mit der Matrikelnummer "
						+ matrikelnummer + " existiert nicht.");
			}

			System.out.println();
			System.out
					.println("Möchten Sie eine weitere Matrikelnummer übprüfen? \nja (1) \nnein (2) ");
			entscheidung = eingabe.nextInt();

		} while (entscheidung == 1);

	}

}
