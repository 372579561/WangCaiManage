package com.wangcai.model;

import javax.persistence.*;

@Entity(name = "t_album")
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    private String resume;

    private String writer;

    private Integer isCharge;

    private Integer price;//从分开始

    private Integer popularty;
    @OneToOne
    private Images images;
    @OneToMany
    private AlbumToLable albumToLable;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public Integer getIsCharge() {
        return isCharge;
    }

    public void setIsCharge(Integer isCharge) {
        this.isCharge = isCharge;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getPopularty() {
        return popularty;
    }

    public void setPopularty(Integer popularty) {
        this.popularty = popularty;
    }

    public Images getImages() {
        return images;
    }

    public void setImages(Images images) {
        this.images = images;
    }

    public AlbumToLable getAlbumToLable() {
        return albumToLable;
    }

    public void setAlbumToLable(AlbumToLable albumToLable) {
        this.albumToLable = albumToLable;
    }
}
