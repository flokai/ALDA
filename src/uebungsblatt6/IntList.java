package uebungsblatt6;

public class IntList {
	private Node head;

	public IntList() {
		head = null;
	}

	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}

	// Ausgabe der Liste
	public void traverseList() {
		for (Node t = head; t != null; t = t.getNext()) {
			System.out.println(t.getValue());
		}
	}

	// Hinzufügen eines Elements am Ende einer Liste
	public void addNode(int x) {

		Node xnode = new Node(x);

		if (head == null) {
			head = xnode;
		} else {
			Node t = head;
			while (t.getNext() != null) {
				t = t.getNext();
			}
			t.setNext(xnode);
		}
	}

	// Einfügen eines Elements
	public void insertNode(Node gefunden, Node einfuegen) {
		einfuegen.setNext(gefunden.getNext());
		gefunden.setNext(einfuegen);
	}

	// Suche nach einem Listenelement
	public int searchNode(int x) {
		Node t = head; // Hilfsvariable
		while ((t != null) && (t.getValue() < x)) {
			t = t.getNext();
		}
		return t.getValue();
	}

	public static void listInsert(IntList list1, IntList list2) {

		// der head-Node aus liste1 wird auch in liste2 als head angelegt
		Node neuHead = new Node(list1.getHead().getValue());
		list2.setHead(neuHead);

		for (Node i = list1.getHead().getNext(); i != null; i = i.getNext()) {

			// der nächste Node aus Liste eins wird angelegt und anschliessend
			// eingefügt
			Node neu = new Node(i.getValue());

			// der aktuelle head aus liste2 wird übernommen
			Node headList2 = list2.getHead();

			if (neu.getValue() < headList2.getValue()) {
				// wenn der einzufügende Head kleiner ist als der aktuelle,
				// dann wird dieser der neue Head
				neu.setNext(headList2);
				list2.setHead(neu);
				continue;
			}

			while (headList2 != null && headList2.getNext() != null) {
				if (neu.getValue() < headList2.getNext().getValue()) {
					// neuen Node an entsprechender Stelle einfügen
					neu.setNext(headList2.getNext());
					headList2.setNext(neu);
					break;
				}
				// nächster Knoten
				headList2 = headList2.getNext();
			}

			// wenn es nur einen Knoten gibt, dann den neuen hinten einfügen
			if (headList2.getNext() == null) {
				headList2.setNext(neu);
			}
		}
	}

	public static void listInsert2(IntList list1, IntList list2) {

		// Head aus Liste1 übernehmen
		Node neuHead = new Node(list1.getHead().getValue());
		list2.setHead(neuHead);

		
		for (Node i = list1.getHead().getNext(); i != null; i = i.getNext()) {

			// insertNode ist der nächste einzufügende Knoten
			Node insertNode = new Node(i.getValue());
			// der aktuelle head aus liste2 wird übernommen
			Node headNode = list2.getHead();

			
			// 1. Möglichkeit
			// Wenn der einzufügende Node kleiner/gleich als der Head ist
			if (insertNode.getValue() <= headNode.getValue()) {
				insertNode.setNext(headNode);
				list2.setHead(insertNode);
				continue;
			}

			// 2. Möglichkeit
			// Wenn der einzufügende Node größer als der Head ist
			while (headNode != null && headNode.getNext() != null) {
				if (insertNode.getValue() < headNode.getNext().getValue()) {
					// neuen Node an entsprechender Stelle einfügen
					insertNode.setNext(headNode.getNext());
					headNode.setNext(insertNode);
					break;
				}
				// nächster Knoten
				headNode = headNode.getNext();
			}
			

			// 3. Möglichkeit
			// Head ist kleiner und einziger Knoten
			if (insertNode.getValue() > headNode.getValue() &&  headNode.getNext() == null) {
				headNode.setNext(insertNode);

			}

		}// ende for

	}// ende Methode

}
