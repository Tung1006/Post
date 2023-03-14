package com.cms.component.content;

import com.cms.common.Constants;
import com.cms.common.ResponseBean;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import javax.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@RequestMapping("/api/content/")
@Tag(name = "06-Content API")
@RestController
public class ContentRest {

    @Autowired
    ContentService service;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/getAll")
    @Operation(summary = "[Lấy tất cả danh sách Content]")
    public ResponseEntity<?> getAll() {
        ResponseBean resBean = new ResponseBean();
        resBean.setCode(HttpStatus.OK.toString());
        resBean.setMessage(Constants.SUCCESS);
        resBean.setData(service.getAll());
        return new ResponseEntity<>(resBean, HttpStatus.OK);
    }

    @GetMapping("/findByContent")
    @Operation(summary = "[Lấy tất cả danh sách Post]")
    public ResponseEntity<?> findByContent(@RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
                                       @RequestParam(name = "size", required = false, defaultValue = "10") Integer size,
                                       @RequestParam(name = "sort", required = false, defaultValue = "ASC") String sort,
                                       @RequestParam(name = "column", required = false, defaultValue = "CREATED") String column,
                                       @RequestParam(name = "content", required = false) String content) {
        ResponseBean resBean = new ResponseBean();
        resBean.setCode(HttpStatus.OK.toString());
        resBean.setMessage(Constants.SUCCESS);
        resBean.setData(service.findByContent(page, size,sort,column,content));
        return new ResponseEntity<>(resBean, HttpStatus.OK);
    }


    @GetMapping("/findById/{id}")
    @Operation(summary = "[Lấy 1 Content]")
    public ResponseEntity<?> findById(@PathVariable("id") long id) {
        ResponseBean resBean = new ResponseBean();
        resBean.setCode(HttpStatus.OK.toString());
        resBean.setMessage(Constants.SUCCESS);
        resBean.setData(service.findById(id));
        return new ResponseEntity<>(resBean, HttpStatus.OK);
    }
    @PostMapping("/add")
    @Operation(summary = "[Thêm mới một Content]")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Object> add(@RequestBody @Valid ContentInput content) {
        ResponseBean resBean = new ResponseBean();
        resBean.setCode(HttpStatus.OK.toString());
        resBean.setMessage(Constants.SUCCESS);
        ContentEntity entity = modelMapper.map(content, ContentEntity.class);
        resBean.setData(service.add(entity));
        return new ResponseEntity<>(resBean, HttpStatus.OK);
    }


    @PostMapping("/addMany")
    @Operation(summary = "[Thêm nhiều Content]")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Object> addMany(@RequestBody @Valid List<ContentInput> lstDto) {
        if ((lstDto == null) || lstDto.isEmpty())

            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Empty list");
        for (ContentInput dto : lstDto) {
            add(dto);

        }

        ResponseBean resBean = new ResponseBean();
        resBean.setCode(HttpStatus.OK.toString());
        resBean.setMessage(Constants.SUCCESS);
        resBean.setData(Constants.SUCCESS);
        return new ResponseEntity<>(resBean, HttpStatus.OK);
    }


    @PutMapping("/update")
    @Operation(summary = "[Cập nhật một Content]")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Object> update(@RequestBody @Valid ContentInput Content) {
        ResponseBean resBean = new ResponseBean();
        resBean.setCode(HttpStatus.OK.toString());
        resBean.setMessage(Constants.SUCCESS);
        ContentEntity entity = modelMapper.map(Content, ContentEntity.class);
        resBean.setData(service.update(entity));
        return new ResponseEntity<>(resBean, HttpStatus.OK);
    }


    @DeleteMapping ("/delete/{id}")
    @Operation(summary = "[Xóa vĩnh viễn một Content]")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Object> deleteById(@PathVariable("id") long id) {
        ResponseBean resBean = new ResponseBean();
        resBean.setCode(HttpStatus.OK.toString());
        resBean.setMessage(Constants.SUCCESS);
        resBean.setData(service.deleteById(id));
        return new ResponseEntity<>(resBean, HttpStatus.OK);
    }


}
