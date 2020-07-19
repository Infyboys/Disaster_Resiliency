package com.ib.springbootstarter.beans;
public class Docs
{
    private String web_url;

    private Headline headline;
    
    private String pub_date;

    public String getPub_date() {
		return pub_date;
	}
	public void setPub_date(String pub_date) {
		this.pub_date = pub_date;
	}
	public void setWeb_url(String web_url){
        this.web_url = web_url;
    }
    public String getWeb_url(){
        return this.web_url;
    }
    public void setHeadline(Headline headline){
        this.headline = headline;
    }
    public Headline getHeadline(){
        return this.headline;
    }
	@Override
	public String toString() {
		return "Docs [web_url=" + web_url + ", headline=" + headline + "]";
	}
}
