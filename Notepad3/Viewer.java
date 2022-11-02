import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.KeyStroke;
import javax.swing.JSeparator;


class Viewer {

	Viewer() {

	Controller controller = new Controller(this);

	JMenuBar menuBar = new JMenuBar();

	JMenu file = new JMenu("File");
	JMenuItem newMenuItem = new JMenuItem("New Document", new ImageIcon("images/new.gif"));
        newMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));


	JMenuItem openMenuItem = new JMenuItem("Open Document");

	file.add(newMenuItem);
	file.add(new JSeparator());
	file.add(openMenuItem);


	JMenu edit = new JMenu("Edit");

	JMenuItem undoMenuItem = new JMenuItem("Undo");
	JMenuItem cutMenuItem = new JMenuItem("Cut");

	edit.add(undoMenuItem);
	edit.add(cutMenuItem);	


	JMenu format = new JMenu("Format");
	JMenu view = new JMenu("View");
	JMenu help = new JMenu("Help");
	
	menuBar.add(file);
	menuBar.add(edit);
       	menuBar.add(format);
	menuBar.add(view);
	menuBar.add(help);


	JTextArea textArea = new JTextArea();
	JScrollPane scroll = new JScrollPane(textArea);


	JFrame frame = new JFrame("Notepad");
	frame.add("Center", textArea);
        frame.setSize(500, 500);
        frame.setJMenuBar(menuBar);
	frame.setVisible(true);
        
	}
}