package com.adobe.prj.orderapp.dto;

import java.util.Date;

public record ReportDTO(String email, String firstName, String lastName, Date orderDate, double total) {
}
