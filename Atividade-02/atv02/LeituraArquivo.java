
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author daypn
 */
public class LeituraArquivo {
    public static void main(String[] args) throws IOException{
	
        Properties prop = new Properties();
	
	try{
            
            Scanner entrada = new Scanner(System.in);
            System.out.println("Digite o nome do arquivo:");
            prop.load(new FileInputStream(entrada.nextLine()));
                    
            System.out.println(prop.getProperty("nome"));
            System.out.println(prop.getProperty("curso"));
            System.out.println(prop.getProperty("matricula"));		

        }catch (IOException ex){
            ex.printStackTrace();
        }
        
                        
   }
}
