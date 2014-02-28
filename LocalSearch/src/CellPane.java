//import java.awt.Color;
import java.awt.Dimension;
//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class CellPane extends JPanel{
//	private Color defaultBackground;
	private int n;
	private JLabel label;
	public CellPane(Integer n) {
		this.n = n;
		label = new JLabel();
		add(label);
//		addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseEntered(MouseEvent e) {
//				defaultBackground = getBackground();
//				
//				setBackground(Color.ORANGE);
//			}
//
//			@Override
//			public void mouseExited(MouseEvent e) {
//				setBackground(defaultBackground);
//			}
//		});
	}

	@Override
	public Dimension getPreferredSize() {//decent fit
		if (n < 10)
		return new Dimension(50, 50);
		else return new Dimension(750/n, 750/n);
	}

	public JLabel getLabel() {
		return label;
	}

}
