package com.ib.springbootstarter.beans;
public class Headline
{
    private String main;

    private String kicker;

    private String content_kicker;

    private String print_headline;

    private String name;

    private String seo;

    private String sub;

    public void setMain(String main){
        this.main = main;
    }
    public String getMain(){
        return this.main;
    }
    public void setKicker(String kicker){
        this.kicker = kicker;
    }
    public String getKicker(){
        return this.kicker;
    }
    public void setContent_kicker(String content_kicker){
        this.content_kicker = content_kicker;
    }
    public String getContent_kicker(){
        return this.content_kicker;
    }
    public void setPrint_headline(String print_headline){
        this.print_headline = print_headline;
    }
    public String getPrint_headline(){
        return this.print_headline;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setSeo(String seo){
        this.seo = seo;
    }
    public String getSeo(){
        return this.seo;
    }
    public void setSub(String sub){
        this.sub = sub;
    }
    public String getSub(){
        return this.sub;
    }
	@Override
	public String toString() {
		return "Headline [main=" + main + ", kicker=" + kicker + ", content_kicker=" + content_kicker
				+ ", print_headline=" + print_headline + ", name=" + name + ", seo=" + seo + ", sub=" + sub + "]";
	}
}
