import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public abstract class Report extends MonthsNames {
    private final File[] reports;
    public Report(File[] reports) {
        this.reports = reports;
    }
    public void getReport() {
        for (File reportFile : this.reports) {
            try (var file = new FileReader(reportFile); var reader = new BufferedReader(file)) {
                List<String> report = reader.lines().toList();
                this.processReport(report, reportFile);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    abstract void processReport (final List<String> report, final File reportFile);
}
