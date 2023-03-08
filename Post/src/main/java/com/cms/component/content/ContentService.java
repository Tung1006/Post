package com.cms.component.content;

import com.cms.component.post.PostEntity;
import com.cms.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ContentService {

    private final Logger log = LoggerFactory.getLogger(ContentService.class);

    @Autowired
    ContentRepository repository;

    public List<ContentEntity> getAll() {
        return repository.findAll();
    }

    public Page<ContentEntity> findByContent(int page, int size, String sort, String column,String content) {

        Sort sortable = null;
        if (sort.equals("ASC")) {
            sortable = Sort.by(column).ascending();
        }
        if (sort.equals("DESC")) {
            sortable = Sort.by(column).descending();
        }
        Pageable pageable = PageRequest.of(page, size, sortable);
        return repository.getPaging(pageable,content);
    }

    public ContentEntity findById(long id) {
        ContentEntity entity = repository.getOne(id);

        if (entity == null)

            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not-found-with-id," + id);

        return entity;
    }

    public ContentEntity add(ContentEntity content){
        content.setCreated(LocalDateTime.now());
        content.setStatus(true);
        content= repository.save(content);
        log.info("Add " + "Content " + content);

        return content;

    }

    public ContentEntity update(ContentEntity content){
        ContentEntity entity = repository.getOne(content.getId());
        if(entity == null){
            log.info("Not-found-with-id: "  + content.getId());
        }else {
            content.setCreated(entity.getCreated());
            content.setStatus(true);
            content= repository.save(content);

            log.info("Update " + "Content " + content);
        }

        return content;

    }
    public ContentEntity deleteById(long id){
        ContentEntity entity = repository.getOne(id);
        if(entity == null){
            log.info("Not-found-with-id: "  + id);
        }else {
            repository.deleteById(id);
        }

        return null;
    }




}
