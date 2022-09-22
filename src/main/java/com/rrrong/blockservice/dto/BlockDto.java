package com.rrrong.blockservice.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class BlockDto implements Serializable {
    private int id;
    private String key;
    private ScheduleDto schedule;
    private PlaceDto place;
    private Date start_date;
    private Date end_date;
    private Date created_date;
    private Date updated_date;
    private Date archived_date;
}
