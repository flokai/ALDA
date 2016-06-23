package uebungsblatt6;

public class StartKlasse {
	
	public static void main(String[] args) {

	IntList list1 = new IntList();
	IntList list2 = new IntList();
	

	for (int i = 1; i <= 5; i++) {
		int zahl = (int) (Math.random()*41 + 20);
		list1.addNode(zahl);
	}
	
	list1.traverseList();
	System.out.println("xxxxx");
	IntList.listInsert2(list1, list2);
	list2.traverseList();
	System.out.println("xxxxx");
	IntList.listInsert(list1, list2);
	list2.traverseList();
	
	}
	
}
