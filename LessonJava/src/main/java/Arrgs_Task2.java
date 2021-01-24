
public class Arrgs_Task2 {
    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.print("Введите аргументы командной строки");
        }

        for (int x = args.length-1; x >= 0; x--) {
            System.out.print(args[x] + " ");
        }
    }
}
