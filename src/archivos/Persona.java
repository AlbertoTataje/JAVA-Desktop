
package archivos;

import java.io.Serializable;



public class Persona implements Serializable{
  String nombre;
  String codigo;
  String telefono;
  int sueldo;

    public Persona(String nombre, String codigo, String telefono, int sueldo) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.telefono = telefono;
        this.sueldo = sueldo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
  

}
