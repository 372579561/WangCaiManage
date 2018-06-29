package com.wangcai.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="t_images")
public class Images {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String imagesLocation;

    private Integer status;

    private String hyperLink;

    private String imagesType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImagesLocation() {
        return imagesLocation;
    }

    public void setImagesLocation(String imagesLocation) {
        this.imagesLocation = imagesLocation;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getHyperLink() {
        return hyperLink;
    }

    public void setHyperLink(String hyperLink) {
        this.hyperLink = hyperLink;
    }

    public String getImagesType() {
        return imagesType;
    }

    public void setImagesType(String imagesType) {
        this.imagesType = imagesType;
    }
}
