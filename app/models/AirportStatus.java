package models;

import java.util.Arrays;

public class AirportStatus {
	public String name;
	public String ICAO;
	public String delay;
	public String IATA;
	public String city;
	public String state;
	public Status status;
	public Weather weather;

	@Override
	public String toString() {
		String s = "<dl><dt><b>" + name + "  ("+IATA+")</b></dt><dt>" + " <b>Status:</b> ";
		if (delay.equals("false")) {
			s = s + "<b><font color='green'>No Delays</font></b>";
		} else {
			s = s + "<b><font color='red'>Delays</font></b>";
			s = s  + "<dt>" + status+"</dt>";
		}
		s=s + "<dt> <b>Weather</b>" + weather + "</dt></dl>";
		System.out.println(s);
		return s;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String ICAO() {
		return ICAO;
	}

	public void setICAO(String iACO) {
		ICAO = iACO;
	}

	public String getDelay() {
		return delay;
	}

	public void setDelay(String delay) {
		this.delay = delay;
	}

	public String getIATA() {
		return IATA;
	}

	public void setIATA(String IATA) {
		this.IATA = IATA;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
