package edu.uniandes.ecos.contadorLOC.mundo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Calse encargada de realizar el conteo de las clases.
 * @author Leonardo Valbuena Calderon
 * @date 15/02/2016
 */
public class ContadorLOC {
    
    /**
     * lista de clases con informaci�n de conteo
     */
    private List<Clase> listaClases;
    
    /**
     * total de lineas LOC del programa analizado
     */
    private int totalLineasLOC;
    
    
    /**
     * Constructor
     * @param directorio carpeta donde se van a buscar los archivos
     */
    //@METODO
    public ContadorLOC(File directorio) {    
        totalLineasLOC = 0;
        listaClases = new ArrayList<Clase>();
        BuscadorArchivos buscador = new BuscadorArchivos();
        List<File> archivos = buscador.buscarArchivos(directorio);        
        for (File archivo : archivos) {
            listaClases.add(this.contarLineas(archivo.getAbsolutePath()));
        }        
    }
    
    /**
     * 
     * @param archivo ruta del archivo al cual se le va a realizar el conteo
     * @return clase que representa el archivo con el total de items y lineas
     */
    //@METODO
    public Clase contarLineas(String archivo) {
        Clase clase = new Clase();
        clase.setNombre(archivo);
                
        try {            
            FileReader f = new FileReader(archivo);
            BufferedReader b = new BufferedReader(f);
                        
            String cadena = "";
            int items = 0;
            int lineas = 0;
            while((cadena = b.readLine())!= null) {
                
                if (cadena.trim().startsWith("//@METODO")) {
                    items++;
                } else if (esLineaContable(cadena.trim())) {
                    lineas++;
                }
            }
            b.close();
            clase.setTotalItems(items);
            clase.setTotalLineasLOC(lineas);
            totalLineasLOC += lineas;
            
        } catch (FileNotFoundException ex) {
            
        } catch(IOException e) {
            
        }
        return clase;
    }
    
    /**
     * indica si la linea se debe o no contar
     * @param linea linea a la cual se le realiza validacion
     * @return true si la linea se debe contar, false de lo contrario
     */
    //@METODO
    private boolean esLineaContable(String linea) {
        boolean contable = true;
        
        if (linea.isEmpty() || linea.startsWith("/") || 
                linea.startsWith("*") ) {
            contable = false;
        }
        return contable;
    }

    /**
     * 
     * @return 
     */
    //@METODO
    public List<Clase> getListaClases() {
        return listaClases;
    }

    /**
     * 
     * @param listaClases 
     */
    //@METODO
    public void setListaClases(List<Clase> listaClases) {
        this.listaClases = listaClases;
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
