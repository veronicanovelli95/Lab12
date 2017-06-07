package it.polito.tdp.rivers.model;

import java.time.LocalDate;

public class Event implements Comparable<Event> {
	public enum EventType {
		FLUSSO
	}
	private EventType type ;
	private LocalDate day ;
	double flowin;
	double flowout;
	
	
	public Event(EventType type, LocalDate day, double flowin, double flowout) {
		super();
		this.type = type;
		this.day = day;
		this.flowin = flowin;
		this.flowout=flowout;
	}
	
	@Override
	public int compareTo(Event o) {
		// TODO Auto-generated method stub
		return 0;
	}

	public EventType getType() {
		return type;
	}

	public LocalDate getDay() {
		return day;
	}

	public double getFlowin() {
		return flowin;
	}

	public double getFlowout() {
		return flowout;
	}

	
	

}
