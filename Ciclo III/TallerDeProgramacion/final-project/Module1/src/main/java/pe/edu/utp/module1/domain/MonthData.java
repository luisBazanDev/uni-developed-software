package pe.edu.utp.module1.domain;

/**
 * @author Luis Bazan
 */
public class MonthData {
    private final String moth;
    private final int amount;
    private final double percentage;

    public MonthData(String moth, int amount, double percentage) {
        this.moth = moth;
        this.amount = amount;
        this.percentage = percentage;
    }

    public String getMoth() {
        return moth;
    }

    public int getAmount() {
        return amount;
    }

    public double getPercentage() {
        return percentage;
    }
}
