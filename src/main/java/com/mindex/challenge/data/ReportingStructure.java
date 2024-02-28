package com.mindex.challenge.data;

/**
 * Represents the reporting structure of an employee.
 * author: Juan Francisco Patino
 */
public class ReportingStructure {

    private Employee employee;
    private Integer numberOfReports;
    private String id;

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
            numberOfReports = getNumberOfReports(this.employee, 0);
        }
        return numberOfReports;
    }

    public int getNumberOfReports(Employee employee, int reports) {

        if(employee.getDirectReports().isEmpty()){ // base case - no reports left
            return reports;
        }
        //otherwise
        for(Employee e : employee.getDirectReports()){
            reports += getNumberOfReports(e, reports);
        }

        return reports;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


}
