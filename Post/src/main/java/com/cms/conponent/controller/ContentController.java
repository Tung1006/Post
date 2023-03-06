package com.cms.conponent.controller;

import com.cms.common.ResponseBean;
import com.cms.conponent.entity.Category;
import com.cms.conponent.entity.imports.ContentInput;
import com.cms.conponent.entity.join.Content;
import com.cms.conponent.service.ContentService;
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

@RequestMapping("/api/content/")
@Tag(name = "06-Content API")
@RestController
public class ContentController {




}
