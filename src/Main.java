import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while (true) {
            Commands.printCommands();
            try {
                var command = new Scanner(System.in).nextInt();
                switch (command) {
                    case 1 -> {
                        new MonthlyReport();
                    }
                    case 2 -> {
                        new YearlyReport();
                    }
                    case 3 -> {
                        System.out.println(3);
                    }
                    case 4 -> {
                        System.out.println(4);
                    }
                    case 5 -> {
                        System.out.println(5);
                    }
                    case 6 -> {
                        System.out.println("Программа завершена");
                        System.exit(0);
                    }
                    default -> throw new IllegalArgumentException();
                }
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
                System.out.println("Неверная команда");
            }
        }
    }
}