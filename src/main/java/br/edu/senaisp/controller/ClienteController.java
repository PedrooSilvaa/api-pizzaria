package br.edu.senaisp.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import com.google.gson.Gson;

import br.edu.senaisp.dao.ClienteDao;
import br.edu.senaisp.model.Cliente;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = "/cliente")
public class ClienteController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ClienteDao dao = new ClienteDao(); //chamando cliente dao
		
		List<Cliente> clientes = dao.lista(); // declarando a lista
		
		String texto = "";
		
		try {
			
			Gson gson = new Gson(); // declaracao do objeto gson
			
			texto = gson.toJson(clientes); // transformando o objeto cliente para gson
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		resp.getWriter().append(texto);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		

		BufferedReader br = req.getReader(); // usando o br para leitura doq sera passado
		
		String json = "";
		String linha = "";
		
		while((linha = br.readLine()) != null) { //guarando a leitura na linha e vendo se nao e nulo
			json += linha; // guardando e concatenando os dados
		}
		
		Gson gson = new Gson();
		
		Cliente cliente = gson.fromJson(json, Cliente.class); //a partir do json para o objeto
		
		ClienteDao dao = new ClienteDao();
		
		dao.novo(cliente);
		
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id = Integer.parseInt(req.getParameter("id")); // pegando parametro
		
		String json = "";
		String linha = "";
		
		BufferedReader br = req.getReader(); 
		
		while((linha = br.readLine()) != null) {
			json += linha; 
		}
		
		Gson gson = new Gson();
		
		Cliente cliente = gson.fromJson(json, Cliente.class);
		
		cliente.setId(id); // mostrando qual id eu quero 
		
		ClienteDao dao = new ClienteDao();
		
		dao.Update(cliente);
		
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		int id = Integer.parseInt(req.getParameter("id")); // pegando parametro
		
		ClienteDao dao = new ClienteDao();
		
		dao.Delete(id);
		
	}
	
	
}
