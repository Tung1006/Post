package com.cms.component.relate;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RelateRepository extends JpaRepository<Relate, RelateId> {

    String str_AnyField = "select * from relate where " +
            "(:catId is null or category_Id = TO_NUMBER(:catId) )  AND (:siteId is null or site_Id = TO_NUMBER(:siteId) ) AND (:postId is null or post_Id = TO_NUMBER(:postId) )";
    @Query(value = str_AnyField, nativeQuery = true)

    List<Relate> findBy( Long catId,Long siteId,Long postId);

}
