package com.cms.conponent.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "Category")
public class Category implements Serializable{


    @GeneratedValue(generator = "CategorySeqGen")
    @Id
    @SequenceGenerator(allocationSize = 1, initialValue = 1, name = "CategorySeqGen", sequenceName = "Category_seq")
    @Column(name = "ID")
    private long id;

    @Column(length = 26, name = "CODE")
    private String code;

    @Column(length = 127, name = "NAME")
    private String name;

    @Column(name = "STATUS")
    private Boolean status = false ;

    @Column(length = 11, name = "PRIORITY")
    private Long priority;

    @Column(length = 255, name = "DESCRIPTION")
    private String description;

    @Column(length = 11, name = "MENU")
    private Long menu;

    @Column(length = 11, name = "BLOCK")
    private Long block;

    @Column(length = 11, name = "TOPIC")
    private Long topic;

    @Column(length = 11, name = "EVENT")
    private Long event;

    @Column(length = 20, name = "PARENTID")
    private Long parnetId;

    @Column(length = 20, name = "PARTNERID")
    private Long partnerId;

    public Category() {
    }


    public Category clone() {
        Category clo = new Category();
        clo.setId(this.id);
        clo.setCode(this.code);
        clo.setName(this.name);
        clo.setDescription(this.description);
        clo.setPriority(this.priority);
        clo.setStatus(this.status);
        clo.setDescription(this.description);
        clo.setMenu(this.menu);
        clo.setBlock(this.block);
        clo.setTopic(this.topic);
        clo.setEvent(this.event);
        clo.setParnetId(this.parnetId);
        clo.setPartnerId(this.partnerId);
        return  clo;
    }
}
