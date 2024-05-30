package com.funfit.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.funfit.bean.Batch;
import com.funfit.service.BatchService;

/**
 * Servlet implementation class BatchController
 */
@WebServlet("/BatchController")
public class BatchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	BatchService bs = new BatchService();
       

    public BatchController() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		if("edit".equals(action)) {
			handleEdit(request, response);
		}
		else {
			List<Batch> listOfBatch = bs.viewAllBatches();
			HttpSession hs = request.getSession();
			hs.setAttribute("batches", listOfBatch);
			String flagValue = request.getParameter("flag");
			if(flagValue.equals("2")) {
				response.sendRedirect("addParticipants.jsp");
			} else {
				response.sendRedirect("viewBatches.jsp");
			}
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		if("delete".equals(action)) {
			handleDelete(request, response);
		}
		else if("update".equals(action)) {
			handleUpdate(request, response);
		}
		else {
			handlePost(request, response);
		}
	}	
	
	private void handleEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		String bid = request.getParameter("bid");
        Batch batch = bs.getBatchById(bid);
        HttpSession session = request.getSession();
        session.setAttribute("batch", batch);
        response.sendRedirect("updateBatch.jsp");
	}
	
	private void handleUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		int bid = Integer.parseInt(request.getParameter("bid"));
		String typeOfBatch = request.getParameter("typeofbatch");
		String time = request.getParameter("time");
		
		Batch bb = new Batch();
		bb.setBid(bid);
		bb.setTypeofbatch(typeOfBatch);
		bb.setTime(time);
		
		boolean result = bs.updateBatch(bb);
		
		if(result) {
			List<Batch> listOfBatch = bs.viewAllBatches();
			HttpSession session = request.getSession();
	        session.setAttribute("batches", listOfBatch);
		}
		
		response.sendRedirect("viewBatches.jsp");
	}

	
	private void handlePost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		String typeOfBatch = request.getParameter("typeofbatch");
		String time = request.getParameter("time");
		Batch bb = new Batch();
		bb.setTypeofbatch(typeOfBatch);
		bb.setTime(time);
		boolean result = bs.addBatch(bb);
		
		if(result) {
			request.setAttribute("result", result);
	        request.getRequestDispatcher("addBatch.jsp").forward(request, response);
		}
		else {
			pw.println("Failed to post batch to database");
		}
	}
	
	private void handleDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		String bid = request.getParameter("bid");
		
		boolean result = bs.deleteBatch(bid);
		if(result) {
			List<Batch> listOfBatch = bs.viewAllBatches();
            request.getSession().setAttribute("batches", listOfBatch);
		}
		else {
			pw.println("Failed to delete batch from database");
		}
		
		response.sendRedirect("viewBatches.jsp");
	}

}
