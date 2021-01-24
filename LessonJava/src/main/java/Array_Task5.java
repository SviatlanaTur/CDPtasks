import java.util.Scanner;

public class Array_Task5 {
    public static String months[] = new String [] {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Input a number: ");
        int x = in.nextInt();
        if (x < 1 || x > 12) {
            System.out.print("Wrong number!");
            return;
        }
        System.out.print(months[x-1]);
    }
}
