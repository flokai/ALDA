package test;

import java.io.*;

public class Pruefung {
	private static FileReader input = null;
	private static BufferedReader reader = null;
	private static Stack meinStack = new Stack(15);

	public static void Klammerpruefung() {
		try {
			input = new FileReader("/Users/floriankaiser/Documents/workspace/ALDA/src/uebungsblatt3/test.txt");
			reader = new BufferedReader(input);
			String zeile = reader.readLine();
			int zeilenzaehler = 0;
			boolean fehler = false;
			while (zeile != null) {
				// System.out.println(zeile);
				zeilenzaehler++;
				for (int i = 0; i < zeile.length(); i++) {
					char zeichen = zeile.charAt(i);
					// Wenn die schliessende Klammer auf ein leeres Stack
					// ausgeführt wird

					if (zeichen == ')' | zeichen == '}' | zeichen == ']'
							&& meinStack.isEmpty()) {
						System.err
								.printf("Fehler! Schliessende Klammer %s ohne "
										+ "Gegenstueck an der Stelle %s : %s %n",
										zeichen, zeilenzaehler, i);
						// for-Schleife verlassen
						fehler = true;
						break;
					}
					switch (zeichen) {
					case '(':
					case '{':
					case '[':
						if (meinStack.isFull()) {
							System.err
									.println("Stack ist voll, kein Hinzufuegen moeglich");
							// switch verlassen
							fehler = true;
							break;
						}
						meinStack.push(zeichen);
						break;
					case ')':
						if (meinStack.pop() != '(') {
							System.err.printf("Fehler! Falsche Klammer %s in "
									+ "der Zeile %s : %s %n", zeichen,
									zeilenzaehler, i);
							fehler = true;
						}
						break;
					case '}':
						if (meinStack.pop() != '{') {
							System.err.printf("Fehler! Falsche Klammer %s in "
									+ "der Zeile %s : %s %n", zeichen,
									zeilenzaehler, i);
							fehler = true;
						}
						break;
					case ']':
						if (meinStack.pop() != '[') {
							System.err.printf("Fehler! Falsche Klammer %s in "
									+ "der Zeile %s : %s %n", zeichen,
									zeilenzaehler, i);
							fehler = true;
						}
						break;
					}
					// for-Schleife verlassen
					if (fehler) {
						break;
					}
				}
				// while-Schleife verlassen
				if (fehler) {
					System.err.println("Das Programm wird beendet!");
					break;
				} else {
					System.out.printf("Zeile %s in Ordnung! %n", zeilenzaehler);
				}
				zeile = reader.readLine();
			}
			if (!fehler) {
				System.out
						.println("Die Pruefung ist abgeschlossen, keine Fehler");
			}

		} catch (FileNotFoundException e) {
			System.err.printf("Datei wurde nicht gefunden! %n"
					+ e.getLocalizedMessage());
		} catch (IOException e) {
			System.err.printf("Dateiquelle fehlerhaft %n" + e.getMessage());
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/* blalablbal */
	public static void Kommentarpruefung() {
		try {
			input = new FileReader(
					"/Users/floriankaiser/Documents/workspace/ALDA/src/uebungsblatt3/test.txt");
			reader = new BufferedReader(input);
			String zeile = reader.readLine();
			int zeilenzaehler = 0;
			boolean fehler = false;
			while (zeile != null) {
				zeilenzaehler++;
				// System.out.println(zeile);
				for (int i = 1; i < zeile.length(); i++) {
					char zwei = zeile.charAt(i);
					char eins = zeile.charAt(i - 1);
					// bei '//' immer eine ganze Zeile, daher break
					if (eins == '/' && zwei == '/') {
						System.out.printf(
								"Einfacher Kommentar in der Zeile %s %n",
								zeilenzaehler);
						break;
					}
					// bei '/*' kann in derselben Zeile aufhören, kein break
					if (eins == '/' && zwei == '*' && !meinStack.isFull()) {
						System.out
								.printf("Zeile %s, Stelle %s, hier faengt ein verschachtelter Kommentar an %n",
										zeilenzaehler, i);
						meinStack.push('a');
						
					}
					// bei '*/' continue um nicht mit einem Kommentarende ohne Anfang zu verwechseln
					if (eins == '*' && zwei == '/' && !meinStack.isEmpty()) {
						System.out.printf("Ende des verschachtelten Kommentars, Zeile %s, Stelle %s %n", zeilenzaehler, i);
						meinStack.pop();
						continue;
						
						
					} // bei '/x'; 'x/'
					/*if (eins == '/' && zwei != '/' || eins != '/'
							&& zwei == '/' || eins == '/' && zwei != '*' || eins != '/' && zwei == '*') {
						System.out
						.printf("Kommentaransatz in der Zeile %s, Falsch formatiert! %n",
								zeilenzaehler);
						fehler = true;
						break;
					}*/
					// bei */ und leerem Stack
					if (meinStack.isEmpty() && eins == '*' && zwei == '/') {
						System.out.printf("Kommentarende ohne Anfang in der Zeile %s %n", zeilenzaehler);
						fehler = true;
						break;
					}

				}
				if (fehler) {
					break;
				}
				zeile = reader.readLine();
			}
			// bei !leerem Stack am Programmende
			if (!meinStack.isEmpty()) {
				System.out.println("Nicht alle Kommentare geschlossen, bitte ueberpruefen!");
				fehler = true;
			}
			if(fehler == true) {
				System.err
				.println("Programm beendet, Bitte die Fehler korrigieren!");

			}

		} catch (FileNotFoundException e) {
			System.out.printf("Datei wurde nicht gefunden! %n"
					+ e.getLocalizedMessage());
		} catch (IOException e) {
			System.out.printf("Dateiquelle fehlerhaft %n" + e.getMessage());
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public static void main(String[] args) {
//		 Klammerpruefung();
		Kommentarpruefung();

	}

}
