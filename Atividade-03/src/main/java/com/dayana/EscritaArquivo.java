import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author daypn
 */
public class EscritaArquivo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
              Properties prop = new Properties();
	
		
        try{
		
            prop.setProperty("Linha_inicial","1");		
            prop.setProperty("Linha_final", "10");		
            prop.store(new FileOutputStream("confg.properties"),null);

		
        }catch (IOException ex){
			
            ex.printStackTrace();
		
        }
	
    }
}
    
    

