

public class SudokuSquare{

	private int row;  //representing which row in the board the square is located
	private int column;  //representing which column the square is located
	private int value; //which numeric value the square contains
	private boolean locked; //Square's value variable can be changed

	public SudokuSquare(int r, int c, int v, boolean l) 
	{
		row = r; 
		column = c;
		if(v<0 || v>4){
			v = 0;  	
		}
		value = v;
		locked = l; 
	}

	public int getRow(){ return row; }
	public int getColumn(){ return column; }
	public int getValue(){ return value; }
	public void setValue(int v)
	{
		if(v<0 || v > 4){
			v = 0;	
		}
		value = v; 
	}
	public boolean isLocked(){ return locked; }
}

