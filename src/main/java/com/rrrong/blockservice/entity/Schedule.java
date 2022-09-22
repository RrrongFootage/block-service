package com.rrrong.blockservice.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Table
@Entity(name="schedule")
public class Schedule {
    @Id
    @Column(name = "id", nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "key", nullable = false, updatable = true,unique = true)
    private String key;
    @Temporal(TemporalType.DATE)
    @Column(name = "created_date", nullable = false, updatable = false)
    private Date created_date;
    @Temporal(TemporalType.DATE)
    @Column(name = "archived_date", nullable = true, updatable = true)
    private Date archived_date;

    @OneToMany(mappedBy = "schedule", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Block> serviceBlocks;


}
