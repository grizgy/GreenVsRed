public class Grid {

    private int width;
    private int height;
    private Players[][] girdForElements;

    public Grid (int height, int width) {
        this.height = height;
        this.width = width;
        girdForElements = new Players[height][width];
    }

    /**
     * this method inserts elements in the grid
     * @param pl player to be inserted in the Grid, it can be both Red and Green
     * @param y  y coordinate of element to be inserted
     * @param x  x coordinate of element to be inserted
     */
    public void putElements(Players pl, int y, int x) {
        girdForElements [y][x] = pl;
    }

    //represents all entries in the in Grid
    public String toString() {

        String line = "";

        for (int i = 0; i <height; i++) {
            for (int j = 0; j < width; j++) {
                line+=girdForElements[i][j];
            }
            line+= "\n";
        }

        return line;
    }


    /**
     * calculates how many times element at chosen index [x,y] will be Green
     * @param generations number of generations the game will be played
     * @param x x y coordinate of element to be calculated
     * @param y y coordinate of element to be calculated
     * @return returns number of times chosen element was green
     */
    public int indexToBeCalculated(int generations, int x, int y) {

        int count = 0;
        int index = 0;

        //check if element at selected index is Green during Generation 0
        if (girdForElements[y][x] instanceof Green) {
            count++;
        }

        Players[][] temporary = new Players[height][width];

        //create copy of the grid
        for (int i = 0; i <height; i++) {
            for (int j = 0; j < width; j++) {
                temporary[i][j] = girdForElements[i][j];
            }
        }

        while (index < generations) {

            for (int i = 0; i < girdForElements.length; i++) {
                for (int j = 0; j < girdForElements [i].length; j ++) {

                    //check element in every index has to be changed
                    //if necesary change it
                    if (temporary[i][j].toBeChanged(girdForElements,i,j)) {

                        temporary [i][j] = temporary[i][j].change();
                    }

                }
            }

            //create copy of the temporary grid
            for (int i = 0; i <height; i++) {
                for (int j = 0; j < width; j++) {
                    girdForElements[i][j] = temporary[i][j];
                }
            }

            // prints the grid during the different generations
//            System.out.println("GENERATION " + (index + 1));
//            System.out.println(this);

            //checks if selected element is Green during the round
            //if true account will be increased
            if (temporary[y][x] instanceof Green) {
                count++;
            }

            index++;

        }

        return count;
    }

}
