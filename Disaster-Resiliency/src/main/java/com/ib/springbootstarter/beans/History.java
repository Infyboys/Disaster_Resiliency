package com.ib.springbootstarter.beans;

public class History {
	public History(String date, String disaster, String city, String state, String country, String longitude,
			String latitude, String keyPoints, String articleLink) {
		super();
		this.date = date;
		this.disaster = disaster;
		this.city = city;
		this.state = state;
		this.country = country;
		this.longitude = longitude;
		this.latitude = latitude;
		this.keyPoints = keyPoints;
		this.articleLink = articleLink;
	}
	private String date;
	private String disaster;
	private String city;
	private String state;
	private String country;
	private String longitude;
	private String latitude;
	private String keyPoints;
	private String articleLink;
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDisaster() {
		return disaster;
	}
	public void setDisaster(String disaster) {
		this.disaster = disaster;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getKeyPoints() {
		return keyPoints;
	}
	public void setKeyPoints(String keyPoints) {
		this.keyPoints = keyPoints;
	}
	public String getArticleLink() {
		return articleLink;
	}
	public void setArticleLink(String articleLink) {
		this.articleLink = articleLink;
	}
	
}
