package com.cms.conponent.service;

import com.cms.conponent.entity.Category;
import com.cms.conponent.entity.dto.CategoryDto;
import com.cms.conponent.repository.CategoryRepository;
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
public class RelationShipService {

//    private final Logger log = LoggerFactory.getLogger(RelationShipService.class);
//
//    @Autowired
//    CategoryRepository repository;
//
//    public List<Category> findAll() {
//        return repository.findAll();
//    }
//    public Page<CategoryDto> findBy(Integer page, Integer size, String[] textSort,  Long id,  String code,String name, Long parentId) {
//
//        return repository.findBy(StringUtil.getPageable(page,size,textSort),  id,   code, name,  parentId);
//    }
//
//
//    public Category findById(long id) {
//        Category entity = repository.getOne(id);
//
//        if (entity == null)
//
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not-found-with-id," + id);
//
//        return entity;
//    }
//
//
//    public Category  add(Category category){
//        category= repository.save(category);
//        log.info("Add " + "Category " + category);
//
//        return category;
//
//    }
//
//    public Category  update(Category category){
//        Category entity = repository.getOne(category.getId());
//        if(entity == null){
//            log.info("Not-found-with-id: "  + category.getId());
//        }else {
//            category= repository.save(category);
//
//        log.info("Update " + "Category " + category);
//        }
//
//        return category;
//
//    }
//    public Category deleteById(long id){
//        Category entity = repository.getOne(id);
//        if(entity == null){
//            log.info("Not-found-with-id: "  + id);
//        }else {
//            repository.deleteById(id);
//        }
//
//        return null;
//    }



}
