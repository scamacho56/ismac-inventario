package com.distribuida.principal;



import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.distribuida.dao.ProductoDAO;
import com.distribuida.entities.Producto;




public class PrincipalProducto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Patron IoC Inversion de control
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		
		ProductoDAO productoDAO = context.getBean("productoDAOImpl", ProductoDAO.class);
		
		
		//CRUD:CREATE,READ,UPDATE,DELETE
		Producto producto = new Producto(0, "Producto00053", "variados3",  9.043,  13 );
		//productoDAO.add(producto);
		
		//up
		Producto producto2 = new Producto(5, "Producto00054", "floreado3",  7.55,  22 );
		//productoDAO.up(producto2);
		
				
				//del
				productoDAO.del(5);
				
				//findOne
				
				//findAll
				

				productoDAO.findAll().forEach(item -> {
					System.out.println(item.toString());
				});
				context.close();
				
		
		
			
	}

}
