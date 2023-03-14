package com.cms.component.site;

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
public class SiteService {

    private final Logger log = LoggerFactory.getLogger(SiteService.class);

    @Autowired
    SiteRepository repository;

    public List<SiteEntity> findAll() {
        return repository.findAll();
    }
    public Page<SiteDto> findBy(Integer page, Integer size, String[] textSort, Long id, String code, String name, Long parnetId) {

        return repository.findBy(StringUtil.getPageable(page,size,textSort), id,  code,  name,  parnetId);

    }


    public SiteEntity findById(long id) {
        SiteEntity entity = repository.getOne(id);

        if (entity == null)

            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not-found-with-id," + id);

        return entity;
    }



    public SiteEntity add(SiteEntity site){
        site= repository.save(site);
        log.info("Add " + "Site " + site);

        return site;

    }

    public SiteEntity update(SiteEntity site){
        SiteEntity entity = repository.getOne(site.getSiteId());
        if(entity == null){
            log.info("Not-found-with-id: "  + site.getSiteId());
        }else {
            site= repository.save(site);

        log.info("Update " + "Site " + site);
        }

        return site;

    }
    public SiteEntity deleteById(long id){
        SiteEntity entity = repository.getOne(id);
        if(entity == null){
            log.info("Not-found-with-id: "  + id);
        }else {
            repository.deleteById(id);
        }

        return null;
    }


}
