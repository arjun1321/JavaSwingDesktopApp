import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class MainFrame extends JFrame {
//	private JTextArea textArea;
//	private JButton btn;
	private TextPanel textPanel;
	private Toolbar toolbar;
	private FormPanel formPanel;
	
	public MainFrame() {
		
		super("Hello World");
		setLayout(new BorderLayout());
		
		setJMenuBar(createMenuBar());
		
//		textArea = new JTextArea();
//		btn = new JButton("Click Me!");
		textPanel = new TextPanel();
		toolbar = new Toolbar();
		formPanel = new FormPanel();
		
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
				String name = event.getName();
				String occupation = event.getOccupation();
				int ageCat = event.getAgeCategory();
				String empCat = event.getEmploymentCategory();
				String gender = event.getGender();
				
				textPanel.appendText(name +": "+ occupation + ": "+ ageCat + ", " + empCat +"\n");
				
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
		add(textPanel, BorderLayout.CENTER);
//		add(btn, BorderLayout.SOUTH);
		
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
		
		return menuBar;
	}
	
	
}
