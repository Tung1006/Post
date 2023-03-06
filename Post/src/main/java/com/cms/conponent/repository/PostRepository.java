package com.cms.conponent.repository;

import com.cms.conponent.entity.Post;
import com.cms.conponent.entity.dto.PostDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PostRepository extends JpaRepository<Post, Long> {

    @Query(value = "SELECT * from Post v where v.status = 1 ",
            countQuery = "SELECT count(*) FROM Post v where v.status = 1 " , nativeQuery = true)
    Page<Post> getPaging( Pageable pageable);
    String str_AnyField = "select v.*,(CASE WHEN v.status = 1 THEN 'true' else 'false' end) as \"status\",(select u.fullname from users u where u.id = v.userid and active_ = 1) as fullname from post v where status = 1 AND (:id is null or id = TO_NUMBER(:id) ) AND (:author is null or LOWER(author) like  CONCAT('%',CONCAT(LOWER(:author),'%')) collate binary_ai) AND (:code is null or LOWER(code) like  CONCAT('%',CONCAT(LOWER(:code),'%')) collate binary_ai) AND (:type is null or type = TO_NUMBER(:type) ) AND (:title is null or LOWER(title) like  CONCAT('%',CONCAT(LOWER(:title),'%')) collate binary_ai)";
    String str_AnyFieldCont = "select count(*) from post where status = 1 AND (:id is null or id = TO_NUMBER(:id) ) AND (:author is null or LOWER(author) like  CONCAT('%',CONCAT(LOWER(:author),'%')) collate binary_ai) AND (:code is null or LOWER(code) like  CONCAT('%',CONCAT(LOWER(:code),'%')) collate binary_ai) AND (:type is null or type = TO_NUMBER(:type) ) AND (:title is null or LOWER(title) like  CONCAT('%',CONCAT(LOWER(:title),'%')) collate binary_ai)";
    @Query(value = str_AnyField,
            countQuery =  str_AnyFieldCont, nativeQuery = true)
    Page<Post> findBy( Pageable pageable,Long id, String author, String code, Long type, String title);


    @Query(value = str_AnyField,
            countQuery =  str_AnyFieldCont, nativeQuery = true)
    Page<PostDto> findBy1(Pageable pageable, Long id, String author, String code, Long type, String title);




}
