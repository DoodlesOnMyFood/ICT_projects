package com.example.service;

import com.example.dao.MovieDAO;
import com.example.vo.MovieVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    private MovieDAO dao;
    @Override
    public List<MovieVO> selectMovie() throws Exception{
        return dao.selectMovie();
    }
}
