package uebungsblatt3;

public class Stack {
	
	private int top;
	private char[] stackArray;

	public Stack (int laenge) {
		this.stackArray = new char[laenge];
		this.top = -1;
	}
	
	public void push(char i){
		//fügt ein Element hinzu
		stackArray[++top] = i;				
	}

	public char getChar (){
		return stackArray[top];
	}
	
	public char pop () {
		//löscht das oberste Element und gibt es zurück
		return stackArray[top--];
	}
	
	public boolean isEmpty () {
		if (top == -1) {
		return true;
		}
		return false;
	}
	public boolean isFull () {
		if (top == stackArray.length-1) {
			return true;
		}
		return false;
	}
	
	
}
