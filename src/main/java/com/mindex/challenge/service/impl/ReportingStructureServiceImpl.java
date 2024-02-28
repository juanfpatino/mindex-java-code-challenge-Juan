package com.mindex.challenge.service.impl;

import com.mindex.challenge.dao.ReportingStructureRepository;
import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.ReportingStructureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public class ReportingStructureServiceImpl implements ReportingStructureService {

    private static final Logger LOG = LoggerFactory.getLogger(ReportingStructureServiceImpl.class);

    @Autowired
    private ReportingStructureRepository reportingStructureRepository;

    @Override
    public ReportingStructure create(ReportingStructure reportingStructure) {
        LOG.debug("Creating employee [{}]", reportingStructure);

        reportingStructure.setRsId(UUID.randomUUID().toString());
        reportingStructureRepository.insert(reportingStructure);

        return reportingStructure;
    }

    @Override
    public ReportingStructure read(String id) {
        LOG.debug("Creating ReportingStructure with id [{}]", id);

        ReportingStructure rs = reportingStructureRepository.findReportingStructureById(id);

        if (rs == null) {
            throw new RuntimeException("Invalid RsId: " + id);
        }

        return rs;
    }

    @Override
    public ReportingStructure update(ReportingStructure employee) {
        LOG.debug("Updating employee [{}]", employee);

        return reportingStructureRepository.save(employee);
    }
}
