import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;


public class Toolbar extends JPanel implements ActionListener{
	
	private JButton helloButton;
	private JButton goodbyeButton;
	private TextPanel textPanel;
	
	public Toolbar() {
		helloButton = new JButton("Hello");
		goodbyeButton = new JButton("Goodbye");
		
		helloButton.addActionListener(this);
		goodbyeButton.addActionListener(this);
		
		setLayout(new FlowLayout(FlowLayout.LEFT));
		add(helloButton);
		add(goodbyeButton);
	}
	
	protected void setTextPanel(TextPanel textPanel) {
		this.textPanel = textPanel;
	}

	public void actionPerformed(ActionEvent event) {
		
		JButton button = (JButton)event.getSource();
		
		if(button == helloButton)
			textPanel.appendText("Hello\n");
		if(button == goodbyeButton)
			textPanel.appendText("Goodbye\n");
	}

}
