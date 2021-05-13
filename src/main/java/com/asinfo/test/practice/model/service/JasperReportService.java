package com.asinfo.test.practice.model.service;

import net.sf.jasperreports.engine.JRException;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;

public interface JasperReportService {

    byte[] getReportWithCollectionDataSource(String reportName, HashMap<String, Object> parameters, Collection collectionDataSource) throws IOException, JRException;
}
