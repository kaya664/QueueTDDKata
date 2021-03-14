
public class Queue {
	
	String element;
	Queue nextNode = null;
	
	public void enqueue(String string) throws Exception {
		if(string == null) {
			throw new Exception();
		}
		
		if(nextNode == null) {
			nextNode = new Queue();
			nextNode.element = string;
		} else {
			nextNode.enqueue(string);
		}
	}
	
	public String dequeue() throws Exception {
		if(nextNode == null) {
			throw new Exception();
		}
		
		String element = nextNode.element;
		if(nextNode.nextNode == null) {
			nextNode = null;
		} else {
			nextNode = nextNode.nextNode;
		}
		return element;
	}
	
	public String peek() throws Exception {
		if(nextNode == null) {
			throw new Exception();
		}
		return nextNode.element;
	}
	
	public int size() {
		int size = 0;
		Queue root = this;
		while(root.nextNode != null) {
			root = root.nextNode;
			size++;
		}
		return size;
	}
	
}
