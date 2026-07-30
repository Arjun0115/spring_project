package com.example.demo.module.catagore.repository;

import com.example.demo.common.enumstatus.StatusEnum;
import com.example.demo.module.catagore.entity.CatagoreEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface CatagoreRepository extends JpaRepository<CatagoreEntity , Long> {

    Optional<CatagoreEntity> findByCtIdAndCtStatus(Long ctId, StatusEnum ctStatus);
}
