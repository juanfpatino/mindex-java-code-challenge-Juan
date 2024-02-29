package com.mindex.challenge;

import com.mindex.challenge.data.Employee;
import com.mindex.challenge.data.ReportingStructure;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertEquals;

/**
 * Test class for Reporting Structure Class
 *
 * @Author Juan Francisco Patino
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReportingStructureTest {

    static final Employee john = new Employee();
    static final Employee paul = new Employee();
    static final Employee ringo = new Employee();
    static final Employee pete = new Employee();
    static final Employee george = new Employee();
    static final ReportingStructure r = new ReportingStructure();
    static final ReportingStructure r1 = new ReportingStructure();
    static final ReportingStructure r2 = new ReportingStructure();
    static final ReportingStructure r3 = new ReportingStructure();


    @BeforeClass
    public static void setUp() {
        john.setFirstName("John");
        john.setLastName("Lennon");
        paul.setFirstName("Paul");
        paul.setLastName("McCartney");
        ringo.setFirstName("Ringo");
        ringo.setLastName("Starr");
        pete.setFirstName("Pete");
        pete.setLastName("Best");
        george.setFirstName("George");
        george.setLastName("Harrison");
        ringo.setDirectReports(Arrays.asList(pete, george));
        john.setDirectReports(Arrays.asList(paul, ringo));
        r.setEmployee(john);
    }

    /**
     * Test to check if the number of reports is correct in the README.md example
     */
    @Test
    public void johnLennonTest() {
        assertEquals(4, r.getNumberOfReports());
    }

    /**
     * Test to check if the number of reports is correct in the README.md example
     * after adding two more reports to John Lennon
     */
    @Test
    public void addTwoToJohnLennon() {
        george.setDirectReports(Collections.singletonList(new Employee()));
        paul.setDirectReports(Collections.singletonList(new Employee()));
        assertEquals(6, r.getNumberOfReports());
    }

    /**
     * Test a ReportingStructure with one employee with no reports
     */
    @Test
    public void testZero() {
        Employee e = new Employee();
        r1.setEmployee(e);
        assertEquals(0, r1.getNumberOfReports());
    }

    /**
     * Test a ReportingStructure with one employee with no reports
     */
    @Test
    public void testOne() {
        Employee e = new Employee();
        e.setDirectReports(Collections.singletonList(new Employee()));
        r2.setEmployee(e);
        assertEquals(1, r2.getNumberOfReports());
    }

    /**
     * Test a ReportingStructure with no employee
     */
    @Test
    public void testEmpty() {
        assertEquals(0, r3.getNumberOfReports());
    }

}
