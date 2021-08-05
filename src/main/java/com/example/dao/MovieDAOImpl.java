package com.example.dao;

import com.example.vo.MovieVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MovieDAOImpl implements MovieDAO{
    @Autowired
    private SqlSession sqlSession;
    private static final String nameSpace = "com.example.mybatis.sql.test";

    @Override
    public List<MovieVO> selectMovie() {
        return sqlSession.selectList(nameSpace + ".selectMovie");
    }
}
