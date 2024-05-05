package com.SRP.sistema.controlador;

import com.SRP.sistema.modelo.Producto;
import com.SRP.sistema.servicio.ProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ControladorProducto {

    // instanciamos para utilizar los metodos
    @Autowired
    ProductoServicio productoServicio;         



    //rutas y procesos

    //Principal
    @GetMapping("/")
    public String home (Model model){
        return "index";
    }


    //Inventario
    @GetMapping("/productos")
    public String tablaProductos (Model model ){
        List<Producto> productoList = productoServicio.listaDeProductos();                          //utilizamos de metodo del servidor y lo introducimos en un List<>
        model.addAttribute("productoList",productoList);
        return "inventario";
    }


    //Nuevo producto 
    @GetMapping("/NuevoProducto")
    public String nuevoProducto (Model model ){
        Producto product = new Producto();               //instanciamos un objeto Producto
        model.addAttribute("product",product);           //Enviamos como modelo el objeto para que lo llenen en el front
        return "nuevoProducto";                          //llamamos el template
    }

    @PostMapping ("/GuardarProducto")
    public String guardarProducto (Producto product ){       //Recibe el objeto producto ya llenado con los datos

        if (productoServicio.guardarOActualizarProducto(product)){                                  //ultilizamos el metodo del servicio para guardar el objeto que nos llego
            return "redirect:/productos";                                                          //si retorna true, es por que se guardo y esta presente y redirecionaremos a /inventario
        }
        return "redirect:/NuevoProducto";                                                           //si no esta presente, retorna false y redirecciona al template para rellenar el formulario nuevamente
    }
    


    //Editar producto
    @GetMapping ("/EditarProducto/{id}")
    public String editarProducto (Model model, @PathVariable Integer id ){   //mismo proceso que ver producto , pero en este en el front si da acceso para editar los datos
        Producto product = productoServicio.detallesProducto(id);
        model.addAttribute("product", product);
        return "EditarProducto";
    }

    @PostMapping ("/ActualizarProducto")
    public String actualizarProducto (@ModelAttribute("product") Producto producto ){    //Recibe el objeto producto ya editado
        if (productoServicio.guardarOActualizarProducto(producto)){
            return "redirect:/productos";
        }
        return "redirect:/EditarProducto";
    }



    //Eliminar producto  
    @GetMapping("/EliminarCliente/{id}")
    public String eliminarProducto(@PathVariable Integer id){

        if (productoServicio.eliminarProducto(id)){                             //utilizando el metodo eliminar del servicio se elimina mediante el id , que se recibe desde la url
            return "redirect:/productos";                                      //el metodo, hace la verificacion si no esta presente es por no se guardo y retorna true
        }
        return "redirect:/productos";                                          //y retorna false, por que esta presente y no se pudo eliminar el producto
    }




}
