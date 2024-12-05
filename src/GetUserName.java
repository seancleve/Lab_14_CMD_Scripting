import java.util.Scanner;

public class GetUserName {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String firstName = getNonZeroLenString(in, "Enter your first name");
        System.out.println("Your name is: " + firstName);
    }

    public static String getNonZeroLenString(Scanner pipe, String prompt) {
        String retVal = "";
        do {
            System.out.print(prompt + ": ");
            retVal = pipe.nextLine().trim();
            if (retVal.length() == 0) {
                System.out.println("Input cannot be empty.");
            }
        } while (retVal.length() == 0);
        return retVal;
    }
}
