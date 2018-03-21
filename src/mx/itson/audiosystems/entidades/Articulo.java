
package mx.itson.audiosystems.entidades;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import mx.itson.audiosystems.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
/**
 * Clase que representa un artículo que puede ser para reparación o para venta
 * @param codigo: Código que viene en los catálogos 
 * @param nombre: Nombre del artículo
 * @param cantidad: Cantidad de artículos que hay actualmente
 * @param id: Id del artículo
 * @param precio: Precio del artículo
 * @param tipo: Tipo de articulo, ya sea venta o reparación
 * @author andy_
 */
@Entity 
public class Articulo {
    String codigo, nombre;
    int cantidad, id;
    double precio; 
    Tipo tipo;
    
    @Id 
    @GeneratedValue
    //Método que genera el id
    public int getId() {
        return id;
    }
    //Método que asigna el id
    public void setId(int id) {
        this.id = id;
    }
    //Método que obtiene el código
    public String getCodigo() {
        return codigo;
    }
    //Método que asigna el código
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    //Método que obtiene el nombre
    public String getNombre() {
        return nombre;
    }
    //Método que asigna el nombre
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    //Método que obtiene la cantidad
    public int getCantidad() {
        return cantidad;
    }
    //Método que asigna la cantidad
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    //Método que obtiene el precio
    public double getPrecio() {
        return precio;
    }
    //Método que asigna el precio
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    //Método que obtiene el tipo
    public Tipo getTipo() {
        return tipo;
    }
    //Método que asigna el tipo
    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
    //Método que obtiene todos los artículos
    public List<Articulo> obtenerTodos(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Articulo> articulos = (List<Articulo>)session.createCriteria(Articulo.class).list();
        return articulos;
    }   
    //Método que guarda todos los artículos
    public void guardar(Articulo a){
        try{
            Session sesion = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = sesion.beginTransaction();
            sesion.save(a);
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
