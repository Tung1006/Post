package com.cms.conponent.entity;

import com.cms.conponent.entity.join.Relate;
import com.cms.conponent.entity.join.RelationShip;
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
@Table(name = "Site")
public class Site implements Serializable{

    @GeneratedValue(generator = "SiteSeqGen")
    @Id
    @SequenceGenerator(allocationSize = 1, initialValue = 1, name = "SiteSeqGen", sequenceName = "Site_seq")
    @Column(name = "ID")
    private long id;


    @Column(length = 26, name = "CODE")
    private String code;

    @Column(length = 127, name = "NAME")
    private String name;

    @Column(length = 255, name = "LANGUAGE")
    private String language;

    @Column(length = 255, name = "DESCRIPTION")
    private String description;

    @Column(length = 20, name = "PARNETID")
    private Long parnetId;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "site")
    @Column(insertable = false, updatable = false)
    Set<RelationShip> relationShips;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "site")
    @Column(insertable = false, updatable = false)
    Set<Relate> relate;

    public Site() {
    }

    public Site Clone(){
        Site clo = new Site();
        clo.setId(this.id);
        clo.setCode(this.code);
        clo.setName(this.name);
        clo.setDescription(this.description);
        clo.setLanguage(this.language);
        clo.setParnetId(this.parnetId);
        return clo;
    }

}
