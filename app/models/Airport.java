package models;

public class Airport {

	/**
	 * @param args
	 */
	
		// TODO Auto-generated method stub
		public String city;
		public String state;
		public String code;
		public String name;
		public float latitude;
		public float longitude;
		public String status;
		public String delay="false";
		public Airport(String city, String state, String code, String name) {
			super();
			this.city = city;
			this.state = state;
			this.code = code;
			this.name = name;
		}
		public Airport(){
			name="void";
		}
		


}
