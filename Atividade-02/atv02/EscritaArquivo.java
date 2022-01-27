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
		
            prop.setProperty("nome", "Dayana");		
            prop.setProperty("curso", "sistemas de informação");		
            prop.setProperty("matricula", "497091");	
            prop.store(new FileOutputStream("questao03.properties"),null);

		
        }catch (IOException ex){
			
            ex.printStackTrace();
		
        }
	
    }
}
    
    

