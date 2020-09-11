package helpers;

import java.awt.Color;
import java.awt.Font;

import java.awt.Component;
import java.awt.Container;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.text.JTextComponent;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JViewport;


public class GUIUtilities {
    private static Color navyBlue = new Color(0, 0, 80);

    public static void setNormalFont(JComponent control) {
            Font myFont = new Font("Arial", Font.PLAIN, 12);
            control.setFont(myFont);
            control.setForeground(navyBlue);
    }

    public static void setHeadingFont(JComponent control) {
            Font myFont = new Font("Arial", Font.BOLD|Font.ITALIC, 14);
            control.setFont(myFont);
            control.setForeground(navyBlue);
    }

    public static void enableInputFields(JPanel panel, boolean enable) {
        for (Component  comp : panel.getComponents()) {
            if (comp instanceof JTextComponent) {
                comp.setEnabled(enable);
                ((JTextComponent) comp).setText("");
            }
            if (comp instanceof JToggleButton) {
                comp.setEnabled(enable);
                ((JToggleButton) comp).setSelected(false);
            }
            if (comp instanceof JComboBox || comp instanceof JList) {
                comp.setEnabled(enable);
            }
        }
    }
    public static void clearInputFields(JPanel panel) {
        for (Component comp : panel.getComponents()) {
            if (comp instanceof JTextComponent) {
                ((JTextComponent) comp).setText("");
            }
            if (comp instanceof JCheckBox) {
                ((JToggleButton) comp).setSelected(false);
            }
            if (comp instanceof JScrollPane) {
                clearJScrollPane((JScrollPane)comp);
            }
        }
    }
    public static void clearJScrollPane(JScrollPane pane) {
        for (Component comp : pane.getViewport().getComponents()) {
             if (comp instanceof JTextComponent) {
                ((JTextComponent) comp).setText("");
            }
            if (comp instanceof JCheckBox) {
                ((JToggleButton) comp).setSelected(false);
            }
        }
    }
    public static void centerForm(JFrame theFrame) {
        if (theFrame != null) {
            theFrame.setVisible(true);
            theFrame.setLocationRelativeTo(null);
        }
    }
}
