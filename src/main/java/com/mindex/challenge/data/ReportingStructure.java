package com.mindex.challenge.data;

/**
 * Represents the reporting structure of an employee.
 * author: Juan Francisco Patino
 */
public class ReportingStructure {

    private Employee employee;
    private Integer numberOfReports;
    private String rsId;

    /**
     * Constructor
     */
    public ReportingStructure() {
    }

    // Getters and Setters

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    // DFS to count the number of reports
    public int getNumberOfReports() {
        if(numberOfReports == null){
            return getNumberOfReports(this.employee);
        }
        return numberOfReports;
    }

    public int getNumberOfReports(Employee employee) {
        return numberOfReports;
    }

    public String getRsId() {
        return rsId;
    }

    public void setRsId(String rsId) {
        this.rsId = rsId;
    }


}
