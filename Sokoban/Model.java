public class Model {
    private Viewer viewer;
    int[][] desktop;
    int indexX;
    int indexY;
    int[][] goalArray;

    LoadLevelFromFile loadLevelFromFile;
//    private Levels levels;
    private Reset buttonReset;
    Model(Viewer viewer) {
	this.viewer = viewer;
	buttonReset = new Reset(600, 50, 150, 75, "Reset");
//	levels = new Levels();
//	desktop = levels.currentLevel();

	loadLevelFromFile = new LoadLevelFromFile();
	desktop = loadLevelFromFile.loadNextLevel("levels/level3.sok");
	initialization();
    }

    private void initialization() {
	auca: for(int i = 0; i < desktop.length; i++) {
		for(int j = 0; j < desktop[i].length; j++) {
			if(desktop[i][j] == 1) {
				indexX = i;
				indexY = j;
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
	goalArray = new int[2][column];
	int t = 0;
	for(int i = 0; i < desktop.length; i++) {
		for(int j = 0; j < desktop[i].length; j++) {
			if(desktop[i][j] == 4) {
				goalArray[0][t] = i;
				goalArray[1][t] = j;
				t++;
			}
		}
	}
    }
    public void move(String direction) {
	if(direction.equals("Left")) {
		moveLeft();
	} else if(direction.equals("Up")) {
		moveUp();
	} else if(direction.equals("Right")) {
		moveRight();
	} else if(direction.equals("Down")) {
		moveDown();
	}
	check();
	printDesktop();
	viewer.update();
	won();
    }

    private void check() {
	for(int j = 0; j < goalArray[0].length; j++) {
		int a = goalArray[0][j];
		int b = goalArray[1][j];
		if(desktop[a][b] == 0) {
			desktop[a][b] = 4;
		}
	}
    }

    private void moveLeft() {

	if(desktop[indexX][indexY - 1] == 3) {
		if(desktop[indexX][indexY - 2] == 0) {
			desktop[indexX][indexY - 1] = 0;
			desktop[indexX][indexY - 2] = 3;
		}
	}

	if(desktop[indexX][indexY - 1] == 0) {
		desktop[indexX][indexY] = 0;
		indexY = indexY - 1;
		desktop[indexX][indexY] = 1;
	}

    }

    private void moveUp() {
	if(desktop[indexX - 1][indexY] == 0) {
		desktop[indexX][indexY] = 0;
		indexX = indexX - 1;
		desktop[indexX][indexY] = 1;
	}

    }

    private void moveRight() {

	if(desktop[indexX][indexY + 1] == 3) {
		if(desktop[indexX][indexY + 2] == 0 || desktop[indexX][indexY + 2] == 4) {
			desktop[indexX][indexY + 1] = 0;
			desktop[indexX][indexY + 2] = 3;
		}
	}

	if(desktop[indexX][indexY + 1] == 0 || desktop[indexX][indexY + 1] == 4) {
		desktop[indexX][indexY] = 0;
		indexY = indexY + 1;
		desktop[indexX][indexY] = 1;
	}
    }

    private void moveDown() {

	if(desktop[indexX + 1][indexY] == 0) {
		desktop[indexX][indexY] = 0;
		indexX = indexX + 1;
		desktop[indexX][indexY] = 1;
	}


    }
    private void printDesktop() {
	for(int i = 0; i < desktop.length; i++) {
		for(int j = 0; j < desktop[i].length; j++) {
			System.out.print(desktop[i][j] + " ");
		}
	System.out.println();
	}
	System.out.println();
	System.out.println();
    }

    private void won() {

	boolean yesOrNo = true;

	for(int j = 0; j < goalArray[0].length; j++) {
		int a = goalArray[0][j];
		int b = goalArray[1][j];
		if(desktop[a][b] != 3) {
			yesOrNo = false;
			break;
		}
	}
	if(yesOrNo) {
		javax.swing.JOptionPane.showMessageDialog(viewer.getFrame(), "You are won!");
//		desktop = levels.currentLevel();
		initialization();
		viewer.update();
	}
    }

    public Reset getMyButton() {
	return buttonReset;
    }
}