
public class StarExplosion {

    public static void main(String[] args) {
        int WIDTH = 15;
        int HEIGHT = 10;

        for (int j = 0; j < HEIGHT / 2; j++) { // row
            System.out.println();

            for (int l = 0; l < (WIDTH / 3) - j; l++) { // stars
                System.out.print("*");
            }
            for (int l = 0; l < (WIDTH / 3) + (2 * j); l++) { // spaces
                System.out.print(" ");
            }
            for (int l = 0; l < (WIDTH / 3) - j; l++) { // stars
                System.out.print("*");
            }
        }

        for (int j = HEIGHT / 2; j >= 0; j--) { // row
            for (int l = (WIDTH / 3) - j; l > 0; l--) { // stars
                System.out.print("*");
            }
            for (int l = (WIDTH / 3) + (2 * j); l > 0; l--) { // spaces
                System.out.print(" ");
            }
            for (int l = (WIDTH / 3) - j; l > 0; l--) { // stars
                System.out.print("*");
            }

            System.out.println();
        }
    }
}
