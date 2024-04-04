package br.edu.senaisp.model;

import java.sql.Date;

public class pedido {

		private Integer id;
		private Integer id_cliente;
		private Date dt_pedido;
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public Integer getId_cliente() {
			return id_cliente;
		}
		public void setId_cliente(Integer id_cliente) {
			this.id_cliente = id_cliente;
		}
		public Date getDt_pedido() {
			return dt_pedido;
		}
		public void setDt_pedido(Date dt_pedido) {
			this.dt_pedido = dt_pedido;
		}
		
		
		
	
}
