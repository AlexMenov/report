
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        while (true) {
            Commands.printCommands();
            try {
                var command = new Scanner(System.in).nextInt();
                switch (command) {
                    case 1: {
                        new MonthlyReport();
                        break;
                    }
                    case 2: {
                        new YearlyReport();
                        break;
                    }
                    case 3: {
                        System.out.println(3);
                        break;
                    }
                    case 4: {
                        System.out.println(4);
                        break;
                    }
                    case 5: {
                        System.out.println(5);
                        break;
                    }
                    case 6: {
                        System.out.println("Программа завершена");
                        System.exit(0);
                        break;
                    }
                    default: throw new IllegalArgumentException();
                }
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
                System.out.println("Неверная команда");
            }
        }
    }
}