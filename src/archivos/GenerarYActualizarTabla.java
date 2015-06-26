/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos;

import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alberto
 */
public class GenerarYActualizarTabla extends JPanel{
   private final String[] titulos={"Nombre","Codigo","Telefono","Sueldo"};  
   private DefaultTableModel dtm; 
   private JTable tabla;
   private JScrollPane scroll;
    
   public GenerarYActualizarTabla(){
        
        setSize(500,400); 
        dtm=new DefaultTableModel();
        tabla=new JTable(dtm);
        dtm.setColumnIdentifiers(titulos);//asigna mi Cadena a la primera Columna
        tabla.setEnabled(false);
        scroll=new JScrollPane(tabla);        
        setLayout(new BorderLayout());
        add(scroll,BorderLayout.CENTER);
   }
    
   /*public JScrollPane GenerarTabla(){
     dtm=new DefaultTableModel();
        tabla=new JTable(dtm);
        dtm.setColumnIdentifiers(titulos);//asigna mi Cadena a la primera Columna
        tabla.setEnabled(false);
        scroll=new JScrollPane(tabla);        
        return scroll;
   }*/
   
   
   public void ActualizaTabla(ArrayList<Persona> listaPersonas){
        try{
            dtm.setRowCount(0); //limpio mi tabla y la vuelvo a llenar
            dtm.setColumnCount(0);
            dtm.setColumnIdentifiers(titulos);
            if(listaPersonas!=null){
              for(Persona p:listaPersonas){
                  Object[] fila={p.getNombre(),p.getCodigo(),p.getTelefono(),p.getSueldo()};
                  dtm.addRow(fila);
                  
              }
           }
           else
                System.out.println("No hay registros");
       
        }catch(Exception e){
              System.out.println("Error de lectura");
              JOptionPane.showMessageDialog(null,"ERROR DE LECTURA,CARGAR OTRO ARCHIVO","Error",JOptionPane.ERROR_MESSAGE);
              e.printStackTrace();
        }
   }

}
