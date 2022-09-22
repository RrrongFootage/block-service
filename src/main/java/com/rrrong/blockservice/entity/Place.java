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
@Entity(name ="place")
public class Place {
    @Id
    @Column(name = "id", nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "label", nullable = false, updatable = true,unique = true)
    private String label;
    @Column(name = "latitude", nullable = false, updatable = true,unique = true)
    private double latitude;
    @Column(name = "longitude", nullable = false, updatable = true,unique = true)
    private double longitude;
    @Temporal(TemporalType.DATE)
    @Column(name = "created_date", nullable = false, updatable = false)
    private Date created_date;
    @Temporal(TemporalType.DATE)
    @Column(name = "updated_date", nullable = false, updatable = true)
    private Date updated_date;
    @Column(name = "archived_date", nullable = true, updatable = true)
    private Date archived_date;
    @OneToMany(mappedBy = "place", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Block> serviceBlocks;
}
