/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trab_01;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author daypn
 */
public class Serializa_trab {
    

    // processar o arquivo e extrair os dados
    public static List<String[]> retornaListaLivros(String caminhoDoArquivo) throws FileNotFoundException, IOException {
        
        List<String[]> listaLivros = new ArrayList<>();

        File arquivoCSV = new File(caminhoDoArquivo);
        FileReader fr = new FileReader(arquivoCSV);
        BufferedReader br = new BufferedReader(fr);
        String linha;
        while ((linha = br.readLine()) != null) {
            String livro[] = linha.split(",");
            listaLivros.add(livro);
        }
        return listaLivros;
    }
    public static void serializaJson(List<String[]> l) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File("ListaLivros.json"), l);

    }

    public static void serializaXml(List<String[]> l) throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        File f = new File("ListaLivros.xml");
        xmlMapper.writeValue(f, l);
       
    }
    
    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     * @throws java.io.UnsupportedEncodingException
     */
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException, IOException {
        
        Scanner entrada = new Scanner(System.in);
        System.out.println("Digite o nome do arquivo:");
        
        List<String[]> lista = Serializa_trab.retornaListaLivros(entrada.nextLine()); 
         
        for (String[] livro : lista) {

            Livro liv = new Livro(livro);
            
            System.out.println(liv);
        }
        serializaXml(lista);  
        serializaJson(lista);
    }
}


     
   

