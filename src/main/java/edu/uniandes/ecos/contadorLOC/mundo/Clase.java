
package edu.uniandes.ecos.contadorLOC.mundo;

/**
 * Representa una clase a la cual se le realiza el conteo LOC
 * @author Leonardo Valbuena Calderon
 * @date 15/02/2016
 */
public class Clase {
    
    /**
     * Nombre de la clase
     */
    private String nombre;    
          
    /**
     * Total de metodos que contiene la clase
     */
    private int totalItems;
    
    /**
     * Total de lineas LOC que contiene la clase
     * basado en el estandar definido
     */
    private int totalLineasLOC;
    
    

    /**
     * 
     * @return 
     */
    //@METODO
    public String getNombre() {
        return nombre;
    }

    /**
     * 
     * @param nombre 
     */
    //@METODO
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * 
     * @return 
     */
    //@METODO
    public int getTotalItems() {
        return totalItems;
    }

    /**
     * 
     * @param totalItems 
     */
    //@METODO
    public void setTotalItems(int totalItems) {
        this.totalItems = totalItems;
    }

    /**
     * 
     * @return 
     */
    //@METODO
    public int getTotalLineasLOC() {
        return totalLineasLOC;
    }

    /**
     * 
     * @param totalLineasLOC 
     */
    //@METODO
    public void setTotalLineasLOC(int totalLineasLOC) {
        this.totalLineasLOC = totalLineasLOC;
    }
    
    
    
    
}
