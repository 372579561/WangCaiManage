package com.wangcai.com.wangcai.dao;

import com.wangcai.com.wangcai.bean.HomePageImages;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HomePageImagesRepository extends JpaRepository<HomePageImages,Integer> {
     List<HomePageImages> findByStatus(Integer status);
}
