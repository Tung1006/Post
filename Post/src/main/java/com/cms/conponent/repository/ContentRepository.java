package com.cms.conponent.repository;

import com.cms.conponent.entity.Content;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContentRepository extends JpaRepository<Content, Long> {
//    String str_AnyField = "select v.*,(CASE WHEN v.status = 1 THEN 'true' else 'false' end) as \"status\" from Category v where status = 1 AND (:id is null or id = TO_NUMBER(:id) ) AND (:code is null or LOWER(code) like  CONCAT('%',CONCAT(LOWER(:code),'%')) collate binary_ai) AND (:name is null or LOWER(name) like  CONCAT('%',CONCAT(LOWER(:name),'%')) collate binary_ai) AND (:parentId is null or parentId = TO_NUMBER(:parentId) ) ";
//    String str_AnyFieldCont = "select count(*) from Category v where status = 1 AND (:id is null or id = TO_NUMBER(:id) ) AND (:code is null or LOWER(code) like  CONCAT('%',CONCAT(LOWER(:code),'%')) collate binary_ai) AND (:name is null or LOWER(name) like  CONCAT('%',CONCAT(LOWER(:name),'%')) collate binary_ai) AND (:parentId is null or parentId = TO_NUMBER(:parentId) ) ";
//    @Query(value = str_AnyField,
//            countQuery =  str_AnyFieldCont, nativeQuery = true)
//    Page<CategoryDto> findBy(Pageable pageable, Long id,  String code,String name, Long parentId);



}
