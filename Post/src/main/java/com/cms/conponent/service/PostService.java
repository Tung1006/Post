package com.cms.conponent.service;

import com.cms.conponent.entity.Post;
import com.cms.conponent.entity.dto.PostDto;
import com.cms.conponent.repository.PostRepository;
import com.cms.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PostService {

    private final Logger log = LoggerFactory.getLogger(PostService.class);

    @Autowired
    PostRepository repository;

    public List<Post> findAll() {
        return repository.findAll();
    }

    public Page<Post> findAllBy(int page, int size,String sort,String column) {

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


    public Page<Post> findBy(Integer page, Integer size, String[] textSort,Long id, String author, String code, Long type, String title) {

        Page<Post> a = repository.findBy(StringUtil.getPageable(page,size,textSort),id,  author,  code,  type,  title);
        return a;
    }

    public Page<PostDto> findBy1(Integer page, Integer size, String[] textSort, Long id, String author, String code, Long type, String title) {


        return repository.findBy1(StringUtil.getPageable(page,size,textSort),id,  author,  code,  type,  title);
    }


    public Post findById(long id) {
        Post entity = repository.getOne(id);

        if (entity == null)

            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not-found-with-id," + id);

        return entity;
    }


    public Post Clone(long id) {
        Post entity = repository.getOne(id);
        System.out.println("hihi: " + entity.getId());


        if (entity == null) {

            log.info("Not found " + id);
        } else {

            Post post = entity.clone();
            post.setId(0L);
            post.setCreated(LocalDateTime.now());
            post= repository.save(post);
            return post;
        }


        return entity;
    }





    public Post  add(Post post){
        post.setCreated(LocalDateTime.now());
        post.setStatus(true);
//        post.setAuthor(Constant.COLOR[Constant.COLOR1[1]]);
//        post.setStatus();
        post= repository.save(post);
        log.info("Add " + "Post " + post);

        return post;

    }

    public Post  update(Post post){
        Post entity = repository.getOne(post.getId());
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
    public Post deleteById(long id){
        Post entity = repository.getOne(id);
        if(entity == null){
            log.info("Not-found-with-id: "  + id);
        }else {
            repository.deleteById(id);
        }

        return null;
    }

    public Post deleteChangeStatusById(long id){
        Post entity = repository.getOne(id);
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

    public Object deleteMany(Post post){


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
