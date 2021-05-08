package net.bendi.dateandtime.controller;

import net.bendi.dateandtime.dto.DateAndDateTimeDTO;
import net.bendi.dateandtime.model.DateAndDateTime;
import net.bendi.dateandtime.repository.DateAndDateTimeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
public class DateAndDateTimeController {

    Logger logger = LoggerFactory.getLogger(DateAndDateTimeController.class);

    @Autowired
    DateAndDateTimeRepository dateAndDateTimeRepository;

    @GetMapping(path="date-and-datetime")
    public DateAndDateTimeDTO getDateAndDateTime() {

        logger.info("Getting current date and datetime");

        DateAndDateTimeDTO dateAndDateTimeDTO = new DateAndDateTimeDTO();
        dateAndDateTimeDTO.setDate(LocalDate.now());
        dateAndDateTimeDTO.setDatetime(OffsetDateTime.now());

        logger.info(dateAndDateTimeDTO.getDate().toString());
        logger.info(dateAndDateTimeDTO.getDatetime().toString());

        return dateAndDateTimeDTO;
    }

    @PostMapping(path="date-and-datetime")
    public DateAndDateTimeDTO setDateAndDateTime(@RequestBody DateAndDateTimeDTO dateAndDateTimeDTO) {

        logger.info("Setting date and datetime");

        logger.info(dateAndDateTimeDTO.getDate().toString());
        logger.info(dateAndDateTimeDTO.getDatetime().toString());

        DateAndDateTime dateAndDateTime = new DateAndDateTime();
        dateAndDateTime.setDate(dateAndDateTimeDTO.getDate());
        dateAndDateTime.setDatetime(dateAndDateTimeDTO.getDatetime());

        DateAndDateTime savedDateAndDateTime = dateAndDateTimeRepository.save(dateAndDateTime);

        dateAndDateTimeDTO.setDate(savedDateAndDateTime.getDate());
        dateAndDateTimeDTO.setDatetime(savedDateAndDateTime.getDatetime());

        return dateAndDateTimeDTO;

    }

    @GetMapping(path="all")
    public List<DateAndDateTimeDTO> findAll() {

        logger.info("Getting stored dates and datetimes");

        List<DateAndDateTimeDTO> dateAndDateTimeDTOList = new ArrayList<>();

        for(DateAndDateTime dateAndDateTime : dateAndDateTimeRepository.findAll()) {
            DateAndDateTimeDTO dateAndDateTimeDTO = new DateAndDateTimeDTO();
            dateAndDateTimeDTO.setDate(dateAndDateTime.getDate());
            dateAndDateTimeDTO.setDatetime(dateAndDateTime.getDatetime());
            dateAndDateTimeDTOList.add(dateAndDateTimeDTO);

            logger.info(dateAndDateTimeDTO.getDate().toString());
            logger.info(dateAndDateTimeDTO.getDatetime().toString());
        }

        return dateAndDateTimeDTOList;
    }
}
