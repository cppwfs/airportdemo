package models;

public class Weather {
	public String weather;
	public String wind;
	public String temp;
	public String visibility;
	public Meta meta;
	@Override
	public String toString() {
		return "<dd>weather: " + weather + "</dd><dd> wind: " + wind + "</dd><dd>temp: "
				+ temp + "</dd><dd> visibility: " + visibility + "</dd><dd>" + meta + "</dd>";
	}
	
}
