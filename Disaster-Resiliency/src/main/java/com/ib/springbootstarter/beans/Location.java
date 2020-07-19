package com.ib.springbootstarter.beans;

public class Location {
	private int id;
	private String city;
	private String state;
	private String country;
	private String longitude;
	private String latitude;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	@Override
	public String toString() {
		return "Location [id=" + id + ", city=" + city + ", state=" + state + ", country=" + country + ", longitude="
				+ longitude + ", latitude=" + latitude + "]";
	}
	public Location(int id, String city, String state, String country, String longitude, String latitude) {
		super();
		this.id = id;
		this.city = city;
		this.state = state;
		this.country = country;
		this.longitude = longitude;
		this.latitude = latitude;
	}
}
