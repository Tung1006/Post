package com.cms.component.post;

import com.cms.component.content.ContentEntity;
import com.cms.component.content.ContentRepository;
import com.cms.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {

    private final Logger log = LoggerFactory.getLogger(PostService.class);

    @Autowired
    PostRepository repository;

    @Autowired
    ContentRepository contentrepository;

    public List<PostEntity> findAll() {
        return repository.findAll();
    }

    public Page<PostEntity> findAllBy(int page, int size, String sort, String column) {

        Sort sortable = null;
        if (sort.equals("ASC")) {
            sortable = Sort.by(column).ascending();
        }
        if (sort.equals("DESC")) {
            sortable = Sort.by(column).descending();
        }
        Pageable pageable = PageRequest.of(page, size, sortable);
        return repository.getPaging(pageable);
    }


    public Page<PostEntity> findBy(Integer page, Integer size, String[] textSort, Long id, String author, String code, Long type, String title) {

        Page<PostEntity> a = repository.findBy(StringUtil.getPageable(page,size,textSort),id,  author,  code,  type,  title);
        return a;
    }

    public Page<PostEntity> AnyFieldBy(Integer page, Integer size, String[] textSort, String keyword) {


        return repository.AnyFieldBy(StringUtil.getPageable(page,size,textSort),   keyword);
    }

    public Page<PostDto> findBy1(Integer page, Integer size, String[] textSort, Long id, String author, String code, Long type, String title) {


        return repository.findBy1(StringUtil.getPageable(page,size,textSort),id,  author,  code,  type,  title);
    }


    public PostEntity findById(long id) {
        PostEntity entity = repository.getOne(id);

        if (entity == null)

            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not-found-with-id," + id);

        return entity;
    }


    public PostEntity Clone(long id) {
        PostEntity entity = repository.getOne(id);
        System.out.println("hihi: " + entity.getId());


        if (entity == null) {

            log.info("Not found " + id);
        } else {

            PostEntity post = entity.clone();
            post.setId(0L);
            post.setCreated(LocalDateTime.now());
            post= repository.save(post);
            return post;
        }


        return entity;
    }





    public PostEntity add(PostEntity post){
        post.setCreated(LocalDateTime.now());
        post.setStatus(true);
//        post.setAuthor(Constant.COLOR[Constant.COLOR1[1]]);
//        post.setStatus();
        post= repository.save(post);
        log.info("Add " + "Post " + post);

        return post;

    }

    public PostEntity update(PostEntity post){
        PostEntity entity = repository.getOne(post.getId());
        if(entity == null){
            log.info("Not-found-with-id: "  + post.getId());
        }else {
        post.setCreated(entity.getCreated());
        post.setUpdated(LocalDateTime.now());
        post.setStatus(true);
        post= repository.save(post);

        log.info("Update " + "Post " + post);
        }

        return post;

    }
    public PostEntity deleteById(long id){
        PostEntity entity = repository.getOne(id);
        if(entity == null){
            log.info("Not-found-with-id: "  + id);
        }else {
            repository.deleteById(id);
        }

        return null;
    }

    public PostEntity deleteChangeStatusById(long id){
        PostEntity entity = repository.getOne(id);
        if(entity == null){
            log.info("Not-found-with-id: "  + id);
        }else {
            entity.setStatus(false);
            entity.setUpdated(LocalDateTime.now());

            repository.save(entity);
            log.info("Not-found-with-id: "  + entity.getId());
        }

        return entity;
    }

    public Object deleteMany(PostEntity post){


        if(post == null){
            log.info("Not-found-with-id: "  + post.getId());
        }else {
            post.setUpdated(LocalDateTime.now());
            post.setStatus(false);

            repository.save(post);
        }

        return null;
    }



}
