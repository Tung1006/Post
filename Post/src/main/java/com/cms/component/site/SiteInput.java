package com.cms.component.site;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class SiteInput {
    private long id;
    private String code;
    private String name;
    private String language;
    private String description;
    private Long parnetId;

    public SiteInput() {
    }

}
