package net.bendi.dateandtime.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.OffsetDateTime;

@Entity
@Table(name = "date_and_datetime")
public class DateAndDateTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column(name = "date")
    LocalDate date;

    @Column(name = "datetime")
    OffsetDateTime datetime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
