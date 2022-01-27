/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dayana;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Serializa {

    public static void serializaApiJava(List<Pessoa> p) {
        try {
            FileOutputStream fileOut = new FileOutputStream("ListaPessoas.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(p);
            out.close();
            fileOut.close();

        } catch (IOException i) {
        }
    }

    public static void serializaJson(List<Pessoa> p) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File("ListaPessoas.json"), p);

    }

    public static void serializaXml(List<Pessoa> pessoas) throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        File f = new File("ListaPessoas.xml");
        xmlMapper.writeValue(f, pessoas);
        // for (Pessoa p : pessoas) {
        // xmlMapper.writeValue(new File("Pessoa-" + p.getId() + "-.xml"), p);
        // }
    }

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        List<Pessoa> pessoas = new ArrayList<Pessoa>();

        pessoas.add(new Pessoa(1, "ana", "ana@gmail.com", 99999));
        pessoas.add(new Pessoa(2, "dayana", "dayana@gmail.com", 123456));
        pessoas.add(new Pessoa(3, "roanna", "roanna@gmail.com", 93544569));

        serializaApiJava(pessoas);
        serializaJson(pessoas);
        serializaXml(pessoas);

    }

}