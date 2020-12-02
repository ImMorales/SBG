
package Logic;


import UI.Reportes;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.util.IOUtils;



/**
 *
 * @author mmorales
 */
public class Metodos_Reporte {
          Calendar cal = Calendar.getInstance();
            String d = ""+cal.get(Calendar.DATE);
            String m = ""+cal.get(Calendar.MONTH);
            String a = ""+cal.get(Calendar.YEAR);
            int mint = Integer.parseInt(m);
            int mes = mint + 1;
            String h = ""+cal.get(Calendar.HOUR_OF_DAY);
            String mi = ""+cal.get(Calendar.MINUTE);
            String s = ""+cal.get(Calendar.SECOND);
            String fecha ="["+d+"-"+mes+"-"+a+"]";
            String hora ="["+h+":"+mi+":"+s+"]";
     
    
    public void reporte_estudiantes(String ruta){
       InputStream is = null;
        try {
            
            Workbook book = new HSSFWorkbook();
            Sheet sheet = (Sheet) book.createSheet("Cleintes");
            //agregando foto al excel
            //cuidado con el perro
            
            CellStyle tituloEstilo = book.createCellStyle();
            tituloEstilo.setAlignment(HorizontalAlignment.CENTER);
            tituloEstilo.setVerticalAlignment(VerticalAlignment.CENTER);
            //fuente titulo
            Font fuenteTitulo = book.createFont();
            fuenteTitulo.setFontName("Arial");
            fuenteTitulo.setBold(true);
            fuenteTitulo.setFontHeightInPoints((short)14);
            tituloEstilo.setFont(fuenteTitulo);
            Row filatitulo = sheet.createRow(1); //combinaciones
            Cell celdatitulo = filatitulo.createCell(0);
            celdatitulo.setCellStyle(tituloEstilo);
            celdatitulo.setCellValue("Sistema bibliotecario: Reporte de clientes");
            // fila de inicio, ultima fila de uso, la primera columna que usara, la ultima col
            sheet.addMergedRegion(new CellRangeAddress(1,2,0,5));
        
            String[] cabecera = new String[]{"Matricula","Nombre","Apellido paterno","Apellido materno","Grado","Grupo"};
             // estilo de la celda
             CellStyle headerStyle = book.createCellStyle();
             headerStyle.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
             headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
             headerStyle.setBorderBottom(BorderStyle.THIN);
             headerStyle.setBorderRight(BorderStyle.THIN);
             headerStyle.setBorderTop(BorderStyle.THIN);
             headerStyle.setBorderLeft(BorderStyle.THIN);
             //fuente de la celda
            Font font = book.createFont();
            font.setFontName("Arial");
            font.setBold(true);
            font.setColor(IndexedColors.WHITE.getIndex());
            font.setFontHeightInPoints((short)12);
            headerStyle.setFont(font);
             //empieza en la 5, es un arreglo asi que 4
            Row filaencabezados = sheet.createRow(4);
            for(int i = 0; i < cabecera.length; i++){
                Cell celdaencabezado = filaencabezados.createCell(i);
                celdaencabezado.setCellStyle(headerStyle);
                celdaencabezado.setCellValue(cabecera[i]);
            }
            conexion con = new conexion();
            con.ConectarBasedeDatos();
            int numfiladatos = 5; //desde que fila se chambea
            
             CellStyle dataStyle = book.createCellStyle();
             dataStyle.setBorderBottom(BorderStyle.THIN);
             dataStyle.setBorderRight(BorderStyle.THIN);
             dataStyle.setBorderTop(BorderStyle.THIN);
             dataStyle.setBorderLeft(BorderStyle.THIN);
            
        String sql = "SELECT * from alumno";
        con.resultado = con.sentencia.executeQuery(sql);
        int numCol = con.resultado.getMetaData().getColumnCount();
        //System.out.println(numCol);
        while(con.resultado.next()){
            Row filadatos = sheet.createRow(numfiladatos);
            for (int a2=0 ;a2 < numCol; a2++){
                Cell celdaDatos = filadatos.createCell(a2);
                celdaDatos.setCellStyle(dataStyle);
                
                if(a2 == 4){
               celdaDatos.setCellValue(con.resultado.getDouble(a2+1));
                    
                }else{
               celdaDatos.setCellValue(con.resultado.getString(a2+1));
                }
                
            }
            numfiladatos++;
        }
            sheet.autoSizeColumn(0);
            sheet.autoSizeColumn(1);
            sheet.autoSizeColumn(2);
            sheet.autoSizeColumn(3);
            sheet.autoSizeColumn(4);
            sheet.autoSizeColumn(5);
          //  sheet.setZoom(150);
            
        //cuidado con el perro 2 pendiente
            //FileOutputStream fileOut = new FileOutputStream(ruta+"\\Sibi_reporte_estudiantes "+hora+fecha+".xlsx");
            //
            try{
            FileOutputStream fileOut = new FileOutputStream(ruta+"/Sibi_Clientes "+fecha+"&"+hora+".xlsx");
            book.write(fileOut);
            fileOut.close();
           
            }catch(Exception nl){
            FileOutputStream fileOut = new FileOutputStream(ruta+"\\Sibi_Clientes "+fecha+"&"+hora+".xlsx");
            book.write(fileOut);
            fileOut.close();
                
            }

//  FileOutputStream fileOut = new FileOutputStream(new File (ruta));
        


            con.DesconectarBasedeDatos();
        
        
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Metodos_Reporte.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Metodos_Reporte.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Metodos_Reporte.class.getName()).log(Level.SEVERE, null, ex);
        } 
            
            
                    
        
        }
    
    //--.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-..-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.
    public void reporte_libros(String ruta){
       try {
            Workbook book = new HSSFWorkbook();
            Sheet sheet = (Sheet) book.createSheet("Libros");
            //agregando foto al excel
            //cuidado con el perro 2
            
            CellStyle tituloEstilo = book.createCellStyle();
            tituloEstilo.setAlignment(HorizontalAlignment.CENTER);
            tituloEstilo.setVerticalAlignment(VerticalAlignment.CENTER);
            //fuente titulo
            Font fuenteTitulo = book.createFont();
            fuenteTitulo.setFontName("Arial");
            fuenteTitulo.setBold(true);
            fuenteTitulo.setFontHeightInPoints((short)14);
            tituloEstilo.setFont(fuenteTitulo);
            Row filatitulo = sheet.createRow(1); //combinaciones
            Cell celdatitulo = filatitulo.createCell(0);
            celdatitulo.setCellStyle(tituloEstilo);
            celdatitulo.setCellValue("Sistema bibliotecario: Reporte de libros");
            // fila de inicio, ultima fila de uso, la primera columna que usara, la ultima col
            sheet.addMergedRegion(new CellRangeAddress(1,2,0,7));
        
            String[] cabecera = new String[]{"Id_libro","Nombre del libro","Descripcion","Tipo","Subgenero","Cantidad","Editorial","Numero de paginas"};
             // estilo de la celda
             CellStyle headerStyle = book.createCellStyle();
             headerStyle.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
             headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
             headerStyle.setBorderBottom(BorderStyle.THIN);
             headerStyle.setBorderRight(BorderStyle.THIN);
             headerStyle.setBorderTop(BorderStyle.THIN);
             headerStyle.setBorderLeft(BorderStyle.THIN);
             //fuente de la celda
            Font font = book.createFont();
            font.setFontName("Arial");
            font.setBold(true);
            font.setColor(IndexedColors.WHITE.getIndex());
            font.setFontHeightInPoints((short)12);
            headerStyle.setFont(font);
             //empieza en la 5, es un arreglo asi que 4
            Row filaencabezados = sheet.createRow(4);
            for(int i = 0; i < cabecera.length; i++){
                Cell celdaencabezado = filaencabezados.createCell(i);
                celdaencabezado.setCellStyle(headerStyle);
                celdaencabezado.setCellValue(cabecera[i]);
            }
            conexion con = new conexion();
            con.ConectarBasedeDatos();
            int numfiladatos = 5; //desde que fila se chambea
            
             CellStyle dataStyle = book.createCellStyle();
             dataStyle.setBorderBottom(BorderStyle.THIN);
             dataStyle.setBorderRight(BorderStyle.THIN);
             dataStyle.setBorderTop(BorderStyle.THIN);
             dataStyle.setBorderLeft(BorderStyle.THIN);
            
        String sql = "SELECT * FROM libro;";
        con.resultado = con.sentencia.executeQuery(sql);
        int numCol = con.resultado.getMetaData().getColumnCount();
        //System.out.println(numCol);
        while(con.resultado.next()){
            Row filadatos = sheet.createRow(numfiladatos);
            for (int a2=0 ;a2 < numCol; a2++){
                Cell celdaDatos = filadatos.createCell(a2);
                celdaDatos.setCellStyle(dataStyle);
                
                if(a2 == 0 || a2 == 5 ){
               celdaDatos.setCellValue(con.resultado.getDouble(a2+1));
                    
                }else{
               celdaDatos.setCellValue(con.resultado.getString(a2+1));
                }
                
            }
            numfiladatos++;
        }
            sheet.autoSizeColumn(0);
            sheet.autoSizeColumn(1);
            sheet.autoSizeColumn(2);
            sheet.autoSizeColumn(3);
            sheet.autoSizeColumn(4);
            sheet.autoSizeColumn(5);
            sheet.autoSizeColumn(6);
            sheet.autoSizeColumn(7);
          
          //  sheet.setZoom(150);
            
        
          //mmmm
            try{
            FileOutputStream fileOut = new FileOutputStream(ruta+"/Sibi_Libros "+fecha+"&"+hora+".xlsx");
            book.write(fileOut);
            fileOut.close();
           
            }catch(Exception nl){
            FileOutputStream fileOut = new FileOutputStream(ruta+"\\Sibi_Libros "+fecha+"&"+hora+".xlsx");
            book.write(fileOut);
            fileOut.close();
                
            }
          //end mmmm
            
            
            
            
            con.DesconectarBasedeDatos();
        
        
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Metodos_Reporte.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Metodos_Reporte.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Metodos_Reporte.class.getName()).log(Level.SEVERE, null, ex);
        } 
            
            
                    
        
        }
    //-.-.-.-.-..-.-.-..-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-...-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-..
    
    public void reporte_prestamos(String ruta){
       try {
           
            Workbook book = new HSSFWorkbook();
            Sheet sheet = (Sheet) book.createSheet("Prestamos");
            //agregando foto al excel
            //cuidado con el perro 2
            //end img 
            //end pic 
            CellStyle tituloEstilo = book.createCellStyle();
            tituloEstilo.setAlignment(HorizontalAlignment.CENTER);
            tituloEstilo.setVerticalAlignment(VerticalAlignment.CENTER);
            //fuente titulo
            Font fuenteTitulo = book.createFont();
            fuenteTitulo.setFontName("Arial");
            fuenteTitulo.setBold(true);
            fuenteTitulo.setFontHeightInPoints((short)14);
            tituloEstilo.setFont(fuenteTitulo);
            Row filatitulo = sheet.createRow(1); //combinaciones
            Cell celdatitulo = filatitulo.createCell(0);
            celdatitulo.setCellStyle(tituloEstilo);
            celdatitulo.setCellValue("Sistema bibliotecario: Reporte de prestamos");
            // fila de inicio, ultima fila de uso, la primera columna que usara, la ultima col
            sheet.addMergedRegion(new CellRangeAddress(1,2,0,8));
        
            
            String[] cabecera = new String[]{"id prestamo","Nombre","Apellido paterno","Apellido materno","Libro","Docente","Fecha de salida","Fecha de devolucion","Estado"};
             // estilo de la celda
             CellStyle headerStyle = book.createCellStyle();
             headerStyle.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
             headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
             headerStyle.setBorderBottom(BorderStyle.THIN);
             headerStyle.setBorderRight(BorderStyle.THIN);
             headerStyle.setBorderTop(BorderStyle.THIN);
             headerStyle.setBorderLeft(BorderStyle.THIN);
             //fuente de la celda
            Font font = book.createFont();
            font.setFontName("Arial");
            font.setBold(true);
            font.setColor(IndexedColors.WHITE.getIndex());
            font.setFontHeightInPoints((short)12);
            headerStyle.setFont(font);
             //empieza en la 5, es un arreglo asi que 4
            Row filaencabezados = sheet.createRow(4);
            for(int i = 0; i < cabecera.length; i++){
                Cell celdaencabezado = filaencabezados.createCell(i);
                celdaencabezado.setCellStyle(headerStyle);
                celdaencabezado.setCellValue(cabecera[i]);
            }
            conexion con = new conexion();
            con.ConectarBasedeDatos();
            int numfiladatos = 5; //desde que fila se chambea
            
             CellStyle dataStyle = book.createCellStyle();
             dataStyle.setBorderBottom(BorderStyle.THIN);
             dataStyle.setBorderRight(BorderStyle.THIN);
             dataStyle.setBorderTop(BorderStyle.THIN);
             dataStyle.setBorderLeft(BorderStyle.THIN);
        String sql = "select p.id_prestamo, a.nombre, a.apellido_paterno, a.apellido_materno, l.nombre, p.docente, p.fecha_salida, p.fecha_devolucion, p.estado from prestamo p, alumno a, libro l where p.matricula = a.matricula and p.id_libro = l.id_libro;";
        //String sql = "SELECT  A.nombre,A.apellido_paterno,A.apellido_materno,D.nombre,D.apellido_paterno,D.apellido_materno,L.nombre, L.tipo,L.sub_genero,P.fecha_salida,P.fecha_entrega FROM libro L,alumno A,prestamo P,Personal D WHERE P.rfc = D.rfc AND A.matricula=P.matricula";
        con.resultado = con.sentencia.executeQuery(sql);
        int numCol = con.resultado.getMetaData().getColumnCount();
       // System.out.println(numCol);
        while(con.resultado.next()){
            Row filadatos = sheet.createRow(numfiladatos);
            for (int a2=0 ;a2 < numCol; a2++){
                Cell celdaDatos = filadatos.createCell(a2);
                celdaDatos.setCellStyle(dataStyle);
                
                
               celdaDatos.setCellValue(con.resultado.getString(a2+1));
                
            }
            numfiladatos++;
        }
            sheet.autoSizeColumn(0);
            sheet.autoSizeColumn(1);
            sheet.autoSizeColumn(2);
            sheet.autoSizeColumn(3);
            sheet.autoSizeColumn(4);
            sheet.autoSizeColumn(5);
            sheet.autoSizeColumn(6);
            sheet.autoSizeColumn(7);
            sheet.autoSizeColumn(8);
      
          //  sheet.setZoom(150);
            
        
            //mmmm
            try{
            FileOutputStream fileOut = new FileOutputStream(ruta+"/Sibi_Prestamos "+fecha+"&"+hora+".xlsx");
            book.write(fileOut);
            fileOut.close();
           
            }catch(Exception nl){
            FileOutputStream fileOut = new FileOutputStream(ruta+"\\Sibi_Prestamos "+fecha+"&"+hora+".xlsx");
            book.write(fileOut);
            fileOut.close();
                
            }
          //end mmmm
            
            
            con.DesconectarBasedeDatos();
        
        
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Metodos_Reporte.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Metodos_Reporte.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Metodos_Reporte.class.getName()).log(Level.SEVERE, null, ex);
        } 
            
       }
    //./.././././././././././././././././././././././././.././././././././../././././././././.
    public void reporte_personal(String ruta){
        try {
            Workbook book = new HSSFWorkbook();
            Sheet sheet = (Sheet) book.createSheet("Personal");
            //agregando foto al excel
            //cuidado con el perro 2
            
            
            CellStyle tituloEstilo = book.createCellStyle();
            tituloEstilo.setAlignment(HorizontalAlignment.CENTER);
            tituloEstilo.setVerticalAlignment(VerticalAlignment.CENTER);
            //fuente titulo
            Font fuenteTitulo = book.createFont();
            fuenteTitulo.setFontName("Arial");
            fuenteTitulo.setBold(true);
            fuenteTitulo.setFontHeightInPoints((short)14);
            tituloEstilo.setFont(fuenteTitulo);
            Row filatitulo = sheet.createRow(1); //combinaciones
            Cell celdatitulo = filatitulo.createCell(0);
            celdatitulo.setCellStyle(tituloEstilo);
            celdatitulo.setCellValue("Sistema bibliotecario: Reporte de usuarios");
            // fila de inicio, ultima fila de uso, la primera columna que usara, la ultima col
            sheet.addMergedRegion(new CellRangeAddress(1,2,0,4));
        
            String[] cabecera = new String[]{"RFC","Nombre","Apellido paterno","Apellido materno","Funcion"};
             // estilo de la celda
             CellStyle headerStyle = book.createCellStyle();
             headerStyle.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
             headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
             headerStyle.setBorderBottom(BorderStyle.THIN);
             headerStyle.setBorderRight(BorderStyle.THIN);
             headerStyle.setBorderTop(BorderStyle.THIN);
             headerStyle.setBorderLeft(BorderStyle.THIN);
             //fuente de la celda
            Font font = book.createFont();
            font.setFontName("Arial");
            font.setBold(true);
            font.setColor(IndexedColors.WHITE.getIndex());
            font.setFontHeightInPoints((short)12);
            headerStyle.setFont(font);
             //empieza en la 5, es un arreglo asi que 4
            Row filaencabezados = sheet.createRow(4);
            for(int i = 0; i < cabecera.length; i++){
                Cell celdaencabezado = filaencabezados.createCell(i);
                celdaencabezado.setCellStyle(headerStyle);
                celdaencabezado.setCellValue(cabecera[i]);
            }
            conexion con = new conexion();
            con.ConectarBasedeDatos();
            int numfiladatos = 5; //desde que fila se chambea
            
             CellStyle dataStyle = book.createCellStyle();
             dataStyle.setBorderBottom(BorderStyle.THIN);
             dataStyle.setBorderRight(BorderStyle.THIN);
             dataStyle.setBorderTop(BorderStyle.THIN);
             dataStyle.setBorderLeft(BorderStyle.THIN);
            
        String sql = "select rfc,nombre,apellido_paterno,apellido_materno,funcion from personal;";
        con.resultado = con.sentencia.executeQuery(sql);
        int numCol = con.resultado.getMetaData().getColumnCount();
       // System.out.println(numCol);
        while(con.resultado.next()){
            Row filadatos = sheet.createRow(numfiladatos);
            for (int a2=0 ;a2 < numCol; a2++){
                Cell celdaDatos = filadatos.createCell(a2);
                celdaDatos.setCellStyle(dataStyle);
                
                if(a2 == 0 || a2 == 5 ){
               celdaDatos.setCellValue(con.resultado.getString(a2+1));
                    
                }else{
               celdaDatos.setCellValue(con.resultado.getString(a2+1));
                }
                
            }
            numfiladatos++;
        }
            sheet.autoSizeColumn(0);
            sheet.autoSizeColumn(1);
            sheet.autoSizeColumn(2);
            sheet.autoSizeColumn(3);
            sheet.autoSizeColumn(4);
          //  sheet.setZoom(150);
            
          //mmmm
            try{
            FileOutputStream fileOut = new FileOutputStream(ruta+"/Sibi_Personal "+fecha+"&"+hora+".xlsx");
            book.write(fileOut);
            fileOut.close();
           
            }catch(Exception nl){
            FileOutputStream fileOut = new FileOutputStream(ruta+"\\Sibi_Personal "+fecha+"&"+hora+".xlsx");
            book.write(fileOut);
            fileOut.close();
                
            }
          //end mmmm
            
            
            
            
            con.DesconectarBasedeDatos();
        
        
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Metodos_Reporte.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Metodos_Reporte.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Metodos_Reporte.class.getName()).log(Level.SEVERE, null, ex);
        } 
            
            
                    
        
        }
    //././././././././././.././././.././././././././././././././././././././././/././././././.
    
    public static void main(String[] args){
           //reporte_estudiantes("Testing...");
        }
}
