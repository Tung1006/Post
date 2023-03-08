package com.cms.component.organization;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrganizationRepository extends JpaRepository<Organization, Long> {
    String str_AnyField = "select * from Organization where (:id is null or id = TO_NUMBER(:id) ) AND (:code is null or LOWER(code) like  CONCAT('%',CONCAT(LOWER(:code),'%')) collate binary_ai) AND (:name is null or LOWER(name) like  CONCAT('%',CONCAT(LOWER(:name),'%')) collate binary_ai) AND (:parnetId is null or parnetId = TO_NUMBER(:parnetId) ) ";
    String str_AnyFieldCont = "select count(*) from Organization where (:id is null or id = TO_NUMBER(:id) ) AND (:code is null or LOWER(code) like  CONCAT('%',CONCAT(LOWER(:code),'%')) collate binary_ai) AND (:name is null or LOWER(name) like  CONCAT('%',CONCAT(LOWER(:name),'%')) collate binary_ai) AND (:parnetId is null or parnetId = TO_NUMBER(:parnetId) ) ";
    @Query(value = str_AnyField,
            countQuery =  str_AnyFieldCont, nativeQuery = true)
    Page<OrganizationDto> findBy(Pageable pageable, Long id, String code, String name, Long parnetId);



}
