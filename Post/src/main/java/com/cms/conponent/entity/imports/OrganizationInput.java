package com.cms.conponent.entity.imports;


import com.cms.conponent.entity.join.RelationShip;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Data
@Getter
@Setter
public class OrganizationInput {
    private long id;
    private String code;
    private String name;
    private Long priority;
    private String description;
    private Long parnetId;

    public OrganizationInput() {
    }


}
