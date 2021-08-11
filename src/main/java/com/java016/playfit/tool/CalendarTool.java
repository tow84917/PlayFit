package com.java016.playfit.tool;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class CalendarTool {
    public Integer monthYearMapGetMonth(Map monthYear){
        return (Integer) monthYear.get("month") + 1;
    }
    public Integer monthYearMapGetYear(Map monthYear){
        return (Integer) monthYear.get("year");
    }
}
