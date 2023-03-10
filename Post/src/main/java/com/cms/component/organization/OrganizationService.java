package com.cms.component.organization;

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
public class OrganizationService {

    private final Logger log = LoggerFactory.getLogger(OrganizationService.class);

    @Autowired
    OrganizationRepository repository;

    public List<OrganizationEntity> findAll() {
        return repository.findAll();
    }

    public Page<OrganizationDto> findBy(Integer page, Integer size, String[] textSort, Long id, String code, String name, Long parnetId) {

        return  repository.findBy(StringUtil.getPageable(page,size,textSort), id,  code, name, parnetId);

    }


    public OrganizationEntity findById(long id) {
        OrganizationEntity entity = repository.getOne(id);

        if (entity == null)

            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not-found-with-id," + id);

        return entity;
    }

    public OrganizationEntity add(OrganizationEntity organization){

        organization= repository.save(organization);
        log.info("Add " + "Organization " + organization);

        return organization;

    }

    public OrganizationEntity update(OrganizationEntity organization){
        OrganizationEntity entity = repository.getOne(organization.getOrganizationId());
        if(entity == null){
            log.info("Not-found-with-id: "  + organization.getOrganizationId());
        }else {
            organization= repository.save(organization);

        log.info("Update " + "Organization " + organization);
        }

        return organization;

    }
    public OrganizationEntity deleteById(long id){
        OrganizationEntity entity = repository.getOne(id);
        if(entity == null){
            log.info("Not-found-with-id: "  + id);
        }else {
            repository.deleteById(id);
        }

        return null;
    }


}
