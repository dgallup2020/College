package helpers;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JFrame;

public class LayoutHelpers {
	
	private static GridBagConstraints bag = LayoutHelpers.setUpBagConstraints();
	
	public static GridBagConstraints setUpBagConstraints() {
		GridBagConstraints bag = new GridBagConstraints();
		
		bag.fill = GridBagConstraints.HORIZONTAL;
		bag.anchor = GridBagConstraints.FIRST_LINE_START;
		bag.insets = new Insets(5,5,5,5);
		
		return bag;
		
	}

	public static void placeComponent(JComponent win, JComponent control, 
						int row, int col,
						int width, int height) 
	{
		bag.gridy = row;
		bag.gridx = col;
		bag.gridwidth = width;
		bag.gridheight = height;
		win.add(control, bag);
	}
        public static void placeComponent(JFrame win, JComponent control, 
						int row, int col,
						int width, int height) 
	{
		bag.gridy = row;
		bag.gridx = col;
		bag.gridwidth = width;
		bag.gridheight = height;
		win.add(control, bag);
	}
	
	public static JTextField addTextInput(JComponent win, String description,
					     int row, int col, int fieldLength,
					     Boolean canEdit) {
		JLabel lblField = new JLabel(description);
		JTextField fld = new JTextField(fieldLength);
		fld.setEditable(canEdit);
		
		placeComponent(win, lblField, row, col, 1, 1);
		col++;  //move over one column, keep the row the same
		placeComponent(win, fld, row, col, 1, 1);
		
		return fld;
	}
        public static JTextField addTextInput(JFrame win, String description,
					     int row, int col, int fieldLength,
					     Boolean canEdit) 
        {
		JLabel lblField = new JLabel(description);
		JTextField fld = new JTextField(fieldLength);
		fld.setEditable(canEdit);
		
		placeComponent(win, lblField, row, col, 1, 1);
		col++;  //move over one column, keep the row the same
		placeComponent(win, fld, row, col, 1, 1);
		
		return fld;
	}
        public static JTextField addTextInput(JFrame win, String description,
					     int row, int col, int fieldLength,
                                             int width, int height,
					     Boolean canEdit) 
        {
		JLabel lblField = new JLabel(description);
		JTextField fld = new JTextField(fieldLength);
		fld.setEditable(canEdit);
		
		placeComponent(win, lblField, row, col, 1, 1);
		col++;  //move over one column, keep the row the same
		placeComponent(win, fld, row, col, width, height);
		
		return fld;
	}

	
	
	
}
