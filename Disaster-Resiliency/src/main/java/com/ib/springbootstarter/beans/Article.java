package com.ib.springbootstarter.beans;
public class Article
{
    private String status;

    private String copyright;

    private Response response;

    public void setStatus(String status){
        this.status = status;
    }
    public String getStatus(){
        return this.status;
    }
    public void setCopyright(String copyright){
        this.copyright = copyright;
    }
    public String getCopyright(){
        return this.copyright;
    }
    public void setResponse(Response response){
        this.response = response;
    }
    public Response getResponse(){
        return this.response;
    }
	@Override
	public String toString() {
		return "Article [status=" + status + ", copyright=" + copyright + ", response=" + response + "]";
	}
}
