package com.mindex.challenge.controller;

import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.ReportingStructureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ReportingStructureController {

    private static final Logger LOG = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private ReportingStructureService reportingStructureService;

    @PostMapping("/ReportingStructure/{id}")
    public ReportingStructure create(@RequestBody ReportingStructure rs) {
        LOG.debug("Received employee create request for [{}]", rs);

        return reportingStructureService.create(rs);
    }

    @GetMapping("/ReportingStructure/{id}")
    public ReportingStructure read(@PathVariable String id) {
        LOG.debug("Received employee read request for id [{}]", id);

        return reportingStructureService.read(id);
    }

}
