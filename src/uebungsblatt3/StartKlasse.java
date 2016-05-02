package uebungsblatt3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Scanner;

public class StartKlasse {
	
	// Stack wird angelegt
	private static Stack meinStack = new Stack (15);
	private static FileReader file = null;
	private static BufferedReader buffer = null;

	public static void KlammerPrüfung(){
		
		// File wird angelegt und mittels BufferedReader wird die Datei eingelesen
		try {
			file = new FileReader("/Users/floriankaiser/Documents/workspace/ALDA/src/uebungsblatt3/Test.txt");
		} catch (FileNotFoundException e) {
			System.out.println("Die Datei konnte nicht gefunden werden. Bitte überprüfen Sie den Dateipfad");
			e.printStackTrace();
		}
		buffer = new BufferedReader(file);
		
		// Zeile für Zeile wird der Text eingelesen
		String zeile = null;
		try {
			zeile = buffer.readLine();
		} catch (IOException e) {
			System.out.println("Zeile kann nicht gelesen werden");
			e.printStackTrace();
		}
		int zeilenzähler = 0;
		boolean fehler = false;
		
		while (zeile != null){
			zeilenzähler++;
			for(int i = 0; i < zeile.length(); i++){
				// Jedes Zeichen innerhalb des Textes wird angeschaut
				char zeichen = zeile.charAt(i);
				// Wenn der Stack mit einer schliessenden Klammer begonnen wird, kommt ein Fehler
				if(zeichen == ')' | zeichen == '}' | zeichen == ']' && meinStack.isEmpty()){
					System.err.printf("Fehler! Schliessende Klammer %s ohne "
							+ "Gegenstueck an der Stelle %s : %s %n",
							zeichen, zeilenzähler, i);
					fehler = true;
					break;
				}
				/* Wenn das Zeichen eine öffnende Klammer ist, der Stack jedoch schon voll ist
				 * dann kommt ebenfalls eine Fehlermeldung mit der Info, dass der Stack voll ist
				 */
				switch(zeichen){
				case '(': 
					if(meinStack.isFull()){
						System.err.println ("Stack ist voll. Kein Hinzufügen mehr möglich");
					}
					meinStack.push(zeichen);
					break;
				case '{':
					if(meinStack.isFull()){
						System.err.println ("Stack ist voll. Kein Hinzufügen mehr möglich");
					}
					meinStack.push(zeichen);
					break;
				case '[':
					if(meinStack.isFull()){
						System.err.println ("Stack ist voll. Kein Hinzufügen mehr möglich");
					}
					meinStack.push(zeichen);
					break; // verlässt den switch-case
					
				/* Wenn das Zeichen eine schliessende Klammer ist, die zuletzt hinzugefügte Klammer jedoch
				 * keine öffnende Klammer ist, wird wieder ein Fehler ausgegeben 	
				 */
				case ')': 
					if(meinStack.pop() != '('){
					System.err.printf("Fehler! Schliessende Klammer %s ohne "
							+ "Gegenstueck an der Stelle %s : %s %n",
							zeichen, zeilenzähler, i);
					fehler = true;
					}
					break;
				case '}': 
					if(meinStack.pop() != '{'){
					System.err.printf("Fehler! Schliessende Klammer %s ohne "
							+ "Gegenstueck an der Stelle %s : %s %n",
							zeichen, zeilenzähler, i);
					fehler = true;
					}
					break;
				case ']': 
					if(meinStack.pop() != '['){
					System.err.printf("Fehler! Schliessende Klammer %s ohne "
							+ "Gegenstueck an der Stelle %s : %s %n",
							zeichen, zeilenzähler, i);
					fehler = true;
					}	
					break;
				}
				// for-Schleife verlassen
				if (fehler) {
					break;
				}
			}
			// while-Schleife bei Fehler verlassen
			if (fehler) {
				System.err.println("Das Programm wird beendet!");
				break;
			} else {
				System.out.printf("Zeile %s in Ordnung! %n", zeilenzähler);
			}
			try {
				zeile = buffer.readLine();
			} catch (IOException e) {
				System.out.println("Zeile kann nicht gelesen werden");
				e.printStackTrace();
			}
		}
		if(!meinStack.isEmpty()){
			System.err.printf("Die Prüfung ist abgeschlossen. %n"
					+ "Achtung! Nicht alle offenen Klammern wurden geschlossen.");
			fehler = true;
		}
		if (!fehler) {
			System.out.println("Die Pruefung ist abgeschlossen, keine Fehler");
		}
	}
	
	
	public static void KommentarPrüfung(){
		
		// Beispiel Kommentar
		// /*ababab/*cdcdcdc*/efef/*ghghgh*/*/
		
		// File wird angelegt und mittels BufferedReader wird die Datei eingelesen
		try {
			file = new FileReader("/Users/floriankaiser/Documents/workspace/ALDA/src/uebungsblatt3/Test.txt");
		} catch (FileNotFoundException e) {
			System.out.println("Die Datei konnte nicht gefunden werden. Bitte überprüfen Sie den Dateipfad");
			e.printStackTrace();
		}
		buffer = new BufferedReader(file);
		
		// Zeile für Zeile wird der Text eingelesen
		String zeile = null;
		try {
			zeile = buffer.readLine();
		} catch (IOException e) {
			System.out.println("Zeile kann nicht gelesen werden");
			e.printStackTrace();
		}
		int zeilenzähler = 0;
		boolean fehler = false;
		
		while (zeile != null){
			zeilenzähler++;
			for(int i = 1; i < zeile.length(); i++){
				// Jedes Zeichen innerhalb des Textes wird angeschaut
				char zeichenEins = zeile.charAt(i-1);
				char zeichenZwei = zeile.charAt(i);
				// Prüfung auf einfache Kommentare
				if(zeichenEins == '/' && zeichenZwei == '/' && !meinStack.isFull()){
					System.out.printf("Einfacher Kommentar in Zeile %s %n", zeilenzähler);
				}
				
				// Öffnende Kommentare 
				// Diese werden immer angenommen und gespeichert
				if(zeichenEins == '/' && zeichenZwei == '*' && !meinStack.isFull()){
					System.out.printf("Kommentarbeginn in Zeile %s an der Stelle %s %n", zeilenzähler, i);
					meinStack.push(zeichenZwei);
					i = i + 1;
				}
				
				// Schliessende Kommentare
				// Prüfung ob davor ein passender öffnender Kommentar vorhanden war
				if(zeichenEins == '*' && zeichenZwei == '/' && !meinStack.isFull()){
					
					// Stack ist leer; Fehler ausgeben
					if(meinStack.isEmpty()){
						System.err.printf("Fehler! In Zeile %s an der Stelle %s ist ein schliessender "
								+ "Kommentar ohne Öffnung %n", zeilenzähler, i);
						fehler = true;
					} 
					else {
					
					// Passendes gegenstück gefunden; Element im Stack wird gelöscht
					if(meinStack.getChar() == '*' && !meinStack.isEmpty()){
						System.out.printf("Kommentarende in Zeile %s an der Stelle %s %n", zeilenzähler, i);
						meinStack.pop();
						i=i+1;
					}
					
					}
				}
				
				// for-Schleife verlassen
				if (fehler) {
					break;
				}
			}
			
			// while-Schleife bei Fehler verlassen
			if (fehler) {
				System.err.println("Das Programm wird beendet!");
				break;
			} 
			
			try {
				zeile = buffer.readLine();
			} catch (IOException e) {
				System.out.println("Zeile kann nicht gelesen werden");
				e.printStackTrace();
			}
		}
		if(!meinStack.isEmpty()){
			System.err.printf("Die Prüfung ist abgeschlossen. %n"
					+ "Achtung! Nicht alle offenen Kommentare wurden geschlossen.");
			fehler = true;
		}
		
		if (!fehler) {
			System.out.println("Die Pruefung ist abgeschlossen, keine Fehler");
		}
	}
	
	public static void main(String[] args) {
//		KlammerPrüfung();
		KommentarPrüfung();
	}
	
}
