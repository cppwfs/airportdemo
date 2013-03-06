package models;

public class Status {
	public String avgDelay;
	public String closureEnd;
	public String closureBegin;
	public String type;
	public String minDelay;
	public String trend;
	public String reason;
	public String maxDelay;
	public String endTime;

	@Override
	public String toString() {
		return "<dd>avgDelay: " + avgDelay + "</dd><dd> closureEnd: " + closureEnd
				+ "</dd><dd> closureBegin: " + closureBegin + "</dd><dd> type: " + type
				+ "</dd><dd> minDelay: " + minDelay + "</dd><dd> trend=" + trend + "</dd><dd> reason: "
				+ reason + "</dd><dd> maxDelay: " + maxDelay + "</dd><dd>endTime: " + endTime
				+ "</dd>";
	}
	
}
