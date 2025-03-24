package ru.vad1mchk.webprogr.lab02.entities;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;

public record ShootRecord(
        LocalDateTime timestamp,
        BigDecimal x,
        BigDecimal y,
        BigDecimal r,
        boolean hit,
        String timeElapsed
) {}
