package me.gabreuw.spring_boot_jpa_pt_2.util;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class DateUtil {

    public String formatLocalDateTimeToDatabaseStyles(LocalDateTime localDateTime) {
        return DateTimeFormatter
                .ofPattern("yyyy-MM-dd HH:mm:ss")
                .format(localDateTime);
    }

}
