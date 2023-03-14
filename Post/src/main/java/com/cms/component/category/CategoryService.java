package com.cms.component.category;

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
public class CategoryService {

    private final Logger log = LoggerFactory.getLogger(CategoryService.class);

    @Autowired
    CategoryRepository repository;

    public List<CategoryEntity> findAll() {
        return repository.findAll();
    }
    public Page<CategoryDto> findBy(Integer page, Integer size, String[] textSort,   String code,String name, Long parentId,String keyword) {

        return repository.findBy(StringUtil.getPageable(page,size,textSort),    code, name,  parentId, keyword);
    }


    public CategoryEntity findById(long id) {
        CategoryEntity entity = repository.getOne(id);

        if (entity == null)

            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not-found-with-id," + id);

        return entity;
    }


    public CategoryEntity add(CategoryEntity category){
        category= repository.save(category);
        log.info("Add " + "Category " + category);

        return category;

    }

    public CategoryEntity update(CategoryEntity category){
        CategoryEntity entity = repository.getOne(category.getCategoryId());
        if(entity == null){
            log.info("Not-found-with-id: "  + category.getCategoryId());
        }else {
            category= repository.save(category);

        log.info("Update " + "Category " + category);
        }

        return category;

    }
    public CategoryEntity deleteById(long id){
        CategoryEntity entity = repository.getOne(id);
        if(entity == null){
            log.info("Not-found-with-id: "  + id);
        }else {
            repository.deleteById(id);
        }

        return null;
    }



}
