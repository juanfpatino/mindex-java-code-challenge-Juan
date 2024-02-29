package com.mindex.challenge.data;

/**
 * Represents the compensation of an employee.
 * author: Juan Francisco Patino
 */
public class Compensation {

    private Employee employee;
    private int salary; // in dollars
    private String effectiveDate; // yyyy-MM-dd

    /**
     * Constructor
     */
    public Compensation() {
    }

    public Compensation(Employee employee, int salary, String effectiveDate) {
        this.employee = employee;
        this.salary = salary;
        this.effectiveDate = effectiveDate;
    }

    // Getters and Setters

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

}
