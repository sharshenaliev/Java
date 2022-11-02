import javax.swing.JFrame;
public class Viewer {
    private Canvas canvas;
    private JFrame frame;
    Viewer() {
	Controller controller = new Controller(this);
	Model model = controller.getModel();
	canvas = new Canvas(model);
	frame = new JFrame("Sokoban AUCA");
	frame.setSize(850, 700);
	frame.setLocation(400, 0);
	frame.add("Center", canvas);
	frame.setVisible(true);
	frame.addKeyListener(controller);
    }
    public void update() {
	canvas.repaint();
    }

    public JFrame getFrame() {
	return frame;
    }

}
