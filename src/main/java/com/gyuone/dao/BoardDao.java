package com.gyuone.dao;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.gyuone.model.ArticleVO;

public class BoardDao {
	private static SqlSessionFactory sessionFactory = null;
	
	public static SqlSessionFactory getInstance() {
		if(sessionFactory == null) {
			try {
				String resource = "mybatis-config.xml";
				Reader reader = Resources.getResourceAsReader(resource);
				sessionFactory = new SqlSessionFactoryBuilder().build(reader);
				reader.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return sessionFactory;
	}

	public List<ArticleVO> selectAllArticles() {
		sessionFactory = getInstance();
		SqlSession session = sessionFactory.openSession();
		List<ArticleVO> articleList = session.selectList("mapper.article.selectAllArticles"); // 리스트 타입으로 던져준다.
		session.close();
		return articleList;
	}
	
	public void insertNewArticle(ArticleVO article) {
		sessionFactory = getInstance();
		SqlSession session = sessionFactory.openSession();
		session.insert("mapper.article.insertArticle", article);
		session.commit();
//		session.close(); commit을 때리면 알아서 해주기 때문에 close 안해도 된다.
	}
	
	public ArticleVO selectArticle(int articleNo) {
		sessionFactory = getInstance();
		SqlSession session = sessionFactory.openSession();
		ArticleVO article;
		article = session.selectOne("mapper.article.selectArticle", articleNo);
		session.close();
		return article;
	}
	
	public void updateArticle(ArticleVO article) {
		sessionFactory = getInstance();
		SqlSession session = sessionFactory.openSession();
		session.update("mapper.article.updateArticle", article);
		session.commit();
	}
	
	public void deleteArticle(int articleNo) {
		sessionFactory = getInstance();
		SqlSession session = sessionFactory.openSession();
		session.delete("mapper.article.deleteArticle", articleNo);
		session.commit();
	}
	
	
}
