package com.rrrong.blockservice.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Table
@Entity(name="serviceblock")
public class Block {
@Id
@Column(name = "id", nullable = false, updatable = false)
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "key", nullable = false, updatable = true, unique = true)
    private String key;
    @ManyToOne
    @JoinColumn(name = "schedule_id", nullable = true, updatable = true)
    private Schedule schedule;
    @ManyToOne
    @JoinColumn(name = "place_id", nullable = false, updatable = true)
    private Place place;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Temporal(TemporalType.DATE)
    @Column(name = "start_date", nullable = false, updatable = true)
    private Date start_date;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Temporal(TemporalType.DATE)
    @Column(name = "end_date", nullable = false, updatable = true)
    private Date end_date;
    @Temporal(TemporalType.DATE)
    @Column(name = "created_date", nullable = false, updatable = false)
    private Date created_date;
    @Temporal(TemporalType.DATE)
    @Column(name = "updated_date", nullable = false, updatable = true)
    private Date updated_date;
    @Temporal(TemporalType.DATE)
    @Column(name = "archived_date", nullable = true, updatable = true)
    private Date archived_date;
}
