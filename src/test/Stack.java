package test;

public class Stack {
	
	private char [] stackArray;
	private int top;
	
	public Stack (int laenge) {
		stackArray = new char [laenge];
		this.top = -1;
	}
	
	public void push (char element) {
			stackArray [++top] = element;
	}
	
	public char pop () {
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

