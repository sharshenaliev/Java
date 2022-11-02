import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
class Viewer {

    JTextField textField;

    Viewer() {
	Controller controller = new Controller(this);
        
        JButton buttonV = new JButton("x^2");
        buttonV.setBounds(10, 70, 75, 75);
        buttonV.addActionListener(controller);
        buttonV.setActionCommand("V");

        JButton buttonPM = new JButton("+/-");
        buttonPM.setBounds(95, 70, 75, 75);
        buttonPM.addActionListener(controller);
        buttonPM.setActionCommand("PM");

        JButton buttonPer = new JButton("%");
        buttonPer.setBounds(180, 70, 75, 75);
        buttonPer.addActionListener(controller);
        buttonPer.setActionCommand("Per");

        JButton buttonD = new JButton("/");
        buttonD.setBounds(265, 70, 75, 75);
        buttonD.addActionListener(controller);
        buttonD.setActionCommand("Divide");

        JButton button7 = new JButton("7");
        button7.setBounds(10, 155, 75, 75);
        button7.addActionListener(controller);
        button7.setActionCommand("Seven");

        JButton button8 = new JButton("8");
        button8.setBounds(95, 155, 75, 75);
        button8.addActionListener(controller);
        button8.setActionCommand("Eight");

        JButton button9 = new JButton("9");
        button9.setBounds(180, 155, 75, 75);
	button9.addActionListener(controller);
        button9.setActionCommand("Nine");

        JButton buttonM = new JButton("*");
        buttonM.setBounds(265, 155, 75, 75);
        buttonM.addActionListener(controller);
        buttonM.setActionCommand("Multiply");

        JButton button4 = new JButton("4");
        button4.setBounds(10, 240, 75, 75);
        button4.addActionListener(controller);
        button4.setActionCommand("Four");

        JButton button5 = new JButton("5");
        button5.setBounds(95, 240, 75, 75);
        button5.addActionListener(controller);
        button5.setActionCommand("Five");

        JButton button6 = new JButton("6");
        button6.setBounds(180, 240, 75, 75);
        button6.addActionListener(controller);
        button6.setActionCommand("Six");

        JButton buttonS = new JButton("-");
        buttonS.setBounds(265, 240, 75, 75);
        buttonS.addActionListener(controller);
        buttonS.setActionCommand("Subtract");

        JButton button1 = new JButton("1");
        button1.setBounds(10, 325, 75, 75);
        button1.addActionListener(controller);
        button1.setActionCommand("One");

        JButton button2 = new JButton("2");
        button2.setBounds(95, 325, 75, 75);
        button2.addActionListener(controller);
        button2.setActionCommand("Two");

        JButton button3 = new JButton("3");
        button3.setBounds(180, 325, 75, 75);
        button3.addActionListener(controller);
        button3.setActionCommand("Three");

	JButton buttonA = new JButton("+");
        buttonA.setBounds(265, 325, 75, 75);
        buttonA.addActionListener(controller);
        buttonA.setActionCommand("Addition");

	JButton buttonAC = new JButton("AC");
        buttonAC.setBounds(10, 410, 75, 75);
        buttonAC.addActionListener(controller);
        buttonAC.setActionCommand("AC");

	JButton button0 = new JButton("0");
        button0.setBounds(95, 410, 75, 75);
        button0.addActionListener(controller);
        button0.setActionCommand("Null");

        JButton buttonC = new JButton(",");
        buttonC.setBounds(180, 410, 75, 75);
        buttonC.addActionListener(controller);
        buttonC.setActionCommand("Comma");

        JButton buttonE = new JButton("=");
        buttonE.setBounds(265, 410, 75, 75);
        buttonE.addActionListener(controller);
        buttonE.setActionCommand("Equals");

        textField = new JTextField();
        textField.setBounds(10, 10, 330, 50);
        
        JFrame frame = new JFrame("Calculator");
        frame.setSize(365, 540);
        frame.setLayout(null);
        frame.add(textField);
        frame.add(buttonV);
        frame.add(buttonPM);
        frame.add(buttonPer);
        frame.add(buttonD);
        frame.add(button7);
        frame.add(button8);
        frame.add(button9);
        frame.add(buttonM);
        frame.add(button4);
        frame.add(button5);
        frame.add(button6);
        frame.add(buttonS);
        frame.add(button1);
        frame.add(button2);
        frame.add(button3);
        frame.add(buttonA);
	frame.add(buttonAC);
        frame.add(button0);
        frame.add(buttonC);
        frame.add(buttonE);
        frame.setVisible(true);
    }

    public void update(String text) {
        textField.setText(text);
    }

}