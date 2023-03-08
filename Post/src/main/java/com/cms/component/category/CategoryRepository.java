package com.cms.component.category;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
    String str_AnyField = "select v.*,(CASE WHEN v.status = 1 THEN 'true' else 'false' end) as \"status\" from Category v where status = 1  AND (:code is null or LOWER(code) like  CONCAT('%',CONCAT(LOWER(:code),'%')) collate binary_ai)  AND (:name is null or LOWER(name) like  CONCAT('%',CONCAT(LOWER(:name),'%')) collate binary_ai)  AND (:parentId is null or parentId = TO_NUMBER(:parentId) ) AND (:keyword is null or LOWER(v.name||v.code||v.parentId) LIKE (LOWER('%'||:keyword||'%') collate binary_ai))";
    String str_AnyFieldCont = "select count(*) from Category v where status = 1  AND (:code is null or LOWER(code) like  CONCAT('%',CONCAT(LOWER(:code),'%')) collate binary_ai)  AND (:name is null or LOWER(name) like  CONCAT('%',CONCAT(LOWER(:name),'%')) collate binary_ai)  AND (:parentId is null or parentId = TO_NUMBER(:parentId) ) AND (:keyword is null or LOWER(v.name||v.code||v.parentId) LIKE (LOWER('%'||:keyword||'%') collate binary_ai))";
    @Query(value = str_AnyField,
            countQuery =  str_AnyFieldCont, nativeQuery = true)
    Page<CategoryDto> findBy(Pageable pageable,  String code,String name, Long parentId, String keyword);

   
}
