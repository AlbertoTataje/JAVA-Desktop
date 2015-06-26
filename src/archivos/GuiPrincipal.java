
package archivos;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class GuiPrincipal extends JFrame{
    private JButton registrar,buscar;
    private JLabel nombre,telefono,codigo,sueldo;
    private JPanel ingresar;
    private JPanel opciones;
    private JPanel paneltabla;
    private JTable tabla;
    private DefaultTableModel dmt;
    private JScrollPane scroll;
    
    public GuiPrincipal(){
        setSize(500,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        this.setLocationRelativeTo(null); 
        setVisible(true);
  }

}