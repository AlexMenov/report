import java.io.File;
import java.util.List;

public class MonthlyReport extends Report {
    MonthlyReport() {
        super(ReadFiles.getMonthsReports());
        super.getReport();
    }

    @Override
    void processReport(List<String> report, File reportFile) {
        StringBuilder message = new StringBuilder();
        message.
                append("\t\t").
                append(reportFile.getName(), 1, 5).
                append(", ").
                append(getMonthName(reportFile.getName().substring(5, 7)));
        String maxIncomeName = "";
        String maxOutcomeName = "";
        double maxIncome = 0.0;
        double maxOutcome = 0.0;
        for (int i = 0; i < report.size(); i++) {
            if (i == 0) {
                continue;
            }
            String[] rows = report.get(i).split(",");
            boolean isExpense = Boolean.parseBoolean(rows[1].toLowerCase());
            double sum = Double.parseDouble(rows[2]) * Double.parseDouble(rows[3]);
            if (isExpense) {
                if (maxOutcome < sum) {
                    maxOutcome = sum;
                    maxOutcomeName = rows[0];
                }
            } else {
                if (maxIncome < sum) {
                    maxIncome = sum;
                    maxIncomeName = rows[0];
                }
            }
        }
        message.
                append(": прибыльный товар - ").
                append(maxIncomeName.toUpperCase()).
                append(" ").
                append(maxIncome).
                append(" руб., убыточный товар - ").
                append(maxOutcomeName.toUpperCase()).
                append(" ").
                append(maxOutcome).
                append(" руб.");
        System.out.println(message);
    }
}
