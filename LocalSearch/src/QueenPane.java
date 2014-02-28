import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;
import java.awt.*;


@SuppressWarnings("serial")
public class QueenPane extends JPanel {
	public QueenPane(Integer n, QueenState s, Color color) {
		
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		String[][] locations = s.gridLocations();//gets locations of all of the queens in solution
		
		for (int row = 0; row < n; row++) {
			for (int col = 0; col < n; col++) {
				gbc.gridx = col;
				gbc.gridy = row;

				CellPane cellPane = new CellPane(n);
				if (!(locations[col][row] == null)) //if there's supposed to be a queen there, paint it blue
					cellPane.setBackground(color);

				Border border = null;
				if (row < n-1) { //make a pretty border
					if (col < n-1) {
						border = new MatteBorder(1, 1, 0, 0, Color.GRAY);
					} else {
						border = new MatteBorder(1, 1, 0, 1, Color.GRAY);
					}
				} else {
					if (col < n-1) {
						border = new MatteBorder(1, 1, 1, 0, Color.GRAY);
					} else {
						border = new MatteBorder(1, 1, 1, 1, Color.GRAY);
					}
				}
				cellPane.setBorder(border);
				add(cellPane, gbc);
			}
		}
	}
}
