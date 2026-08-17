package com.example.demo.module.catagore.specification;


import com.example.demo.common.enumstatus.StatusEnum;
import com.example.demo.module.catagore.dto.request.CatagoreFilterDTO;
import com.example.demo.module.catagore.entity.CatagoreEntity;


import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;



public class CatagoreSpecification {

    public CatagoreSpecification(){

    }

    public static Specification<CatagoreEntity> filter(CatagoreFilterDTO filter){

        return (root, query, cb) -> {

            List<Predicate> predicates = new ArrayList<>() ;

            if(filter.getStatus() == null ){

                predicates.add(
                        cb.notEqual(root.get("ctStatus") , StatusEnum.X)
                ) ;

            }
            else {
               if(filter.getStatus() == StatusEnum.A){
                   predicates.add(
                         cb.equal( root.get("ctStatus") , StatusEnum.A)
                   ) ;
               }
               else {
                   predicates.add(
                           cb.equal( root.get("ctStatus") , StatusEnum.I)
                   ) ;
               }
            }


            if(filter.getId() != null){
                predicates.add(
                        cb.equal(root.get("id") , filter.getId())
                ) ;
                predicates.add(
                        cb.notEqual(root.get("ctStatus") , StatusEnum.X)
                ) ;
            }

            if(filter.getSearchById() != null){
                predicates.add(
                        cb.equal(root.get("id") , filter.getSearchById())
                ) ;
            }


            if(filter.getGlobalSearch() != null && !filter.getGlobalSearch().trim().isEmpty()){

                String keyword = "%" + filter.getGlobalSearch().trim().toLowerCase() + "%" ;

                Predicate globalSearch = cb.or(
                        cb.like(
                                cb.lower(root.get("ctName")), keyword
                        )
                ) ;

                Predicate status = cb.notEqual(root.get("ctStatus") , StatusEnum.X) ;

                predicates.add(globalSearch);
                predicates.add(status) ;

            }



            return cb.and(predicates.toArray(new Predicate[0])) ;
        } ;

    }
}
