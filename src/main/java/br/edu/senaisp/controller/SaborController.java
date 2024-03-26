package br.edu.senaisp.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import com.google.gson.Gson;

import br.edu.senaisp.dao.SaborDao;
import br.edu.senaisp.model.Sabor;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = "/projeto")
public class SaborController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		SaborDao dao = new SaborDao();
		
		List<Sabor> sabores = dao.lista();
		
		String texto = "";
		
		try {
			
			Gson gson = new Gson();
			texto = gson.toJson(sabores);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		resp.getWriter().append(texto);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		BufferedReader br = req.getReader();
		
		String json = "";
		String linha = "";
		
		while ((linha = br.readLine()) != null) {
			json += linha;
		}
		
		Gson gson = new Gson();
		Sabor sabor = gson.fromJson(json, Sabor.class);
		SaborDao dao = new SaborDao();
		
		dao.novo(sabor);

		resp.getWriter().append("funfou");
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
	
}
