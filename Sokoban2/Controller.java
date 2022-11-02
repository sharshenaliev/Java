import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

class Controller implements KeyListener{
	Model model;

	Controller(Viewer viewer) {
		model = new Model(viewer);
	}
	
	public void keyTyped(KeyEvent e) {

	}
	public void keyPressed(KeyEvent event) {
		int keyCode = event.getKeyCode();

		String direction = "";

		switch(keyCode) {
			case 39:
				direction = "Right";
			break;
		}

		switch(keyCode) {
			case 37:
				direction = "Left";
			break;
		}

		switch(keyCode) {
			case 40:
				direction = "Up";
			break;
		}

		switch(keyCode) {
			case 38:
				direction = "Down";
			break;
		}
		model.move(direction);
	}
	public void keyReleased(KeyEvent e) {

	}

}