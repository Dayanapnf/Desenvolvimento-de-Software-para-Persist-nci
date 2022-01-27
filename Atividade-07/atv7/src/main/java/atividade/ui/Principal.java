/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atividade.ui;

import java.util.List;
import javax.swing.JOptionPane;

        
import atividade.dao.FuncionarioDAO;
import atividade.entity.Funcionario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
/**
 *
 * @author daypn
 */
@SpringBootApplication
@ComponentScan("atividade")
@EntityScan("atividade.entity")
@EnableJpaRepositories("atividade.dao")

public class Principal implements CommandLineRunner {
    @Autowired
    private FuncionarioDAO baseFuncionarios;
    public static void main(String[] args) {
	//SpringApplication.run(Principal.class, args);
	SpringApplicationBuilder builder = new SpringApplicationBuilder(Principal.class);
	builder.headless(false).run(args);
    }

    public static void obterFuncionario(Funcionario fc){
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

    public static void listaFuncionarios(List<Funcionario> funcionario) {
        StringBuilder listagem = new StringBuilder();
        for(Funcionario fc : funcionario) {
            listagem.append(fc).append("\n");
        }
 	JOptionPane.showMessageDialog(null, listagem.length() == 0 ? "Nenhum funcionario encontrado" : listagem);
    }
    public static void listaFuncionarios(Funcionario fc) {
        JOptionPane.showMessageDialog(null, fc == null ? "Nenhum funcionario encontrado" : fc);
    }

    public void run(String... args) throws Exception{
        String menu = "Escolha uma opção:\n1 - Inserir\n2 - Atualizar por CPF\n3 - Remover por CPF\n4 - Exibir por CPF\n5 - Exibir por Matricula\n6 - Exibir por id\n7 - Exibir todos\n8 - Exibir todos que contem determinado nome\n9 - Sair";
        char opcao;
        do {
            Funcionario fc;
            String cpf;
            opcao = JOptionPane.showInputDialog(menu).charAt(0);
            switch (opcao) {
                case '1':     // Inserir
                    fc = new Funcionario();
                    obterFuncionario(fc);
                    baseFuncionarios.save(fc);
                    break;
                case '2':     // Atualizar por CPF
                    cpf = JOptionPane.showInputDialog("Digite o CPF do funcionario a ser alterado");
                    fc = baseFuncionarios.findFirstByCpf(cpf);
                
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
                    fc = baseFuncionarios.findFirstByCpf(cpf);
                    if (fc != null) {
                        baseFuncionarios.deleteById(fc.getId());
                    } else {
                        JOptionPane.showMessageDialog(null, "Não foi possível remover, pois o funcionario não encontrado.");
                    }
                    break;
                case '4':     // Exibir por CPF
                    cpf = JOptionPane.showInputDialog("CPF");
                    fc = baseFuncionarios.buscaPorCpfViaConsultaNomeada(cpf);
                    listaFuncionarios(fc);
                    break;
                case '5': //EXIBIR POR MATRICULA
                    int matricula = Integer.parseInt(JOptionPane.showInputDialog("Matricula"));
                    fc = baseFuncionarios.buscaPorMatricula(matricula);
                    break;
                case '6':     // Exibir por id
                    int id = Integer.parseInt(JOptionPane.showInputDialog("Id"));
                    fc = baseFuncionarios.findById(id).orElse(null);
                    listaFuncionarios(fc);
                    break;
                case '7':     // Exibir todos
                    listaFuncionarios(baseFuncionarios.findAll());
                    break;
                case '8':     // Exibir todos que contem determinado nome
                    String nome = JOptionPane.showInputDialog("Nome");
                    listaFuncionarios(baseFuncionarios.buscaPorNomeIniciadoPor(nome));
                    break;
                case '9':     // Sair
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção Inválida");
                    break;
            }
        }while(opcao != '9');
    }
  
}
    
    

  


