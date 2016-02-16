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
     * 
     */
    private JPanel contentPane;
    
    /**
     * 
     */
    private JTextField textField;    
    
    /**
     * 
     */
    private JLabel jlabel;

    /**
     * 
     * @param args 
     */
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
    public InterfazContador() {        
        //Parametros asociados a la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setLayout(null);
        setContentPane(contentPane);

        textField = new JTextField();
        textField.setToolTipText("Directorio donde se encuentran las clases");
        textField.setBounds(52, 26, 209, 20);
        contentPane.add(textField);
        textField.setColumns(10);

        JButton btnSeleccionar = new JButton("Seleccionar Directorio");
        btnSeleccionar.setBounds(270, 25, 180, 23);
        contentPane.add(btnSeleccionar);
        
        jlabel = new JLabel();
        jlabel.setBounds(52, 76, 360, 156);
        
        
        JScrollPane scroll = new JScrollPane(jlabel);
        scroll.setBounds(52, 76, 360, 156);
        contentPane.add(scroll);
                               

        
        btnSeleccionar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                                
                JFileChooser fc = new JFileChooser();

                //solo se permiten seleccionar directorios
                fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

                int seleccion = fc.showOpenDialog(contentPane);

                //cuando se seleccione aceptar se inicia el calculo
                if (seleccion == JFileChooser.APPROVE_OPTION) {
                    
                    File directorio = fc.getSelectedFile();
                    
                    //se realiza calculo de lineas
                    ContadorLOC contadorLOC = new ContadorLOC(directorio);
                    
                    String t = "";
                    for (Clase clase : contadorLOC.getListaClases()) {
                        t += clase.getNombre() + "\n";

                    }
                    
                    jlabel.setText(t);

                }

            }
        });
    }
}
