
package archivos;
//para guardar en un archivo un objeto se tiene que serializar es decir pasar a una cadena de bytes el objeto 
//y recien se podrá guardar en un archivo
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;


public class ArchivoBinario {   
    private File f;
    private File fa;
    private String archivo;
    
    public ArchivoBinario(String archivo){
       this.archivo=archivo;
       //inicializar fa 
    }
    
    public void CrearArchivo(){
      try{
        f=new File(archivo); 
          System.out.println("Archivo Creado"+f.getAbsolutePath());
          
      }catch(Exception e){
          System.out.println("Error al crear el archivo");
      } 
      //Ubicacion del archivo 
      this.fa=f;
    }
    
    public String AsignarArchivo(){
        JFileChooser selector=new JFileChooser();
        selector.setDialogTitle("Escoga Archivo de Texto a cargar");
        selector.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES); 
        int num=selector.showOpenDialog(selector);
        if(num==JFileChooser.APPROVE_OPTION){
            File archivocargar=selector.getSelectedFile();
            this.fa=archivocargar;
            System.out.println(archivocargar.getName());    
            this.archivo=archivocargar.getName();
            return archivo;
        } 
        else
            return archivo;
    
    }
    public void Archivo(){
            JOptionPane.showMessageDialog(null,"\n\t\tCaracteristicas Archivo:\n "+"\n\n\tNombre  :       "+fa.getName()
                    +"\n\n\tUbicaion  :     "+fa.getAbsolutePath()
            +"\n\n\tUltima Modficación  :        "+new Date(fa.lastModified())+"\n","ARCJVO",JOptionPane.INFORMATION_MESSAGE);
    }
    
    
    public void LLenarDatos(){
      List<Persona> persona=new <Persona>ArrayList();
        persona.add(new Persona("Jose","09200159","9654",4000));        
        persona.add(new Persona("Luis","092355","548481961",2000)); 
        persona.add(new Persona("Juan","054544","548487845",1500));
          EscribirArchivo(persona);
      
    }
 
        public void EscribirArchivo(List<Persona> pers){
        /*List<Persona> persona=new <Persona>ArrayList();
        persona.add(new Persona("Alberto","09200159","9654",4000));        
        persona.add(new Persona("Luis","092355","548481961",2000)); 
        persona.add(new Persona("Juan","054544","548487845",1500));
       
         */ try{
           
           FileOutputStream fos=new FileOutputStream(archivo);
           ObjectOutputStream oos=new ObjectOutputStream(fos);
           oos.writeObject(pers); 
           fos.close();
           oos.close();
           //metodo opcional para pasar el registro y leerlo
           //LeerRegistro(pers);       
         }catch(Exception e){
           System.out.println("Error al escribir el archivo");
       }
    
         
    
    }  
    public void LeerArchivo(){
        List<Persona> personas=null;
        try{
           FileInputStream fis=new FileInputStream(archivo);//f="Binario.txt"
           ObjectInputStream ois=new ObjectInputStream(fis);
           personas=(ArrayList<Persona>)ois.readObject();
           if(personas!=null){
              for(Persona p:personas){
                  System.out.println(p.getNombre()+" "+p.getCodigo()+" "+p.getTelefono());
              }
           }
           else
                System.out.println("No hay registros");
            
     
           fis.close();
           ois.close();
             
        }catch(Exception ex){
            System.out.println("Error de lectura");
            
            ex.printStackTrace();
        }
    }  
    public void CambiarNombre2(){
        //para que me guarde en una nueva lista
        List<Persona> personactual=new <Persona>ArrayList();
        
        List<Persona> personal=null;
        Scanner scan=new Scanner(System.in);
        String name=scan.next();
        try{
         FileInputStream fis=new FileInputStream(f);
         ObjectInputStream ois=new ObjectInputStream(fis);
         personal=(ArrayList<Persona>)ois.readObject();
         if(personal!=null){
            for(Persona pe:personal){
                    
                    if(pe.getNombre().equals(name)){
                    
                    System.out.println("El nombre se encuentra en el registro");
                    System.out.println("Ingrese el nombre a cambiar");
                    Scanner sc=new Scanner(System.in);
                    String nuevonombre=sc.nextLine();
                    pe.setNombre(nuevonombre);   
                   }   
               personactual.add(pe);
           }
             
                    f.delete();
                    CrearArchivo();
                    EscribirArchivo(personactual);
         }
         else
                System.out.println("Archivo vacio");
        fis.close();
        ois.close();
        }catch(Exception e){
          System.out.println("ERROR ");
      }
       
        System.out.println(" ");
        LeerArchivo();
    }

//Metodo opcional  pasamos la lista de personas ñuego la imprimimos
   public void LeerRegistro(List<Persona> personal){
   List<Persona> personactual=new <Persona>ArrayList();
       
       
         if(personal!=null){
            for(Persona pe:personal){
                    System.out.println(pe.getNombre()+" "+pe.getTelefono());
                    if(pe.getNombre().equals("Luis")){
                    System.out.println("El nombre se encuentra en el registro:Luis");   
                   }   
               personactual.add(pe);
           }
            
         }
         else
                System.out.println("Archivo vacio");
       
        System.out.println(" ");
      
  }
 
 
 
   
   
   //con este metodo me devuelve la lista de personas  
   public ArrayList<Persona> ListaPersonas(){
      ArrayList<Persona> listpersonas=null;
      
      try{
      
      FileInputStream isr=new FileInputStream(archivo);
      ObjectInputStream ois=new ObjectInputStream(isr);
      listpersonas=(ArrayList<Persona>) ois.readObject();
      isr.close();
      ois.close();
      }catch(Exception e){
        System.out.println("Error al pasar la lista de personas");
    }  
      
      return listpersonas;
  
   }  
   
   //buscar codigo
   public Persona BuscarCodigo(String codigo){
         Persona pers = null;
         List<Persona> persona=ListaPersonas(); 
          if(persona!=null){
                for(Persona pe:persona){
                     if(pe.getCodigo().equals(codigo))
                     pers=pe;
                }
           } 
          return pers;
   }
   public void CambiarNombre(String nuevoNombre,String codigo){
      List<Persona> listaActual=new <Persona>ArrayList();
      List<Persona> personas=ListaPersonas();
      for(Persona pe:personas){
          if(pe.getCodigo().equals(codigo))
              pe.setNombre(nuevoNombre);
      listaActual.add(pe);         
      }
     f.delete();
     CrearArchivo();
     EscribirArchivo(listaActual);
   }
   public void CambiarCodigo(String nuevoCodigo){
     
   }  
   public void CambiarTelefono(String nuevoTelefono){
           
   }
   public void CambiarSueldo(String nuevoSueldo){
         
   }



}
