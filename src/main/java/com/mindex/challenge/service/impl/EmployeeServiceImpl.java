package com.mindex.challenge.service.impl;

import com.mindex.challenge.dao.CompensationRepository;
import com.mindex.challenge.dao.EmployeeRepository;
import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private static final Logger LOG = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private CompensationRepository compensationRepository;

    @Override
    public Employee create(Employee employee) {
        LOG.debug("Creating employee [{}]", employee);

        employee.setEmployeeId(UUID.randomUUID().toString());
        employeeRepository.insert(employee);

        return employee;
    }

    @Override
    public Employee read(String id) {
        LOG.debug("Reading employee with id [{}]", id);

        Employee employee = employeeRepository.findByEmployeeId(id);

        if (employee == null) {
            throw new RuntimeException("Invalid employeeId: " + id);
        }

        return employee;
    }

    @Override
    public Employee update(Employee employee) {
        LOG.debug("Updating employee [{}]", employee);

        return employeeRepository.save(employee);
    }

    /**
     * This method is used to get the reporting structure of an employee
     *
     * @param employeeId ID of the employee
     * @return ReportingStructure object
     */
    @Override
    public ReportingStructure getReportingStructure(String employeeId) {
        LOG.debug("Getting ReportingStructure with Employee [{}]", employeeId);

        ReportingStructure rs = new ReportingStructure();

        Employee employee = employeeRepository.findByEmployeeId(employeeId);
        if (employee == null) {
            throw new RuntimeException("Invalid employee: " + employeeId);
        }
        finishSettingUpDR(employee);

        rs.setEmployee(employee);
        rs.getNumberOfReports(); // update number of reports
        return rs;
    }

    /**
     * This method is used to create a compensation object
     *
     * @param compensation Compensation object
     * @return
     */
    @Override
    public Compensation create(Compensation compensation) {

        if (compensation.getEmployee() == null)
            LOG.warn("Creating compensation for null employee");
        else
            LOG.debug("Creating employee compensation for employee [{}]", compensation.getEmployee());

        compensationRepository.insert(compensation);

        return compensation;
    }

    /**
     * This method is used to get the compensation of an employee given its id
     *
     * @param id ID of the employee
     * @return Compensation object
     */
    @Override
    public Compensation getCompensation(String id) {
        LOG.debug("Getting compensation for employee with id [{}]", id);

        Employee employee = employeeRepository.findByEmployeeId(id);

        if (employee == null) {
            throw new RuntimeException("Invalid employeeId: " + id);
        }

        return compensationRepository.findByEmployee(employee);
    }

    /**
     * Given the database is complete, this method will finish setting up the direct reports of an employee given its id
     *
     * @param employee Employee
     */
    private void finishSettingUpDR(Employee employee) {

        if (employee.getDirectReports() == null)
            return;

        List<Employee> completedEmployees = new ArrayList<Employee>();

        for (Employee e : employee.getDirectReports()) {
            Employee subEmployee = employeeRepository.findByEmployeeId(e.getEmployeeId());
            if (subEmployee == null) {
                throw new RuntimeException("Invalid reporter to employee " + employee.getEmployeeId() + ": " + e.getEmployeeId());
            }
            completedEmployees.add(subEmployee);
            finishSettingUpDR(e);
        }

        employee.setDirectReports(completedEmployees);

    }

}
