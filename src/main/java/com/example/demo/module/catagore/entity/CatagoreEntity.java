package com.example.demo.module.catagore.entity;

import com.example.demo.common.enumstatus.ColumnStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "MM_CATAGORE")
@Getter
@Setter
public class CatagoreEntity {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    @Column(name = "ctId")
    private Long ctId;

    @Column(name = "ctName" , nullable = false)
    private String ctName ;

    @Column( name = "ctStatus" , nullable = false)
    private ColumnStatus ctStatus = ColumnStatus.A;

}
