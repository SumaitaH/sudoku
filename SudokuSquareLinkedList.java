
public class SudokuSquareLinkedList {
	private SudokuSquareNode head;
	private SudokuSquareNode next; 

	public SudokuSquareLinkedList(SudokuSquareNode n){
		head = n;
		next = head; 
	}
	public void append(SudokuSquareNode x){
		SudokuSquareNode current = head;
		while (current.getNext() != null){
			current = current.getNext();
		} 
		current.setNext(x);
	}	

	public SudokuSquareNode getNext(){

		SudokuSquareNode temp = next; 
		if(next != null){
			next = next.getNext();
			return temp;
		}

		return temp; 
	}
//	public void print()
//	{
//		SudokuSquareNode current = head; 
//		while(current!=null)
//		{
//			System.out.println(current.getData().getValue());
//			current = current.getNext(); 
//		}
//	}


}