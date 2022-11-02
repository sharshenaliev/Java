import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Viewer{
	private JTextField ipTextField;
	private JTextArea messageTextArea; 
	private JTextArea receivedTextArea;


	public Viewer(){
	Controller controller = new Controller(this);
        JLabel ipLabel = new JLabel("IP:");
	ipLabel.setBounds(30, 30, 30, 50);

	ipTextField = new JTextField("localhost");
        ipTextField.setBounds(50, 30, 230, 50);

	messageTextArea = new JTextArea("Message");
	JScrollPane scroll1 = new JScrollPane(messageTextArea);
	scroll1.setBounds(30, 100, 250, 250);

	JButton buttonS = new JButton("Send");
        buttonS.setBounds(180, 360, 100, 50);
	buttonS.addActionListener(controller);
	buttonS.setActionCommand("Send Message");

	receivedTextArea = new JTextArea("Client message");
	JScrollPane scroll2 = new JScrollPane(receivedTextArea);
	scroll2.setBounds(30, 420, 250, 250);

	JButton buttonC = new JButton("Clear");
        buttonC.setBounds(180, 680, 100, 50);
	buttonC.addActionListener(controller);
	buttonC.setActionCommand("Clear TextArea");

	JFrame frame = new JFrame("ICQ");
        frame.setSize(330, 800);
	frame.setResizable(false);
        frame.setLayout(null);
	frame.setLocation(130, 30); 
        frame.add(ipLabel);
	frame.add(scroll1);
	frame.add(scroll2);
	frame.add(ipTextField);
	frame.add(buttonS);
	frame.add(buttonC);
        frame.setVisible(true);
       
	}
        
	public String getIpAddress(){
		return ipTextField.getText();
	}

	public String getMessageText(){
		return messageTextArea.getText();
	}

	public void setReceivedText(String text){
		receivedTextArea.setText(text);
	}
	
}