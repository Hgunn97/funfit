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
import com.funfit.bean.Participants;
import com.funfit.service.BatchService;
import com.funfit.service.ParticipantsService;

/**
 * Servlet implementation class ParticipantsController
 */
@WebServlet("/ParticipantsController")
public class ParticipantsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	ParticipantsService ps = new ParticipantsService();
	BatchService bs = new BatchService();

    public ParticipantsController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if("edit".equals(action)) {
			handleEdit(request, response);
		}
		else if("view".equals(action)) {
			handleViewBatch(request, response);
		}
		else {
			PrintWriter pw = response.getWriter();
			List<Participants> listOfParticipants = ps.viewAllParticipants();
			HttpSession hs = request.getSession();
			hs.setAttribute("participants", listOfParticipants);
			response.sendRedirect("viewParticipants.jsp");
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
		String pid = request.getParameter("pid");
        Participants participant = ps.getParticipantsById(pid);
        List<Batch> listOfBatches = bs.viewAllBatches();
        HttpSession session = request.getSession();
        session.setAttribute("participant", participant);
        session.setAttribute("batches", listOfBatches);
        response.sendRedirect("updateParticipants.jsp");
	}
	
	private void handleViewBatch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		String bid = request.getParameter("bid");
        List<Participants> participants = ps.getParticipantsByBid(bid);
        HttpSession session = request.getSession();
        session.setAttribute("participants", participants);
        response.sendRedirect("viewParticipantsByBatch.jsp");
	}
	
	private void handleUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		int pid = Integer.parseInt(request.getParameter("pid"));
		String fname = request.getParameter("fname");
		int age = Integer.parseInt(request.getParameter("age"));
		String phonenumber = request.getParameter("phonenumber");
		int bid = Integer.parseInt(request.getParameter("bid"));
		
		Participants pp = new Participants();
		pp.setPid(pid);
		pp.setFname(fname);
		pp.setAge(age);
		pp.setPhonenumber(phonenumber);
		pp.setBid(bid);
		
		boolean result = ps.updateParticipants(pp);
		
		if(result) {
			List<Participants> listOfParticipants = ps.viewAllParticipants();
			HttpSession session = request.getSession();
	        session.setAttribute("participants", listOfParticipants);
		}
		
		response.sendRedirect("viewParticipants.jsp");
	}
	
	private void handlePost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		
		String fname = request.getParameter("fname");
		int age = Integer.parseInt(request.getParameter("age"));
		String phonenumber = request.getParameter("phonenumber");
		int bid = Integer.parseInt(request.getParameter("bid"));
		RequestDispatcher rd = request.getRequestDispatcher("addParticipants.jsp");
		
		Participants pp = new Participants();
		pp.setFname(fname);
		pp.setAge(age);
		pp.setPhonenumber(phonenumber);
		pp.setBid(bid);
		
		String result = ps.addParticipants(pp);
		pw.println(result);
		rd.include(request, response);
	}
	
	private void handleDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		String pid = request.getParameter("pid");
		
		boolean result = ps.deleteParticipants(pid);
		if(result) {
			List<Participants> listOfParticipatns = ps.viewAllParticipants();
            request.getSession().setAttribute("participants", listOfParticipatns);
		}
		else {
			pw.println("Failed to delete participants from database");
		}
		
		response.sendRedirect("viewParticipants.jsp");
	}

}
