import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class MainFrame extends JFrame {
//	private JTextArea textArea;
	private JButton btn;
	private TextPanel textPanel;
	
	public MainFrame() {
		
		super("Hello World");
		setLayout(new BorderLayout());
		
//		textArea = new JTextArea();
		btn = new JButton("Click Me!");
		textPanel = new TextPanel();
		
		btn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
//				textArea.append("Hello\n");
				textPanel.appendText("Hello\n");
				
			}
			
		});
		
//		add(new JScrollPane(textArea), BorderLayout.CENTER);
		add(textPanel, BorderLayout.CENTER);
		add(btn, BorderLayout.SOUTH);
		
		setSize(600, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	
	
}
