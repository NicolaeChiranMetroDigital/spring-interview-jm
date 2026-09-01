package com.interview.jm.api;

import com.interview.jm.service.ExportService;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/export")
public class ExportController {
  private final ExportService exportService;

  public ExportController(ExportService exportService) {
    this.exportService = exportService;
  }

  @GetMapping
  public ResponseEntity<String> export(
      @RequestParam(defaultValue = "10") @Min(1) @Max(1000) int limit) {
    return ResponseEntity.ok()
        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"export.csv\"")
        .contentType(MediaType.parseMediaType("text/csv"))
        .body(exportService.exportCsv(limit));
  }
}
