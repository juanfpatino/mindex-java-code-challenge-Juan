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

        numberOfReports = getNumberOfReports(this.employee);
        return numberOfReports;

    }

    public int getNumberOfReports(Employee employee) {

        if(employee == null || employee.getDirectReports() == null)
            return 0;

        int directReports = employee.getDirectReports().size(); // get this employee's
        int subReports = 0;
        for(Employee e : employee.getDirectReports()){
            subReports += getNumberOfReports(e);
        }

        return subReports + directReports;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


}
