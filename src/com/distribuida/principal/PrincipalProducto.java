package com.distribuida.principal;



import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.distribuida.dao.ProductoDAO;
import com.distribuida.entities.Producto;




public class PrincipalProducto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Patron IoC Inversion de control
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml  ");
		
		ProductoDAO productoDAO = context.getBean("productoDAOImpl", ProductoDAO.class);
		
		
		//CRUD:CREATE,READ,UPDATE,DELETE
		Producto producto = new Producto(0, "Producto0003", "variados",  9.04,  10 );
		//productoDAO.add(producto);
		
		//up
		Producto producto2 = new Producto(4, "Producto0005", "floreado",  7.5,  23 );
		productoDAO.up(producto2);
		
				
				//del
				productoDAO.del(1);
				
				//findOne
				
				//findAll
				

				productoDAO.findAll().forEach(item -> {
					System.out.println(item.toString());
				});
				context.close();
				
		
		
			
	}

}
