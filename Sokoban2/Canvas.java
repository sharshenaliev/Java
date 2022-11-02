import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.awt.Font;
import java.awt.Graphics2D;

class Canvas extends JPanel{
    Model model;
    private Image imageGamer;
    private Image imageWall;
    private Image imageBox;
    private Image imageX;
    private Reset reset;
    Font font;
	
    Canvas(Model model) {
		this.model = model;
		setBackground(Color.white);
		reset = model.getMyButton();
		addMouseListener(reset);
	        setOpaque(true);

		File fileNameGamer = new File("Images/Gamer.png");
             	File fileNameWall = new File("Images/Wall.png");
		File fileNameBox = new File("Images/Box.png");
		File fileNameX = new File("Images/X.png");


		try {
			imageGamer = ImageIO.read(fileNameGamer);
			imageWall = ImageIO.read(fileNameWall);
			imageBox = ImageIO.read(fileNameBox);
			imageX = ImageIO.read(fileNameX);
			
		} catch(IOException e) {

		}
	}

	public void paint(Graphics g) {
		super.paint(g);
		
		if(model.flag){
			g.setFont(font);
			g.setColor(Color.red);
			g.drawString("Initialization ERROR", 50, 50);
		} else {
			drawDesktop(g);
		}
	}
	
	public void drawDesktop(Graphics g) {  
		int startX = 50;
		int startY = 50;
		int x = startX;
		int y = startY;
		int width = 50;
		int height = 50;
		int offset = 5;
		for(int i = 0; i < model.desktop.length; i++){
			for(int j = 0; j < model.desktop[i].length; j++){
				if(model.desktop[i][j] == 1){
					g.drawImage(imageGamer, x, y, null);
				} else if(model.desktop[i][j] == 2){    
					g.drawImage(imageWall, x, y, null);
				} else if(model.desktop[i][j] == 3){    
					g.drawImage(imageBox, x, y, null);
				} else if(model.desktop[i][j] == 4){    
					g.drawImage(imageX, x, y, null);
				} else {
//					g.setColor(Color.black);
//					g.drawRect(x, y, width, height);
				}
				x = x + width + offset;
			}
			x = startX;
			y = y + height + offset;
		}
		drawReset(g);
    }

    private void drawReset(Graphics g) {
	Graphics2D g2d = (Graphics2D)g;

	g2d.setColor(Color.red);
	g2d.fill(reset.getRectangle());
	g2d.setColor(Color.yellow);
	g2d.draw(reset.getRectangle()); 

	font = new Font("Impact", Font.BOLD, 25);
        g2d.setFont(font);
	g2d.setColor(Color.white);
	g2d.drawString(reset.getName(), (int)reset.getRectangle().x + 30, (int)reset.getRectangle().y + 50);

    }
}	

