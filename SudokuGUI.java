import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class SudokuGUI extends JFrame implements ActionListener {

	private static final long serialVersionUID = -5223931092417790736L;

	static JFrame S = new JFrame();
	static Container pane;
	static JRadioButton checkValid, enter, clear;
	static ButtonGroup userEnter = new ButtonGroup();
	static Button reset = new Button();
	static Button go = new Button("Go!");
	static TextField autoSpace = new TextField("Hello! Welcome to Sudoku");
	static TextField userSpace = new TextField("");
	static Label enterNum = new Label("Enter your desired number");
	static public JButton a00, a01, a02, a03, a10, a11, a12, a13, a20, a21,
			a22, a23, a30, a31, a32, a33;

	// static ActionListener a1, a2, a3, a4, a5, a6, a7, a8, a9, a010, a011,
	// a012, a013, a14, a15, a16;

	public SudokuGUI() {
		super("Sudoku");
		pane = getContentPane();

		checkValid = new JRadioButton();
		checkValid.setText("Check if Valid");
		// checkValid.addActionListener(this);
		enter = new JRadioButton();
		// enter.addActionListener(this);
		enter.setText("Enter");
		clear = new JRadioButton();
		clear.setText("Clear");
		// clear.addActionListener(this);
		userEnter.add(checkValid);
		userEnter.add(clear);
		userEnter.add(enter);
		JPanel x = new JPanel(new GridLayout(2, 0));

		x.add(autoSpace, BorderLayout.CENTER);
		autoSpace.setEditable(false);
		// add(autoSpace, BorderLayout.PAGE_START);
		for (Enumeration<AbstractButton> en = userEnter.getElements(); en
				.hasMoreElements();) {
			AbstractButton b = en.nextElement();
			x.add(b, BorderLayout.SOUTH);
		}

		add(x, BorderLayout.NORTH);

		GridLayout a = new GridLayout(2, 0);
		a.setColumns(0);
		a.setRows(2);
		a.setVgap(50);
		JPanel xyz = new JPanel(a);
		xyz.add(enterNum);
		xyz.add(userSpace);
		xyz.add(go);
		go.addActionListener(this);
		userSpace.addActionListener(this);
		reset.setLabel("Reset Game");
		xyz.add(reset);
		add(xyz, BorderLayout.SOUTH);
		add(BoardGUI(), BorderLayout.CENTER);
		// add(BoardGUI(), BorderLayout.CENTER);

	}

	public JPanel BoardGUI() {

		JPanel grid = new JPanel(new GridLayout(4, 4));
		a00 = new JButton();
		a00.setText(String.valueOf(SudokuBoard.getSquare(0, 0).getValue()));
		a00.setName("00");
		a00.addActionListener(this);
		grid.add(a00);

		a01 = new JButton();
		a01.setText(String.valueOf(SudokuBoard.getSquare(0, 1).getValue()));
		a01.addActionListener(this);
		a01.setName("01");
		grid.add(a01);

		a02 = new JButton();
		a02.setText(String.valueOf(SudokuBoard.getSquare(0, 2).getValue()));
		a02.addActionListener(this);
		a01.setName("01");
		grid.add(a02);

		a03 = new JButton();
		a03.setText(String.valueOf(SudokuBoard.getSquare(0, 3).getValue()));
		a03.addActionListener(this);
		a01.setName("01");
		grid.add(a03);

		a10 = new JButton();
		a10.setText(String.valueOf(SudokuBoard.getSquare(1, 0).getValue()));
		a00.addActionListener(this);
		a01.setName("01");
		grid.add(a10);

		a11 = new JButton();
		a11.setText(String.valueOf(SudokuBoard.getSquare(1, 1).getValue()));
		a11.addActionListener(this);
		a01.setName("01");
		grid.add(a11);

		a12 = new JButton();
		a12.setText(String.valueOf(SudokuBoard.getSquare(1, 2).getValue()));
		a12.addActionListener(this);
		a01.setName("01");
		grid.add(a12);

		a13 = new JButton();
		a13.setText(String.valueOf(SudokuBoard.getSquare(1, 3).getValue()));
		a13.addActionListener(this);
		a01.setName("01");
		grid.add(a13);

		a20 = new JButton();
		a20.setText(String.valueOf(SudokuBoard.getSquare(2, 0).getValue()));
		a20.addActionListener(this);
		a01.setName("01");
		grid.add(a20);

		a21 = new JButton();
		a21.setText(String.valueOf(SudokuBoard.getSquare(2, 1).getValue()));
		a21.addActionListener(this);
		a01.setName("01");
		grid.add(a21);

		a22 = new JButton();
		a22.setText(String.valueOf(SudokuBoard.getSquare(2, 2).getValue()));
		a22.addActionListener(this);
		a01.setName("01");
		grid.add(a22);

		a23 = new JButton();
		a23.setText(String.valueOf(SudokuBoard.getSquare(2, 3).getValue()));
		a23.addActionListener(this);
		a01.setName("01");
		grid.add(a23);

		a30 = new JButton();
		a30.setText(String.valueOf(SudokuBoard.getSquare(3, 0).getValue()));
		a30.addActionListener(this);
		a01.setName("01");
		grid.add(a30);

		a31 = new JButton();
		a31.setText(String.valueOf(SudokuBoard.getSquare(3, 1).getValue()));
		a31.addActionListener(this);
		a01.setName("01");
		grid.add(a31);

		a32 = new JButton();
		a32.setText(String.valueOf(SudokuBoard.getSquare(3, 2).getValue()));
		a32.addActionListener(this);
		a01.setName("01");
		grid.add(a32);

		a33 = new JButton();
		a33.setText(String.valueOf(SudokuBoard.getSquare(3, 3).getValue()));
		a33.addActionListener(this);
		a01.setName("01");
		grid.add(a33);

		// grid.addMouseListener(this);
		return grid;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		// if(go.isEnabled()){
		// this.getName();
		if (a00.isEnabled()) {
			try {
				int a = Integer.parseInt(userSpace.getText());
				if (checkValid.isSelected()) {
					if (a >= 0 && a <= 4) {
						if ((SudokuBoard.isValid(0, 0, a))) {// ||(a01.isSelected()&&SudokuBoard.isValid(0,1,a))||(a02.isSelected()&&SudokuBoard.isValid(0,2,a))||(a03.isSelected()&&SudokuBoard.isValid(0,3,a))||(a10.isSelected()&&SudokuBoard.isValid(1,0,a))||(a11.isSelected()&&SudokuBoard.isValid(1,1,a))||(a12.isSelected()&&SudokuBoard.isValid(1,2,a))||(a13.isSelected()&&SudokuBoard.isValid(1,3,a))||(a20.isSelected()&&SudokuBoard.isValid(2,0,a))||(a21.isSelected()&&SudokuBoard.isValid(2,1,a))||(a22.isSelected()&&SudokuBoard.isValid(2,2,a))||(a23.isSelected()&&SudokuBoard.isValid(2,3,a))||(a30.isSelected()&&SudokuBoard.isValid(3,0,a))||(a31.isSelected()&&SudokuBoard.isValid(3,1,a))||(a32.isSelected()&&SudokuBoard.isValid(3,2,a))||(a33.isSelected()&&SudokuBoard.isValid(3,3,a))){
							autoSpace.setText("This is a valid move");

						} else {
							autoSpace
									.setText("Sorry, this is not a valid move");
						}
					}
				}
			} catch (NumberFormatException a) {
				// a.printStackTrace();
				autoSpace.setText("Please enter an integer");
			}
			if (enter.isSelected()) {
				int a = Integer.parseInt(userSpace.getText());
				try {
					SudokuBoard.enterMove(0, 0, a);
				} catch (NumberFormatException nfe) {
					nfe.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					autoSpace.setText("Invalid Move");
				}
				if (clear.isSelected()) {
					a00.setText("");
					try {
						SudokuBoard.enterMove(0, 0, 0);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						autoSpace.setText("Invalid Move");
					}

				}

			}
		}
		if (a01.isEnabled()) {
			try {
				if (checkValid.isSelected()) {
					int a = Integer.parseInt(userSpace.getText());
					if (a >= 0 && a <= 4) {
						if ((SudokuBoard.isValid(0, 1, a))) {// ||(a01.isSelected()&&SudokuBoard.isValid(0,1,a))||(a02.isSelected()&&SudokuBoard.isValid(0,2,a))||(a03.isSelected()&&SudokuBoard.isValid(0,3,a))||(a10.isSelected()&&SudokuBoard.isValid(1,0,a))||(a11.isSelected()&&SudokuBoard.isValid(1,1,a))||(a12.isSelected()&&SudokuBoard.isValid(1,2,a))||(a13.isSelected()&&SudokuBoard.isValid(1,3,a))||(a20.isSelected()&&SudokuBoard.isValid(2,0,a))||(a21.isSelected()&&SudokuBoard.isValid(2,1,a))||(a22.isSelected()&&SudokuBoard.isValid(2,2,a))||(a23.isSelected()&&SudokuBoard.isValid(2,3,a))||(a30.isSelected()&&SudokuBoard.isValid(3,0,a))||(a31.isSelected()&&SudokuBoard.isValid(3,1,a))||(a32.isSelected()&&SudokuBoard.isValid(3,2,a))||(a33.isSelected()&&SudokuBoard.isValid(3,3,a))){
							autoSpace.setText("This is a valid move");
						} else {
							autoSpace
									.setText("Sorry, this is not a valid move");
						}
					}
				}
			} catch (NumberFormatException a) {
				// a.printStackTrace();
				autoSpace.setText("Please enter an integer");
			}
			if (enter.isSelected()) {
				int a = Integer.parseInt(userSpace.getText());
				try {
					SudokuBoard.enterMove(0, 1, a);
					
				} catch (NumberFormatException nfe) {
					nfe.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					autoSpace.setText("Invalid Move");
				}
			}
			if (clear.isSelected()) {
				a01.setText("");
				try {
					SudokuBoard.enterMove(0, 1, 0);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					autoSpace.setText("Invalid Move");
				}

			}

		}
		if (a02.isEnabled()) {
			try {
				if (checkValid.isSelected()) {
					int a = Integer.parseInt(userSpace.getText());
					if (a >= 0 && a <= 4) {
						if ((SudokuBoard.isValid(0, 2, a))) {// ||(a01.isSelected()&&SudokuBoard.isValid(0,1,a))||(a02.isSelected()&&SudokuBoard.isValid(0,2,a))||(a03.isSelected()&&SudokuBoard.isValid(0,3,a))||(a10.isSelected()&&SudokuBoard.isValid(1,0,a))||(a11.isSelected()&&SudokuBoard.isValid(1,1,a))||(a12.isSelected()&&SudokuBoard.isValid(1,2,a))||(a13.isSelected()&&SudokuBoard.isValid(1,3,a))||(a20.isSelected()&&SudokuBoard.isValid(2,0,a))||(a21.isSelected()&&SudokuBoard.isValid(2,1,a))||(a22.isSelected()&&SudokuBoard.isValid(2,2,a))||(a23.isSelected()&&SudokuBoard.isValid(2,3,a))||(a30.isSelected()&&SudokuBoard.isValid(3,0,a))||(a31.isSelected()&&SudokuBoard.isValid(3,1,a))||(a32.isSelected()&&SudokuBoard.isValid(3,2,a))||(a33.isSelected()&&SudokuBoard.isValid(3,3,a))){
							autoSpace.setText("This is a valid move");
						} else {
							autoSpace
									.setText("Sorry, this is not a valid move");
						}
					}
				}
			} catch (NumberFormatException a) {
				// a.printStackTrace();
				autoSpace.setText("Please enter an integer");
			}
			if (enter.isSelected()) {
				int a = Integer.parseInt(userSpace.getText());
				try {
					SudokuBoard.enterMove(0, 2, a);
				} catch (NumberFormatException nfe) {
					nfe.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					autoSpace.setText("Invalid Move");
				}
			}
			if (clear.isSelected()) {
				a02.setText("");
				try {
					SudokuBoard.enterMove(0, 2, 0);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					autoSpace.setText("Invalid Move");
				}

			}

		}
		if (a03.isEnabled()) {
			try {
				if (checkValid.isSelected()) {
					int a = Integer.parseInt(userSpace.getText());
					if (a >= 0 && a <= 4) {
						if ((SudokuBoard.isValid(0, 3, a))) {// ||(a01.isSelected()&&SudokuBoard.isValid(0,1,a))||(a02.isSelected()&&SudokuBoard.isValid(0,2,a))||(a03.isSelected()&&SudokuBoard.isValid(0,3,a))||(a10.isSelected()&&SudokuBoard.isValid(1,0,a))||(a11.isSelected()&&SudokuBoard.isValid(1,1,a))||(a12.isSelected()&&SudokuBoard.isValid(1,2,a))||(a13.isSelected()&&SudokuBoard.isValid(1,3,a))||(a20.isSelected()&&SudokuBoard.isValid(2,0,a))||(a21.isSelected()&&SudokuBoard.isValid(2,1,a))||(a22.isSelected()&&SudokuBoard.isValid(2,2,a))||(a23.isSelected()&&SudokuBoard.isValid(2,3,a))||(a30.isSelected()&&SudokuBoard.isValid(3,0,a))||(a31.isSelected()&&SudokuBoard.isValid(3,1,a))||(a32.isSelected()&&SudokuBoard.isValid(3,2,a))||(a33.isSelected()&&SudokuBoard.isValid(3,3,a))){
							autoSpace.setText("This is a valid move");
						} else {
							autoSpace
									.setText("Sorry, this is not a valid move");
						}
					}
				}
			} catch (NumberFormatException a) {
				// a.printStackTrace();
				autoSpace.setText("Please enter an integer");
			}
			if (enter.isSelected()) {
				int a = Integer.parseInt(userSpace.getText());
				try {
					SudokuBoard.enterMove(0, 3, a);
				} catch (NumberFormatException nfe) {
					nfe.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					autoSpace.setText("Invalid Move");
				}
			}
			if (clear.isSelected()) {
				a03.setText("");
				try {
					SudokuBoard.enterMove(0, 3, 0);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					autoSpace.setText("Invalid Move");
				}

			}

		}
		if (a10.isEnabled()) {
			try {
				if (checkValid.isSelected()) {
					int a = Integer.parseInt(userSpace.getText());
					if (a >= 0 && a <= 4) {
						if ((SudokuBoard.isValid(1, 0, a))) {// ||(a01.isSelected()&&SudokuBoard.isValid(0,1,a))||(a02.isSelected()&&SudokuBoard.isValid(0,2,a))||(a03.isSelected()&&SudokuBoard.isValid(0,3,a))||(a10.isSelected()&&SudokuBoard.isValid(1,0,a))||(a11.isSelected()&&SudokuBoard.isValid(1,1,a))||(a12.isSelected()&&SudokuBoard.isValid(1,2,a))||(a13.isSelected()&&SudokuBoard.isValid(1,3,a))||(a20.isSelected()&&SudokuBoard.isValid(2,0,a))||(a21.isSelected()&&SudokuBoard.isValid(2,1,a))||(a22.isSelected()&&SudokuBoard.isValid(2,2,a))||(a23.isSelected()&&SudokuBoard.isValid(2,3,a))||(a30.isSelected()&&SudokuBoard.isValid(3,0,a))||(a31.isSelected()&&SudokuBoard.isValid(3,1,a))||(a32.isSelected()&&SudokuBoard.isValid(3,2,a))||(a33.isSelected()&&SudokuBoard.isValid(3,3,a))){
							autoSpace.setText("This is a valid move");
						} else {
							autoSpace
									.setText("Sorry, this is not a valid move");
						}
					}
				}
			} catch (NumberFormatException a) {
				// a.printStackTrace();
				autoSpace.setText("Please enter an integer");
			}
			if (enter.isSelected()) {
				int a = Integer.parseInt(userSpace.getText());
				try {
					SudokuBoard.enterMove(1, 0, a);
				} catch (NumberFormatException nfe) {
					nfe.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					autoSpace.setText("Invalid Move");
				}
			}
			if (clear.isSelected()) {
				a10.setText("");
				try {
					SudokuBoard.enterMove(1, 0, 0);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					autoSpace.setText("Invalid Move");
				}

			}

		}
		if (a11.isEnabled()) {
			try {
				if (checkValid.isSelected()) {
					int a = Integer.parseInt(userSpace.getText());
					if (a >= 0 && a <= 4) {
						if ((SudokuBoard.isValid(1, 1, a))) {// ||(a01.isSelected()&&SudokuBoard.isValid(0,1,a))||(a02.isSelected()&&SudokuBoard.isValid(0,2,a))||(a03.isSelected()&&SudokuBoard.isValid(0,3,a))||(a10.isSelected()&&SudokuBoard.isValid(1,0,a))||(a11.isSelected()&&SudokuBoard.isValid(1,1,a))||(a12.isSelected()&&SudokuBoard.isValid(1,2,a))||(a13.isSelected()&&SudokuBoard.isValid(1,3,a))||(a20.isSelected()&&SudokuBoard.isValid(2,0,a))||(a21.isSelected()&&SudokuBoard.isValid(2,1,a))||(a22.isSelected()&&SudokuBoard.isValid(2,2,a))||(a23.isSelected()&&SudokuBoard.isValid(2,3,a))||(a30.isSelected()&&SudokuBoard.isValid(3,0,a))||(a31.isSelected()&&SudokuBoard.isValid(3,1,a))||(a32.isSelected()&&SudokuBoard.isValid(3,2,a))||(a33.isSelected()&&SudokuBoard.isValid(3,3,a))){
							autoSpace.setText("This is a valid move");
						} else {
							autoSpace
									.setText("Sorry, this is not a valid move");
						}
					}
				}
			} catch (NumberFormatException a) {
				// a.printStackTrace();
				autoSpace.setText("Please enter an integer");
			}
			if (enter.isSelected()) {
				int a = Integer.parseInt(userSpace.getText());
				try {
					SudokuBoard.enterMove(1, 1, a);
				} catch (NumberFormatException nfe) {
					nfe.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					autoSpace.setText("Invalid Move");
				}
			}
			if (clear.isSelected()) {
				a11.setText("");
				try {
					SudokuBoard.enterMove(1, 1, 0);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					autoSpace.setText("Invalid Move");
				}

			}

		}
		if (a12.isEnabled()) {
			try {
				if (checkValid.isSelected()) {
					int a = Integer.parseInt(userSpace.getText());
					if (a >= 0 && a <= 4) {
						if ((SudokuBoard.isValid(1, 2, a))) {// ||(a01.isSelected()&&SudokuBoard.isValid(0,1,a))||(a02.isSelected()&&SudokuBoard.isValid(0,2,a))||(a03.isSelected()&&SudokuBoard.isValid(0,3,a))||(a10.isSelected()&&SudokuBoard.isValid(1,0,a))||(a11.isSelected()&&SudokuBoard.isValid(1,1,a))||(a12.isSelected()&&SudokuBoard.isValid(1,2,a))||(a13.isSelected()&&SudokuBoard.isValid(1,3,a))||(a20.isSelected()&&SudokuBoard.isValid(2,0,a))||(a21.isSelected()&&SudokuBoard.isValid(2,1,a))||(a22.isSelected()&&SudokuBoard.isValid(2,2,a))||(a23.isSelected()&&SudokuBoard.isValid(2,3,a))||(a30.isSelected()&&SudokuBoard.isValid(3,0,a))||(a31.isSelected()&&SudokuBoard.isValid(3,1,a))||(a32.isSelected()&&SudokuBoard.isValid(3,2,a))||(a33.isSelected()&&SudokuBoard.isValid(3,3,a))){
							autoSpace.setText("This is a valid move");
						} else {
							autoSpace
									.setText("Sorry, this is not a valid move");
						}
					}
				}
			} catch (NumberFormatException a) {
				// a.printStackTrace();
				autoSpace.setText("Please enter an integer");
			}
			if (enter.isSelected()) {
				int a = Integer.parseInt(userSpace.getText());
				try {
					SudokuBoard.enterMove(1, 2, a);
				} catch (NumberFormatException nfe) {
					nfe.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					autoSpace.setText("Invalid Move");
				}
			}
			if (clear.isSelected()) {
				a12.setText("");
				try {
					SudokuBoard.enterMove(1, 2, 0);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					autoSpace.setText("Invalid Move");
				}

			}

		}
		if (a13.isEnabled()) {
			try {
				if (checkValid.isSelected()) {
					int a = Integer.parseInt(userSpace.getText());
					if (a >= 0 && a <= 4) {
						if ((SudokuBoard.isValid(1, 3, a))) {// ||(a01.isSelected()&&SudokuBoard.isValid(0,1,a))||(a02.isSelected()&&SudokuBoard.isValid(0,2,a))||(a03.isSelected()&&SudokuBoard.isValid(0,3,a))||(a10.isSelected()&&SudokuBoard.isValid(1,0,a))||(a11.isSelected()&&SudokuBoard.isValid(1,1,a))||(a12.isSelected()&&SudokuBoard.isValid(1,2,a))||(a13.isSelected()&&SudokuBoard.isValid(1,3,a))||(a20.isSelected()&&SudokuBoard.isValid(2,0,a))||(a21.isSelected()&&SudokuBoard.isValid(2,1,a))||(a22.isSelected()&&SudokuBoard.isValid(2,2,a))||(a23.isSelected()&&SudokuBoard.isValid(2,3,a))||(a30.isSelected()&&SudokuBoard.isValid(3,0,a))||(a31.isSelected()&&SudokuBoard.isValid(3,1,a))||(a32.isSelected()&&SudokuBoard.isValid(3,2,a))||(a33.isSelected()&&SudokuBoard.isValid(3,3,a))){
							autoSpace.setText("This is a valid move");
						} else {
							autoSpace
									.setText("Sorry, this is not a valid move");
						}
					}
				}
			} catch (NumberFormatException a) {
				// a.printStackTrace();
				autoSpace.setText("Please enter an integer");
			}
			if (enter.isSelected()) {
				int a = Integer.parseInt(userSpace.getText());
				try {
					SudokuBoard.enterMove(1, 3, a);
				} catch (NumberFormatException nfe) {
					nfe.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					autoSpace.setText("Invalid Move");
				}
			}
			if (clear.isSelected()) {
				a13.setText("");
				try {
					SudokuBoard.enterMove(1, 3, 0);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					autoSpace.setText("Invalid Move");
				}

			}

		}
		if (a20.isEnabled()) {
			try {
				if (checkValid.isSelected()) {
					int a = Integer.parseInt(userSpace.getText());
					if (a >= 0 && a <= 4) {
						if ((SudokuBoard.isValid(2, 0, a))) {// ||(a01.isSelected()&&SudokuBoard.isValid(0,1,a))||(a02.isSelected()&&SudokuBoard.isValid(0,2,a))||(a03.isSelected()&&SudokuBoard.isValid(0,3,a))||(a10.isSelected()&&SudokuBoard.isValid(1,0,a))||(a11.isSelected()&&SudokuBoard.isValid(1,1,a))||(a12.isSelected()&&SudokuBoard.isValid(1,2,a))||(a13.isSelected()&&SudokuBoard.isValid(1,3,a))||(a20.isSelected()&&SudokuBoard.isValid(2,0,a))||(a21.isSelected()&&SudokuBoard.isValid(2,1,a))||(a22.isSelected()&&SudokuBoard.isValid(2,2,a))||(a23.isSelected()&&SudokuBoard.isValid(2,3,a))||(a30.isSelected()&&SudokuBoard.isValid(3,0,a))||(a31.isSelected()&&SudokuBoard.isValid(3,1,a))||(a32.isSelected()&&SudokuBoard.isValid(3,2,a))||(a33.isSelected()&&SudokuBoard.isValid(3,3,a))){
							autoSpace.setText("This is a valid move");
						} else {
							autoSpace
									.setText("Sorry, this is not a valid move");
						}
					}
				}
			} catch (NumberFormatException a) {
				// a.printStackTrace();
				autoSpace.setText("Please enter an integer");
			}
			if (enter.isSelected()) {
				int a = Integer.parseInt(userSpace.getText());
				try {
					if(a>=0 && a<5){
					SudokuBoard.enterMove(2, 0, a);}
				} catch (NumberFormatException nfe) {
					nfe.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					autoSpace.setText("Invalid Move");
				}
			}
			if (clear.isSelected()) {
				a20.setText("");
				try {
					SudokuBoard.enterMove(2, 0, 0);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					autoSpace.setText("Invalid Move");
				}

			}

		}
		if (a21.isEnabled()) {
			try {
				if (checkValid.isSelected()) {
					int a = Integer.parseInt(userSpace.getText());
					if (a >= 0 && a <= 4) {
						if ((SudokuBoard.isValid(2, 1, a))) {// ||(a01.isSelected()&&SudokuBoard.isValid(0,1,a))||(a02.isSelected()&&SudokuBoard.isValid(0,2,a))||(a03.isSelected()&&SudokuBoard.isValid(0,3,a))||(a10.isSelected()&&SudokuBoard.isValid(1,0,a))||(a11.isSelected()&&SudokuBoard.isValid(1,1,a))||(a12.isSelected()&&SudokuBoard.isValid(1,2,a))||(a13.isSelected()&&SudokuBoard.isValid(1,3,a))||(a20.isSelected()&&SudokuBoard.isValid(2,0,a))||(a21.isSelected()&&SudokuBoard.isValid(2,1,a))||(a22.isSelected()&&SudokuBoard.isValid(2,2,a))||(a23.isSelected()&&SudokuBoard.isValid(2,3,a))||(a30.isSelected()&&SudokuBoard.isValid(3,0,a))||(a31.isSelected()&&SudokuBoard.isValid(3,1,a))||(a32.isSelected()&&SudokuBoard.isValid(3,2,a))||(a33.isSelected()&&SudokuBoard.isValid(3,3,a))){
							autoSpace.setText("This is a valid move");
						} else {
							autoSpace
									.setText("Sorry, this is not a valid move");
						}
					}
				}
			} catch (NumberFormatException a) {
				// a.printStackTrace();
				autoSpace.setText("Please enter an integer");
			}
			if (enter.isSelected()) {
				int a = Integer.parseInt(userSpace.getText());
				try {
					SudokuBoard.enterMove(2, 1, a);
				} catch (NumberFormatException nfe) {
					nfe.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					autoSpace.setText("Invalid Move");
				}
			}
			if (clear.isSelected()) {
				a21.setText("");
				try {
					SudokuBoard.enterMove(2, 1, 0);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					autoSpace.setText("Invalid Move");
				}

			}

		}
		if (a22.isEnabled()) {
			try {
				if (checkValid.isSelected()) {
					int a = Integer.parseInt(userSpace.getText());
					if (a >= 0 && a <= 4) {
						if ((SudokuBoard.isValid(2, 2, a))) {// ||(a01.isSelected()&&SudokuBoard.isValid(0,1,a))||(a02.isSelected()&&SudokuBoard.isValid(0,2,a))||(a03.isSelected()&&SudokuBoard.isValid(0,3,a))||(a10.isSelected()&&SudokuBoard.isValid(1,0,a))||(a11.isSelected()&&SudokuBoard.isValid(1,1,a))||(a12.isSelected()&&SudokuBoard.isValid(1,2,a))||(a13.isSelected()&&SudokuBoard.isValid(1,3,a))||(a20.isSelected()&&SudokuBoard.isValid(2,0,a))||(a21.isSelected()&&SudokuBoard.isValid(2,1,a))||(a22.isSelected()&&SudokuBoard.isValid(2,2,a))||(a23.isSelected()&&SudokuBoard.isValid(2,3,a))||(a30.isSelected()&&SudokuBoard.isValid(3,0,a))||(a31.isSelected()&&SudokuBoard.isValid(3,1,a))||(a32.isSelected()&&SudokuBoard.isValid(3,2,a))||(a33.isSelected()&&SudokuBoard.isValid(3,3,a))){
							autoSpace.setText("This is a valid move");
						} else {
							autoSpace
									.setText("Sorry, this is not a valid move");
						}
					}
				}
			} catch (NumberFormatException a) {
				// a.printStackTrace();
				autoSpace.setText("Please enter an integer");
			}
			if (enter.isSelected()) {
				int a = Integer.parseInt(userSpace.getText());
				try {
					SudokuBoard.enterMove(2, 2, a);
				} catch (NumberFormatException nfe) {
					nfe.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					autoSpace.setText("Invalid Move");
				}
			}
			if (clear.isSelected()) {
				a22.setText("");
				try {
					SudokuBoard.enterMove(2, 2, 0);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					autoSpace.setText("Invalid Move");
				}

			}

		}
		if (a23.isEnabled()) {
			try {
				if (checkValid.isSelected()) {
					int a = Integer.parseInt(userSpace.getText());
					if (a >= 0 && a <= 4) {
						if ((SudokuBoard.isValid(2, 3, a))) {// ||(a01.isSelected()&&SudokuBoard.isValid(0,1,a))||(a02.isSelected()&&SudokuBoard.isValid(0,2,a))||(a03.isSelected()&&SudokuBoard.isValid(0,3,a))||(a10.isSelected()&&SudokuBoard.isValid(1,0,a))||(a11.isSelected()&&SudokuBoard.isValid(1,1,a))||(a12.isSelected()&&SudokuBoard.isValid(1,2,a))||(a13.isSelected()&&SudokuBoard.isValid(1,3,a))||(a20.isSelected()&&SudokuBoard.isValid(2,0,a))||(a21.isSelected()&&SudokuBoard.isValid(2,1,a))||(a22.isSelected()&&SudokuBoard.isValid(2,2,a))||(a23.isSelected()&&SudokuBoard.isValid(2,3,a))||(a30.isSelected()&&SudokuBoard.isValid(3,0,a))||(a31.isSelected()&&SudokuBoard.isValid(3,1,a))||(a32.isSelected()&&SudokuBoard.isValid(3,2,a))||(a33.isSelected()&&SudokuBoard.isValid(3,3,a))){
							autoSpace.setText("This is a valid move");
						} else {
							autoSpace
									.setText("Sorry, this is not a valid move");
						}
					}
				}
			} catch (NumberFormatException a) {
				// a.printStackTrace();
				autoSpace.setText("Please enter an integer");
			}
			if (enter.isSelected()) {
				int a = Integer.parseInt(userSpace.getText());
				try {
					SudokuBoard.enterMove(2, 3, a);
				} catch (NumberFormatException nfe) {
					nfe.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					autoSpace.setText("Invalid Move");
				}
			}
			if (clear.isSelected()) {
				a23.setText("");
				try {
					SudokuBoard.enterMove(2, 3, 0);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					autoSpace.setText("Invalid Move");
				}

			}

		}
		if (a30.isEnabled()) {
			try {
				if (checkValid.isSelected()) {
					int a = Integer.parseInt(userSpace.getText());
					if (a >= 0 && a <= 4) {
						if ((SudokuBoard.isValid(3, 0, a))) {// ||(a01.isSelected()&&SudokuBoard.isValid(0,1,a))||(a02.isSelected()&&SudokuBoard.isValid(0,2,a))||(a03.isSelected()&&SudokuBoard.isValid(0,3,a))||(a10.isSelected()&&SudokuBoard.isValid(1,0,a))||(a11.isSelected()&&SudokuBoard.isValid(1,1,a))||(a12.isSelected()&&SudokuBoard.isValid(1,2,a))||(a13.isSelected()&&SudokuBoard.isValid(1,3,a))||(a20.isSelected()&&SudokuBoard.isValid(2,0,a))||(a21.isSelected()&&SudokuBoard.isValid(2,1,a))||(a22.isSelected()&&SudokuBoard.isValid(2,2,a))||(a23.isSelected()&&SudokuBoard.isValid(2,3,a))||(a30.isSelected()&&SudokuBoard.isValid(3,0,a))||(a31.isSelected()&&SudokuBoard.isValid(3,1,a))||(a32.isSelected()&&SudokuBoard.isValid(3,2,a))||(a33.isSelected()&&SudokuBoard.isValid(3,3,a))){
							autoSpace.setText("This is a valid move");
						} else {
							autoSpace
									.setText("Sorry, this is not a valid move");
						}
					}
				}
			} catch (NumberFormatException a) {
				// a.printStackTrace();
				autoSpace.setText("Please enter an integer");
			}
			if (enter.isSelected()) {
				int a = Integer.parseInt(userSpace.getText());
				try {
					SudokuBoard.enterMove(3, 0, a);
				} catch (NumberFormatException nfe) {
					nfe.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					autoSpace.setText("Invalid Move");
				}
			}
			if (clear.isSelected()) {
				a30.setText("");
				try {
					SudokuBoard.enterMove(3, 0, 0);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					autoSpace.setText("Invalid Move");
				}

			}

		}
		if (a31.isEnabled()) {
			try {
				if (checkValid.isSelected()) {
					int a = Integer.parseInt(userSpace.getText());
					if (a >= 0 && a <= 4) {
						if ((SudokuBoard.isValid(3, 1, a))) {// ||(a01.isSelected()&&SudokuBoard.isValid(0,1,a))||(a02.isSelected()&&SudokuBoard.isValid(0,2,a))||(a03.isSelected()&&SudokuBoard.isValid(0,3,a))||(a10.isSelected()&&SudokuBoard.isValid(1,0,a))||(a11.isSelected()&&SudokuBoard.isValid(1,1,a))||(a12.isSelected()&&SudokuBoard.isValid(1,2,a))||(a13.isSelected()&&SudokuBoard.isValid(1,3,a))||(a20.isSelected()&&SudokuBoard.isValid(2,0,a))||(a21.isSelected()&&SudokuBoard.isValid(2,1,a))||(a22.isSelected()&&SudokuBoard.isValid(2,2,a))||(a23.isSelected()&&SudokuBoard.isValid(2,3,a))||(a30.isSelected()&&SudokuBoard.isValid(3,0,a))||(a31.isSelected()&&SudokuBoard.isValid(3,1,a))||(a32.isSelected()&&SudokuBoard.isValid(3,2,a))||(a33.isSelected()&&SudokuBoard.isValid(3,3,a))){
							autoSpace.setText("This is a valid move");
						} else {
							autoSpace
									.setText("Sorry, this is not a valid move");
						}
					}
				}
			} catch (NumberFormatException a) {
				// a.printStackTrace();
				autoSpace.setText("Please enter an integer");
			}
			if (enter.isSelected()) {
				int a = Integer.parseInt(userSpace.getText());
				try {
					SudokuBoard.enterMove(3, 1, a);
				} catch (NumberFormatException nfe) {
					nfe.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					autoSpace.setText("Invalid Move");
				}
			}
			if (clear.isSelected()) {
				a31.setText("");
				try {
					SudokuBoard.enterMove(3, 1, 0);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					autoSpace.setText("Invalid Move");
				}

			}

		}
		if (a32.isEnabled()) {
			try {
				if (checkValid.isSelected()) {
					int a = Integer.parseInt(userSpace.getText());
					if (a >= 0 && a <= 4) {
						if ((SudokuBoard.isValid(3, 2, a))) {// ||(a01.isSelected()&&SudokuBoard.isValid(0,1,a))||(a02.isSelected()&&SudokuBoard.isValid(0,2,a))||(a03.isSelected()&&SudokuBoard.isValid(0,3,a))||(a10.isSelected()&&SudokuBoard.isValid(1,0,a))||(a11.isSelected()&&SudokuBoard.isValid(1,1,a))||(a12.isSelected()&&SudokuBoard.isValid(1,2,a))||(a13.isSelected()&&SudokuBoard.isValid(1,3,a))||(a20.isSelected()&&SudokuBoard.isValid(2,0,a))||(a21.isSelected()&&SudokuBoard.isValid(2,1,a))||(a22.isSelected()&&SudokuBoard.isValid(2,2,a))||(a23.isSelected()&&SudokuBoard.isValid(2,3,a))||(a30.isSelected()&&SudokuBoard.isValid(3,0,a))||(a31.isSelected()&&SudokuBoard.isValid(3,1,a))||(a32.isSelected()&&SudokuBoard.isValid(3,2,a))||(a33.isSelected()&&SudokuBoard.isValid(3,3,a))){
							autoSpace.setText("This is a valid move");
						} else {
							autoSpace
									.setText("Sorry, this is not a valid move");
						}
					}
				}
			} catch (NumberFormatException a) {
				// a.printStackTrace();
				autoSpace.setText("Please enter an integer");
			}
			if (enter.isSelected()) {
				int a = Integer.parseInt(userSpace.getText());
				try {
					SudokuBoard.enterMove(3, 2, a);
				} catch (NumberFormatException nfe) {
					nfe.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					autoSpace.setText("Invalid Move");
				}
			}
			if (clear.isSelected()) {
				a32.setText("");
				try {
					SudokuBoard.enterMove(3, 2, 0);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					autoSpace.setText("Invalid Move");
				}

			}

		}
		if (a33.isEnabled()) {
			try {
				if (checkValid.isSelected()) {
					int a = Integer.parseInt(userSpace.getText());
					if (a >= 0 && a <= 4) {
						if ((SudokuBoard.isValid(3, 3, a))) {// ||(a01.isSelected()&&SudokuBoard.isValid(0,1,a))||(a02.isSelected()&&SudokuBoard.isValid(0,2,a))||(a03.isSelected()&&SudokuBoard.isValid(0,3,a))||(a10.isSelected()&&SudokuBoard.isValid(1,0,a))||(a11.isSelected()&&SudokuBoard.isValid(1,1,a))||(a12.isSelected()&&SudokuBoard.isValid(1,2,a))||(a13.isSelected()&&SudokuBoard.isValid(1,3,a))||(a20.isSelected()&&SudokuBoard.isValid(2,0,a))||(a21.isSelected()&&SudokuBoard.isValid(2,1,a))||(a22.isSelected()&&SudokuBoard.isValid(2,2,a))||(a23.isSelected()&&SudokuBoard.isValid(2,3,a))||(a30.isSelected()&&SudokuBoard.isValid(3,0,a))||(a31.isSelected()&&SudokuBoard.isValid(3,1,a))||(a32.isSelected()&&SudokuBoard.isValid(3,2,a))||(a33.isSelected()&&SudokuBoard.isValid(3,3,a))){
							autoSpace.setText("This is a valid move");
						} else {
							autoSpace
									.setText("Sorry, this is not a valid move");
						}
					}
				}
			} catch (NumberFormatException a) {
				// a.printStackTrace();
				autoSpace.setText("Please enter an integer");
			}
			if (enter.isSelected()) {
				int a = Integer.parseInt(userSpace.getText());
				try {
					SudokuBoard.enterMove(3, 3, a);
				} catch (NumberFormatException nfe) {
					nfe.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					autoSpace.setText("Invalid Move");
				}
			}
			if (clear.isSelected()) {
				a33.setText("");
				try {
					SudokuBoard.enterMove(3, 3, 0);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					autoSpace.setText("Invalid Move");
				}

			}

		}
		if(reset.isEnabled()){
			
			SudokuBoard.reset(); 
		}
	}


}