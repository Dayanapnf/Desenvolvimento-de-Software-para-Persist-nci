
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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
	String arquivo = args[0];
        Properties prop = new Properties();
	
	try{
            
            
            prop.load(new FileInputStream( "confg.properties"));
                    
            int inicio = Integer.parseInt(prop.getProperty("Linha_inicial"));
            int fim = Integer.parseInt(prop.getProperty("Linha_final"));
           // Scanner entrada = new Scanner(System.in);
           // System.out.println("Digite o nome do arquivo:");
           // String arquivo = entrada.nextLine();
            InputStream is = new FileInputStream(arquivo);
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            int i =inicio;
            while(i <=fim){
                System.out.println("linha " + i +": "+ br.readLine() );
                i++;
            
            };        
            
        }catch (IOException ex){
            ex.printStackTrace();
        }
        
                        
   }
}
