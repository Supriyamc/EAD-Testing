package com.shylu;

import java.net.UnknownHostException;
import java.text.DecimalFormat;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import org.bson.Document;
import org.bson.types.ObjectId;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.util.Iterator;

//import org.apache.log4j.Logger;


import com.itextpdf.text.Document;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.DBObject;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.client.MongoDatabase; 
import com.mongodb.MongoCredential;

import com.shylu.AjaxFile;
import static java.lang.System.out;


@WebServlet("/Appraisal")
public class Appraisal extends HttpServlet{

	/*the following code gives the JAVA file connection to 
	the MongoDatabase by creating new client.*/
	MongoClient mongoClient = new MongoClient();
    DB database = mongoClient.getDB("selfappraisal");
   
    /*the following code connects the client to the general_inforamtion 
    collection in the database called as selfapprasial*/
    DBCollection collection = database.getCollection("general_information");
	
	
		public Appraisal() {
			super();
		}
		
	    
		protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
	
			System.out.println("selfappraisal db");
			
			String fullName = request.getParameter("fullName");//program variable name= form names(id)
			String department = request.getParameter("department");
			String designation = request.getParameter("designation");
			String startYear = request.getParameter("startYear");
			String endYear = request.getParameter("endYear");
			String fciScore = request.getParameter("fciScore");
			String nirfJournals = request.getParameter("nirfJournals");
			String indexedPapers = request.getParameter("indexedPapers");
			String journalPublication = request.getParameter("journalPublication");
			String books = request.getParameter("books");
			String booksChapters = request.getParameter("booksChapters");
			String disclosuresFiled = request.getParameter("disclosuresFiled");
			String patentsGranted = request.getParameter("patentsGranted");
			String researchGuidanceUg = request.getParameter("researchGuidanceUg");
			String researchGuidanceMaster = request.getParameter("researchGuidanceMaster");
			String researchGuidancePhd = request.getParameter("researchGuidancePhd");
			String fundedProjects1 = request.getParameter("fundedProjects1");
			String fundedProjects2 = request.getParameter("fundedProjects2");
			String fundedProjects3 = request.getParameter("fundedProjects3");
			String fundedProjects4 = request.getParameter("fundedProjects4");
			String consultingProjects1 = request.getParameter("consultingProjects1");
			String consultingProjects2 = request.getParameter("consultingProjects2");
			String consultingProjects3 = request.getParameter("consultingProjects3");
			String consultingProjects4 = request.getParameter("consultingProjects4");
			String chairReviewer = request.getParameter("chairReviewer");
			String fiveDayWorkShop = request.getParameter("fiveDayWorkShop");
			String threeDayWorkShop = request.getParameter("threeDayWorkShop");
			String invitedTalksOutside = request.getParameter("invitedTalksOutside");
			String eventsOutside = request.getParameter("eventsOutside");
			String invitedTalksInside = request.getParameter("invitedTalksInside");
			String industryRelations = request.getParameter("industryRelations");
			String instDeptServicesCoordinator = request.getParameter("instDeptServicesCoordinator");
			String instDeptServicesOthers = request.getParameter("instDeptServicesOthers");
			String othServices = request.getParameter("othServices");
			String awardsHonours = request.getParameter("awardsHonours");
			String profTeam = request.getParameter("profTeam");
			String anyContribution = request.getParameter("anyContribution");
			
			
			//to check whether the program is reading from the form 
			System.out.println(fullName+" "+department+" "+designation);
			
			int found=0;
			// to print the structure of the database here in the java
			BasicDBObject searchQuery = new BasicDBObject();
			searchQuery.put("Fullname", fullName);
			BasicDBObject where=new BasicDBObject();
			where.put("$and",searchQuery);
			//FindIterable<Document> cursor = collection.find(searchQuery);
			DBCursor cursor = collection.find(searchQuery);
			Iterator curs = cursor.iterator(); 
			while (curs.hasNext()) {
				
				System.out.println(curs.next());
			    found=1;
			}
		
			//to insert the data entered into the database
			DBObject general_information = new BasicDBObject("Fullname", fullName)//(database name,program variable name)
	                .append("Dept",department)
	                .append("Desgn", designation)
	                .append("StartYear",startYear)//;

	                .append("EndYear",endYear)
	                .append("FCI", fciScore)
	                .append("SJR",nirfJournals)//;

	                .append("IND",indexedPapers)
	                .append("NIND", journalPublication)
	                .append("Num",books)//;

	                .append("Num_chap",booksChapters)
	                .append("DISC", disclosuresFiled)
	                .append("Patent",patentsGranted)//

	                .append("UG",researchGuidanceUg)
	                .append("MS", researchGuidanceMaster)
	                .append("PHD",researchGuidancePhd)//;

	                .append("FTL",fundedProjects1)
	                .append("FFTL", fundedProjects2)
	                .append("FOFL",fundedProjects3)//;

	                .append("FOL",fundedProjects4)
	                .append("CTL", consultingProjects1)//
	                .append("CFTL",consultingProjects2)//;

	                .append("COFL",consultingProjects3)
	                .append("COL", consultingProjects4)
	                .append("Journal",chairReviewer)//;

	                .append("Fivedays",fiveDayWorkShop)
	                .append("Threedays", threeDayWorkShop)//start from here
	                .append("TECH",invitedTalksOutside)//;

	                .append("EOUT",eventsOutside)
	                .append("EIN", invitedTalksInside)
	                .append("Industry",industryRelations)//;

	                .append("Coordinate",instDeptServicesCoordinator)
	                .append("NOther", instDeptServicesOthers)
	                .append("Society",othServices)//;

	                .append("Award",awardsHonours)
	                .append("Team", profTeam)
	                .append("Other",anyContribution);

			collection.insert(general_information);	
			
			//to check whether the insertion has been completed successfully 
			System.out.println("Insertion complete");
			
			RequestDispatcher req = request.getRequestDispatcher("/index.jsp");
			request.getRequestDispatcher("index.jsp").forward(request, response);
			//req.forward(request, response);
			
			}
}
	
	  
