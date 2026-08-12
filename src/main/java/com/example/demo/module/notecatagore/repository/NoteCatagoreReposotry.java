package com.example.demo.module.notecatagore.repository;

import com.example.demo.module.notecatagore.entity.NoteCatagoreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface NoteCatagoreReposotry extends JpaRepository<NoteCatagoreEntity, Long> ,
        JpaSpecificationExecutor<NoteCatagoreEntity> {

    List<NoteCatagoreEntity> findByCategoryCtId(Long ctId) ;
}
