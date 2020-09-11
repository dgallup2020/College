package helpers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class ExitButton extends JButton {
	
	private String appName = "Application";
		
	public ExitButton() {
		createButton();
	}
	public ExitButton(String appName) {
		setAppName(appName);
		createButton();
	}
	private void setAppName(String appName) {
		if (appName != null && !appName.trim().isEmpty()) {
			this.appName = appName;
		}
		else {
			appName = "Application";
		}
	}
	private void createButton()
	{
		this.setText("Exit");
		this.setMnemonic('x');
		this.setToolTipText("Click to exit " + appName);
		this.addActionListener(new Handler());
	}
	private class Handler implements ActionListener {
		public void actionPerformed(ActionEvent e)
		{
			int response = JOptionPane.NO_OPTION;
			String prompt = "Do you want to quit " + appName + "?";
			String title = "Quit " + appName;
			response = JOptionPane.showConfirmDialog(null, prompt, title, 
										  JOptionPane.OK_CANCEL_OPTION, 
										  JOptionPane.QUESTION_MESSAGE);
			if(response == JOptionPane.YES_OPTION) {
				System.exit(0);
			}
		}
	}
}
