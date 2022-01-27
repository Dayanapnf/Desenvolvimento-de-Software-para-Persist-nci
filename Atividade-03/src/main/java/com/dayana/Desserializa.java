package com.dayana;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

@SuppressWarnings("unchecked")
public class Desserializa {
    public static List<Pessoa> desserializaXml() throws IOException {
        XmlMapper xmlMapper = new XmlMapper();

        return (List<Pessoa>) xmlMapper.readValue(new File("ListaPessoas.xml"), List.class);
    }

    public static void main(String[] args) throws IOException {

        List<Pessoa> pessoas = desserializaXml();

        System.out.println(pessoas);

    }

}
