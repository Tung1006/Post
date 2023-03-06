package com.cms.conponent.service;

import com.cms.conponent.entity.Site;
import com.cms.conponent.entity.dto.SiteDto;
import com.cms.conponent.repository.SiteRepository;
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
public class SiteService {

    private final Logger log = LoggerFactory.getLogger(SiteService.class);

    @Autowired
    SiteRepository repository;

    public List<Site> findAll() {
        return repository.findAll();
    }
    public Page<SiteDto> findBy(Integer page, Integer size, String[] textSort, Long id, String code, String name, Long parnetId) {

        return repository.findBy(StringUtil.getPageable(page,size,textSort), id,  code,  name,  parnetId);

    }


    public Site findById(long id) {
        Site entity = repository.getOne(id);

        if (entity == null)

            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not-found-with-id," + id);

        return entity;
    }



    public Site  add(Site site){
        site= repository.save(site);
        log.info("Add " + "Site " + site);

        return site;

    }

    public Site  update(Site site){
        Site entity = repository.getOne(site.getId());
        if(entity == null){
            log.info("Not-found-with-id: "  + site.getId());
        }else {
            site= repository.save(site);

        log.info("Update " + "Site " + site);
        }

        return site;

    }
    public Site deleteById(long id){
        Site entity = repository.getOne(id);
        if(entity == null){
            log.info("Not-found-with-id: "  + id);
        }else {
            repository.deleteById(id);
        }

        return null;
    }


}
