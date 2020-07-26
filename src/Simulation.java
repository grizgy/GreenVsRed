import java.util.Scanner;

public class Simulation {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextLine()) {
            scanner.useDelimiter("[^0-9]+");
            int width = scanner.nextInt();
            int height = scanner.nextInt();

            if (!((width < 0)|| (width > height) || (height >= 1000))) { // x <= y < 1000
                Grid playground = new Grid(height,width);

                char ch;
                int input;

                for (int i = 0; i < height; i++) {

                    Scanner sc = new Scanner(System.in);
                    String str = sc.next();

                    for (int j = 0; j < width; j++) {

                        //divide integer into digits
                        ch = str.charAt(j);
                        input = Character.getNumericValue(ch);

                        //initialize input as Red or Green object
                        if (input == 0) {
                            playground.putElements(new Red(), i, j);
                        } else if (input == 1) {
                            playground.putElements(new Green(), i, j);
                        }
                    }
                }

                //scanner sets coordinates to be calculated
                int positionX1 = scanner.nextInt();
                int positionY1 = scanner.nextInt();

                //if coordinates [X1,Y1] are available will print the result, otherwise no output
                if (!((positionX1 > width-1) || (positionY1 > height-1)
                        ||(positionX1 < 0) || (positionY1 < 0))) {
                    int numberOfGenerations = scanner.nextInt();
                    // prints the grid at generations 0
//                    System.out.println("Generation 0");
//                    System.out.println(playground);
                    System.out.println("# expected result: " + playground.indexToBeCalculated(numberOfGenerations,positionX1,positionY1));

                }
            }
        }
    }
}