package pe.edu.utp.module2.domain;

import pe.edu.utp.provider.enums.AgeType;

/**
 * @author Luis Bazan
 */
public class AgeData {
    private final int age;
    private final int amount;
    private final double porcentage;
    private final AgeType ageType;

    public AgeData(int age, int amount, double porcentage, AgeType ageType) {
        this.age = age;
        this.amount = amount;
        this.porcentage = porcentage;
        this.ageType = ageType;
    }

    public int getAge() {
        return age;
    }

    public int getAmount() {
        return amount;
    }

    public double getPorcentage() {
        return porcentage;
    }

    public AgeType getAgeType() {
        return ageType;
    }
}
