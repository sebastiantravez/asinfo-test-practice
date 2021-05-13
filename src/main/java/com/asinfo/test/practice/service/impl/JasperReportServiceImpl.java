package com.asinfo.test.practice.service.impl;

import com.asinfo.test.practice.service.JasperReportService;
import org.springframework.core.io.ClassPathResource;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;

@Service
public class JasperReportServiceImpl implements JasperReportService {


    @Override
    public byte[] getReportWithCollectionDataSource(String reportName, HashMap<String, Object> parameters, Collection collectionDataSource) throws IOException, JRException {
        InputStream jasperReport = getCompileReport(reportName);
        JRDataSource dataSource = new JRBeanCollectionDataSource(collectionDataSource);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);

        return exportToPDF(jasperPrint);
    }

    private InputStream getCompileReport(String reportName) throws IOException {

        ClassPathResource classPathResource = new ClassPathResource("report/" + reportName + ".jasper");
        return classPathResource.getInputStream();
    }

    private byte[] exportToPDF(JasperPrint... jasperPrint) throws JRException, IOException {

        byte[] pdf;

        JRPdfExporter exporter = new JRPdfExporter();
        exporter.setParameter(JRExporterParameter.JASPER_PRINT_LIST, Arrays.asList(jasperPrint));
        try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {
            exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, byteArrayOutputStream);
            exporter.exportReport();
            pdf = byteArrayOutputStream.toByteArray();

        }

        return pdf;
    }
}
