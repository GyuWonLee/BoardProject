package com.gyuone.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gyuone.model.ArticleVO;
import com.gyuone.service.BoardService;

@Controller
@RequestMapping("/board") // board를 다 받음
public class BoardController {
	@Autowired
	BoardService boardService;
	@Autowired
	ArticleVO articleVo;
	
	List<ArticleVO> articleList = new ArrayList<ArticleVO>();
	
	@RequestMapping({"/listArticles","/"}) // 배열로 때림
	public String getArticleList(Model model) {
		articleList = boardService.listArticles();
		model.addAttribute("articleList", articleList);
		return "listArticles";
	}
	
	@RequestMapping("/newArticle")
	public String writeArticle(Model model) {
		return "articleForm";
		
	}
	
	@RequestMapping(value="/addArticle", method=RequestMethod.POST)
	public String addArticle(Model model, @RequestParam(value="title") String title,
			@RequestParam(value="content") String content) {
		articleVo.setTitle(title);
		articleVo.setContents(content);
		articleVo.setWriteId("bit");
		boardService.addArticle(articleVo);
		
		return "redirect:listArticles"; // client ---> server addArticle로 들어온거.
		// server----> client 요청한거 다 끝냈으니깐 listArticles로 더 불러줄래? ---> listArticles로 다시 불러줌.
	}
	
	@RequestMapping(value="/viewArticle", method=RequestMethod.GET)
	public ModelAndView viewArticle(@RequestParam(value="articleno") String articleNo) {
		articleVo = boardService.viewArticle(Integer.parseInt(articleNo));
		ModelAndView mv = new ModelAndView();
		mv.setViewName("viewArticle");
		mv.addObject("article", articleVo);
		
		return mv;
	}
}
