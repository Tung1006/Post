package com.cms.component.relate;

import com.cms.component.content.ContentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class RelateService {

    private final Logger log = LoggerFactory.getLogger(RelateService.class);

    @Autowired
    RelateRepository repository;

    @Autowired
    ContentRepository contentrepository;

    public List<Relate> findAll() {
        return repository.findAll();
    }


    public Relate findById(RelateId id) {
        Relate entity = repository.getOne(id);

        if (entity == null)

            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not-found-with-id," + id);

        return entity;
    }





    public Relate add(Relate relate){
        relate= repository.save(relate);
        log.info("Add " + "Relate " + relate);

        return relate;

    }

    public Relate update(Relate relate){
        Relate entity = repository.getOne(relate.getId());
        if(entity == null){
            log.info("Not-found-with-id: "  + relate.getId());
        }else {

            log.info("Update " + "Relate " + relate);
        }

        return relate;

    }
    public Relate deleteById(RelateId id){
        Relate entity = repository.getOne(id);
        if(entity == null){
            log.info("Not-found-with-id: "  + id);
        }else {
            repository.deleteById(id);
        }

        return null;
    }





}
