
package mx.itson.audiosystems.entidades;

import java.util.List;
import mx.itson.audiosystems.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Clase que representa una reparación 
 * @param id: Id de la reparación
 * @param nombreCliente: Nombre del cliente
 * @param nombreAparato: Nombre del aparato
 * @param falla: Falla que presenta el aparato
 * @param fechaDeEntrega: Fecha en la que se tiene que entregar 
 * @param costoTotal: Precio que tendrá la reparación en total
 * @param anticipo: Anticipo que dejó el cliente
 * @param restante: Cantidad que resta por pagar
 * @author andy_
 */
public class Reparacion {
    int id;
    String nombreCliente, nombreAparato, falla, fechaDeEntrega;
    double costoTotal, anticipo, restante;
    //Método que obtiene el id
    public int getId() {
        return id;
    }
    //Método que asigna el id    
    public void setId() {
        this.id = id;
    }
    //Método que obtiene el nombre del cliente
    public String getNombreCliente() {
        return nombreCliente;
    }
    //Método que asigna el nombre del cliente
    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }
    //Método que obtiene el nombre del aparato
    public String getNombreAparato(){
        return nombreAparato;
    }
    //Método que asigna el nombre del aparato
    public void setNombreAparato(String nombreAparato){
        this.nombreAparato = nombreAparato;
    }
    //Método que obtiene la falla
    public String getFalla() {
        return falla;
    }
    //Método que asigna la falla
    public void setFalla(String falla) {
        this.falla = falla;
    }
    //Método que obtiene la fecha de entrega
    public String getFechaDeEntrega() {
        return fechaDeEntrega;
    }
    //Método que asigna la fecha de entrega
    public void setFechaDeEntrega(String fechaDeEntrega) {
        this.fechaDeEntrega = fechaDeEntrega;
    }
    //Método que obtiene el costo total
    public double getCostoTotal() {
        return costoTotal;
    }
    //Método que asigna el costo total
    public void setCostoTotal(double costoTotal) {
        this.costoTotal = costoTotal;
    }
    //Método que obtiene el anticipo
    public double getAnticipo() {
        return anticipo;
    }
    //Método que asigna el anticipo
    public void setAnticipo(double anticipo) {
        this.anticipo = anticipo;
    }
    //Método que obtiene la cantidad restante
    public double getRestante() {
        return restante;
    }
    //Método que asigna la cantidad restante 
    public void setRestante(double restante) {
        this.restante = restante;
    }
    //Método que obtiene todas las reparaciones
    public List<Reparacion> obtenerTodos(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Reparacion> reparaciones = (List<Reparacion>)session.createCriteria(Reparacion.class).list();
        return reparaciones;
    }   
    //Método que guarda todas las reparaciones
    public void guardar(Reparacion r){
        try{
            Session sesion = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = sesion.beginTransaction();
            sesion.save(r);
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
