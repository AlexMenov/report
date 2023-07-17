import java.io.File;
import java.text.DecimalFormat;
import java.util.List;

public class YearlyReport extends Report {
    public YearlyReport() {
        super(ReadFiles.getYearReports());
        super.getReport();
    }
    @Override
    void processReport(List<String> report, File reportFile) {
        System.out.printf("\t\t\t\t\t%-20s\n", reportFile.getName().substring(1, 5));
        System.out.printf("\t\t%-17s%10s%n", "Месяц", "Прибыль, руб.");
        double mediumCount = (double) (report.size() - 1) / 2;
        double mediumIncome = 0.0;
        double mediumOutcome = 0.0;
        for (int i = 0; i < report.size(); i++) {
            if (i == 0) {
                continue;
            }
            String[] row = report.get(i).split(",");
            double income = Double.parseDouble(row[1]);
            mediumIncome += income;
            String month = MonthsNames.getMonthName(row[0]);
            i++;
            row = report.get(i).split(",");
            double outcome = Double.parseDouble(row[1]);
            mediumOutcome += outcome;
            System.out.printf("\t\t%-20s%10s%n", month, income - outcome);
        }
        System.out.printf("\t\t%-20s%10s%n", "Средний доход", new DecimalFormat("#0.00").format(mediumIncome /mediumCount));
        System.out.printf("\t\t%-20s%10s%n\n", "Средний расход", new DecimalFormat("#0.00").format(mediumOutcome / mediumCount));
    }
}
