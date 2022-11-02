import javax.swing.JFrame;
public class Viewer {
    private Canvas canvas;
    private JFrame frame;
    Viewer() {
		Controller controller = new Controller(this);
		canvas = new Canvas(controller.model);
		JFrame frame = new JFrame("Sokoban");
		frame.setSize(800, 800);
		frame.setLocation(100, 100);
		frame.add(canvas);
		frame.setVisible(true);
		frame.addKeyListener(controller);
	}

    public void updateCanvas() {
	canvas.repaint();
	}
    public JFrame getFrame() {
	return frame;
    }
}
