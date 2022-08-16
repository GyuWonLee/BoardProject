package com.gyuone.model;

public class ArticleVO {
	private int articleNo;
	private String title;
	private String contents;
	private String writeId;
	private String writeDate;
	
	public ArticleVO() { // value object 
		
	}

	public ArticleVO(int articleNo, String title, String contents, String writeID) {
		super();
		this.articleNo = articleNo;
		this.title = title;
		this.contents = contents;
		this.writeId = writeID; // date는 default라 뺀다.
	}

	public int getArticleNo() {
		return articleNo;
	}

	public void setArticleNo(int articleNo) {
		this.articleNo = articleNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getWriteId() {
		return writeId;
	}

	public void setWriteId(String writeId) {
		this.writeId = writeId;
	}

	public String getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}
	
	
}
