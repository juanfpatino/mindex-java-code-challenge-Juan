package com.mindex.challenge.service.impl;
import com.mindex.challenge.data.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Test class for Reporting Structure Class
 * @Author Juan Francisco Patino
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReportingStructureTest {

    final Employee john = new Employee();

    @Test
    public void johnLennonTest(){

        // todo assert Employee John Lennon has 4 reports
        john.setFirstName("John");
        john.setLastName("Lennon");



    }

}
