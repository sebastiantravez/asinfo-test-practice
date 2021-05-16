package com.asinfo.test.practice.controller.util;

import java.math.BigDecimal;

public class Util {
    public String decimal(BigDecimal bigDecimal) {
        String result = String.format("%.2f", bigDecimal);
        return result.replace(",", ".");
    }
}
