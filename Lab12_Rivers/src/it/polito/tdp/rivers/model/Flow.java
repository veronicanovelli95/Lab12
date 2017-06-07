package it.polito.tdp.rivers.model;

import java.time.LocalDate;
import java.util.Comparator;

public class Flow implements Comparable<Flow>{

	private LocalDate day;
	private double flow;
	private River river;

	public Flow(LocalDate day, double flow, River river) {
		this.day = day;
		this.flow = flow;
		this.river = river;
	}

	public LocalDate getDay() {
		return day;
	}

	public void setDay(LocalDate day) {
		this.day = day;
	}

	public River getRiver() {
		return river;
	}

	public double getFlow() {
		return flow;
	}

	public void setFlow(float flow) {
		this.flow = flow;
	}

	@Override
	public String toString() {
		return "Flow [day=" + day + ", flow=" + flow + ", river=" + river + "]";
	}

	



	@Override
	public int compareTo(Flow o) {
		if(this.day.isAfter(o.day))
		return 1;
		else if(this.day.isBefore(o.day))
		return -1;
		else
		return 0;
	}

}
