import java.awt.geom.Rectangle2D;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class Reset implements MouseListener{
    private Rectangle2D.Double rectangle;
    private String name;

    public Reset(int x, int y, int width, int height, String name) {
	rectangle = new Rectangle2D.Double(x, y, width, height);
	this.name = name;
    } 

    public Rectangle2D.Double getRectangle() {
	return rectangle;
    } 

    public String getName() {
	return name;
    }

    public void mouseClicked(MouseEvent e) {

    }
    public void mousePressed(MouseEvent event) {
	int x = event.getX();
	int y = event.getY();

	if(rectangle.contains(x, y)) {
		System.out.println("OK");

	}



    }
    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent event) {

    }
    public void mouseExited(MouseEvent event) {


    }

}