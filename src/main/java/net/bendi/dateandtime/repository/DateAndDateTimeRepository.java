package net.bendi.dateandtime.repository;

import net.bendi.dateandtime.model.DateAndDateTime;
import org.springframework.data.repository.CrudRepository;

public interface DateAndDateTimeRepository extends CrudRepository<DateAndDateTime, Long> {
}
