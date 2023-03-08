package com.cms.component.track;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TrackRepository extends JpaRepository<Track, Long> {
    String str_AnyField = "select * from track where (:id is null or id = TO_NUMBER(:id) ) and (:postId is null or postId = TO_NUMBER(:postId) )AND (:type is null or LOWER(type) like  CONCAT('%',CONCAT(LOWER(:type),'%')) collate binary_ai) ";
    String str_AnyFieldCont = "select count(*) from track where (:id is null or id = TO_NUMBER(:id) ) and (:postId is null or postId = TO_NUMBER(:postId) )AND (:type is null or LOWER(type) like  CONCAT('%',CONCAT(LOWER(:type),'%')) collate binary_ai) ";
    @Query(value = str_AnyField,
            countQuery =  str_AnyFieldCont, nativeQuery = true)
    Page<TrackDto> findBy(Pageable pageable, Long id, Long postId, String type);



}
