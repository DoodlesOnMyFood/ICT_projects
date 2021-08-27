package com.example.demo;

import com.example.demo.dao.StatisticMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	StatisticMapper mapper;


	@Test
	void mapper() {
		System.out.println(mapper.selectYearMonthDepartment("2101", "test"));
	}


}
