package com.gyuone.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gyuone.dao.BoardDao;
import com.gyuone.model.ArticleVO;

@Service
public class BoardService {
	@Autowired
	BoardDao boardDao;
	
	public List<ArticleVO> listArticles(){
		List<ArticleVO> articleList = boardDao.selectAllArticles();
		return articleList;
	}
	
	public void addArticle(ArticleVO article) {
		boardDao.insertNewArticle(article);
	}
	
	public ArticleVO viewArticle(int articleNo) {
		ArticleVO article;
		article = boardDao.selectArticle(articleNo);
		return article;
	}
}
