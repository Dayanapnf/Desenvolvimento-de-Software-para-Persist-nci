import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class Atv2_01 {
   
/**
 *
 * @author daypn

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    static private int BUFFER_SIZE = 4096;
    public static void main(String[] args) throws FileNotFoundException, IOException {
       
        Scanner entrada = new Scanner(System.in);
        System.out.println("Digite o nome do arquivo origem:");
        String arq1 = entrada.nextLine();
        System.out.println("Digite o nome do arquivo destino:");
        String arq2 = entrada.nextLine();
        
        
        long timeIni = System.currentTimeMillis();
        File fileOrigin = new File(arq1);
        File fileDestiny = new File(arq2);
        int bufferSize= 4096;
        InputStream is = new BufferedInputStream(new FileInputStream(fileOrigin), bufferSize);
        OutputStream os = new BufferedOutputStream(new FileOutputStream(fileDestiny,true),bufferSize);
        
       
        byte[] buffer = new byte[BUFFER_SIZE];
        
        
        /*long fileSize = fileOrigin.length();
        byte[] allBytes = new byte[(int) fileSize];
        is.read(allBytes);
        os.write(allBytes);
        */
        while (is.read(buffer) != -1) {
           os.write(buffer);
        }
        long timeFinal = System.currentTimeMillis();
            
        System.out.println("Tempo total: " + (timeFinal - timeIni));
                
        
    }
 
 }
      
