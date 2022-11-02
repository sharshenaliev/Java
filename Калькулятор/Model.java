class Model{
 
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
	action = '@';
  }

   public void doAction(String value) {
        temp =  viewer.getStr();
       	if(value.equals("0")) {
                temp = temp + "0";
	} else if(value.equals("1")) {
                temp = temp + "1";                
	} else if(value.equals("2")) {
                temp = temp + "2";                
	} else if(value.equals("3")) {
                temp = temp + "3";                
	} else if(value.equals("4")) {
                temp = temp + "4";                
	} else if(value.equals("5")) {
                temp = temp + "5";                
	} else if(value.equals("6")) {
                temp = temp + "6";                
	} else if(value.equals("7")) {
                temp = temp + "7";                
	} else if(value.equals("8")) {
                temp = temp + "8";                
	} else if(value.equals("9")) {
                temp = temp + "9";                
	} else if(value.equals(".")) {
                temp = temp + ".";                



	} else if(value.equals("C")) {
                temp = "";                
		viewer.update(temp);  
	} else if(value.equals("+")) {
                leftValue = temp;
		temp = "";
		action = '+';
		viewer.update(temp);  
		return;         

	} else if(value.equals("-")) {
                leftValue = temp;
		temp = "";
		action = '-';
		viewer.update(temp);  
                return;

	} else if(value.equals("/")) {
                leftValue = temp;
		temp = "";
		action = '/';
		viewer.update(temp);  
                return;

	} else if(value.equals("*")) {
                leftValue = temp;
		temp = "";
		action = '*';
		viewer.update(temp);  
                return;


	} else if(value.equals("=")) {
                rightValue = temp;

		double leftNumber  = Double.parseDouble(leftValue);
		double rightNumber = Double.parseDouble(rightValue);
	
		double answer = 0;

		switch(action) {
			case '+':

				answer = leftNumber + rightNumber;
				
			break;

			case '-':

				answer = leftNumber - rightNumber;

			break;

			case '/':

				answer = leftNumber / rightNumber;

			break;


			case '*':

				answer = leftNumber * rightNumber;

			break;


		}

		
            	temp = "" + answer;
		
	 }
        
	viewer.update(temp);  

    }
}