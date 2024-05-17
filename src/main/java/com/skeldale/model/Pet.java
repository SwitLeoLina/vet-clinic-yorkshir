package main.java.com.skeldale.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Pet {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("HH:mm dd/MM/yyyy");

    private String type;
    private String sex;
    public int age;
    private String name;
    private String ownerName;
    private final LocalDateTime registrationDate = LocalDateTime.now();

    public HealthState healthState;
    public Pet() {}
    public Pet(HealthState healthState) {
        this.healthState = healthState;
    }

    @Override
    public String toString() {
        return "type = " + type
                + ", sex = " + sex
                + ", age = " + age
                + ", name = " + name
                + ", owner name = " + ownerName
                + ", health state = " + healthState
                + ", registrationDate = " + registrationDate.format(FORMATTER)
                + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return Objects.equals(type, pet.type) && Objects.equals(sex, pet.sex) && Objects.equals(age, pet.age) && Objects.equals(name, pet.name) && Objects.equals(ownerName, pet.ownerName) && Objects.equals(healthState, pet.healthState);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, sex, age, name, ownerName, healthState);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = Integer.parseInt(age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public HealthState getHealthState() { return healthState;};
    public void setHealthState(HealthState healthState) { this.healthState = healthState;}

    public enum HealthState {
        Emergency(1),
        Serious(2),
        Moderate(3),
        Good(4),
        UNKNOWN(0);
        private final int valueHealth;
        HealthState(int valueHealth) {
            this.valueHealth = valueHealth;
        }

        public int getValueHealth() {
            return valueHealth;
        }
    }

}
