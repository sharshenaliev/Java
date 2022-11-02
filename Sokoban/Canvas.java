import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.io.File;
import java.awt.Image;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.Graphics2D;
import java.awt.Font;

public class Canvas extends JPanel{
    private Model model;
    private Image imageGamer;
    private Image imageWall;
    private Image imageBox;
    private Image imageGoal;
    private Reset reset;

    Canvas(Model model) {
	this.model = model;
	reset = model.getMyButton();
	addMouseListener(reset);
	setBackground(Color.black);
	setOpaque(true);

	File fileNameGamer = new File("images/gamer.png");
	File fileNameWall = new File("images/wall.png");
	File fileNameBox = new File("images/box.png");
	File fileNameGoal = new File("images/goal.png");

	try {
	    imageGamer = ImageIO.read(fileNameGamer);
	    imageWall = ImageIO.read(fileNameWall);
	    imageBox = ImageIO.read(fileNameBox);
	    imageGoal = ImageIO.read(fileNameGoal);
	} catch(IOException e) {
	    System.out.println(e);
	}

    }
    public void paint(Graphics pen) {
	super.paint(pen);
	int start = 50;
	int x = start;
	int y = start;
	int width = 50;
	int height = 50;
	int offset = 2;
	for(int i = 0; i < model.desktop.length; i++) {
		for(int j = 0; j < model.desktop[i].length; j++) {

			if(model.desktop[i][j] == 1) {
				pen.drawImage(imageGamer, x, y, null);
			} else if(model.desktop[i][j] == 2) {

				pen.drawImage(imageWall, x, y, null);

			} else if(model.desktop[i][j] == 3) {

				pen.drawImage(imageBox, x, y, null);

			} else if(model.desktop[i][j] == 4) {

				pen.drawImage(imageGoal, x, y, null);



			} else {
//				pen.setColor(Color.white);
//				pen.drawRect(x, y, width, height);
			}
			x = x + width + offset;
		}
	x = start;
	y = y + height + offset;
	}

	drawReset(pen);
    }

    private void drawReset(Graphics pen) {
	Graphics2D g2d = (Graphics2D)pen;

	g2d.setColor(Color.red);
	g2d.fill(reset.getRectangle());
	g2d.setColor(Color.yellow);
	g2d.draw(reset.getRectangle());


	Font font = new Font("Arial", Font.BOLD, 25);
	g2d.setFont(font);
	g2d.setColor(Color.white);
	g2d.drawString(reset.getName(), (int)reset.getRectangle().x + 30, (int)reset.getRectangle().y + 50);



    }
}