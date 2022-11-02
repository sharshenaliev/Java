import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.File;
import javax.swing.JOptionPane;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import java.io.PrintWriter;

import java.awt.print.PrinterJob;
import java.awt.print.PrinterException;
import java.awt.print.PageFormat;
import java.awt.print.Printable;      
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Font;
import java.awt.FontMetrics;

class Controller implements ActionListener, Printable{

    Viewer viewer;
    String textToPrint;
    int pageCounter;
    int bottomBorder;

    Controller(Viewer viewer) {
	this.viewer = viewer;
	textToPrint = "";
    }
    public void actionPerformed(ActionEvent event) {


    String command = event.getActionCommand();
    
    switch(command) {

    	case "Create New Document":    
		JFileChooser fc1 = new JFileChooser();
		int returnValue = fc1.showSaveDialog(viewer.frame);

		if(returnValue == 0){
			save(fc1);	
		}		

	break;

	case "Open Document":

		JFileChooser fc = new JFileChooser();
		int returnVal = fc.showOpenDialog(new JFrame());

		if(returnVal == 0){
			String textFromFile = open(fc);
			
			if(textFromFile != null){
				viewer.getTextArea().setText(textFromFile);
			}
		}		

	break;

        case "Print Document":    
		showPrinterDialog();	
	break;



	}
    }


	public String open(JFileChooser fileChooser) {
		String text = "";
		try {
			File file = fileChooser.getSelectedFile();
			FileInputStream in = new FileInputStream(file);
			int c;
			while ((c = in.read()) != -1) {
				char symbol = (char)c;
				text = text + symbol;
			}
		} catch(FileNotFoundException fnfe) {
			System.out.println(fnfe);
			return null;
		} catch(IOException ioe) {
			System.out.println(ioe);
			return null;
		}
		return text;
	}

	public void save(JFileChooser fileChooser) {
		String textToSave = viewer.getTextArea().getText();
		try {
			File file = fileChooser.getSelectedFile();
			PrintWriter outputStream = new PrintWriter(file);
			outputStream.println(textToSave);
			outputStream.close();
		} catch(FileNotFoundException fnfe) {
			System.out.println(fnfe); 
		}
 	}
	
	public int print(Graphics g, PageFormat pf, int page)
		throws PrinterException {

		if (page > pageCounter) {
			return NO_SUCH_PAGE;
		}             

		Graphics2D g2d = (Graphics2D)g;
		g2d.translate(pf.getImageableX(), pf.getImageableY());		
		FontMetrics fontMetrics = g2d.getFontMetrics(); 

		int x = 20;
		int y = 20;
		int widthPage = (int)pf.getWidth();
		int heightPage = (int)pf.getHeight();
		int heightRow = fontMetrics.getHeight();
         
		bottomBorder = heightPage;
		pageCounter = 0;
                                           
		for(int i = 0; i < textToPrint.length(); i++){
			char letter = textToPrint.charAt(i);
	
			int widthLetter = fontMetrics.charWidth(letter);
			g.drawString("" + letter, x, y);
			x = x + widthLetter;

			if(x > widthPage || letter == '\n') {
				x = 20;
				y = y + heightRow;
				if(y > bottomBorder) {
					pageCounter++;

					bottomBorder = bottomBorder + heightPage;
				}
			}
		}
		viewer.frame.printAll(g2d);

		return PAGE_EXISTS;
	}

	public void showPrinterDialog() {
		textToPrint = viewer.getTextArea().getText();
		PrinterJob job = PrinterJob.getPrinterJob();
		job.setPrintable(this);
		boolean ok = job.printDialog();
		if (ok) {
			try {
				job.print();
			} catch (PrinterException ex) {

			}
		}
	}
}