import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.KeyStroke;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

class Viewer {

    Controller controller;
    JTextArea textArea;

    JFrame frame;

    Viewer() {
	controller = new Controller(this);
        initialization();
    }

	public void initialization() {
		JMenuItem newDocument = new JMenuItem("New", new ImageIcon("img/new.gif"));
		newDocument.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));		
	        newDocument.addActionListener(controller);
		newDocument.setActionCommand("Create New Document");             
		
		JMenuItem openDocument = new JMenuItem("Open...", new ImageIcon("img/open.gif"));
		openDocument.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
                openDocument.addActionListener(controller);
		openDocument.setActionCommand("Open Document");

		JMenuItem saveDocument = new JMenuItem("Save", new ImageIcon("img/save.gif"));
		saveDocument.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));

		JMenuItem saveasDocument = new JMenuItem("Save As...", new ImageIcon("img/save_as.gif"));
	
		JMenuItem pageDocument = new JMenuItem("Page Setup...");

		JMenuItem printDocument = new JMenuItem("Print...", new ImageIcon("img/print.gif"));
		printDocument.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
		printDocument.addActionListener(controller);
		printDocument.setActionCommand("Print Document");


		JMenuItem exitDocument = new JMenuItem("Exit");

		JMenu fileMenu = new JMenu("File");
		fileMenu.add(newDocument);
		fileMenu.add(openDocument);
		fileMenu.add(saveDocument);
		fileMenu.add(saveasDocument);
                fileMenu.add(new JSeparator());
		fileMenu.add(pageDocument);
		fileMenu.add(printDocument);
		fileMenu.add(new JSeparator());
		fileMenu.add(exitDocument);    


		JMenuItem undoDocument = new JMenuItem("Undo");
		undoDocument.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, ActionEvent.CTRL_MASK));

		JMenuItem cutDocument = new JMenuItem("Cut", new ImageIcon("img/cut.gif"));
		saveDocument.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));

		JMenuItem copyDocument = new JMenuItem("Copy", new ImageIcon("img/copy.gif"));
		copyDocument.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
		
		JMenuItem pasteDocument = new JMenuItem("Paste", new ImageIcon("img/past.gif"));
		pasteDocument.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
	
		JMenuItem deleteDocument = new JMenuItem("Delete", new ImageIcon("img/delit.gif"));
		deleteDocument.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0));

		JMenuItem findDocument = new JMenuItem("Find...", new ImageIcon("img/find.gif"));
		findDocument.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, ActionEvent.CTRL_MASK));
	
		JMenuItem findnDocument = new JMenuItem("Find Next", new ImageIcon("img/findMore.gif"));
		findnDocument.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F3, 0));

		JMenuItem replaceDocument = new JMenuItem("Replace");
		replaceDocument.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, ActionEvent.CTRL_MASK));
 
		JMenuItem gotoDocument = new JMenuItem("Go to...", new ImageIcon("img/go.gif"));
		gotoDocument.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, ActionEvent.CTRL_MASK));

		JMenuItem selectDocument = new JMenuItem("Select All");
		selectDocument.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));

		JMenuItem tdDocument = new JMenuItem("Time/Date", new ImageIcon("img/time.gif"));
		tdDocument.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F5, ActionEvent.CTRL_MASK));

		JMenu editMenu = new JMenu("Edit"); 	
		editMenu.add(undoDocument);
		editMenu.add(new JSeparator());
		editMenu.add(cutDocument);     
		editMenu.add(copyDocument);
		editMenu.add(pasteDocument);   
		editMenu.add(deleteDocument);                
         	editMenu.add(new JSeparator());
		editMenu.add(findDocument);     
		editMenu.add(findnDocument);
		editMenu.add(replaceDocument);   
		editMenu.add(gotoDocument);
		editMenu.add(new JSeparator()); 
		editMenu.add(selectDocument);   
		editMenu.add(tdDocument); 
 

		JMenuItem worldDocument = new JMenuItem("World Wrap", new ImageIcon("img/wordSpace.gif"));                                   

		JMenuItem fontDocument = new JMenuItem("Font...", new ImageIcon("img/font.gif"));      

       		JMenu formatMenu = new JMenu("Format");
		formatMenu.add(worldDocument);
		formatMenu.add(fontDocument);   
	

                JMenuItem statusDocument = new JMenuItem("Status Bar");

		JMenu viewMenu = new JMenu("View");
		viewMenu.add(statusDocument);


		JMenu helpMenu = new JMenu("Help");

		JMenuBar mBar = new JMenuBar();

		mBar.add(fileMenu);
		mBar.add(editMenu);
		mBar.add(formatMenu);
		mBar.add(viewMenu);
		mBar.add(helpMenu);

		textArea = new JTextArea();
		JScrollPane scroll = new JScrollPane(textArea);

		frame = new JFrame("Notepad");
		frame.setSize(600, 600);
		frame.setLocation(500, 50);
		frame.setJMenuBar(mBar);
		frame.add("Center", scroll);
		frame.setVisible(true);
	}
	        public JTextArea getTextArea() {
			return textArea;
		}
}