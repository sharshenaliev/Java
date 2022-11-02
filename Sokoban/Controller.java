import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
public class Controller implements KeyListener{
    private Model model;
    Controller(Viewer viewer) {
	model = new Model(viewer);
    }
    public Model getModel() {
	return model;
    }
    public void keyTyped(KeyEvent event) {
    }
    public void keyPressed(KeyEvent event) {
	int keyCode = event.getKeyCode();
	String direction = "";
	switch(keyCode) {
		case 37:
			direction = "Left";
		break;
		case 38:
			direction = "Up";
		break;
		case 39:
			direction = "Right";
		break;
		case 40:
			direction = "Down";
		break;
		default:
			return;
	}
	model.move(direction);
    }
    public void keyReleased(KeyEvent event) {
    }
}