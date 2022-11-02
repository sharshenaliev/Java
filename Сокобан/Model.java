class Model {
	Viewer viewer;
	int[][] desktop;
	int indexI;
	int indexJ;
	boolean flag;
	int[][] arrayX;

	Model(Viewer viewer) {
		this.viewer = viewer;
		desktop = new int[][] {
					{2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
					{2, 1, 0, 0, 0, 0, 0, 0, 0, 2},
					{2, 0, 0, 0, 0, 0, 3, 0, 0, 2},					
					{2, 0, 4, 0, 2, 2, 0, 0, 0, 2},
					{2, 0, 0, 0, 2, 2, 0, 0, 0, 2},
					{2, 0, 3, 0, 0, 0, 0, 0, 0, 2},
					{2, 0, 0, 0, 0, 0, 0, 0, 0, 2},
					{2, 0, 0, 0, 0, 0, 0, 0, 0, 2},	
					{2, 0, 0, 0, 0, 0, 0, 0, 4, 2},
					{2, 2, 2, 2, 2, 2, 2, 2, 2, 2}
		};         
		
		initialization();
	}

	public void initialization() {
	        int countOne = 0;
		int countThree = 0;
		int countFour = 0;
		for(int i = 0; i< desktop.length; i++){
			for(int j = 0; j < desktop[i].length; j++){
				if(desktop[i][j] == 1){
					indexI = i;
					indexJ = j;
					countOne++;
				}
				if(desktop[i][j] == 3){
					countThree++;
				}
				if(desktop[i][j] == 4){
					countFour++;
				}
			}
		}
		if((countThree == 0 || countFour == 0) || (countThree != countFour)){
			flag = true;
		}
		if(countOne != 1){
			flag = true;
		} 
		
		arrayX = new int[2][countFour];

		for(int i = 0; i < arrayX.length; i++){
			for(int j = 0; j < arrayX[i].length; j++){
				
			}
		}
	}


	public void move(String direction) {
		if(direction.equals("Right")) {
			moveRight();
		}
		else if(direction.equals("Left")) {
			moveLeft();
		}
		else if(direction.equals("Up")) {
			moveUp();
		}
		else if(direction.equals("Down")) {
			moveDown();
		}
	check();
        printDesktop();          
	viewer.updateCanvas();	

	}

	private void moveRight() {
		if(desktop[indexI][indexJ + 1] == 3){
			if(desktop[indexI][indexJ + 2] == 0 || desktop[indexI][indexJ + 2] == 4){        
				desktop[indexI][indexJ + 1] = 0;
				desktop[indexI][indexJ + 2] = 3;
			}
		}

		if(desktop[indexI][indexJ + 1] == 0 || desktop[indexI][indexJ + 1] == 4){
	        	desktop[indexI][indexJ] = 0;
			indexJ = indexJ + 1;
			desktop[indexI][indexJ] = 1;
		}
	}
	private void moveLeft() {
		if(desktop[indexI][indexJ - 1] == 3){
			if(desktop[indexI][indexJ - 2] == 0 || desktop[indexI][indexJ - 2] == 4){
				desktop[indexI][indexJ - 1] = 0;
				desktop[indexI][indexJ - 2] = 3;
			}
		}

		if(desktop[indexI][indexJ - 1] == 0 || desktop[indexI][indexJ - 1] == 4){
	        	desktop[indexI][indexJ] = 0;
			indexJ = indexJ - 1;
			desktop[indexI][indexJ] = 1;
		}
	}
	private void moveUp() {         
		if(desktop[indexI + 1][indexJ] == 3){
			if(desktop[indexI + 2][indexJ] == 0 || desktop[indexI + 2][indexJ] == 4){
				desktop[indexI + 1][indexJ] = 0;
				desktop[indexI + 2][indexJ] = 3;
			}
		}

		if(desktop[indexI + 1][indexJ] == 0 || desktop[indexI + 1][indexJ] == 4){
	        	desktop[indexI][indexJ] = 0;
			indexI = indexI + 1;
			desktop[indexI][indexJ] = 1;
		}
	}
	private void moveDown() {
		if(desktop[indexI - 1][indexJ] == 3){
			if(desktop[indexI - 2][indexJ] == 0 || desktop[indexI - 2][indexJ] == 4){
				desktop[indexI - 1][indexJ] = 0;
				desktop[indexI - 2][indexJ] = 3;
			}
		}

		if(desktop[indexI - 1][indexJ] == 0 || desktop[indexI - 1][indexJ] == 4){
	        	desktop[indexI][indexJ] = 0;
			indexI = indexI - 1;
			desktop[indexI][indexJ] = 1;
		}
	}

	private void printDesktop() {
		for(int i = 0; i< desktop.length; i++){
			for(int j = 0; j < desktop[i].length; j++){
			}				
		}
	}
	
	public void check(){
		if(desktop[3][2] == 0){
			desktop[3][2] = 4;
		}
	}
}
