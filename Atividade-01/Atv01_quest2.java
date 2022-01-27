
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
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
public class Atv01_quest2 {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException{
        
        Scanner entrada = new Scanner(System.in);
        System.out.println("Digite o nome do 1° arquivo:");
        String arq1 = entrada.nextLine();
        System.out.println("Digite o nome do 2° arquivo");
        String arq2 = entrada.nextLine();
        System.out.println("Digite o nome do 3° arquivo");
        String arq3 = entrada.nextLine();
        
       
        File arquivo;
        File saida = new File(arq3);
        File[] arquivos = new File[]{new File(arq1),new File (arq2)};
        FileReader fr = null;
        BufferedReader br = null;
        FileOutputStream fos = null;
        String linha = " ";
        
        long timeIni = System.currentTimeMillis();
        
        for (int i = 0; i < arquivos.length; i++) {
            arquivo = arquivos[i];
            fr = new FileReader(arquivo);
            br = new BufferedReader(fr);
            fos = new FileOutputStream(saida,true);
            while ((linha = br.readLine()) != null) {
                fos.write(linha.getBytes());
            }
        }
        long timeFinal = System.currentTimeMillis();
        System.out.println("Tempo total: " + (timeFinal - timeIni));
        
       
        if(saida.exists() && saida.isFile()){
                System.out.printf("Arquivo (%s) - tamanho: %d bytes\n", saida.getName(), saida.length());
        }else{
            System.out.println("Arquivo inexistente!");
        }
        
        
        fos.flush();
        fos.close();
        
        
        
        
    }
}
             

