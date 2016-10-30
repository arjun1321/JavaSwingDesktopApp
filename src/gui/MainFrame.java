package gui;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;

import com.sun.glass.events.KeyEvent;

import controller.Controller;


public class MainFrame extends JFrame {
//	private JTextArea textArea;
//	private JButton btn;
	private TextPanel textPanel;
	private Toolbar toolbar;
	private FormPanel formPanel;
	private JFileChooser fileChooser;
	private Controller controller;
	private TablePanel tablePanel;
	
	public MainFrame() {
		
		super("Hello World");
		setLayout(new BorderLayout());
		
		setJMenuBar(createMenuBar());
		
//		textArea = new JTextArea();
//		btn = new JButton("Click Me!");
		textPanel = new TextPanel();
		toolbar = new Toolbar();
		formPanel = new FormPanel();
		controller = new Controller();
		tablePanel = new TablePanel();
		
		tablePanel.setData(controller.getPeople());
		
		fileChooser = new JFileChooser();
		fileChooser.addChoosableFileFilter(new PersonFileFilter());
		
//		btn.addActionListener(new ActionListener() {
//
//			public void actionPerformed(ActionEvent arg0) {
//				textArea.append("Hello\n");
//				textPanel.appendText("Hello\n");
//				
//			}
//			
//		});
		
//		toolbar.setTextPanel(textPanel);
		
		formPanel.setFormListener(new FormListener() {

			public void formEventOccured(FormEvent event) {
				controller.addPerson(event);
				tablePanel.refresh();
				
			}
			
			
		});
		
		toolbar.setStringListener(new StringListener () {

			public void textEmitted(String string) {
				textPanel.appendText(string);
				
			}
			
		});
		
//		add(new JScrollPane(textArea), BorderLayout.CENTER);
		add(formPanel, BorderLayout.WEST);
		add(toolbar, BorderLayout.NORTH);
		add(tablePanel, BorderLayout.CENTER);
//		add(btn, BorderLayout.SOUTH);
		
		setMinimumSize(new Dimension(500, 400));
		setSize(600, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	
	private JMenuBar createMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		
		JMenu fileMenu = new JMenu("File");
		
		JMenuItem exportDataItem = new JMenuItem("Export Data...");
		JMenuItem importDataItem = new JMenuItem("Import Data...");
		JMenuItem exitItem = new JMenuItem("Exit");
		
		fileMenu.add(exportDataItem);
		fileMenu.add(importDataItem);
		fileMenu.addSeparator();
		fileMenu.add(exitItem);
		
		JMenu windowMenu = new JMenu("Window");
		JMenu showMenu = new JMenu("Show");
		
//		JMenuItem showFormItem = new JMenuItem("Person Form");
//		showMenu.add(showFormItem);
		
		JCheckBoxMenuItem showFormItem = new JCheckBoxMenuItem("Person Form");
		showFormItem.setSelected(true);
		showMenu.add(showFormItem);
		windowMenu.add(showMenu);
		
		menuBar.add(fileMenu);
		menuBar.add(windowMenu);
		
		showFormItem.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				JCheckBoxMenuItem menuItem = (JCheckBoxMenuItem) arg0.getSource();
				formPanel.setVisible(menuItem.isSelected());
			}
			
		});
		
		fileMenu.setMnemonic(KeyEvent.VK_F);
		exitItem.setMnemonic(KeyEvent.VK_X);
		// Accelerator is used to create a shortcut key
		exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
		importDataItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, ActionEvent.CTRL_MASK));

		
		importDataItem.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				if(fileChooser.showOpenDialog(MainFrame.this) == fileChooser.APPROVE_OPTION) {
					try {
						controller.loadFromFile(fileChooser.getSelectedFile());
						tablePanel.refresh();
					} catch (IOException e) {
						JOptionPane.showMessageDialog(MainFrame.this, "Could not load data from file", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}	
			}
		});
		
		exportDataItem.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				if(fileChooser.showSaveDialog(MainFrame.this) == fileChooser.APPROVE_OPTION) {
					try {
						controller.saveToFile(fileChooser.getSelectedFile());
					} catch (IOException e) {
						JOptionPane.showMessageDialog(MainFrame.this, "Could not save data to file", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}	
			}
		});
		
		exitItem.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				
				// Creating input dialog
//				String username = JOptionPane.showInputDialog(MainFrame.this, "Enter Your Usename", "Enter Username", JOptionPane.OK_OPTION|JOptionPane.INFORMATION_MESSAGE);
//				System.out.println(username);
				
				int action = JOptionPane.showConfirmDialog(MainFrame.this, "Are you really want to exit?", "Confirm Exit", JOptionPane.OK_CANCEL_OPTION);
				
				if(action == JOptionPane.OK_OPTION)
				System.exit(0);
			}
			
		});
		
		return menuBar;
	}
	
	
}
