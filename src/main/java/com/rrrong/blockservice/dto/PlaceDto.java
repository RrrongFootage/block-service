package com.rrrong.blockservice.dto;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
public class PlaceDto implements Serializable {
    private int id;
    private String label;
    private double latitude;
    private double longitude;
    private Date created_date;
    private Date updated_date;
    private Date archived_date;
}
