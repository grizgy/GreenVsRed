public class Red implements Players {

    //represent Red objects as 0
    public String toString() {
        return "" + 0;
    }

    /**
     * This calculates the number of the green neighbours and decides if element's color needs to be changed to green
     * @param arr represents the Grid
     * @param y y coordinate of element to be calculated
     * @param x x coordinate of element to be calculated
     * @return returns true if this element has certain amount of neighbours and needs to change it's color
     */
    public boolean toBeChanged(Players[][] arr,int y, int x) {

                int count = 0;

                if (x > 0) {
                    if (arr[y][x - 1] instanceof Green) {
                        count++;
                    }
                }

                if (x < arr[y].length - 1) {
                    if (arr[y][x + 1] instanceof Green) {
                        count++;
                    }
                }
                if (y > 0) {
                    if (arr[y - 1][x] instanceof Green) {
                        count++;
                    }
                }

                if (y > 0 && x > 0) {
                    if (arr[y - 1][x - 1] instanceof Green) {
                        count++;
                    }
                }
                if (y > 0 && x < arr[y].length - 1) {
                    if (arr[y - 1][x + 1] instanceof Green) {
                        count++;
                    }
                }
                if (x > 0 && y < arr.length - 1) {
                    if (arr[y+1][x-1] instanceof Green) {
                        count++;
                    }
                }
                if (x < arr[y].length - 1 && y < arr.length - 1) {
                    if (arr[y+1][x+1] instanceof Green) {
                        count++;
                    }
                }
                if (y < arr.length - 1) {
                    if (arr[y+1][x] instanceof Green) {
                        count++;
                    }
                }
         return ((count == 3) || (count == 6));
    }

    //this method turns Red elements into Green
    public Players change() {
        return new Green();
    }

}