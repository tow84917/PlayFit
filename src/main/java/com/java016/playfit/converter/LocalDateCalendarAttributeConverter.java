package com.java016.playfit.converter;

import org.springframework.stereotype.Component;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.Date;
import java.util.Calendar;

@Component
@Converter(autoApply = true)
public class LocalDateCalendarAttributeConverter implements AttributeConverter<Calendar, Date> {

    @Override
    public Date convertToDatabaseColumn(Calendar attribute) {
        return new Date(attribute.getTimeInMillis());
    }

    @Override
    public Calendar convertToEntityAttribute(Date dbData) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(dbData);
        return cal;
    }
}