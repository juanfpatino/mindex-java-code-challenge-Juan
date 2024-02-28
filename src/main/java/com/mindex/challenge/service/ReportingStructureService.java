package com.mindex.challenge.service;

import com.mindex.challenge.data.Employee;
import com.mindex.challenge.data.ReportingStructure;

// REST service for Reporting Stucture Class
public interface ReportingStructureService {
    ReportingStructure create(ReportingStructure reportingStructure);
    ReportingStructure read(String id);
    ReportingStructure update(String id, Employee employee);

}
