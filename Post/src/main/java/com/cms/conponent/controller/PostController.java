package com.cms.conponent.controller;

import com.cms.common.ResponseBean;
import com.cms.conponent.entity.Post;
import com.cms.conponent.entity.imports.PostInput;
import com.cms.conponent.service.PostService;
import com.cms.util.Constant;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Sort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequestMapping("/api/post/")
@Tag(name = "01-Post API")
@RestController
public class PostController {

    @Autowired
    PostService service;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/getAll")
    @Operation(summary = "[Lấy tất cả danh sách Post]")
    public ResponseEntity<?> findAll() {
        ResponseBean resBean = new ResponseBean();
        resBean.setCode(HttpStatus.OK.toString());
        resBean.setMessage(Constant.SUCCESS);
        resBean.setData(service.findAll());
        return new ResponseEntity<>(resBean, HttpStatus.OK);
    }



    @GetMapping("/getAllBy")
    @Operation(summary = "[Lấy tất cả danh sách Post]")
    public ResponseEntity<?> findAllBy(@RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
                                       @RequestParam(name = "size", required = false, defaultValue = "10") Integer size,
                                     @RequestParam(name = "sort", required = false, defaultValue = "ASC") String sort,
                                     @RequestParam(name = "column", required = false, defaultValue = "CREATED") String column) {
        ResponseBean resBean = new ResponseBean();
        resBean.setCode(HttpStatus.OK.toString());
        resBean.setMessage(Constant.SUCCESS);
        resBean.setData(service.findAllBy(page, size,sort,column));
        return new ResponseEntity<>(resBean, HttpStatus.OK);
    }

    @GetMapping("/findBy")
    @Operation(summary = "[Lấy tất cả danh sách Post]")
    public ResponseEntity<?> findBy(@RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
                                    @RequestParam(name = "size", required = false, defaultValue = "10") Integer size,
                                    @RequestParam(required = false, name = "textSort") String[] textSort,
                                    @RequestParam(name = "id", required = false) Long id,
                                    @RequestParam(name = "author", required = false) String author,
                                    @RequestParam(name = "code", required = false) String code,
                                    @RequestParam(name = "type", required = false) Long type,
                                    @RequestParam(name = "title", required = false) String title) {
        ResponseBean resBean = new ResponseBean();
        resBean.setCode(HttpStatus.OK.toString());
        resBean.setMessage(Constant.SUCCESS);
        resBean.setData(service.findBy(page, size,textSort, id,  author,  code,  type,  title));
        return new ResponseEntity<>(resBean, HttpStatus.OK);
    }

    @GetMapping("/findByDto")
    @Operation(summary = "[Lấy tất cả danh sách Post]")
    public ResponseEntity<?> findBy1(@RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
                                    @RequestParam(name = "size", required = false, defaultValue = "10") Integer size,
                                    @RequestParam(required = false, name = "textSort") String[] textSort,
                                    @RequestParam(name = "id", required = false) Long id,
                                    @RequestParam(name = "author", required = false) String author,
                                    @RequestParam(name = "code", required = false) String code,
                                    @RequestParam(name = "type", required = false) Long type,
                                    @RequestParam(name = "title", required = false) String title) {
        ResponseBean resBean = new ResponseBean();
        resBean.setCode(HttpStatus.OK.toString());
        resBean.setMessage(Constant.SUCCESS);
        resBean.setData(service.findBy1(page, size,textSort, id,  author,  code,  type,  title));
        return new ResponseEntity<>(resBean, HttpStatus.OK);
    }


    @GetMapping("/findById/{id}")
    @Operation(summary = "[Lấy 1 Post]")
    public ResponseEntity<?> findById(@PathVariable("id") long id) {
        ResponseBean resBean = new ResponseBean();
        resBean.setCode(HttpStatus.OK.toString());
        resBean.setMessage(Constant.SUCCESS);
        resBean.setData(service.findById(id));
        return new ResponseEntity<>(resBean, HttpStatus.OK);
    }


    @PostMapping("/cloneById/{id}")
    @Operation(summary = "[Clone 1 Post]")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> cloneById(@PathVariable("id") long id) {
        ResponseBean resBean = new ResponseBean();
        resBean.setCode(HttpStatus.OK.toString());
        resBean.setMessage(Constant.SUCCESS);

        resBean.setData(service.Clone(id));
        return new ResponseEntity<>(resBean, HttpStatus.OK);
    }
    @PostMapping("/add")
    @Operation(summary = "[Thêm mới một Post]")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Object> add(@RequestBody @Valid PostInput post) {
        ResponseBean resBean = new ResponseBean();
        resBean.setCode(HttpStatus.OK.toString());
        resBean.setMessage(Constant.SUCCESS);
        Post entity = modelMapper.map(post, Post.class);
        resBean.setData(service.add(entity));
        return new ResponseEntity<>(resBean, HttpStatus.OK);
    }


    @PostMapping("/addMany")
    @Operation(summary = "[Thêm nhiều Post]")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Object> addMany(@RequestBody @Valid List<PostInput> lstDto) {
        if ((lstDto == null) || lstDto.isEmpty())

            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Empty list");
        for (PostInput dto : lstDto) {
            add(dto);

        }

        ResponseBean resBean = new ResponseBean();
        resBean.setCode(HttpStatus.OK.toString());
        resBean.setMessage(Constant.SUCCESS);
        resBean.setData(Constant.SUCCESS);
        return new ResponseEntity<>(resBean, HttpStatus.OK);
    }


    @PutMapping("/update")
    @Operation(summary = "[Cập nhật một Post]")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Object> update(@RequestBody @Valid PostInput post) {
        ResponseBean resBean = new ResponseBean();
        resBean.setCode(HttpStatus.OK.toString());
        resBean.setMessage(Constant.SUCCESS);
        Post entity = modelMapper.map(post, Post.class);
        resBean.setData(service.update(entity));
        return new ResponseEntity<>(resBean, HttpStatus.OK);
    }


    @DeleteMapping ("/delete/{id}")
    @Operation(summary = "[Xóa vĩnh viễn một Post]")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Object> deleteById(@PathVariable("id") long id) {
        ResponseBean resBean = new ResponseBean();
        resBean.setCode(HttpStatus.OK.toString());
        resBean.setMessage(Constant.SUCCESS);
        resBean.setData(service.deleteById(id));
        return new ResponseEntity<>(resBean, HttpStatus.OK);
    }


    @DeleteMapping ("/delete/ChangeStatusById/{id}")
    @Operation(summary = "[Xóa 1 nhưng chuyển trạng thái một Post]")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Object> deleteChangeStatusById(@PathVariable("id") long id) {
        ResponseBean resBean = new ResponseBean();
        resBean.setCode(HttpStatus.OK.toString());
        resBean.setMessage(Constant.SUCCESS);
        resBean.setData(service.deleteChangeStatusById(id));
        return new ResponseEntity<>(resBean, HttpStatus.OK);
    }

    @DeleteMapping ("/delete")
    @Operation(summary = "[Xóa nhiều nhưng chuyển trạng thái một Post]")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Object> deleteMany(@RequestBody @Valid List<Post> lstDto) {
        if ((lstDto == null) || lstDto.isEmpty()){

            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Empty list");
        }

        ResponseBean resBean = new ResponseBean();
        resBean.setCode(HttpStatus.OK.toString());
        resBean.setMessage(Constant.SUCCESS);
        for (Post dto: lstDto){
            service.deleteMany(dto);
        }
        resBean.setData(Constant.SUCCESS);
        return new ResponseEntity<>(resBean, HttpStatus.OK);
    }


}
