package com.gyuone.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.gyuone.controller.BoardController;
import com.gyuone.dao.BoardDao;
import com.gyuone.model.ArticleVO;
import com.gyuone.service.BoardService;

@Configuration
@ComponentScan(basePackages= {"com.gyuone.config, com.gyuone.service"})
public class ControllerConfig {
	@Bean
	public ArticleVO articleVO() {
		return new ArticleVO();
	}

	@Bean
	public BoardDao boardDao() {
		return new BoardDao();
	}

//	@Bean
//	public BoardService boardService() {
//		return new BoardService();
//	}
	
	@Bean
	public BoardController boardController() {
		return new BoardController();
	}
}
