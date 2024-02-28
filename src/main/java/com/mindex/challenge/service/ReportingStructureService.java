package com.mindex.challenge.service;

import com.mindex.challenge.data.ReportingStructure;

// REST service for Reporting Stucture Class
public interface ReportingStructureService {
    ReportingStructure create(ReportingStructure employee);
    ReportingStructure read(String id);

}
