package br.edu.senaisp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.edu.senaisp.model.Sabor;

public class SaborDao {

	private final String SQLINSERT = 
	"INSERT INTO sabor (nome, descricao, preco) VALUES(?, ?, ?)";
	
	private final String SQLSELECT = 
	"SELECT id, nome, descricao, preco FROM sabor";
	
	private final String SQLDELETE = 
			"DELETE FROM sabor WHERE id = ?";	
	
	private String SQLUPDATE = 
			"UPDATE sabor SET nome = ? WHERE id = ?;";
	
	public void novo(Sabor sabor) {
		System.out.println(sabor.getNome());
		try {
			Connection con = dao.conexao();
			
            if (!con.isClosed()) {
            	PreparedStatement ps = 
            			con.prepareStatement(SQLINSERT);
            	ps.setString(1, sabor.getNome());
            	ps.setString(2, sabor.getDescricao());
            	ps.setFloat(3, sabor.getPreco());
            	
            	ps.execute();
            }
            	
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public List<Sabor> lista() {
		
		List<Sabor> sabores = new ArrayList<Sabor>();
		
		try {
			Connection con = dao.conexao();
			
            if (!con.isClosed()) {
            	PreparedStatement ps = 
            	con.prepareStatement(SQLSELECT);
            	ResultSet rs = ps.executeQuery();
            	
            	Sabor tmp = null;
            	while (rs.next()) {
            		
            		tmp = new Sabor();
            		tmp.setId( rs.getInt("id") );
            		tmp.setNome(rs.getString("nome") );
            		tmp.setDescricao(rs.getString("descricao"));
            		tmp.setPreco(rs.getFloat("preco"));
            		
            		sabores.add(tmp);
            	}
            	
            	con.close();
            }
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return sabores;
	}
	
	public void Delete(int numero) {
		
		try {
			Connection con = dao.conexao();
			
            if (!con.isClosed()) {
            	PreparedStatement ps = 
            	con.prepareStatement(SQLDELETE);
            		
            		ps.setInt(1, numero);
            		ps.execute();
            		
            	}
            	
            	con.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void Update(String nomeVar, String conteudo, int numero) {
		
		if(nomeVar.equalsIgnoreCase("descricao")) {
			SQLUPDATE = "UPDATE sabor SET descricao = ? WHERE id = ?;";
		}else 	if(nomeVar.equalsIgnoreCase("preco")) {
			SQLUPDATE = "UPDATE sabor SET preco = ? WHERE id = ?;";
		}
		
		
		try {
			Connection con = dao.conexao();
			
			if (!con.isClosed()) {
				PreparedStatement ps = 
						con.prepareStatement(SQLUPDATE);
				ps.setString(1, conteudo);
				ps.setInt(2, numero);
				ps.execute();
				
			}
			
			con.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
}
