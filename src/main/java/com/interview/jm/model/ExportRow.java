package com.interview.jm.model;

public record ExportRow(
    String orderId, String customerName, String productCode, String country, String status) {}
