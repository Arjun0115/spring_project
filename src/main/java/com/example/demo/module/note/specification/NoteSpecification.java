package com.example.demo.module.note.specification;

import com.example.demo.common.enumstatus.StatusEnum;
import com.example.demo.module.note.dto.request.NoteFilterDTO;
import com.example.demo.module.note.entity.NoteEntity;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class NoteSpecification {

    public NoteSpecification(){

    }

    public static Specification<NoteEntity> filter (NoteFilterDTO filter){
        return (root , query ,cb )->{

            List<Predicate> predicates = new ArrayList<>() ;

            // id softDelete filter
            if( filter.getId() != null ){

                predicates.add(
                        cb.equal(root.get("id") , filter.getId())
                ) ;

                predicates.add(
                        cb.notEqual(root.get("ntStatus") , StatusEnum.X)
                ) ;
            }

            // filter by status
            if(filter.getStatus() == null){
                predicates.add(
                        cb.notEqual(root.get("ntStatus") , StatusEnum.X)
                ) ;
            }
            else {
                if(filter.getStatus() == StatusEnum.A){
                    predicates.add(
                            cb.equal(root.get("ntStatus") , StatusEnum.A)
                    ) ;
                }
                else {
                    predicates.add(
                            cb.equal(root.get("ntStatus") , StatusEnum.I)
                    ) ;
                }
            }

            //search by id
            if(filter.getSearchById() != null){
                predicates.add(
                        cb.equal(root.get("id") , filter.getSearchById())
                ) ;
            }

            // gloab search
            if(filter.getGlobalSearch() != null && !filter.getGlobalSearch().trim().isEmpty()){

                String keyword = "%" + filter.getGlobalSearch().trim().toLowerCase() + "%" ;

                Predicate gloabsearch = cb.or(

                        cb.like(
                                cb.lower(root.get("title")) , keyword
                        ) ,
                        cb.like(
                                cb.lower(root.get("content")) , keyword
                        )
                ) ;

                Predicate status = cb.notEqual(root.get("ntStatus") , StatusEnum.X) ;

                predicates.add(gloabsearch) ;
                predicates.add(status) ;
            }



            return cb.and(predicates.toArray(new Predicate[0])) ;
        } ;
    }

}
