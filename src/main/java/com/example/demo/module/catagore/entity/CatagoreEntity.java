package com.example.demo.module.catagore.entity;

import com.example.demo.common.enumstatus.StatusEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "mm_catagore")
@Getter
@Setter
public class CatagoreEntity {


    @Id
    @GeneratedValue( strategy = GenerationType.SEQUENCE , generator = "ct_id_seq")
    @SequenceGenerator( name = "ct_id_seq" , sequenceName = "ct_id_seq" , allocationSize = 1)
    @Column(name = "ctId")
    private Long ctId;

    @Column(name = "ctName" , nullable = false)
    private String ctName ;

    @Column( name = "ctStatus" , nullable = false)
    private StatusEnum ctStatus = StatusEnum.A;

}
