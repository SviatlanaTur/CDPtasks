import java.util.Scanner;

public class Name_Task1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String NamePrint = in.nextLine();

        System.out.print("Hello " + NamePrint + "!");
    }
}

