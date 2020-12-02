
package Logic;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author martin
 */
public class Prestamos_Render extends DefaultTableCellRenderer {
 @Override
    public Component getTableCellRendererComponent(JTable table, Object value, 
                                                   boolean isSelected, 
                                                   boolean hasFocus, 
                                                   int row, 
                                                   int column) {
 
    String estado = (String) table.getValueAt(row, 8);
 switch(estado)
        {
            case "pendiente":
            setBackground(Color.WHITE);
            setForeground(Color.BLACK);
            break;
            
            case "ultimo dia de entrega":
            setBackground(new Color (255,255,153));
            setForeground(Color.BLACK);
            break;
            
            case "tiempo excedido":
            setBackground(new Color (255,102,102));
            setForeground(Color.BLACK);
            break;
            
            default:
            setBackground(Color.WHITE);
            setForeground(Color.BLACK);
 }
        
 
        return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
    }    
}


 
        /*
 switch(Valor)
        {
            case "pendiente":
            cell.setBackground(Color.WHITE);
            cell.setForeground(Color.BLACK);
            break;
            
            case "ultimo dia de entrega":
            cell.setBackground(Color.yellow);
            cell.setForeground(Color.BLACK);
            break;
            
            case "tiempo excedido":
            cell.setBackground(Color.red);
            cell.setForeground(Color.BLACK);
            break;
            
            default:
            cell.setBackground(Color.WHITE);
            cell.setForeground(Color.BLACK);
            System.out.println("Prestamos_Render excepcion");
       







        if (column == 8)
        {
        
            if(Valor.equals("pendiente")){
            cell.setBackground(Color.WHITE);
            cell.setForeground(Color.BLACK);
        }
        else if(Valor.equals("ultimo dia de entrega")){
            cell.setBackground(Color.YELLOW);
            cell.setForeground(Color.BLACK);
        }
        else if(Valor.equals("tiempo excedido")){
            cell.setBackground(Color.RED);
            cell.setForeground(Color.BLACK);
        }
        else{
            cell.setBackground(Color.WHITE);
            cell.setForeground(Color.BLACK);
         }
        
        */ 