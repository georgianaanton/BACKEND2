package com.georgiana.certification.domain.mentor;

import static com.georgiana.certification.domain.RomanianDateTimeFormatter.ROMANIAN_FORMATTER;

import java.time.LocalDateTime;

public class ValidRomanianIntervalGenerator {
    public static final LocalDateTime START_TIME = LocalDateTime.parse("23.06.2015 15:00", ROMANIAN_FORMATTER);
    public static final LocalDateTime END_TIME = LocalDateTime.parse("23.07.2015 15:00", ROMANIAN_FORMATTER);
}