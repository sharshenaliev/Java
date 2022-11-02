class Model {

    Viewer viewer;
    String temp;
    String leftValue;
    String rightValue;
    char action;

    Model(Viewer viewer) {
	this.viewer = viewer;
        temp = "";
        leftValue = "";
        rightValue = "";
        action = '!';
    }

    public void doAction(String value) {
	if(value.equals("One")) {
                temp = temp + "1";
        } else if(value.equals("Two")) {
                temp = temp + "2";
        } else if(value.equals("Three")) {
                temp = temp + "3";
        } else if(value.equals("Four")) {
                temp = temp + "4";
        } else if(value.equals("Five")) {
                temp = temp + "5";
        } else if(value.equals("Six")) {
                temp = temp + "6";
        } else if(value.equals("Seven")) {
                temp = temp + "7";
        } else if(value.equals("Eight")) {
                temp = temp + "8";
        } else if(value.equals("Nine")) {
                temp = temp + "9";
        } else if(value.equals("Null")) {
                temp = temp + "0";
	} else if(value.equals("Comma")) {
		temp = temp + ".";
	} else if(value.equals("Addition")) {
                action = '+';
                leftValue = temp;
                temp = "";
                return;	
        } else if(value.equals("Subtract")) {
                action = '-';
                leftValue = temp;
                temp = "";
                return;
        } else if(value.equals("Divide")) {
                action = '/';
                leftValue = temp;
                temp = "";
                return;
        } else if(value.equals("Multiply")) {
                action = '*';
                leftValue = temp;
                temp = "";
                return;
        } else if(value.equals("AC")) {
                rightValue = "";
                temp = "";
        } else if(value.equals("PM")) {
		if(temp.charAt(0) == '-') {
                	temp = temp.substring(1, temp.length());
                        } else {
				temp = "-" + temp;
                	}
	} else if(value.equals("Per")) {
                action = '/';
		leftValue = temp;
		temp = "100";
		return;
	} else if(value.equals("V")) {
		action = '*';
		leftValue = temp;
		temp = temp;
		return;
        } else if(value.equals("Equals")) {
                rightValue = temp;
		double numberLeft = Double.parseDouble(leftValue);
                double numberRight = Double.parseDouble(rightValue);
                double answer = 0.0;
                switch(action) {
                        case '+':
				answer = numberLeft + numberRight;
                        break;
                        case '-':
				answer = numberLeft - numberRight;
                        break;
                        case '/':
				answer = numberLeft / numberRight;
                        break;
                        case '*':
				answer = numberLeft * numberRight;
                        break;
                        }
                temp = "" + answer;
                char a = temp.charAt(temp.length() - 2);
		char b = temp.charAt(temp.length() - 1);
                if(a == '.' && b == '0') {
                       temp = temp.substring(0, temp.length() - 2);
                }      
        }   
	viewer.update(temp);
    }   
   
}