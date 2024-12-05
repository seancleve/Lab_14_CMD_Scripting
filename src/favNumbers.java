import java.util.Scanner;

public class favNumbers {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int favInt = getInt(in, "Enter your favorite integer");
        double favDouble = getDouble(in, "Enter your favorite double");

        System.out.println("Favorite integer: " + favInt);
        System.out.println("Favorite double: " + favDouble);
    }

    public static int getInt(Scanner pipe, String prompt) {
        int retVal = 0;
        boolean done = false;
        do {
            System.out.print(prompt + ": ");
            if (pipe.hasNextInt()) {
                retVal = pipe.nextInt();
                pipe.nextLine();
                done = true;
            } else {
                System.out.println("Invalid input. Enter a valid integer.");
                pipe.nextLine();
            }
        } while (!done);
        return retVal;
    }

    public static double getDouble(Scanner pipe, String prompt) {
        double retVal = 0;
        boolean done = false;
        do {
            System.out.print(prompt + ": ");
            if (pipe.hasNextDouble()) {
                retVal = pipe.nextDouble();
                pipe.nextLine();
                done = true;
            } else {
                System.out.println("Invalid input. Enter a valid double.");
                pipe.nextLine();
            }
        } while (!done);
        return retVal;
    }
}
