/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atividade.dao;

import atividade.entity.Funcionario;
import java.util.List;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 *
 * @author daypn
 */
@Repository
public interface FuncionarioDAO extends JpaRepository <Funcionario, Integer> {
    public Funcionario findFirstByCpf(String cpf);

    @Query("select f from funcionario f where f.cpf = :cpf")
    public Funcionario buscaPrimeiroPorCpf(String cpf);
    
    @Query(name = "funcionarioPorCpf")
    public Funcionario buscaPorCpfViaConsultaNomeada(String cpf);


	
    public List<Funcionario> findByNomeStartingWith(String str);

    @Query("select f from Funcionario f where f.nome like :nome%")
    public List<Funcionario> buscaPorNomeIniciadoPor(String nome);
    
   

    @Query("select f from Funcionario f where f.matricula = :matricula ")
    public Funcionario buscaPorMatricula(@Param("matricula") int matricula);
}


    
    
      
