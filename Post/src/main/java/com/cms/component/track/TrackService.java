package com.cms.component.track;

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
public class TrackService {

    private final Logger log = LoggerFactory.getLogger(TrackService.class);

    @Autowired
    TrackRepository repository;

    public List<Track> findAll() {
        return repository.findAll();
    }
    public Page<TrackDto> findBy(Integer page, Integer size, String[] textSort, Long id, Long postId, String type) {

        return repository.findBy(StringUtil.getPageable(page,size,textSort), id,  postId, type);

    }


public Track findById(long id) {
    Track entity = repository.getOne(id);

    if (entity == null)

        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not-found-with-id," + id);

    return entity;
}

    public Track  add(Track track){

        track= repository.save(track);
        log.info("Add " + "track " + track);

        return track;

    }

    public Track  update(Track track){
        Track entity = repository.getOne(track.getId());
        if(entity == null){
            log.info("Not-found-with-id: "  + track.getId());
        }else {

            track= repository.save(track);

            log.info("Update " + "track " + track);
        }

        return track;

    }
    public Track deleteById(long id){
        Track entity = repository.getOne(id);
        if(entity == null){
            log.info("Not-found-with-id: "  + id);
        }else {
            repository.deleteById(id);
        }

        return null;
    }



}
