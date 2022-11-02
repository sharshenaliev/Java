public class Model {
    private Viewer viewer;
    int[][] desktop;
    int indexI;
    int indexJ;
    boolean flag;
    int[][] arrayX;
    
    LoadLevelFromFile loadLevelFromFile;
    private Reset buttonReset;
    private Levels levels;

    Model(Viewer viewer) {
		this.viewer = viewer;
		buttonReset = new Reset(600, 50, 150, 75, "Reset");
	

		loadLevelFromFile = new LoadLevelFromFile();
		desktop = loadLevelFromFile.loadNextLevel("levels/level1.sok");
		initialization();
	}

	public void initialization() {
	   auca: for(int i = 0; i < desktop.length; i++) {
		for(int j = 0; j < desktop[i].length; j++) {
			if(desktop[i][j] == 1) {
				indexI = i;
				indexJ = j;
				break auca;
			}
		}
	}


	int column = 0;
	for(int i = 0; i < desktop.length; i++) {
		for(int j = 0; j < desktop[i].length; j++) {
			if(desktop[i][j] == 4) {
				column++;
			}
		}
	}
	arrayX = new int[2][column];
	int t = 0;
	for(int i = 0; i < desktop.length; i++) {
		for(int j = 0; j < desktop[i].length; j++) {
			if(desktop[i][j] == 4) {
				arrayX[0][t] = i;
				arrayX[1][t] = j;
				t++;
			}
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
	won();	

	}

	public void check() {
		for(int j = 0; j < arrayX[0].length; j++) {
			int a = arrayX[0][j];
			int b = arrayX[1][j];
			if(desktop[3][2] == 0)	{
				desktop[3][2] = 4;
			}
		}
	}


	private void moveRight() {
		if(desktop[indexI][indexJ + 1] == 3) { 
			if(desktop[indexI][indexJ + 2] == 0 || desktop[indexI][indexJ + 2] == 4) {        
				desktop[indexI][indexJ + 1] = 0;
				desktop[indexI][indexJ + 2] = 3;
			}
		}

		if(desktop[indexI][indexJ + 1] == 0 || desktop[indexI][indexJ + 1] == 4) {
	        	desktop[indexI][indexJ] = 0;
			indexJ = indexJ + 1;
			desktop[indexI][indexJ] = 1;
		}
	}
	private void moveLeft() {
		if(desktop[indexI][indexJ - 1] == 3) {
			if(desktop[indexI][indexJ - 2] == 0 || desktop[indexI][indexJ - 2] == 4) {
				desktop[indexI][indexJ - 1] = 0;
				desktop[indexI][indexJ - 2] = 3;
			}
		}

		if(desktop[indexI][indexJ - 1] == 0 || desktop[indexI][indexJ - 1] == 4) {
	        	desktop[indexI][indexJ] = 0;
			indexJ = indexJ - 1;
			desktop[indexI][indexJ] = 1;
		}
	}
	private void moveUp() {         
		if(desktop[indexI + 1][indexJ] == 3) {  
			if(desktop[indexI + 2][indexJ] == 0 || desktop[indexI + 2][indexJ] == 4) {
				desktop[indexI + 1][indexJ] = 0;
				desktop[indexI + 2][indexJ] = 3;
			}
		}

		if(desktop[indexI + 1][indexJ] == 0 || desktop[indexI + 1][indexJ] == 4) {
	        	desktop[indexI][indexJ] = 0;
			indexI = indexI + 1;
			desktop[indexI][indexJ] = 1;
		}
	}
	private void moveDown() {
		if(desktop[indexI - 1][indexJ] == 3) {
			if(desktop[indexI - 2][indexJ] == 0 || desktop[indexI - 2][indexJ] == 4) {
				desktop[indexI - 1][indexJ] = 0;
				desktop[indexI - 2][indexJ] = 3;
			}
		}

		if(desktop[indexI - 1][indexJ] == 0 || desktop[indexI - 1][indexJ] == 4) {
	        	desktop[indexI][indexJ] = 0;
			indexI = indexI - 1;
			desktop[indexI][indexJ] = 1;
		}
	}

	private void printDesktop() {
		for(int i = 0; i< desktop.length; i++) {
			for(int j = 0; j < desktop[i].length; j++){
				System.out.print(desktop[i][j] + " ");
		}
	System.out.println();
	}
	System.out.println();
	System.out.println();
	}				
	
	private void won() {

	boolean yesOrNo = true;
                                           
	for(int j = 0; j < arrayX[0].length; j++) {
		int a = arrayX[0][j];
		int b = arrayX[1][j];
		if(desktop[a][b] != 3) {
			yesOrNo = false;
			break;
		}
	}
	if(yesOrNo) {
		javax.swing.JOptionPane.showMessageDialog(viewer.getFrame(), "You won!");
		initialization();
		viewer.updateCanvas();
	}
    }
	public Reset getMyButton() {
		return buttonReset;
    }
}

