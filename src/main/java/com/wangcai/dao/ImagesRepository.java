package com.wangcai.dao;

import com.wangcai.model.Images;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImagesRepository extends JpaRepository<Images,Integer> {
     List<Images> findByStatus(Integer status);
}
