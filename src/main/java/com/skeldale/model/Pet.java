package main.java.com.skeldale.model;

import java.util.Objects;

public class Pet {
    public static final String Good = "Good";
    public static final String Moderate = "Moderate";
    public static final String Serious = "Serious";
    public static final String Emergency = "Emergency";

    private String type;
    private String sex;
    public int age;
    private String name;
    private String ownerName;

    public String healthState;
    public Pet() {}
    public Pet(String healthState) {
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

    public String getHealthState() { return healthState;};
    public void setHealthState(String healthState) { this.healthState = healthState;}

}
