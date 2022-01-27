/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regis;
import java.util.List;

import javax.swing.JOptionPane;

import regis.dao.FuncionariosDAO;
import regis.dao.FuncionariosJDBCDAO;
import regis.model.Funcionarios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;


/**
 *
 * @author daypn
 */

public class Principal implements CommandLineRunner {
    private FuncionariosDAO baseFuncionarios;
    public static void main(String[] args) {
        //SpringApplication.run(Principal.class, args);
        SpringApplicationBuilder builder = new SpringApplicationBuilder(Principal.class);
        builder.headless(false).run(args);
    }
    public static void obterFuncionario(Funcionarios fc){
        String cpf = JOptionPane.showInputDialog("Cpf", fc.getCpf());
        String nome = JOptionPane.showInputDialog("Nome", fc.getNome());
        int matricula = Integer.parseInt(JOptionPane.showInputDialog("Matricula", fc.getMatricula()));
        String email = JOptionPane.showInputDialog("Email", fc.getEmail());
        String telefone = JOptionPane.showInputDialog("Telefone", fc.getTelefone());
        fc.setCpf(cpf);
        fc.setMatricula(matricula);
        fc.setNome(nome);
        fc.setEmail(email);
	fc.setTelefone(telefone);   
    } 
    public static void listaFuncionarios(List<Funcionarios> funcionario) {
        StringBuilder listagem = new StringBuilder();
        for(Funcionarios fc : funcionario) {
            listagem.append(fc).append("\n");
        }
 	JOptionPane.showMessageDialog(null, listagem.length() == 0 ? "Nenhum funcionario encontrado" : listagem);
    }
    public static void listaFuncionarios(Funcionarios fc) {
        JOptionPane.showMessageDialog(null, fc == null ? "Nenhum funcionario encontrado" : fc);
    }

   
    public void run(String... args) throws Exception{
        String menu = "Escolha uma opção:\n1 - Inserir\n2 - Atualizar por CPF\n3 - Remover por CPF\n4 - Exibir por CPF\n5 - Exibir por Matricula\n6 - Exibir por id\n7 - Exibir todos\n8 - Exibir todos que contem determinado nome\n9 - Sair";
        char opcao;
        do {
            Funcionarios fc;
            String cpf;
            opcao = JOptionPane.showInputDialog(menu).charAt(0);
            switch (opcao) {
                case '1':     // Inserir
                    fc = new Funcionarios();
                    obterFuncionario(fc);
                    baseFuncionarios.save(fc);
                    break;
                case '2':     // Atualizar por CPF
                    cpf = JOptionPane.showInputDialog("Digite o CPF do funcionario a ser alterado");
                    fc = baseFuncionarios.findByCpf(cpf);
                
                    if(fc != null){
                        obterFuncionario(fc);
                        baseFuncionarios.save(fc);
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Não foi possível atualizar, pois o funcionario foi não encontrado.");
                    }
		
                    break;
                case '3':     // Remover por CPF
                    cpf = JOptionPane.showInputDialog("CPF");
                    fc = baseFuncionarios.findByCpf(cpf);
                    if (fc != null) {
                    baseFuncionarios.delete(fc.getId());
                    } else {
                        JOptionPane.showMessageDialog(null, "Não foi possível remover, pois o funcionario não encontrado.");
                    }
                    break;
                case '4':     // Exibir por CPF
                    cpf = JOptionPane.showInputDialog("CPF");
                    fc = baseFuncionarios.findByCpf(cpf);
                    listaFuncionarios(fc);
                case '5': //EXIBIR POR MATRICULA
                    int matricula = Integer.parseInt(JOptionPane.showInputDialog("Matricula"));
                    fc = baseFuncionarios.findByMatricula(matricula);
                    break;
                case '6':     // Exibir por id
                    int id = Integer.parseInt(JOptionPane.showInputDialog("Id"));
                    fc = baseFuncionarios.find(id);
                    listaFuncionarios(fc);
                    break;
                case '7':     // Exibir todos
                    listaFuncionarios(baseFuncionarios.find());
                    break;
                case '8':     // Exibir todos que contem determinado nome
                    String nome = JOptionPane.showInputDialog("Nome");
                    listaFuncionarios(baseFuncionarios.findByNome(nome));
                    break;
                case '9':     // Sair
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção Inválida");
                    break;
            }
        }while(opcao != '8');
    }
  
}
    
    

  


