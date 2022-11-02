import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;



public class LoadLevelFromFile {

    public LoadLevelFromFile() {

    }

    public static void main(String args[]) {
	LoadLevelFromFile loadLevelFromFile = new LoadLevelFromFile();
	loadLevelFromFile.loadNextLevel("level4.sok");
    }


    public int[][] loadNextLevel(String nameFile) {
	String anvar = readFromFile(nameFile);
	anvar = parseKim(anvar);
//	System.out.println(anvar);

	int row = getNumberOfRow(anvar);
//	System.out.println("row = " + row);

	int[][] twoD = new int[row][];
	int[] arrayOfElements = getArrayOfElements(anvar);

	for(int o = 0; o < arrayOfElements.length; o++) {
//		System.out.println("[" + o + "] = " + arrayOfElements[o]);
		twoD[o] = new int[arrayOfElements[o]];
	}

	for(int i = 0; i < twoD.length; i++) {
	   for(int j = 0; j < twoD[i].length; j++) {
//		System.out.print(twoD[i][j] + " ");
	   }
//	System.out.println();
	}

	int[][] desktop = twoD;

	fillArray(anvar, desktop);

//	System.out.println("---------------------");

	for(int i = 0; i < twoD.length; i++) {
	   for(int j = 0; j < twoD[i].length; j++) {
//		System.out.print(twoD[i][j] + " ");
	   }
//	System.out.println();
	}


	return desktop;
    }

    public String parseKim(String value) {
	String text = "";
	for(int i = 0; i < value.length(); i++) {
		char symbol = value.charAt(i);
		if('0' <= symbol && symbol <= '9') {
			text = text + symbol;
		}
		if(symbol == '\n') {
			text = text + "Q";
		}
	}
	return text;
    }

    private String readFromFile(String nameFile) {
		String text = "";
		File fileName = new File(nameFile);
		FileInputStream in = null;
			try {
				in = new FileInputStream(fileName);
				int c;
				while ((c = in.read()) != -1) {
					char symbol = (char) c;
					text = text + symbol;
				}
				in.close();
				} catch (IOException e) {
					System.out.println("Hello " + e);
				}
	return text;
    }

    private int getNumberOfRow(String value) {
	int row = 1;
	for(int a = 0; a < value.length(); a++) {
		char symbol = value.charAt(a);
		if(symbol == 'Q') {
			row =row + 1;
		}
	}
	return row;
    }

    private int[] getArrayOfElements(String value) {

	int colums = 1;
	for(int a = 0; a < value.length(); a++) {
		char symbol = value.charAt(a);
		if(symbol == 'Q') {
			colums = colums + 1;
		}
	}

	System.out.println("colums = " + colums);

	int[] array = new int[colums];
        colums = 0;
	int numberOfElements = 0;
	for(int a = 0; a < value.length(); a++) {
		char symbol = value.charAt(a);
		if(symbol != 'Q') {
			numberOfElements = numberOfElements + 1;
		} else {
			array[colums] = numberOfElements;
			colums++;
			numberOfElements = 0;

		}

		if(a == value.length() - 1) {
			array[colums] = numberOfElements;
		}

	}

	return array;
    }

    private void fillArray(String value, int[][] array) {
        int count = 0;
	for(int i = 0; i < array.length; i++) {
	   for(int j = 0; j < array[i].length; j++) {
		char symbol = value.charAt(count);
//		System.out.print(symbol);
		if(symbol != 'Q') {
			array[i][j] = Integer.parseInt("" + symbol);

		} 
		count++;

	   }
//	System.out.println();
	count = count + 1;
	}
    }



}