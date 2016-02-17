package edu.uniandes.ecos.contadorLOC.mundo;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase encargada de buscar los arvhivos a los cuales se le
 * quiere realizar conteo.
 * @author Leonardo Valbuena Calderon
 * @date 15/02/2016
 */
public class BuscadorArchivos {
    
    /**
     * indica la extension de los archivos que se deben contar
     */
    private static final String EXTENSION_VALIDA = ".java";
    
    /**
     * Lista de archivos a los cuales se les va a contar lineas
     */
    private List<File> listaArchivos;
    
    /**
     * 
     */
    //@METODO
    public BuscadorArchivos() {        
        listaArchivos = new ArrayList<File>();
    }
    
    /**
     * Se encarga de buscar todos los archivos (.java) que se encuentren
     * en el directorio enviado.
     * @param directorio carpeta donde se realiza la busqueda
     * @return lista de archivos (.java) a los cuales se les va a realizar conteo
     */
    //@METODO
    public List<File> buscarArchivos(File directorio) {          
        if (directorio.listFiles() != null) {
            for (File archivo : directorio.listFiles()) {                
                if (archivo.isDirectory()) {
                    buscarArchivos(archivo);
                } else {
                    if (archivo.getName().trim().endsWith(EXTENSION_VALIDA)) {
                        listaArchivos.add(archivo);
                    }
                }
            }
        }
        return listaArchivos;
    }
    
}
