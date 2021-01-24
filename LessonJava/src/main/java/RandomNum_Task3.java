import java.util.Scanner;

public class RandomNum_Task3 {

        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            System.out.print("Enter number: ");
            int n = in.nextInt();

            // Output random numbers into different lines
            for (int i=1; i<=n; i++) {
                System.out.print((int)(Math.random()*100) + "\n");
            }
            // Output random numbers into one line
            for (int i=1; i<=n; i++) {
                System.out.print((int)(Math.random()*100) + " ");
            }
    }
}
