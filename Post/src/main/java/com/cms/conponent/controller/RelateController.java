package com.cms.conponent.controller;

import com.cms.common.ResponseBean;
import com.cms.conponent.entity.Category;
import com.cms.conponent.entity.imports.CategoryInput;
import com.cms.conponent.entity.imports.RelateInput;
import com.cms.conponent.entity.join.Relate;
import com.cms.conponent.service.CategoryService;
import com.cms.conponent.service.RelateService;
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

@RequestMapping("/api/relate/")
@Tag(name = "07-relate API")
@RestController
public class RelateController {



    @Autowired
    RelateService service;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/getAll")
    @Operation(summary = "[Lấy tất cả danh sách Relate]")
    public ResponseEntity<?> findAll() {
        ResponseBean resBean = new ResponseBean();
        resBean.setCode(HttpStatus.OK.toString());
        resBean.setMessage(Constant.SUCCESS);
        resBean.setData(service.findAll());
        return new ResponseEntity<>(resBean, HttpStatus.OK);
    }



//    @GetMapping("/getAllBy")
//    @Operation(summary = "[Lấy tất cả danh sách Relate]")
//    public ResponseEntity<?> findAllBy(@RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
//                                       @RequestParam(name = "size", required = false, defaultValue = "10") Integer size,
//                                       @RequestParam(name = "sort", required = false, defaultValue = "ASC") String sort,
//                                       @RequestParam(name = "column", required = false, defaultValue = "CREATED") String column) {
//        ResponseBean resBean = new ResponseBean();
//        resBean.setCode(HttpStatus.OK.toString());
//        resBean.setMessage(Constant.SUCCESS);
//        resBean.setData(service.findAllBy(page, size,sort,column));
//        return new ResponseEntity<>(resBean, HttpStatus.OK);
//    }
//
//    @GetMapping("/findBy")
//    @Operation(summary = "[Lấy tất cả danh sách Relate]")
//    public ResponseEntity<?> findBy(@RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
//                                    @RequestParam(name = "size", required = false, defaultValue = "10") Integer size,
//                                    @RequestParam(required = false, name = "textSort") String[] textSort,
//                                    @RequestParam(name = "id", required = false) Long id,
//                                    @RequestParam(name = "author", required = false) String author,
//                                    @RequestParam(name = "code", required = false) String code,
//                                    @RequestParam(name = "type", required = false) Long type,
//                                    @RequestParam(name = "title", required = false) String title) {
//        ResponseBean resBean = new ResponseBean();
//        resBean.setCode(HttpStatus.OK.toString());
//        resBean.setMessage(Constant.SUCCESS);
//        resBean.setData(service.findBy(page, size,textSort, id,  author,  code,  type,  title));
//        return new ResponseEntity<>(resBean, HttpStatus.OK);
//    }
//
//    @GetMapping("/findByDto")
//    @Operation(summary = "[Lấy tất cả danh sách Relate]")
//    public ResponseEntity<?> findBy1(@RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
//                                     @RequestParam(name = "size", required = false, defaultValue = "10") Integer size,
//                                     @RequestParam(required = false, name = "textSort") String[] textSort,
//                                     @RequestParam(name = "id", required = false) Long id,
//                                     @RequestParam(name = "author", required = false) String author,
//                                     @RequestParam(name = "code", required = false) String code,
//                                     @RequestParam(name = "type", required = false) Long type,
//                                     @RequestParam(name = "title", required = false) String title) {
//        ResponseBean resBean = new ResponseBean();
//        resBean.setCode(HttpStatus.OK.toString());
//        resBean.setMessage(Constant.SUCCESS);
//        resBean.setData(service.findBy1(page, size,textSort, id,  author,  code,  type,  title));
//        return new ResponseEntity<>(resBean, HttpStatus.OK);
//    }
//
//
//    @GetMapping("/findById/{id}")
//    @Operation(summary = "[Lấy 1 Relate]")
//    public ResponseEntity<?> findById(@PathVariable("id") long id) {
//        ResponseBean resBean = new ResponseBean();
//        resBean.setCode(HttpStatus.OK.toString());
//        resBean.setMessage(Constant.SUCCESS);
//        resBean.setData(service.findById(id));
//        return new ResponseEntity<>(resBean, HttpStatus.OK);
//    }
//
//
//    @RelateMapping("/cloneById/{id}")
//    @Operation(summary = "[Clone 1 Relate]")
//    @ResponseStatus(HttpStatus.CREATED)
//    public ResponseEntity<?> cloneById(@PathVariable("id") long id) {
//        ResponseBean resBean = new ResponseBean();
//        resBean.setCode(HttpStatus.OK.toString());
//        resBean.setMessage(Constant.SUCCESS);
//
//        resBean.setData(service.Clone(id));
//        return new ResponseEntity<>(resBean, HttpStatus.OK);
//    }
    @PostMapping("/add")
    @Operation(summary = "[Thêm mới một Relate]")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Object> add(@RequestBody @Valid RelateInput relate) {
        ResponseBean resBean = new ResponseBean();
        resBean.setCode(HttpStatus.OK.toString());
        resBean.setMessage(Constant.SUCCESS);
        Relate entity = modelMapper.map(relate, Relate.class);
        resBean.setData(service.add(entity));
        return new ResponseEntity<>(resBean, HttpStatus.OK);
    }

//    @RelateMapping("/add")
//    @Operation(summary = "[Thêm mới một Relate]")
//    @ResponseStatus(HttpStatus.CREATED)
//    public ResponseEntity<Object> add(@RequestBody @Valid Relate Relate) {
//        ResponseBean resBean = new ResponseBean();
//        resBean.setCode(HttpStatus.OK.toString());
//        resBean.setMessage(Constant.SUCCESS);
//        resBean.setData(service.add(Relate));
//        return new ResponseEntity<>(resBean, HttpStatus.OK);
//    }


//    @RelateMapping("/addMany")
//    @Operation(summary = "[Thêm nhiều Relate]")
//    @ResponseStatus(HttpStatus.CREATED)
//    public ResponseEntity<Object> addMany(@RequestBody @Valid List<RelateInput> lstDto) {
//        if ((lstDto == null) || lstDto.isEmpty())
//
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Empty list");
//        for (RelateInput dto : lstDto) {
//            add(dto);
//
//        }
//
//        ResponseBean resBean = new ResponseBean();
//        resBean.setCode(HttpStatus.OK.toString());
//        resBean.setMessage(Constant.SUCCESS);
//        resBean.setData(Constant.SUCCESS);
//        return new ResponseEntity<>(resBean, HttpStatus.OK);
//    }
//
//
//    @PutMapping("/update")
//    @Operation(summary = "[Cập nhật một Relate]")
//    @ResponseStatus(HttpStatus.CREATED)
//    public ResponseEntity<Object> update(@RequestBody @Valid RelateInput Relate) {
//        ResponseBean resBean = new ResponseBean();
//        resBean.setCode(HttpStatus.OK.toString());
//        resBean.setMessage(Constant.SUCCESS);
//        Relate entity = modelMapper.map(Relate, Relate.class);
//        resBean.setData(service.update(entity));
//        return new ResponseEntity<>(resBean, HttpStatus.OK);
//    }
//
//
//    @DeleteMapping ("/delete/{id}")
//    @Operation(summary = "[Xóa vĩnh viễn một Relate]")
//    @ResponseStatus(HttpStatus.CREATED)
//    public ResponseEntity<Object> deleteById(@PathVariable("id") long id) {
//        ResponseBean resBean = new ResponseBean();
//        resBean.setCode(HttpStatus.OK.toString());
//        resBean.setMessage(Constant.SUCCESS);
//        resBean.setData(service.deleteById(id));
//        return new ResponseEntity<>(resBean, HttpStatus.OK);
//    }
//
//
//    @DeleteMapping ("/delete/ChangeStatusById/{id}")
//    @Operation(summary = "[Xóa 1 nhưng chuyển trạng thái một Relate]")
//    @ResponseStatus(HttpStatus.CREATED)
//    public ResponseEntity<Object> deleteChangeStatusById(@PathVariable("id") long id) {
//        ResponseBean resBean = new ResponseBean();
//        resBean.setCode(HttpStatus.OK.toString());
//        resBean.setMessage(Constant.SUCCESS);
//        resBean.setData(service.deleteChangeStatusById(id));
//        return new ResponseEntity<>(resBean, HttpStatus.OK);
//    }
//
//    @DeleteMapping ("/delete")
//    @Operation(summary = "[Xóa nhiều nhưng chuyển trạng thái một Relate]")
//    @ResponseStatus(HttpStatus.CREATED)
//    public ResponseEntity<Object> deleteMany(@RequestBody @Valid List<Relate> lstDto) {
//        if ((lstDto == null) || lstDto.isEmpty()){
//
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Empty list");
//        }
//
//        ResponseBean resBean = new ResponseBean();
//        resBean.setCode(HttpStatus.OK.toString());
//        resBean.setMessage(Constant.SUCCESS);
//        for (Relate dto: lstDto){
//            service.deleteMany(dto);
//        }
//        resBean.setData(Constant.SUCCESS);
//        return new ResponseEntity<>(resBean, HttpStatus.OK);
//    }





}
