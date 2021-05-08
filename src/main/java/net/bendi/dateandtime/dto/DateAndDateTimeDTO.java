package net.bendi.dateandtime.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.time.OffsetDateTime;

public class DateAndDateTimeDTO {

    @JsonProperty("date")
    private LocalDate date;

    @JsonProperty("datetime")
    private OffsetDateTime datetime;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public OffsetDateTime getDatetime() {
        return datetime;
    }

    public void setDatetime(OffsetDateTime datetime) {
        this.datetime = datetime;
    }
}
