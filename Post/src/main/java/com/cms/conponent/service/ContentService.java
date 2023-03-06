package com.cms.conponent.service;
import com.cms.conponent.entity.Content;
import com.cms.conponent.repository.ContentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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


    public Content findById(long id) {
        Content entity = repository.getOne(id);

        if (entity == null)

            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not-found-with-id," + id);

        return entity;
    }


    public Content  add(Content content){
        content= repository.save(content);
        log.info("Add " + "Content " + content);

        return content;

    }

    public Content  update(Content content){
        Content entity = repository.getOne(content.getId());
        if(entity == null){
            log.info("Not-found-with-id: "  + content.getId());
        }else {
            content= repository.save(content);

            log.info("Update " + "Content " + content);
        }

        return content;

    }
    public Content deleteById(long id){
        Content entity = repository.getOne(id);
        if(entity == null){
            log.info("Not-found-with-id: "  + id);
        }else {
            repository.deleteById(id);
        }

        return null;
    }



}
