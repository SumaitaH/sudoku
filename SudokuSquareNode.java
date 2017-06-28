public class SudokuSquareNode {


	private SudokuSquare data;
	private SudokuSquareNode next;

	public SudokuSquareNode(SudokuSquare i){
		data = i;
	}

	public SudokuSquareNode(SudokuSquare i, SudokuSquareNode n){
		data =i;
		next = n;
	}

	public SudokuSquare getData(){return data;}
	public SudokuSquareNode getNext(){return next;}
	public void setNext(SudokuSquareNode n){next = n;}

}