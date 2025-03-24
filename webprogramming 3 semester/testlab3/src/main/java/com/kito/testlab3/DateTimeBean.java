package com.kito.testlab3;
import javax.annotation.ManagedBean;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import jdk.jfr.Name;

import java.io.Serializable;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;



@ManagedBean
@RequestScoped
public class DateTimeBean implements Serializable {
    private static final long serialVersionUID = 1234567L;

    public String getDateTime() {
        return Instant.now().atZone(ZoneId.of("Europe/Moscow")).format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
    }
}

