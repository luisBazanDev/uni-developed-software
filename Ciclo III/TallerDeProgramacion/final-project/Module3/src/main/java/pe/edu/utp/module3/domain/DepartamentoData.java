package pe.edu.utp.module3.domain;

/**
 * @author Luis Bazan
 */
public class DepartamentoData {
    private final String name;
    private final int amount;
    private final double porcentage;

    public DepartamentoData(String name, int amount, double porcentage) {
        this.name = name;
        this.amount = amount;
        this.porcentage = porcentage;
    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }

    public double getPorcentage() {
        return porcentage;
    }
}
