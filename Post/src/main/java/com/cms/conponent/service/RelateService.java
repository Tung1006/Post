package com.cms.conponent.service;

import com.cms.conponent.entity.join.Relate;
import com.cms.conponent.repository.RelateRepository;
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
public class RelateService {

    private final Logger log = LoggerFactory.getLogger(RelateService.class);

    @Autowired
    RelateRepository repository;

    public List<Relate> findAll() {
        return repository.findAll();
    }
//    public Page<RelateDto> findBy(Integer page, Integer size, String[] textSort,  Long id,  String code,String name, Long parentId) {
//
//        return repository.findBy(StringUtil.getPageable(page,size,textSort),  id,   code, name,  parentId);
//    }
//
//
//    public Relate findById(long id) {
//        Relate entity = repository.getOne(id);
//
//        if (entity == null)
//
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not-found-with-id," + id);
//
//        return entity;
//    }


    public Relate  add(Relate Relate){
        Relate= repository.save(Relate);
        log.info("Add " + "Relate " + Relate);

        return Relate;

    }

//    public Relate  update(Relate Relate){
//        Relate entity = repository.getOne(Relate.getId());
//        if(entity == null){
//            log.info("Not-found-with-id: "  + Relate.getId());
//        }else {
//            Relate= repository.save(Relate);
//
//        log.info("Update " + "Relate " + Relate);
//        }
//
//        return Relate;
//
//    }
//    public Relate deleteById(long id){
//        Relate entity = repository.getOne(id);
//        if(entity == null){
//            log.info("Not-found-with-id: "  + id);
//        }else {
//            repository.deleteById(id);
//        }
//
//        return null;
//    }



}
