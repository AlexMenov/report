import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public abstract class Report extends MonthsNames {
    public void getReport() {
        for (File reportFile : this.reports) {
            try (FileReader file = new FileReader(reportFile); BufferedReader reader = new BufferedReader(file)) {
                List<String> report = reader.lines().toList();
                processReport(report, reportFile);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    Report(File[] reports) {
        this.reports = reports;
    }

    private final File[] reports;

    abstract void processReport(final List<String> report, final File reportFile);
}
