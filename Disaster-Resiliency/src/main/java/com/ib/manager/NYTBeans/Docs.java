package com.ib.manager.NYTBeans;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("docs")
public class Docs {
	private ArrayList<NewsContent> contents;

	public ArrayList<NewsContent> getContents() {
		return contents;
	}

	public void setContents(ArrayList<NewsContent> contents) {
		this.contents = contents;
	}
	
}
