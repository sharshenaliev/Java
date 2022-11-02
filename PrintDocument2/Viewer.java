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
import java.awt.Color;

public cinterJob job;
    private Image imageDuke;
    PrintDocument() {
	System.out.println("Print any Document.");
	job = PrinterJob.getPrinterJob();
        job.setPrintable(this);

	File fileNameDuke = new File("images/imageDuke.gif");

	try {
	    imageDuke = ImageIO.read(fileNameDuke);
	} catch(IOException e) {
	    System.out.println(e);
	}

	System.out.println("End action Document.");
    }
    public int print(Graphics g, PageFormat pf, int page) {
	if (page > 0) {
		return NO_SUCH_PAGE;
	}
        Graphics2D g2d = (Graphics2D)g;
        g2d.translate(pf.getImageableX(), pf.getImageableY());

        g2d.drawString("Кошоев Эркин Бекболотович", 100, 100);
	g2d.drawImage(imageDuke, 100, 200, 150, 150, null);
	g2d.drawLine(0, 0, 100, 100);
	g2d.setColor(Color.red);
	g2d.drawRect(110, 110, 200, 200);
	g2d.setColor(Color.green);
	g2d.drawOval(110, 110, 200, 200);


	return PAGE_EXISTS;
    }
    public void doAction() {
	System.out.println("Start to print Document.");
	boolean ok = job.printDialog();
	if (ok) {
             try {
                  job.print();
             } catch (PrinterException ex) {
              /* The job did not successfully complete */
             }
         }
    }
    public static void main(String args[]) {
	PrintDocument ob = new PrintDocument();
	ob.doAction();

    }
}