/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates00
 * and open the template in the editor.
 */
package trab_01;

/**
 *
 * @author daypn
 */
public class Livro implements java.io.Serializable{
    public String isbn,ano_publicacao; 
    public String  titulo, editora;

    public Livro(String isbn, String ano_publicacao, String titulo, String editora) {
        this.isbn = isbn;
        this.ano_publicacao = ano_publicacao;
        this.titulo = titulo;
        this.editora = editora;
    }

    Livro() {
        super();
    }
   
     public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setAno_publicacao(String ano_publicacao) {
        this.ano_publicacao = ano_publicacao;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }
    
    public String getIsbn() {
        return isbn;
    }

    public String getAno_publicacao() {
        return ano_publicacao;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getEditora() {
        return editora;
    }
    public Livro(String[] livro) {
        if (livro.length > 0) {

            isbn = livro[0];
            ano_publicacao = livro[1];
            titulo = livro[2];
            editora = livro[3];

        }
    }
    @Override
     public String toString() {
        return "Livro{" + "\nIsbn=" + isbn + "\nAno_publicacao=" + ano_publicacao + "\nTitulo=" + titulo + "\nEditora=" + editora + '}';
    }
   
    
}
