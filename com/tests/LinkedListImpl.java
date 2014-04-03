package javatests;


public class LinkedListImpl {

	private int size;
	private Node firstNode;
	
	class Node{
		
		private Node nextNode;
		int data;
		int index;
		
		Node(int data){
			this.data = data;
		}

		public Node getNextNode() {
			return nextNode;
		}

		public void setNextNode(Node nextNode) {
			this.nextNode = nextNode;
		}
		
	}
	
	private void add(int data){
		
		if(this.size == 0){
			this.firstNode = new Node(data);
			this.firstNode.index = 0;
			size++;
		}
		else{
			//traverse to the end of the list
			Node currentNode = this.firstNode;
			while(currentNode.nextNode != null){
				currentNode = currentNode.nextNode;
			}
			
			Node newNode = new Node(data);
			currentNode.nextNode = newNode;
			newNode.index = size;
			size++;
		}
	}
	
	private void delete(int data){
		//if first node is getting deleted
		Node currentNode = this.firstNode;
		if(currentNode.data == data){
			currentNode = currentNode.nextNode;
			this.firstNode = null;
			this.firstNode = currentNode;
			size--;			
		}
		else{
			boolean isDeleted = false;
			
			while(!isDeleted){
				if(currentNode.nextNode.data != data){
					currentNode = currentNode.nextNode;
				}
				else{
					Node deleteNode = currentNode.nextNode;
					currentNode.nextNode = deleteNode.nextNode;
					deleteNode.nextNode.index--;
					deleteNode = null;
					size--;
					isDeleted = true;
				}
			}
		}
		
		return;
	}
	
	private int get(int index){
		
		Node currenNode = this.firstNode;
		while(currenNode.index < index){
			currenNode = currenNode.nextNode;			
		}
		return currenNode.data;
	}
	
	private void traverseLinkedList(){
		System.out.println("\n");
		if(this.size == 0){
			System.out.println("empty list");
			return;
		}
		Node currentNode = this.firstNode;
		while(currentNode != null){
			System.out.print(currentNode.data + " ");
			currentNode = currentNode.nextNode;
		}
	}
	
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	
	public static void main(String[] args) {
		
		LinkedListImpl lk = new LinkedListImpl();
		lk.add(1);
		lk.add(9);
		lk.add(3);
		lk.add(5);
		lk.add(10);
		
		System.out.println("size :" + lk.getSize());
		
		System.out.println("data at 4 : " + lk.get(4));
		
		lk.traverseLinkedList();
		lk.delete(5);
		lk.traverseLinkedList();
		lk.add(7);
		lk.traverseLinkedList();
		lk.delete(1);
		lk.traverseLinkedList();
	}
	

}
