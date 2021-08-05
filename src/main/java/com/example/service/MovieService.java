package com.example.service;

import com.example.vo.MovieVO;

import java.util.List;

public interface MovieService {
    public List<MovieVO> selectMovie() throws Exception;
}
