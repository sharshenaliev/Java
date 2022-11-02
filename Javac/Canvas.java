import java.awt.Image;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.awt.Font;

class Canvas extends JPanel{
	Model model;
	private Image imageGamer;
	private Image imageWall;
	private Image imageBox;
	private Image imageX;
	Color wallColor;
	Color gamerColor;
	Font font;

	Canvas(Model model) {
		this.model = model;
		setBackground(Color.white);

		font = new Font("Impact", Font.BOLD, 25);

//		wallColor = new Color(105, 105, 105);
//		gamerColor = new Color(0, 128, 128);
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
//					g.setColor(Color.black);
//					g.drawRect(x, y, width, height);
//					g.setColor(gamerColor);
//					g.fillRect(x, y, width, height);
					g.drawImage(imageGamer, x, y, null);
				} else if(model.desktop[i][j] == 2){    
//					g.setColor(Color.black);
//					g.drawRect(x, y, width, height);
//					g.setColor(wallColor);
//					g.fillRect(x, y, width, height);
					g.drawImage(imageWall, x, y, null);
				} else if(model.desktop[i][j] == 3){    
//					g.setColor(Color.black);
//					g.drawRect(x, y, width, height);
//					g.setColor(wallColor);
//					g.fillRect(x, y, width, height);
					g.drawImage(imageBox, x, y, null);
				} else if(model.desktop[i][j] == 4){    
//					g.setColor(Color.black);
//					g.drawRect(x, y, width, height);
//					g.setColor(wallColor);
//					g.fillRect(x, y, width, height);
					g.drawImage(imageX, x, y, null);
				} else {
					g.setColor(Color.black);
					g.drawRect(x, y, width, height);
				}
				x = x + width + offset;
			}
			x = startX;
			y = y + height + offset;
		}
	}
}
//		g.setColor(Color.orange);
//		g.fillRect(model.x, model.y, model.width, model.height);
//		g.drawImage(imageGamer, model.x, model.y, imageGamer.getWidth(this), imageGamer.getHeight(this), null);
