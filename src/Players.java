public interface Players {

    //This method represents the player as 0 or 1 according to it's color
    String toString();

    /*
    * This method calculates the neighbours of the element.
    * If true element's color will be changed, if false the
    * color of the element will stay the same
    */
    boolean toBeChanged(Players[][] arr,int i, int j);

    //This method changes the object at selected position
    Players change();

}
