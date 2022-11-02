import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JLabel;
class Viewer{
	Viewer(){
		Controller controller = new Controller(this);

		JLabel ipLabel = new JLabel("IP:");
		ipLabel.setBounds(30, 30, 30, 50);

		JTextField ipTextField = new JTextField("localhost");
		ipTextField.setBounds(50, 30, 300, 50);

		JTextArea mesTextArea = new JTextArea("Message");
		mesTextArea.setBounds(50, 100, 300, 200);

		JButton sButton = new JButton("Send");
		sButton.setBounds(300, 320, 70, 30);

		JTextArea recTextArea = new JTextArea("Client message");
		recTextArea.setBounds(50, 400, 300, 200);

		JButton cButton = new JButton("Clear");
		cButton.setBounds(300, 620, 70, 30);

		JFrame frame = new JFrame("ICQ");

		frame.setSize(400, 800);
		frame.add(ipTextField);
		frame.add(mesTextArea);
		frame.add(recTextArea);
		frame.add(sButton);
		frame.add(cButton);
		frame.add(ipLabel);
		frame.setLayout(null);
		frame.setVisible(true);
		
	}
}