package com.shylu;


import java.io.IOException;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

@WebServlet("/Search")
public class Search extends HttpServlet {
	
	//mongo DB connection using client which connects database and collection
	 MongoClient mongoClient = new MongoClient();
	    DB database = mongoClient.getDB("selfappraisal");
	    DBCollection collection = database.getCollection("general_information");
	    static String findreq;
	    static String desig;
		public Search() {
			super();
		}
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		 findreq = request.getParameter("searchbar");
     System.out.println(findreq);
	   int count=0;
	    int flag=0;
	    // search function to search the data in database
	    BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.put("Fullname", findreq);
		BasicDBObject where=new BasicDBObject();
		where.put("$and",searchQuery);
		//FindIterable<Document> cursor = collection.find(searchQuery);
		DBCursor cursor = collection.find(searchQuery);
		Iterator curs = cursor.iterator(); 
		while (curs.hasNext()) {
			
			System.out.println(curs.next());
			count++;
			System.out.println(count);
		    flag=1;
		}
		
		if(flag==0)
		{
			System.out.println("Search failed");
			RequestDispatcher req = request.getRequestDispatcher("/index.jsp");
			req.forward(request, response);
		}
		else
		{
			// search is success after which it has display all the details  
			System.out.println("Search Success");
			System.out.println(findreq+"------------------");
			DBObject query = new BasicDBObject("Fullname", findreq);
			cursor = collection.find(query);
			String fn=(String)cursor.one().get("Fullname");
			System.out.println(fn);
			
			String desgn=(String)cursor.one().get("Desgn");
			System.out.println(desgn);			
			
			String dept=(String)cursor.one().get("Dept");
			System.out.println(dept);
			
			String startYear=(String)cursor.one().get("StartYear");
			System.out.println(startYear);
			
			String endYear=(String)cursor.one().get("EndYear");
			System.out.println(endYear);
			
			String fciScore=(String)cursor.one().get("FCI");
			System.out.println(fciScore);
			
			String nirfJournals=(String)cursor.one().get("SJR");
			System.out.println(nirfJournals);
			
			String indexedPapers=(String)cursor.one().get("IND");
			System.out.println(indexedPapers);
			
			String journalPublication=(String)cursor.one().get("NIND");
			System.out.println(journalPublication);
			
			String books=(String)cursor.one().get("Num");
			System.out.println(books);
			
			
			String booksChapters=(String)cursor.one().get("Num_chap");
			System.out.println(booksChapters);
			
			String disclosuresFiled=(String)cursor.one().get("DISC");
			System.out.println(disclosuresFiled);
			
			String patentsGranted=(String)cursor.one().get("Patent");
			System.out.println(patentsGranted);
			
			String researchGuidanceUg=(String)cursor.one().get("UG");
			System.out.println(researchGuidanceUg);
			
			String researchGuidanceMaster=(String)cursor.one().get("MS");
			System.out.println(researchGuidanceMaster);
			
			String researchGuidancePhd=(String)cursor.one().get("PHD");
			System.out.println(researchGuidancePhd);
			
			String fundedProjects1=(String)cursor.one().get("FTL");
			System.out.println(fundedProjects1);
			
			String fundedProjects2=(String)cursor.one().get("FFTL");
			System.out.println(fundedProjects2);
			
			String fundedProjects3=(String)cursor.one().get("FOFL");
			System.out.println(fundedProjects3);
			
			String fundedProjects4=(String)cursor.one().get("FOL");
			System.out.println(fundedProjects4);
			
			String consultingProjects1=(String)cursor.one().get("CTL");
			System.out.println(consultingProjects1);
			String consultingProjects2=(String)cursor.one().get("CFTL");
			System.out.println(consultingProjects2);
			String consultingProjects3=(String)cursor.one().get("COFL");
			System.out.println(consultingProjects3);
			
			String consultingProjects4=(String)cursor.one().get("COL");
			System.out.println(consultingProjects4);
			String chairReviewer=(String)cursor.one().get("Journal");
			System.out.println(chairReviewer);
			String fiveDayWorkShop=(String)cursor.one().get("Fivedays");
			System.out.println(fiveDayWorkShop);
			
			String threeDayWorkShop=(String)cursor.one().get("Threedays");
			System.out.println(threeDayWorkShop);
			String invitedTalksOutside=(String)cursor.one().get("TECH");
			System.out.println(invitedTalksOutside);
			String eventsOutside=(String)cursor.one().get("EOUT");
			System.out.println(eventsOutside);
			
			String invitedTalksInside=(String)cursor.one().get("EIN");
			System.out.println(invitedTalksInside);
			String industryRelations=(String)cursor.one().get("Industry");
			System.out.println(industryRelations);
			String instDeptServicesCoordinator=(String)cursor.one().get("Coordinate");
			System.out.println(instDeptServicesCoordinator);
			
			String instDeptServicesOthers=(String)cursor.one().get("NOther");
			System.out.println(instDeptServicesOthers);
			String othServices=(String)cursor.one().get("Society");
			System.out.println(othServices);
			String awardsHonours=(String)cursor.one().get("Award");
			System.out.println(awardsHonours);
			
			String profTeam=(String)cursor.one().get("Team");
			System.out.println(profTeam);
			
			String anyContribution=(String)cursor.one().get("Other");
			System.out.println(anyContribution);
			
			
			RequestDispatcher req = request.getRequestDispatcher("/searchResult.jsp");
			
			request.setAttribute("Fullname", fn);
			request.setAttribute("Desgn", desgn);// get from the DB names
			request.setAttribute("department",dept);
			request.setAttribute("StartYear",startYear);
			request.setAttribute("EndYear",endYear);
			
			request.setAttribute("FCI",fciScore);
			request.setAttribute("SJR",nirfJournals);
			request.setAttribute("IND",indexedPapers);
			request.setAttribute("NIND",journalPublication);
			
			request.setAttribute("Num",books);
			request.setAttribute("Num_chap",booksChapters);
			
			request.setAttribute("DISC",disclosuresFiled);
			request.setAttribute("Patent",patentsGranted);
			
			request.setAttribute("UG",researchGuidanceUg);
			request.setAttribute("MS",researchGuidanceMaster);
			request.setAttribute("PHD",researchGuidancePhd);
			
			request.setAttribute("FTL",fundedProjects1);
			request.setAttribute("FFTL",fundedProjects2);
			request.setAttribute("FOFL",fundedProjects3);
			request.setAttribute("FOL",fundedProjects4);
			
			request.setAttribute("CTL",consultingProjects1);
			request.setAttribute("CFTL",consultingProjects2);
			request.setAttribute("COFL",consultingProjects3);
			request.setAttribute("COL",consultingProjects4);
			
			request.setAttribute("Journal",chairReviewer);
			request.setAttribute("Fivedays",fiveDayWorkShop);
			//
			request.setAttribute("Threedays",threeDayWorkShop);
			request.setAttribute("TECH",invitedTalksOutside);
			request.setAttribute("EOUT",eventsOutside);
			request.setAttribute("EIN",invitedTalksInside);
			
			request.setAttribute("Industry",industryRelations);
			request.setAttribute("Coordinate",instDeptServicesCoordinator);
			//
			request.setAttribute("NOther",instDeptServicesOthers);
			request.setAttribute("Society",othServices);
			request.setAttribute("Award",awardsHonours);
			request.setAttribute("Team",profTeam);
			
			request.setAttribute("Other",anyContribution);
			
			request.getRequestDispatcher("searchResult.jsp").forward(request, response);
			//req.forward(request, response);
		}
		
		}
		
		public static  String Systemid()
	    {
			System.out.println(findreq);
	        return findreq;
	    }
		

}
