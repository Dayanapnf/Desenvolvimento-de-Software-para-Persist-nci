/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regis.dao;

import java.util.List;
import regis.model.Funcionarios;

/**
 *
 * @author daypn
 */
public interface FuncionariosDAO {

    public void save(Funcionarios entity);
    public void delete(int id);
    public Funcionarios find(int id);
    public List<Funcionarios> find();
    public Funcionarios findByCpf(String cpf);
    public Funcionarios findByMatricula(int matricula);
    public List<Funcionarios> findByNome(String str);

}
