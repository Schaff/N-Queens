import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;


public class Grid {
	JFrame _frame;
	QueenPane _pane;
	public Grid(Integer n, State s) {
	_frame = new JFrame(n.toString() + " Queens");
    _frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    _frame.setLayout(new BorderLayout());
    _pane = new QueenPane(n, ((QueenState) s), Color.GRAY);
    _frame.getContentPane().add(_pane);
    _frame.pack();
    _frame.setLocationRelativeTo(null);
    _frame.setVisible(true);
	}
	
	public void setFrame(int n, State s, Color color) {
		_frame.getContentPane().removeAll();
	    _frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    _frame.setLayout(new BorderLayout());
	    _pane = new QueenPane(n, ((QueenState) s), color);
	    _frame.getContentPane().add(_pane);
	    _frame.pack();
	    _frame.setLocationRelativeTo(null);
	    _frame.setVisible(true);
	}
}
