package com.interview.jm.service;

import com.interview.jm.model.CsvExportField;
import com.interview.jm.model.ExportRow;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

@Service
public class ExportService {
  public String exportCsv(int limit) {
    return toCsv(sampleRows().stream().limit(limit).toList());
  }

  private List<ExportRow> sampleRows() {
    return List.of(
        new ExportRow("ORD-1001", "Alpha GmbH", "PRD-001", "DE", "READY"),
        new ExportRow("ORD-1002", "Beta SRL", "PRD-002", "IT", "READY"),
        new ExportRow("ORD-1003", "Gamma Ltd", "PRD-003", "UK", "PENDING"),
        new ExportRow("ORD-1004", "Delta Inc", "PRD-004", "US", "SHIPPED"));
    //TODO : add more sample rows to simulate a larger dataset if needed
  }

  private String toCsv(List<ExportRow> rows) {
    String header =
        Stream.of(CsvExportField.values()).map(CsvExportField::header).collect(Collectors.joining(","));
    String body = "";
    //TODO: Implement the logic to convert the list of ExportRow objects into CSV format, joining each row's fields with commas and separating rows with newlines.
    return header + "\n" + body + (body.isEmpty() ? "" : "\n");
  }
}
