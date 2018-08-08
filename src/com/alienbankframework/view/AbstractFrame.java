package com.alienbankframework.view;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public abstract class AbstractFrame extends JFrame {
	private JPanel JPanel1;
	private DefaultTableModel tableModel;
	private JScrollPane JScrollPane1;
	private JTable JTable1;
	
	public AbstractFrame(String title) {
		JPanel1 = new JPanel();
		
		setTitle(title);
		
		setDefaultCloseOperation(javax.swing.JFrame.DO_NOTHING_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(0,0));
		setSize(575,310);
		setVisible(false);
		JPanel1.setLayout(null);
		getContentPane().add(BorderLayout.CENTER, JPanel1);
		JPanel1.setBounds(0,0,575,310);
		
		JScrollPane1 = new JScrollPane();
		tableModel = getTableModel();
        JTable1 = new JTable(tableModel);
        
		JPanel1.add(JScrollPane1);
        JScrollPane1.setBounds(12,92,444,160);
        JScrollPane1.getViewport().add(JTable1);
        JTable1.setBounds(0, 0, 420, 0);
	}
	
	//public abstract JPanel getPanel();
	public abstract DefaultTableModel getTableModel();
	public final JTable getTable() {
		return JTable1;
	}
	
	public final void addButton(JButton button, int x, int y, int height, int width) {
		//button.setText(text);
		JPanel1.add(button);
		button.setBounds(x,y,height,width);
	}
}
