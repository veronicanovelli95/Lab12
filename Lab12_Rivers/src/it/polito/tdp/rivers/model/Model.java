package it.polito.tdp.rivers.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;


import it.polito.tdp.rivers.db.RiversDAO;

public class Model {
  private RiversDAO dao;
  List<River> fiumi;
  private float capienza;
  private PriorityQueue<Event> coda;
  

	
	
  
  public Model() {
	dao= new RiversDAO();
	fiumi = dao.getAllRivers();
	dao.getAllFlows(fiumi);
  }


  public List<River> getFiumi(){
	return fiumi;
  }
  
  
  
  
	
  public List<Double> simula(Double k,River r){
	  double q= (double)(k*r.portataMedia()*30*3600);
	  double fmin= (r.portataMedia()*0.8);
	  double c = q/2;
	  coda= new PriorityQueue<Event>();
	  Event e1=null;
	  for(Flow f :r.getFlows()){
			   e1 = new Event(Event.EventType.FLUSSO, f.getDay(), f.getFlow(),fmin);
		 
		  if(e1!=null)
		  coda.add(e1);
	  }
	  
	  List<Double> risultato;
		
	  risultato =run(q,c,r);
	  return risultato;
  }
  
  
  
  public 	List<Double> run(double q, double c,River r) {
	 
		double cmed =0;
		int misu = 0;
		double fallimenti=0;
		List<Double> risultato=new LinkedList<Double>();
		
		double ctot = 0;
		while(!coda.isEmpty()) {
			Event e = coda.poll() ;
			
			switch(e.getType()) {
			
			case FLUSSO:
				Random ran= new Random();
				double caso = ran.nextDouble();
				if(caso<0.95){
					double f = (double)(e.getFlowin()-e.getFlowout())	;
					c+=f;
					
					
				}
				else{
					float f = (float)(e.getFlowin()-e.getFlowout()*10)	;
					c+=f;
					fallimenti++;
				}
				
				
				if(c>q){
					c=q;
				}
				
				
				misu++;
				ctot=c;
                break;
						
			
			}}
		
	   cmed= ctot/misu;
	   risultato.add(cmed);
//	   System.out.println(cmed);
	   risultato.add(fallimenti);
//	   System.out.println(fallimenti);
		return risultato;
			
			
}
}
