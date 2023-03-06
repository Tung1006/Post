package com.cms.conponent.repository;

import com.cms.conponent.entity.Post;
import com.cms.conponent.entity.Site;
import com.cms.conponent.entity.dto.SiteDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SiteRepository extends JpaRepository<Site, Long> {
    String str_AnyField = "select v.* from site v Where (:id is null or v.id = TO_NUMBER(:id) ) AND (:code is null or LOWER(v.code) like  CONCAT('%',CONCAT(LOWER(:code),'%')) collate binary_ai) AND (:name is null or LOWER(v.name) like  CONCAT('%',CONCAT(LOWER(:name),'%')) collate binary_ai) AND (:parnetId is null or v.parnetId = TO_NUMBER(:parnetId) ) ";
    String str_AnyFieldCont = "select count(v.*) from site v Where (:id is null or v.id = TO_NUMBER(:id) ) AND (:code is null or LOWER(v.code) like  CONCAT('%',CONCAT(LOWER(:code),'%')) collate binary_ai) AND (:name is null or LOWER(v.name) like  CONCAT('%',CONCAT(LOWER(:name),'%')) collate binary_ai) AND (:parnetId is null or v.parnetId = TO_NUMBER(:parnetId) ) ";
    @Query(value = str_AnyField,
            countQuery =  str_AnyFieldCont, nativeQuery = true)
    Page<SiteDto> findBy(Pageable pageable, Long id, String code, String name, Long parnetId);



}
