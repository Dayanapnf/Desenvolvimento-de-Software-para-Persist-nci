
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import static java.lang.System.in;
import static java.lang.System.out;
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
public class Atv01_quest3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
       
        Scanner entrada = new Scanner(System.in);
        System.out.println("Digite o nome do arquivo origem:");
        String arq1 = entrada.nextLine();
        System.out.println("Digite o nome do arquivo destino:");
        String arq2 = entrada.nextLine();
        
        File fileOrigin = new File(arq1);
        File fileDestiny = new File(arq2);
        FileInputStream is = new FileInputStream(fileOrigin);
        FileOutputStream os = new FileOutputStream(fileDestiny,true);
        BufferedInputStream bri = new BufferedInputStream(is);
        BufferedOutputStream bro = new BufferedOutputStream(os);
 
        long timeIni = System.currentTimeMillis();
        
        int x;
        while((x = bri.read()) != -1){
            bro.write(x);
            System.out.println("byte = "+x);
        }
        
        long timeFinal = System.currentTimeMillis();
        if(fileDestiny.exists() && fileDestiny.isFile()){
            
            System.out.println("Tempo total: " + (timeFinal - timeIni));
                
        }else{
            System.out.println("Arquivo inexistente!");
        }
        
        bri.close();
        bro.close();
    }
   
}
