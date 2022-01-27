/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regis.dao;
import java.util.ArrayList;
import java.util.List;
import regis.model.Funcionarios;
/**
 *
 * @author daypn
 */
public class FuncionariosListDAO implements FuncionariosDAO{
   

    private List<Funcionarios> funcionario;
	
    private static int idProximo = 1;
	
	
    public FuncionariosListDAO() {
	this.funcionario = new ArrayList<Funcionarios>();
    }
	
    @Override
    public void save(Funcionarios entity) {
		// Inserir um funcionario se o id do objeto for 0.
    	if (entity.getId() == 0) {
            entity.setId(idProximo++);
		funcionario.add(entity);
	// Alterar um cliente se o id não for 0.
	} else {
            int posicaoNaLista = findIndex(entity.getId());
            funcionario.set(posicaoNaLista, entity);
	}
    }
    @Override
    public void delete(int id) {
        funcionario.remove(find(id));
	}

    @Override
    public Funcionarios find(int id) {
        for (Funcionarios fc : this.funcionario) {
            if (fc.getId() == id) {
                return fc;
            }
        }
        return null;
    }
    private int findIndex(int id) {
        for (int i=0; i < funcionario.size(); i++) {
            if (funcionario.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }
    @Override
    public List<Funcionarios> find() {
        return this.funcionario;
    }
    @Override
    public Funcionarios findByCpf(String cpf) {
        for (Funcionarios fc : this.funcionario){
            if (fc.getCpf().equals(cpf)) {
                return fc;
            }
        }
        return null;
    }

    @Override
    public Funcionarios findByMatricula(int matricula) {
        for (Funcionarios fc : this.funcionario) {
            if(fc.getMatricula() == matricula){
                return fc;
            } 
        }
        return null;
    }

    @Override
    public List<Funcionarios> findByNome(String str) {
	List<Funcionarios> resultado = new ArrayList<>();
        this.funcionario.stream().filter(fc -> (fc.getNome().toUpperCase().contains(str.toUpperCase()))).forEachOrdered(fc -> {
            resultado.add(fc);
        });
        return resultado;
    }

  

}
