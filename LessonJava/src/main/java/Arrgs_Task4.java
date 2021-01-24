public class Arrgs_Task4 {
    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.print("Введите аргументы командной строки");
        }

        int sum = 0;
        int mult = 1;

        for (int x =0; x <=args.length-1; x++) {
            sum += Integer.parseInt(args[x]);
            mult *= Integer.parseInt(args[x]);
        }
        System.out.println(sum);
        System.out.println(mult);
    }
}


