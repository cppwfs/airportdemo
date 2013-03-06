package models;

import java.util.Arrays;

public class AirportStatusArray {
	public String name;
	public String ICAO;
	public String delay;
	public String IATA;
	public String city;
	public String state;
	public Status status[];
	public Weather weather;
	@Override
	public String toString() {
		return "AirportStatusArray [name=" + name + ", ICAO=" + ICAO
				+ ", delay=" + delay + ", IATA=" + IATA + ", city=" + city
				+ ", state=" + state + ", status=" + Arrays.toString(status)
				+ ", weather=" + weather + "]";
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
