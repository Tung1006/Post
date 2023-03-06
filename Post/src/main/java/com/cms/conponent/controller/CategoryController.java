package com.cms.conponent.controller;

import com.cms.common.ResponseBean;
import com.cms.conponent.entity.Category;
import com.cms.conponent.entity.Post;
import com.cms.conponent.entity.imports.CategoryInput;
import com.cms.conponent.service.CategoryService;
import com.cms.util.Constant;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/api/category/")
@Tag(name = "04-Category API")
@RestController
public class CategoryController {

    @Autowired
    CategoryService service;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/getAll")
    @Operation(summary = "[Lấy tất cả danh sách Category]")
    public ResponseEntity<?> findAll() {
        ResponseBean resBean = new ResponseBean();
        resBean.setCode(HttpStatus.OK.toString());
        resBean.setMessage(Constant.SUCCESS);
        resBean.setData(service.findAll());
        return new ResponseEntity<>(resBean, HttpStatus.OK);
    }



    @GetMapping("/findBy")
    @Operation(summary = "[Lấy tất cả danh sách Category]")
    public ResponseEntity<?> findBy(@RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
                                       @RequestParam(name = "size", required = false, defaultValue = "10") Integer size,
                                    @RequestParam(required = false, name = "textSort") String[] textSort,
                                       @RequestParam(name = "id", required = false) Long id,
                                    @RequestParam(name = "code", required = false) String code,
                                    @RequestParam(name = "name", required = false) String name,
                                    @RequestParam(name = "parentId", required = false) Long parentId) {
        ResponseBean resBean = new ResponseBean();
        resBean.setCode(HttpStatus.OK.toString());
        resBean.setMessage(Constant.SUCCESS);
        resBean.setData(service.findBy(page, size,textSort,   id,   code, name,  parentId));
        return new ResponseEntity<>(resBean, HttpStatus.OK);
    }


    @GetMapping("/findById/{id}")
    @Operation(summary = "[Lấy 1 Category]")
    public ResponseEntity<?> findById(@PathVariable("id") long id) {
        ResponseBean resBean = new ResponseBean();
        resBean.setCode(HttpStatus.OK.toString());
        resBean.setMessage(Constant.SUCCESS);
        resBean.setData(service.findById(id));
        return new ResponseEntity<>(resBean, HttpStatus.OK);
    }


    @PostMapping("/add")
    @Operation(summary = "[Thêm mới một Category]")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Object> add(@RequestBody @Valid CategoryInput category) {
        ResponseBean resBean = new ResponseBean();
        resBean.setCode(HttpStatus.OK.toString());
        resBean.setMessage(Constant.SUCCESS);
        Category entity = modelMapper.map(category, Category.class);
        resBean.setData(service.add(entity));
        return new ResponseEntity<>(resBean, HttpStatus.OK);
    }


    @PostMapping("/addMany")
    @Operation(summary = "[Thêm nhiều Category]")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Object> addMany(@RequestBody @Valid List<CategoryInput> lstDto) {
        if ((lstDto == null) || lstDto.isEmpty())

            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Empty list");
        for (CategoryInput dto : lstDto) {
            add(dto);

        }

        ResponseBean resBean = new ResponseBean();
        resBean.setCode(HttpStatus.OK.toString());
        resBean.setMessage(Constant.SUCCESS);
        resBean.setData(Constant.SUCCESS);
        return new ResponseEntity<>(resBean, HttpStatus.OK);
    }


    @PutMapping("/update")
    @Operation(summary = "[Cập nhật một Category]")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Object> update(@RequestBody @Valid CategoryInput category) {
        ResponseBean resBean = new ResponseBean();
        resBean.setCode(HttpStatus.OK.toString());
        resBean.setMessage(Constant.SUCCESS);
        Category entity = modelMapper.map(category, Category.class);
        resBean.setData(service.update(entity));
        return new ResponseEntity<>(resBean, HttpStatus.OK);
    }


    @DeleteMapping ("/delete/{id}")
    @Operation(summary = "[Xóa vĩnh viễn một Category]")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Object> deleteById(@PathVariable("id") long id) {
        ResponseBean resBean = new ResponseBean();
        resBean.setCode(HttpStatus.OK.toString());
        resBean.setMessage(Constant.SUCCESS);
        resBean.setData(service.deleteById(id));
        return new ResponseEntity<>(resBean, HttpStatus.OK);
    }


}
