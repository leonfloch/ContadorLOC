package edu.uniandes.ecos.contadorLOC.interfaz;

import edu.uniandes.ecos.contadorLOC.mundo.Clase;
import edu.uniandes.ecos.contadorLOC.mundo.ContadorLOC;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/**
 * Interfaz visual en donde el usuario selecciona la carpeta donde se encuentran
 * los archivos a contar.
 *
 * @author Leonardo Valbuena Calderon
 * @date 15/02/2016
 */
public class InterfazContador extends JFrame {

    /**
     * contenedor de los elementos de la pantalla
     */
    private JPanel contenedor;
    
    /**
     * caja de texto donde se muestra el directorio seleccionado
     */
    private JTextField textField;    
    
    /**
     * label donde se muestran los resultados
     */
    private JLabel jlabel;

    /**
     * Metodo inicial donde se lanza la aplicacion
     * @param args 
     */
    //@METODO
    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    InterfazContador frame = new InterfazContador();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }

    /**
     * 
     */
    //@METODO
    public InterfazContador() {        
        //Parametros asociados a la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 380);
        setTitle("Contador Lineas Código LOC");
        contenedor = new JPanel();
        contenedor.setLayout(null);        
        setContentPane(contenedor);

        textField = new JTextField();
        textField.setToolTipText("Directorio donde se encuentran las clases");
        textField.setBounds(30, 50, 380, 20);
        contenedor.add(textField);
        textField.setColumns(10);

        JButton btnSeleccionar = new JButton("Seleccionar Directorio");
        btnSeleccionar.setBounds(30, 15, 180, 23);
        contenedor.add(btnSeleccionar);
        
        jlabel = new JLabel();
        jlabel.setBounds(30, 76, 380, 240);
        
        JScrollPane scroll = new JScrollPane(jlabel);
        scroll.setBounds(30, 76, 380, 240);
        contenedor.add(scroll);
           
        //evento que dispara el boton de busqueda
        btnSeleccionar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                     
                JFileChooser fc = new JFileChooser();

                //solo se permiten seleccionar directorios
                fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

                int seleccion = fc.showOpenDialog(contenedor);
                                
                //cuando se seleccione aceptar se inicia el calculo
                if (seleccion == JFileChooser.APPROVE_OPTION) {     

                    File directorio = fc.getSelectedFile();
                    textField.setText(directorio.toString());
                    //se realiza calculo de lineas
                    ContadorLOC contadorLOC = new ContadorLOC(directorio);                    
                    pintarResultado(contadorLOC);                    
                }
            }
        });
    }
    
    /**
     * Pinta el resultado del conteo en pantalla
     * @param contadorLOC resultado del conteo 
     */
    //@METODO
    public void pintarResultado(ContadorLOC contadorLOC) {
        jlabel.setText("");                            
        String resultado = "<HTML><table border=\"1\" style=\"width:100%\">";
        resultado += "<th>Clase</th><th>Items</th><th>Lineas LOC</th>";
        for (Clase clase : contadorLOC.getListaClases()) {
            resultado += "<tr><td>" + clase.getNombre() + "</td>";
            resultado += "<td>" + clase.getTotalItems() + "</td>";
            resultado += "<td>" + clase.getTotalLineasLOC() + "</td></tr>";
        }
        resultado += "</table>";
        resultado += "<h3>Total Lineas: " +  contadorLOC.getTotalLineasLOC() + "</h3></html>";
        jlabel.setText(resultado);        
    }
}
