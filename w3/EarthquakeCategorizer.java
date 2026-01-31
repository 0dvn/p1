import java.util.Scanner;

public class EarthquakeCategorizer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter earthquake magnitude: ");
        String magnitudeInput = scanner.nextLine();
        double magnitude = Double.parseDouble(magnitudeInput);

        switch (magnitude) {
            case double m when m < 2.0 -> {
                System.out.println("Category: Micro");
                System.out.println("Advise: Ignore");
            }
            case double m when 2.0 <= m && m < 4.0 -> {
                System.out.println("Category: Minor");
                System.out.println("Advise: Ignore");
            }
            case double m when 4.0 <= m && m < 5.0 -> {
                System.out.println("Category: Light");
                System.out.println("Advise: Stay alert");
            }
            case double m when 5.0 <= m && m < 6.0 -> {
                System.out.println("Category: Moderate");
                System.out.println("Advise: Prepare");
            }
            case double m when 6.0 <= m && m < 7.0 -> {
                System.out.println("Category: Strong");
                System.out.println("Advise: Take precautions");
            }
            case double m when 7.0 <= m && m < 8.0 -> {
                System.out.println("Category: Major");
                System.out.println("Advise: Seek shelter");
            }
            case double m when m >= 8.0 -> {
                System.out.println("Category: Great");
                System.out.println("Advise: Evacuate immediately");
            }
            default -> throw new AssertionError();
        }
    }
}