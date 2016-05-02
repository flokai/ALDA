package uebungsblatt1;

import java.util.Scanner;

public class Student extends Person {
	
	int matrikelnummer = 123456;
	
	public void setMatrikelnummer (int matrikelnummer) {
		this.matrikelnummer = matrikelnummer;
	}
	
	public int getMatrikelnummer () {
		return matrikelnummer;
	}
	
	public void read() {
		super.read();
		
		Scanner eingabe = new Scanner(System.in);
		System.out.println("Bitte geben Sie die Matrikelnummer ein: ");
		int matrikelnummer = eingabe.nextInt();
		this.setMatrikelnummer(matrikelnummer);	
	}
	
	public String toString(){
		String text;
		text = super.toString() + "\nMatrikelnummer: " + this.getMatrikelnummer();
		return text;
	}

}
