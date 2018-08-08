package com.alienbankframework.view;

import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class AbstractCustomerDialog extends javax.swing.JDialog {
	private AbstractFrame parentFrame;
	
	public AbstractCustomerDialog(AbstractFrame parentFrame, String title) {
		super(parentFrame);
		this.parentFrame = parentFrame;
		
		setTitle("Add compamy account");
		setModal(true);
		getContentPane().setLayout(null);
		setSize(298,360);
		setVisible(false);
	}
	
}
