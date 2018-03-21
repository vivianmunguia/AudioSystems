
package mx.itson.audiosystems.entidades;

import java.util.List;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import mx.itson.audiosystems.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Clase que representa un cliente registrado
 * @param id: Id del cliente
 * @param nombre: Nombre del cliente
 * @param direccion: Dirección del cliente
 * @param telefono: Teléfono del cliente
 * @param correo: Correo del cliente
 * @author andy_
 */
public class Cliente {
    int id;
    String nombre, direccion, telefono, correo;
    @Id 
    @GeneratedValue
    //Método que genera el id
    public int getId() {
        return id;
    }
    //Método que obtiene el nombre de la persona
    public void setId(int id) {
        this.id = id;
    }
    //Método que obtiene el nombre
    public String getNombre() {
        return nombre;
    }
    //Método que asigna el nombre
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    //Método que obtiene la dirección
    public String getDireccion() {
        return direccion;
    }
    //Método que asigna la dirección 
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    //Método que obtiene el teléfono
    public String getTelefono() {
        return telefono;
    }
    //Método que asigna el teléfono
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    //Método que obtiene el correo
    public String getCorreo() {
        return correo;
    }
    //Método que asigna el correo
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    //Método que obtiene todos los clientes
    public List<Cliente> obtenerTodos(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Cliente> clientes = (List<Cliente>)session.createCriteria(Cliente.class).list();
        return clientes;
    }   
    //Método que guarda todos los clientes
    public void guardar(Cliente c){
        try{
            Session sesion = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = sesion.beginTransaction();
            sesion.save(c);
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
