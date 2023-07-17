import java.io.File;
import java.io.FilenameFilter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReadFiles {
    private static File[] monthsReports;
    private static File[] yearReports;
    private final static File PATH = new File("src\\files");
    static void readFiles() {
        var logger = Logger.getLogger("Работа с файлами");
        try {
            monthsReports = PATH.listFiles(new FileFilter("\\bm\\d{6}.(txt|csv)"));
            yearReports = PATH.listFiles(new FileFilter("\\by\\d{4}.(txt|csv)"));
            assert monthsReports != null;
            if (monthsReports.length == 0) {
                throw new FindMonthsReportException();
            }
            assert yearReports != null;
            if (yearReports.length == 0) {
                throw new FindYearReportException();
            }
        } catch (SecurityException e) {
            logger.log(Level.INFO, "Ошибка открытия файлов (отсутствует доступ)");
        } catch (FindMonthsReportException | FindYearReportException e) {
            logger.log(Level.WARNING, e.getMessage() + " отчеты отсутствуют");
        }
    }

    static class FileFilter implements FilenameFilter {
        private final String rex;

        FileFilter(String rex) {
            this.rex = rex;
        }

        @Override
        public boolean accept(File dir, String name) {
            return name.matches(rex);
        }
    }

    static class FindMonthsReportException extends Exception {
        FindMonthsReportException() {
            super("Месячные");
        }
    }

    static class FindYearReportException extends Exception {
        FindYearReportException() {
            super("Годовые");
        }
    }

    public static File[] getMonthsReports() {
        ReadFiles.readFiles();
        return monthsReports;
    }

    public static File[] getYearReports() {
        ReadFiles.readFiles();
        return yearReports;
    }
}
