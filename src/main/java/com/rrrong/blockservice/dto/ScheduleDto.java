package com.rrrong.blockservice.dto;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
public class ScheduleDto implements Serializable {
    private int id;
    private String key;
    private Date created_date;
    private Date archived_date;
}
