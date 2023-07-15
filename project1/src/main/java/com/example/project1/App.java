package com.example.project1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	 Configuration con = new Configuration().configure().addAnnotatedClass(agentmanagement.class);
         SessionFactory sf = con.buildSessionFactory();
         
         createAgent(sf, "Ankit","ankit@gmail.com", "7738725392");
         createAgent(sf, "Rahul","Rahul@gmail.com", "854566350");
         createAgent(sf, "Rinshu","R@gmail.com", "9845663250");
         updateagent(sf, 1, "kaju","Ramu@gmail.com", "8459656329");
         deletagent(sf, 1);
         showagent(sf, 2);
      }
      
      
      public static void createAgent( SessionFactory ss, String name , String mail, String phone ){
      	
      	Session session = ss.openSession();
      	 Transaction transaction = session.beginTransaction();
      	 
      agentmanagement a1= new agentmanagement();
           
           
           a1.setAname(name);
           a1.setEmailid(mail);
           a1.setPhoneno(phone);
             
           session.persist(a1);
           transaction.commit();
  	}
      
      public static void updateagent( SessionFactory ss, int id, String name , String mail, String phone ){
      	
      	Session session = ss.openSession();
      	 Transaction transaction = session.beginTransaction(); 
      	 
      	 agentmanagement  agent = session.load(agentmanagement.class,id);
      	 agent.setAname(name);
      	 agent.setEmailid(mail);
           agent.setPhoneno(phone);
        	
           session.persist(agent);
           transaction.commit();
  	}
      
      public static void deletagent( SessionFactory ss, int id) {
      	
      	Session session = ss.openSession();
     	 Transaction transaction = session.beginTransaction(); 
     	agentmanagement agent =session.get(agentmanagement.class, id);
     	 session.delete(agent);
     	 
     	 
//     	session.persist(agent);
      transaction.commit();
  	}
      
      public static void showagent( SessionFactory ss, int id ) {
      	
      	Session session = ss.openSession();
        	 Transaction transaction = session.beginTransaction(); 
        	   
        	 agentmanagement agent = session.get(agentmanagement.class, id);
        	 System.out.print(agent.getAid()+" ");
        	System.out.print(agent.getAname()+" ");
        	System.out.print(agent.getEmailid()+" ");
        	System.out.print(agent.getPhoneno()+" ");
        
    }
}
