package com.learning.hello;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Map;

import org.apache.jasper.runtime.ProtectedFunctionMapper;

/**
 * Servlet implementation class FibonacciServlet
 */
public class FibonacciServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	public int fibonacci(int n) {
		if (n <= 1)
            return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Generate the fibonacci sequence up to n numbers where n is the value defined by the query parameter "n".
	    //i.e. the request looks like localhost:8080/learning-web/fibonacci?n=10
	    //the response should be HTML-formatted comma-separated fibonacci numbers.
		try {
		      PrintWriter out = response.getWriter();
		      int num = Integer.valueOf(request.getParameter("n"));
		      out.println("<h1>Fibonnaci of "+ num+ "</h1>");
		      for(int i = 0; i < num; i++) {
		    	  out.println(fibonacci(i) + ",");
		      } 
		}
        catch(IOException e){
		    	  e.printStackTrace();
		      }
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		try {
			PrintWriter out = response.getWriter();
			int num = Integer.valueOf(request.getParameter("formLimit"));
			out.println("<h1>Fibonnaci of "+ num+ "</h1>");
			for(int i = 0; i < num; i++) {
				out.println(fibonacci(i) + ",");
		}
		}
			catch(IOException e){
		    	  e.printStackTrace();
		      }
	}
		
		

}
