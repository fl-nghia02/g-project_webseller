package com.webseller.be.util;

import lombok.experimental.UtilityClass;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@UtilityClass
public class ConvertTime {
    public static String convertLocalDateTimeToString(LocalDateTime localDateTime) {
        DateTimeFormatter fmt3 = DateTimeFormatter.ofPattern("HH:mm:ss dd/MM/yyyy");
        return localDateTime.format(fmt3);
    }
}
