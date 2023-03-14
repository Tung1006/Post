package com.cms.component.content;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ContentRepository extends JpaRepository<ContentEntity, Long> {


    String str_Any = "SELECT * from content v where v.status = 1 AND (:content is null or LOWER(v.content) like  CONCAT('%',CONCAT(LOWER(:content),'%')) collate binary_ai)";

    String str_count= "SELECT count(*) FROM content v where v.status = 1 AND (:content is null or LOWER(v.content) like  CONCAT('%',CONCAT(LOWER(:content),'%')) collate binary_ai)";
    @Query(value = str_Any,
            countQuery = str_count , nativeQuery = true)
    Page<ContentEntity> getPaging(Pageable pageable, String content);

    @Query(value = "SELECT * from content v where v.status = 1 AND (:content is null or LOWER(v.content) like  CONCAT('%',CONCAT(LOWER(:content),'%')) collate binary_ai) order by v.created desc", nativeQuery = true)

    List<ContentEntity> findByContent(String content);



}
