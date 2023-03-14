package com.cms.component.track;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class TrackInput {
    private long trackId;
    private String type;
    private String time;
    private String description;
    private String userId;
    private Long postId;

    public TrackInput() {
    }



}
