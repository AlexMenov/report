import java.util.HashMap;
import java.util.Map;

public abstract class MonthsNames {
    protected static String getMonthName(String monthNumber) {
        return monthsNames.get(monthNumber);
    }

    private static final Map<String, String> monthsNames = new HashMap<>();

    static {
        monthsNames.put("01", "Январь");
        monthsNames.put("02", "Февраль");
        monthsNames.put("03", "Март");
        monthsNames.put("04", "Апрель");
        monthsNames.put("05", "Май");
        monthsNames.put("06", "Июнь");
        monthsNames.put("07", "Июль");
        monthsNames.put("08", "Август");
        monthsNames.put("09", "Сентябрь");
        monthsNames.put("10", "Октябрь");
        monthsNames.put("11", "Ноябрь");
        monthsNames.put("12", "Декабрь");
    }
}
