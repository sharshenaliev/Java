import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PrinterJob;
import java.awt.print.Printable;
import java.awt.print.PageFormat;
import java.awt.print.PrinterException;
import java.io.File;
import java.io.FileInputStream;
import java.awt.Color;
import java.awt.FontMetrics;
import java.io.IOException;

public class PrintDocument implements Printable {
    private PrinterJob job;
    private String textForPrint;
    private int xStart;
    private int yStart;
    private int xEnd;
    private int yEnd;
    PrintDocument(int xStart, int yStart, int xEnd, int yEnd) {
	System.out.println("Print any Document.");
	this.xStart = xStart;
	this.yStart = yStart;
	this.xEnd = xEnd;
	this.yEnd = yEnd;

	job = PrinterJob.getPrinterJob();
        job.setPrintable(this);
	File file = new File("Viewer.java");
	textForPrint = readFromFile(file);
	System.out.println("End action Document.");
    }
    public int print(Graphics g, PageFormat pf, int page) {
	if (page > 1) {
		return NO_SUCH_PAGE;
	}
        Graphics2D g2d = (Graphics2D)g;
        g2d.translate(pf.getImageableX(), pf.getImageableY());

	int x = (int)(pf.getImageableX()) + xStart;
	int y = (int)(pf.getImageableY()) + yStart;
	int widthPage = (int)pf.getImageableWidth() - xStart - xEnd;
	int heightPage = (int)pf.getImageableHeight() - yEnd;
	FontMetrics metrics = g.getFontMetrics();
        int lineHeight = metrics.getHeight();
	int countSymbol = 0;

	String newStr = "";
        for(int i = 0; i < textForPrint.length(); i++) {
		char symbol = textForPrint.charAt(i);
		int widthAnySymbol = metrics.charWidth(symbol); 

		if(i == 0) {
			g2d.drawString("Start Page", x, y - 10);

		}


		if(symbol == '\n') {
			y = y + lineHeight;
			g2d.drawString(newStr, x, y);
			newStr = "";
			countSymbol = 0;
		} else if(widthPage < countSymbol){
			y = y + lineHeight;
			g2d.drawString(newStr, x, y);
			i--;
			newStr = "";
			countSymbol = 0;
		} else {
			countSymbol = countSymbol + widthAnySymbol;
			newStr = newStr + symbol;
		} 

		if(y > heightPage) {
			g2d.drawString("End Page", x, y + 10);
			break;	  		
		}
	}
	
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
	PrintDocument ob = new PrintDocument(100, 80, 50, 20);
	ob.doAction();
    }

    private String readFromFile(File fileName) {
	String text = "";
	FileInputStream in = null;
	try {
		in = new FileInputStream(fileName);
		int c;
		while ((c = in.read()) != -1) {
		char symbol = (char) c;
		text = text + symbol;
		}
		in.close();
	} catch (IOException e) {
		System.out.println("Hello " + e);
	}

	return text;
	}

}