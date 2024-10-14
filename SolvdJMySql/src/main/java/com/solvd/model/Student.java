package com.solvd.model;

public class Student {

    private String firstName;
    private int carId;

    public Student(String firstName, int carId) {
        this.firstName = firstName;
        this.carId = carId;
    }

    public Student() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", carId=" + carId +
                '}';
    }
}
