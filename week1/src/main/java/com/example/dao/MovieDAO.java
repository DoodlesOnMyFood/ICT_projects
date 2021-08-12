package com.example.dao;

import com.example.vo.MovieVO;

import java.util.List;

public interface MovieDAO {
    public List<MovieVO> selectMovie() throws Exception;
}
