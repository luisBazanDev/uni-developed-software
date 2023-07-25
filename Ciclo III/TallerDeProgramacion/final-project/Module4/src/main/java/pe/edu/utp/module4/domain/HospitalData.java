package pe.edu.utp.module4.domain;

/**
 * @author Luis Bazan
 */
public class HospitalData {
    private final int index;
    private final String name;
    private final int amounts;
    private final double percentage;

    public HospitalData(int index, String name, int amounts, double percentage) {
        this.index = index;
        this.name = name;
        this.amounts = amounts;
        this.percentage = percentage;
    }

    public int getIndex() {
        return index;
    }

    public String getName() {
        return name;
    }

    public int getAmounts() {
        return amounts;
    }

    public double getPercentage() {
        return percentage;
    }
}
