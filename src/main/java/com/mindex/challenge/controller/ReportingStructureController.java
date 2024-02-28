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

    @PostMapping("/ReportingStructure")
    public ReportingStructure create(@RequestBody ReportingStructure rs) {
        LOG.debug("Received employee create request for [{}]", rs);

        return reportingStructureService.create(rs);
    }

    @GetMapping("/employee/{id}")
    public ReportingStructure read(@PathVariable String id) {
        LOG.debug("Received employee create request for id [{}]", id);

        return reportingStructureService.read(id);
    }

    @PutMapping("/employee/{id}")
    public ReportingStructure update(@PathVariable String id, @RequestBody ReportingStructure rs) {
        LOG.debug("Received employee create request for id [{}] and employee [{}]", id, rs);

        rs.setRsId(id);
        return reportingStructureService.update(rs);
    }
}
