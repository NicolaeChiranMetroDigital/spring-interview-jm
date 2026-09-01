package com.interview.jm.model;

public enum CsvExportField {
  ORDER_ID("Order ID"),
  CUSTOMER_NAME("Customer Name"),
  PRODUCT_CODE("Product Code"),
  COUNTRY("Country"),
  STATUS("Status");

  private final String header;

  CsvExportField(String header) {
    this.header = header;
  }

  public String header() {
    return header;
  }
}
