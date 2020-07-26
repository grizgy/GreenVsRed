public class Green implements Players {

    //represent Green objects as 1
    public String toString() {
        return "" + 1;
    }

    /**
     * This calculates the number of the green neighbours and decides if element's color needs to be changed to red
     * @param arr represents the Grid
     * @param y y coordinate of element to be calculated
     * @param x x coordinate of element to be calculated
     * @return returns true if this element has certain amount of neighbours and needs to change it's color
     */
    public boolean toBeChanged(Players[][] arr,int y, int x){

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

        return  ((count == 0) ||(count == 1) || (count == 4)|| (count == 5)|| (count == 7)|| (count == 8));
    }

    //this method turns Green elements into Red
    public Players change() {
        return new Red();
    }

}