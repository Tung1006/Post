package com.cms.conponent.service;
import com.cms.conponent.entity.join.Content;
import com.cms.conponent.repository.ContentRepository;
import com.cms.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ContentService {

    private final Logger log = LoggerFactory.getLogger(ContentService.class);

    @Autowired
    ContentRepository repository;

    public List<Content> findAll() {
        return repository.findAll();
    }
//    public Page<ContentDto> findBy(Integer page, Integer size, String[] textSort,  Long id,  String code,String name, Long parentId) {
//
//        return repository.findBy(StringUtil.getPageable(page,size,textSort),  id,   code, name,  parentId);
//    }


//    public Content findById(long id) {
//        Content entity = repository.getOne(id);
//
//        if (entity == null)
//
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not-found-with-id," + id);
//
//        return entity;
//    }


    public Content  add(Content Content){
        Content= repository.save(Content);
        log.info("Add " + "Content " + Content);

        return Content;

    }

//    public Content  update(Content Content){
//        Content entity = repository.getOne(Content.getId());
//        if(entity == null){
//            log.info("Not-found-with-id: "  + Content.getId());
//        }else {
//            Content= repository.save(Content);
//
//            log.info("Update " + "Content " + Content);
//        }
//
//        return Content;
//
//    }
//    public Content deleteById(long id){
//        Content entity = repository.getOne(id);
//        if(entity == null){
//            log.info("Not-found-with-id: "  + id);
//        }else {
//            repository.deleteById(id);
//        }
//
//        return null;
//    }



}
