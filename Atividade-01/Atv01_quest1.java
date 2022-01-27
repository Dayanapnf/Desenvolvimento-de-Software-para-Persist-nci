
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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
public class Atv01_quest1 {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException{
        
        Scanner entrada = new Scanner(System.in);
        System.out.println("Digite o nome do arquivo:");
        FileInputStream is = new FileInputStream(entrada.nextLine());
        System.out.println("Digite a String S:");
        String s = entrada.nextLine();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        
        String d ;
        String [] vets;
        
        while((d = br.readLine())!= null){
            vets = d.split(" ");
            for (String vet : vets)
            {
                if (vet.length() == s.length() + 1){
                    char carac = vet.charAt(vet.length()-1);
                    if(!(carac>= 'a' && carac<= 'z' || carac >= 'a' && carac <= 'z') && vet.substring(0,vet.length()-1).contains(s));
                }
                else if(vet.contains(s)){
                    System.out.println(d);
                }
                else 
                    System.out.println("String não faz parte do texto");
                
            }
        }
        
    }
    
}
