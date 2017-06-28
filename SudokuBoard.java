
public class SudokuBoard  {

	private static SudokuSquare[][] board = new SudokuSquare[4][4];
	
	

	public SudokuBoard(SudokuSquareLinkedList a) {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				board[i][j] = new SudokuSquare(0, 0, 0, false);
			}
		}
		SudokuSquareNode b = a.getNext();
		while (b != null) {
			board[b.getData().getRow()][b.getData().getColumn()] = new SudokuSquare(
					b.getData().getRow(), b.getData().getColumn(), b.getData()
							.getValue(), true);
			b = a.getNext();
		}
	}

	public static boolean isValid(int r, int c, int v) {
//		if(getSquare(r,c).isLocked()){
//			return false; 
//		}
		if (v == 0) {
			return true;
		}
		// check diagonally and vertically
		for (int i = 0; i < 4; i++) {
			if ((i != r) && board[i][c].getValue() == v) {
				return false;
			}
			if ((i != c) && board[r][i].getValue() == v) {
				return false;
			}
		}
		// check each quadrant
		if (r < 2) {
			if (c < 2) {
				for (int i = 0; i < 2; i++) {
					for (int j = 0; j < 2; j++) {
						if ((i != r) && (j != c) && board[i][j].getValue() == v)
							return false;
					}// for
				}// for
					// if
			}// if column
			else {
				for (int i = 0; i < 2; i++) {
					for (int j = 2; j < 4; j++) {
						if ((i != r) && (j != c) && board[i][j].getValue() == v)
							return false;
					}// for
				}// for
			}// if

		}// else if

		else {
			if (c < 2) {
				for (int i = 2; i < 4; i++) {
					for (int j = 0; j < 2; j++) {
						if ((i != r) && (j != c) && board[i][j].getValue() == v)
							return false;
					}// for
				}// for
			}// if
			else {
				for (int i = 2; i < 4; i++) {
					for (int j = 2; j < 4; j++) {
						if ((i != r) && (j != c) && board[i][j].getValue() == v)
							return false;
					}// for
				}// for
			}// if
		}// else if
		return true;
	}

	public static void enterMove(int r, int c, int v) throws Exception {
		if (!isValid(r, c, v)) {
			throw new SudokuException("Not valid");
		} else if (v == 0) {
			board[r][c] = new SudokuSquare(r, c, v, false);
		}
		
		board[r][c] = new SudokuSquare(r, c, v, true);
	}

	public static void reset() {

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (board[i][j].isLocked()) {
					board[i][j] = new SudokuSquare(0, 0, 0, false);
				}
			}
		}
	}

	public static boolean isFull() { // return true if board is filled with nonzero
								// values
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (!board[i][j].isLocked()) {
					return false;
				}
			}
		}
		return true;
	}

	public static SudokuSquare getSquare(int row, int column) {// return square object
		return board[row][column];
	}

	public void print() {
		for (int i = 0; i < 4; i++) {

			for (int j = 0; j < 4; j++) {

				System.out.print("|_" + board[i][j].getValue() + "_");

			}
			System.out.println("|");
		}
		System.out.println();
	}
}