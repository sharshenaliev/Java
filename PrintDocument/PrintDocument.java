import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PrinterJob;
import java.awt.print.Printable;
import java.awt.print.PageFormat;
import java.awt.print.PrinterException;
import java.io.File;
import java.awt.Image;
import java.io.IOException;
import javax.imageio.ImageIO;

public class PrintDocument implements Printable {
    private PrinterJob job;
    private Image imageDuke;
    PrintDocument() {
	System.out.println("Print any Document.");
	job = PrinterJob.getPrinterJob();
	job.setPrintable(this);
	
 	File fileNameDuke = new File("images/javalogo.jpg);
    	
	try {
	    imageDuke = imageIO.read(fileNameDuke);
	} catch(IOException e) {
	    System.out.println(e);
	}
	
	System.out.println("End action Docuument.");
    }

    public int print(Graphics g, PageFormat pf, int page) {
	if (page > 0) {
		return NO_SUCH_PAGE;
	}
	Graphics2D g2d = (Graphics2D)g;
	g2d.translate(pf.getImageableX(), pf.getImageableY());
	g2d.drawString("Almaz", 100, 100);
	g2d.drawImage(imageDuke, 100, 200, null)
	return PAGE_EXISTS; 
    }

    public void doAction() {
	System.out.println("Start to print Document.");
	boolean ok = job.printDialog();
	if (ok) {
	     try {
		  job.print();
	     } catch (PrinterException ex) {
	
	     }
	}
    }
    public static void main(String args[]) {
	PrintDocument ob = new PrintDocument();
	ob.doAction();

    }
}
