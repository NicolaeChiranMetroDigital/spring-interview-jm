package com.interview.jm.api;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class ExportControllerTest {
  @Autowired private MockMvc mockMvc;

  @Test
  void exportsCsvAsAttachment() throws Exception {
    mockMvc
        .perform(get("/api/export").param("limit", "2"))
        .andExpect(status().isOk())
        .andExpect(header().string("Content-Disposition", "attachment; filename=\"export.csv\""))
        .andExpect(content().contentType("text/csv"))
        .andExpect(
            content()
                .string(
                    "Order ID,Customer Name,Product Code,Country,Status\n"
                        + "ORD-1001,Alpha GmbH,PRD-001,DE,READY\n"
                        + "ORD-1002,Beta SRL,PRD-002,IT,READY\n"));
  }
}
