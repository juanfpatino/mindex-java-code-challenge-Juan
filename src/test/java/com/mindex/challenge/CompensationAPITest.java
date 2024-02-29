package com.mindex.challenge;

import com.mindex.challenge.dao.CompensationRepository;
import com.mindex.challenge.dao.EmployeeRepository;
import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.service.impl.EmployeeServiceImpl;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)

public class CompensationAPITest {
    @InjectMocks
    private EmployeeServiceImpl employeeService;
    @Mock
    private CompensationRepository compensationRepository;
    @Mock
    private EmployeeRepository employeeRepository;


    private static final Compensation compensation = new Compensation();
    private static final Employee employee = new Employee();


    @BeforeClass
    public static void setUp() {
        employee.setFirstName("Juan");
        compensation.setSalary(100000);
        compensation.setEffectiveDate("2024-28-02");
    }

    @Test
    public void CompensationTest() {
        //setup
        Employee temporaryTestEmployee = this.employeeService.create(employee);
        verify(this.employeeRepository).insert(temporaryTestEmployee);
        compensation.setEmployee(temporaryTestEmployee);

        //assertions
        try {
            this.employeeService.create(compensation);
            verify(this.compensationRepository).insert(compensation);
        } catch (Exception e) {
            fail(e.getMessage());
        }
        assertEquals(compensation, this.employeeService.getCompensation(temporaryTestEmployee.getEmployeeId()));
        assertEquals(compensation, this.compensationRepository.findByEmployee(temporaryTestEmployee));
    }

}
