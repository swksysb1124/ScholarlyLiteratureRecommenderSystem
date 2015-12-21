package controllers;

import java.util.*;


import play.*;
import play.mvc.*;
import play.data.*;
import static play.data.Form.*;
import views.html.*;
import models.*;

import java.io.*;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

/**
 * Manage a database of computers
 */
public class Application extends Controller {
    
	static int list_per_page = 10;
	
	/**
     * Handle default path requests, redirect to computers list
     */
	 
    public static Result index() {
        return ok(index.render("CitxtSeer")); // pass a string as argument to index.scala.html 
    }
	 /* return the search results to list.scala*/
    public static Result list(String querystring, int page) throws Exception{
		if (querystring == "") 
			return ok(noquery.render("please enter a query!!"));
		String line = querystring;
		line = line.trim();
		/* *
		 * define a "Paper class" and employ instance of this type to gather 
		 * the necessary information of the relevant documents retrieved from database. 
		 * 
		 * Then, employ a List structure to store these relevant Paper type
		 */
		List<Paper> paged_results = new ArrayList<Paper>();
		List<String> clusterid = new ArrayList<String>();
			
		/* Employ IndexReader, IndexSearcher, Analyzer, QueryParser, Query Class in Lucene lib
		 * to complete :
		 * 	1. linking to index, (IndexReader, IndexSearcher)
		 *	2. parsing the query, (Analyzer, QueryParser, Query)
		 *	3. and then get the relevant documents in the database.
		 */
			 
			 
		/* Link to index and initialize the a instance of IndexSearcher Class 
		 * which get the relevant documents associated with the query
		 */
		IndexReader reader = DirectoryReader.open(FSDirectory.open(new File("index"))); 
		IndexSearcher searcher = new IndexSearcher(reader);
		
		// analyzer is to help to parse the query
		Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_47);
			
		// Create Parser which parse the query
		QueryParser parser = new QueryParser(Version.LUCENE_47, "contents", analyzer);
		Query query = parser.parse(line);
			
		/* TopDocs, ScoreDoc, Document class	
		 *
		 * the object of TopDocs class returns the "top list_per_page" documents' names (paper id)
		 * Since at first we have no idea about how many relevant documents will be retrieved 
		 *
		 * Therefore, first, we retrieve some top number of relevant documents by the non-static search method of IndexSearcher type 
		 * 			  Second, get total number of relevant documents in the database.
		 *            third, get all ranked relevant documents from the database.	*/
		 
		TopDocs results = searcher.search(query, list_per_page);
		// hits means "hit" the documents relevant to the query
		int numTotalHits = results.totalHits; // the number of relevant documents.
		
		/* the object of TopDocs class returns 
		 * the "all" relevant ranked documents' names (cluster id or real paper id) */
		ScoreDoc[] hits = searcher.search(query, numTotalHits).scoreDocs; 
		
		/* page 1: offset =0 , top 1 ~top 10 relevant papers
		 * page 2: offset =10, top 11~top 20 relevant papers
		 * ... and so on. */
		int offset = (page - 1) * list_per_page; 
		/* Upper limit number in each page */
		int upper = Math.min(offset + 10, numTotalHits);
		
		
		for ( int i = offset; i < upper; i++ ){
			Document doc = searcher.doc(hits[i].doc);
			String path = doc.get("path");
			if (path != null) {
				clusterid.add(cathClusterId(path));
			} else {
				System.out.println("No path for this document");
			}
		}
		
		/* Retrieve the list of relevant papers by the static method "findByCluster" of Paper class
		 * with the argument the list of cluster ids.	*/
		paged_results = Paper.findByCluster(clusterid);
		
		// pass arugment list( paged_results, offset, upper, numTotalHits, page, querystring ) to list.scala.html
		return ok(list.render(paged_results, offset, upper, numTotalHits, page, querystring));
	}	
	
	public static Result context(String paperid) {
		// 
		List<Paper> paperinfo = Paper.findByPaperid(paperid);			// Retrieve data about paper from database and return a list of Paper objects
		List<Context> citationinfo = Context.findByPaperid(paperid);	// Retrieve data about citation context of a given paper from database,
																		// and return a list of Context objects.
		
		// pass arugment list( paperinfo, citationinfo ) to context.scala.html
		return ok(context.render(paperinfo, citationinfo)); 
	}
	
	private static String cathClusterId(String path){
		// the path would be like " X:\\ clusterid.txt "
		String[] sp1 = path.split("\\\\");
		String[] sp2 = sp1[2].split("\\.");
		return sp2[0];
	}
	
}


