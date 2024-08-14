package com.distribuida.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.distribuida.dao.ProductoDAO;
import com.distribuida.entities.Producto;

@Controller
@RequestMapping("/productos") //path principal
public class ProductoController {
	//JSP.-Java Server Page, son las paginas web de tecnologia java
	
	
		@Autowired
		private ProductoDAO productoDAO;
		
		@GetMapping("/findAll")   //path secundario
		public String findAll(Model model) {
			//try {
				List<Producto> productos = productoDAO.findAll();
				
				model.addAttribute("productos", productos);  //	EJ:clave=keyProductos,valor = Productos
				
				return "productos-listar";  //esto es el nombre del formulario Ej,"listar.Productos.html o "listar-Productos.jsp
			
			//} catch (Exception e) {
//	       //TODO: handle exception 
				//e.printStackTrace();
			// }
					  		  			
		
		}
		
		@GetMapping("/findOne")
		public String findOne(@RequestParam("idProductos") @Nullable Integer idProducto
				             ,@RequestParam("opcion") @Nullable Integer opcion
				             , Model model
				) {
		
			if(idProducto !=null) {
				Producto Producto = productoDAO.findOne(idProducto);
				model.addAttribute("Producto", Producto);
			}
			
			if(opcion == 1) return "productos-add"; //actualizacion
			else return "productos-del";            //eliminacion
		}
		
		
		@PostMapping("/add")
		public String add(@RequestParam("idProductos")@Nullable Integer idProductos
				         ,@RequestParam("nombre")   @Nullable String nombre
				         ,@RequestParam("descripcion") @Nullable String descripcion
				         ,@RequestParam("precio")@Nullable double precio
				         ,@RequestParam("stock") @Nullable Integer stock
				         ,Model model
				) {
			
		//try{
			
			if(idProductos == null) {
			 Producto producto = new Producto(0,  nombre, descripcion, precio, stock);
			 productoDAO.add(producto);
		    } else {
		    	Producto Producto2  = new Producto(idProductos, nombre, descripcion, precio, stock );
		    	productoDAO.up(Producto2);
		    }   
		    
		    
			return "redirect:/productos/findAll";
		//}catch (Exception e) {
		//	//TODO: HANDLE exception
//		}
		}
		
	    @GetMapping("/del")
	    public String del(@RequestParam("idProductos") @Nullable Integer idProductos) {
	    	//try{
	    
	    productoDAO.del(idProductos);
	    return "redirect:/productos/findAll";
	    // } catch (Exception e) {
	    //  //TODO : handle exception
	    // }
	    }
	    
	}


