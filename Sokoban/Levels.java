public class Levels{

    private int level;

    Levels() {
	level = 1;
    }

    public int[][] currentLevel() {

	int[][] desktopLevel = null;

	switch(level) {
		case 1:
			desktopLevel = getFirstLevel();
		break;
		case 2:
			desktopLevel = getSecondLevel();
		break;

		case 3:
			desktopLevel = getThirdLevel();
		break;

		case 4:
			desktopLevel = getFoursLevel();
		break;

		default:
			desktopLevel = getFirstLevel();
			level = 1;
	}
	level++;
	return desktopLevel;
    }

    private int[][] getFirstLevel() {
	int[][] desktop = new int[][] 
		{
			{2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
			{2, 0, 0, 0, 0, 3, 4, 0, 0, 2},
			{2, 0, 0, 0, 0, 3, 4, 0, 0, 2},
			{2, 0, 0, 0, 0, 3, 4, 0, 0, 2},
			{2, 2, 2, 0, 0, 0, 0, 2, 2, 2},
			{2, 0, 0, 0, 0, 0, 0, 0, 0, 2},
			{2, 0, 0, 0, 0, 0, 0, 0, 0, 2},
			{2, 0, 0, 0, 2, 0, 0, 0, 0, 2},
			{2, 1, 0, 0, 2, 0, 0, 0, 0, 2},
			{2, 2, 2, 2, 2, 2, 2, 2, 2, 2}

		};

	return desktop;
    }

    private int[][] getSecondLevel() {
	int[][] desktop = new int[][] 
		{
			{2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
			{2, 1, 0, 0, 3, 4, 0, 0, 0, 2},
			{2, 0, 0, 0, 0, 0, 0, 0, 0, 2},
			{2, 0, 0, 0, 0, 0, 0, 0, 0, 2},
			{2, 2, 2, 0, 0, 0, 0, 2, 2, 2},
			{2, 0, 0, 0, 0, 0, 0, 0, 0, 2},
			{2, 0, 0, 0, 0, 0, 0, 0, 0, 2},
			{2, 0, 0, 0, 2, 0, 0, 0, 0, 2},
			{2, 0, 0, 0, 2, 0, 0, 0, 0, 2},
			{2, 2, 2, 2, 2, 2, 2, 2, 2, 2}

		};

	return desktop;
    }


    private int[][] getThirdLevel() {
	int[][] desktop = new int[][] 
		{
			{2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
			{2, 0, 0, 0, 0, 0, 0, 0, 0, 2},
			{2, 0, 0, 0, 0, 0, 0, 0, 0, 2},
			{2, 0, 0, 0, 0, 0, 0, 0, 0, 2},
			{2, 2, 2, 0, 0, 0, 0, 2, 2, 2},
			{2, 0, 0, 0, 0, 0, 0, 0, 0, 2},
			{2, 0, 0, 0, 0, 0, 0, 0, 0, 2},
			{2, 0, 0, 0, 2, 0, 0, 0, 0, 2},
			{2, 0, 0, 0, 2, 1, 0, 3, 4, 2},
			{2, 2, 2, 2, 2, 2, 2, 2, 2, 2}

		};

	return desktop;
    }

    private int[][] getFoursLevel() {
	int[][] desktop = new int[][] 
		{
			{2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
			{2, 0, 0, 0, 0, 0, 0, 0, 0, 2},
			{2, 0, 0, 0, 0, 0, 0, 0, 0, 2},
			{2, 0, 0, 0, 0, 0, 0, 0, 0, 2},
			{2, 2, 2, 0, 0, 0, 0, 2, 2, 2},
			{2, 0, 0, 0, 0, 0, 1, 3, 4, 2},
			{2, 0, 0, 0, 0, 0, 0, 0, 0, 2},
			{2, 0, 0, 0, 2, 0, 0, 0, 0, 2},
			{2, 0, 0, 0, 2, 0, 0, 0, 0, 2},
			{2, 2, 2, 2, 2, 2, 2, 2, 2, 2}

		};

	return desktop;
    }


}