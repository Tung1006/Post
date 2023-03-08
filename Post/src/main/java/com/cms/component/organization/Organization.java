package com.cms.component.organization;


import com.cms.component.acc.RelationShip;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "Organization")
public class Organization implements Serializable{


    @GeneratedValue(generator = "OrganizationSeqGen")
    @Id
    @SequenceGenerator(allocationSize = 1, initialValue = 1, name = "OrganizationSeqGen", sequenceName = "Organization_seq")
    @Column(name = "ID")
    private long id;

    @Column(length = 26, name = "CODE")
    private String code;

    @Column(length = 127, name = "NAME")
    private String name;

    @Column(length = 11, name = "PRIORITY")
    private Long priority;

    @Column(length = 255, name = "DESCRIPTION")
    private String description;

    @Column(length = 20, name = "PARNETID")
    private Long parnetId;

//    @OneToMany(mappedBy = "organization")
////    Set<RelationShip> relationShips;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "organization")
    @Column(insertable = false, updatable = false)
    Set<RelationShip> relationShips;

    public Organization() {
    }


    public Organization clone() {
        Organization clo = new Organization();
        clo.setId(this.id);
        clo.setCode(this.code);
        clo.setName(this.name);
        clo.setDescription(this.description);
        clo.setPriority(this.priority);
        clo.setParnetId(this.parnetId);
        return  clo;
    }
}
