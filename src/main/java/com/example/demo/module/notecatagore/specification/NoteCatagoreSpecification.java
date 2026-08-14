package com.example.demo.module.notecatagore.specification;


import com.example.demo.common.enumstatus.StatusEnum;
import com.example.demo.module.notecatagore.dto.request.NoteCatagoreFilterRequestDTO;
import com.example.demo.module.notecatagore.entity.NoteCatagoreEntity;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class NoteCatagoreSpecification {

    private NoteCatagoreSpecification(){

    }

    public static Specification<NoteCatagoreEntity> filter( NoteCatagoreFilterRequestDTO filter){

        return (root, query, cb) -> {

            List<Predicate> predicates = new ArrayList<>() ;

            if( filter.getStatus() == null ){
                predicates.add(
                        cb.notEqual(root.get("status") , StatusEnum.X)
                ) ;
            }
            else {
                if(filter.getStatus() == StatusEnum.A){
                    predicates.add(
                            cb.equal(root.get("status") , StatusEnum.A)
                    ) ;
                }
                else {
                    predicates.add(
                            cb.equal(root.get("status") , StatusEnum.I)
                    ) ;
                }
            }



            if( filter.getNtId() != null ){

                predicates.add(
                        cb.equal(root.get("note").get("id"), filter.getNtId())
                ) ;

                predicates.add(
                        cb.notEqual(root.get("status") , StatusEnum.X)
                ) ;
            }

            if(filter.getCtId() != null){

                predicates.add(
                        cb.equal(root.get("category").get("ctId") , filter.getCtId())
                ) ;

                predicates.add(
                        cb.notEqual(root.get("status") , StatusEnum.X)
                ) ;
            }

            return cb.and(predicates.toArray(new Predicate[0])) ;
        };
    }

}
