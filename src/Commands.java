public class Commands {
    private final static String commands = """
            \n
            \t\t1. Считать месячные отчеты
            \t\t2. Считать годовые отчеты
            \t\t3. Сверить отчеты
            \t\t4. Вывести информацию о всех месячных отчетах
            \t\t5. Вывести информацию о годовом отчете
            \t\t6. Выход из программы
            """;
    static void printCommands () {
        System.out.println(commands);
    }
}
