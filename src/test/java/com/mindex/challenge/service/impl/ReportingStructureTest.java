package com.mindex.challenge.service.impl;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.data.ReportingStructure;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Test class for Reporting Structure Class
 * @Author Juan Francisco Patino
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReportingStructureTest {

    final Employee john = new Employee();
    final Employee paul = new Employee();
    final Employee ringo = new Employee();
    final Employee pete = new Employee();
    final Employee george = new Employee();


    @Test
    public void johnLennonTest(){

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

        ringo.setDirectReports(Arrays.asList(new Employee[]{pete, george}));
        john.setDirectReports(Arrays.asList(new Employee[]{paul, ringo}));

        ReportingStructure r = new ReportingStructure();
        r.setEmployee(john);

        assertEquals(4, r.getNumberOfReports());

    }

}
