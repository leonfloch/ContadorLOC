package edu.uniandes.ecos.contadorLOC;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Clase encargada de realizar pruebas a la aplicacion
 * @author Leonardo Valbuena Calderon
 * @date 16/02/2016
 */
public class Prueba extends TestCase {
    
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    //@METODO
    public Prueba( String testName ) {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    //@METODO
    public static Test suite() {
        return new TestSuite( Prueba.class );
    }

    /**
     * Rigourous Test :-)
     */
    //@METODO
    public void testApp() {
        assertTrue( true );
    }
}
