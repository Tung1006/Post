package com.cms.component.post;

import com.cms.component.category.CategoryEntity;
import com.cms.component.category.CategoryService;
import com.cms.component.content.ContentRepository;
import com.cms.component.post.entity.PostDto;
import com.cms.component.post.entity.PostEntity;
import com.cms.component.post.entity.PostEntityDto;
import com.cms.component.post.entity.PostInput;
import com.cms.component.relate.Relate;
import com.cms.component.relate.RelateRepository;
import com.cms.component.site.SiteEntity;
import com.cms.component.site.SiteService;
import com.cms.util.StringUtil;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {

    private final Logger log = LoggerFactory.getLogger(PostService.class);

    @Autowired
    PostRepository repository;

    @Autowired
    ContentRepository contentrepository;

    @Autowired
    private SiteService siteService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private RelateRepository relateRepository;


    @Autowired
    private ModelMapper modelMapper;

    public List<PostEntity> findAll() {
        return repository.findAll();
    }

    public ArrayList<PostEntityDto> find(int page, int size, String sort, String column, String keyword) {

        Sort sortable = null;
        if (sort.equals("ASC")) {
            sortable = Sort.by(column).ascending();
        }
        if (sort.equals("DESC")) {
            sortable = Sort.by(column).descending();
        }
        Pageable pageable = PageRequest.of(page, size, sortable);

        Page<PostEntity>  a = repository.getPaging(pageable,keyword);
        ArrayList<PostEntityDto> list = new ArrayList<PostEntityDto>();
        for (PostEntity dto: a){
            PostEntityDto postEntityDto = new PostEntityDto();
            postEntityDto.setPost(dto);
            List<Relate> b = relateRepository.findBy(null,null,dto.getPostId());
            postEntityDto.setRelates(b);
            list.add(postEntityDto);
        }
        return list;
    }


    public Page<PostEntity> findAllBy(int page, int size, String sort, String column, String keyword) {

        Sort sortable = null;
        if (sort.equals("ASC")) {
            sortable = Sort.by(column).ascending();
        }
        if (sort.equals("DESC")) {
            sortable = Sort.by(column).descending();
        }
        Pageable pageable = PageRequest.of(page, size, sortable);
        return repository.getPaging(pageable,keyword);
    }


    public Page<PostEntity> findBy(Integer page, Integer size, String[] textSort, Long id, String author, String code, Long type, String title) {

        Page<PostEntity> a = repository.findBy(StringUtil.getPageable(page,size,textSort),id,  author,  code,  type,  title);
        return a;
    }

    public Page<PostEntity> AnyFieldBy(Integer page, Integer size, String[] textSort, String keyword) {


        return repository.AnyFieldBy(StringUtil.getPageable(page,size,textSort),   keyword);
    }

    public Page<PostDto> findBy1(Integer page, Integer size, String[] textSort, Long id, String author, String code, Long type, String title) {


        return repository.findBy1(StringUtil.getPageable(page,size,textSort),id,  author,  code,  type,  title);
    }


    public PostEntity findById(long id) {
        PostEntity entity = repository.getOne(id);

        if (entity == null)

            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not-found-with-id," + id);

        return entity;
    }


    public PostEntity Clone(long id) {
        PostEntity entity = repository.getOne(id);
        System.out.println("hihi: " + entity.getPostId());


        if (entity == null) {

            log.info("Not found " + id);
        } else {

            PostEntity post = entity.clone();
            post.setPostId(0L);
            post.setCreated(LocalDateTime.now());
            post= repository.save(post);
            return post;
        }


        return entity;
    }

    public PostEntity add(PostEntity post){
        post.setCreated(LocalDateTime.now());
        post.setStatus(true);


        repository.save(post);
        log.info("Add " + "Post " + post);
        return post;
    }


    public PostEntity addCustomer(PostInput post){
        System.out.println("S post: " + post);
        PostInput newPost = post.clone();
        newPost.setCreated(LocalDateTime.now());
        newPost.setStatus(true);
        PostEntity entity = modelMapper.map(newPost, PostEntity.class);


        repository.save(entity);
        try {
            Relate relate = new Relate();
            relate.setPost(entity);
            SiteEntity site = siteService.findById(post.getSiteId());
            CategoryEntity category = categoryService.findById(post.getCategoryId());
            if(site == null ){

                }else {
                    relate.setSite(site);
                    if(category == null){

                    }else {

                    relate.setCategory(category);

                        relateRepository.save(relate);
                    }
                }
        }catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        log.info("Add " + "Post " + post);
        return entity;
    }
    public PostEntity update(PostEntity post){
        PostEntity entity = repository.getOne(post.getPostId());
        if(entity == null){
            log.info("Not-found-with-id: "  + post.getPostId());
        }else {
        post.setCreated(entity.getCreated());
        post.setUpdated(LocalDateTime.now());
        post.setStatus(true);
        post= repository.save(post);

        log.info("Update " + "Post " + post);
        }

        return post;

    }
    public PostEntity deleteById(long id){
        PostEntity entity = repository.getOne(id);
        if(entity == null){
            log.info("Not-found-with-id: "  + id);
        }else {
            repository.deleteById(id);
        }

        return null;
    }

    public PostEntity deleteChangeStatusById(long id){
        PostEntity entity = repository.getOne(id);
        if(entity == null){
            log.info("Not-found-with-id: "  + id);
        }else {
            entity.setStatus(false);
            entity.setUpdated(LocalDateTime.now());

            repository.save(entity);
            log.info("Not-found-with-id: "  + entity.getPostId());
        }

        return entity;
    }

    public Object deleteMany(PostEntity post){


        if(post == null){
            log.info("Not-found-with-id: "  + post.getPostId());
        }else {
            post.setUpdated(LocalDateTime.now());
            post.setStatus(false);

            repository.save(post);
        }

        return null;
    }



}
