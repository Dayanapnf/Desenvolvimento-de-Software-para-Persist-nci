/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trab_01;

import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

/**
 *
 * @author daypn
 */
public class Csv {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     * @throws com.opencsv.exceptions.CsvDataTypeMismatchException
     * @throws com.opencsv.exceptions.CsvRequiredFieldEmptyException
     */
    private static final String CSV_SEPARATOR = ",";

    private static void writeToCSV(Livro livroList) {
        try {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("livros.csv", true), "UTF-8"));

            StringBuilder sb = new StringBuilder();
            sb.append(livroList.getIsbn().trim().length() == 0 ? "" : livroList.getIsbn());
            sb.append(CSV_SEPARATOR);
            sb.append(livroList.getTitulo().trim().length() == 0 ? "" : livroList.getTitulo());
            sb.append(CSV_SEPARATOR);
            sb.append(livroList.getEditora().trim().length() == 0 ? "" : livroList.getEditora());
            sb.append(CSV_SEPARATOR);
            sb.append(livroList.getAno_publicacao().trim().length() == 0 ? "" : livroList.getAno_publicacao());
            bw.write(sb.toString());
            bw.newLine();

            bw.flush();
            bw.close();
        } catch (UnsupportedEncodingException e) {
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        }
    }

    public static void main(String[] args) throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {

        Livro book = new Livro();
        Scanner entrada = new Scanner(System.in);
        int op = 1;

        while (op != 0) {
            System.out.println("==================================");
            System.out.println("Digite o ISBN:");
            book.setIsbn(entrada.nextLine());
            System.out.println("==================================");
            System.out.println("Digite o Título:");
            book.setTitulo(entrada.nextLine());
            System.out.println("==================================");
            System.out.println("Digite a Editora:");
            book.setEditora(entrada.nextLine());
            System.out.println("==================================");
            System.out.println("Digite o Ano da Publicação:");
            book.setAno_publicacao(entrada.nextLine());

            writeToCSV(book);

            System.out.println("==================================");
            System.out.println("1- Cadastrar livro\n0- Sair ");
            op = entrada.nextInt();
            entrada.nextLine();
        }

    }

}
