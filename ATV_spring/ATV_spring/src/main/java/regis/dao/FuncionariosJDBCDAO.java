/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regis.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import regis.model.Funcionarios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
/**
 *
 * @author daypn
 */
@Repository
public class FuncionariosJDBCDAO implements FuncionariosDAO {
    
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;
    
    public FuncionariosJDBCDAO(){
        
    }
    public void save(Funcionarios entity) {
        String insert_sql = "insert into funcionarios (cpf, matricula, nome, email, telefone) values (:cpf, :matricula, :nome, :email, :telefone)";
	String update_sql = "update funcionarios set cpf = :cpf, matricula = :matricula, nome = :nome,email = :email,  telefone = :telefone where id = :id";
	MapSqlParameterSource params = new MapSqlParameterSource()
                        .addValue("cpf",  entity.getCpf())
                        .addValue("matricula",  entity.getMatricula())
			.addValue("nome", entity.getNome())
                        .addValue("email", entity.getEmail())
			.addValue("telefone", entity.getTelefone());
			

		if (entity.getId() == 0) {
			jdbcTemplate.update(insert_sql, params);
		} else {
			params.addValue("id", entity.getId());
			jdbcTemplate.update(update_sql, params);
		}
    }

    
    public void delete(int id) {
        String sql = "delete from funcionarios where id = :id";
        MapSqlParameterSource params = new MapSqlParameterSoucer().addValue("id", id);
        jdbcTemplate.update(sql, params);
        
    }

    

    private Funcionarios map(ResultSet rs) throws SQLException {
		Funcionarios fc = new Funcionarios();
		fc.setId(rs.getInt("id"));
		fc.setCpf(rs.getString("cpf"));
                fc.setMatricula(rs.getInt("matricula"));
		fc.setNome(rs.getString("nome"));
		fc.setEmail(rs.getString("email"));
		fc.setTelefone(rs.getString("telefone"));
		return fc;
	}

    public Funcionarios find(int id){
        String sql = "select id, cpf, matricula, nome, email, telefone from funcionarios where id= :id_";
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("id_,id");
        return jdbcTemplate.queryForObject(sql, namedParameters, (rs, rowNum) -> map(rs));  
    }
    public List<Funcionarios> find() {
        String sql = "select id, cpf, matricula, nome, email, telefone from funcionarios";
        return jdbcTemplate.query(sql, (rs, rowNum) -> map(rs));
    }

    public Funcionarios findByCpf(String cpf) {
        String sql = "select id, cpf, matricula, nome, email, telefone from funcionarios where cpf = :cpf_";
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("cpf_,cpf");
        List<Funcionarios> result jdbcTemplate.query(sql, namedParameters, (rs, rowNum) -> map(rs)0);
        return result.isEmpty() ? null : result.get(0);
	}



    public Funcionarios findByMatricula(int matricula){
        String sql = "select id, cpf, matricula, nome, email, telefone from funcionarios where matricula= :matricula_";
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("mtricula_,matricula");
        return jdbcTemplate.queryForObject(sql, namedParameters, (rs, rowNum) -> map(rs));  
    }
    
    public List<Funcionarios> findByNome(String str) {
        String sql = "select id, cpf, matricula, nome, email, telefone from funcionarios where nome= :nome_";
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("nome_,nome");
        return jdbcTemplate.query(sql, namedParameters, (rs, rowNum) -> map(rs));  
    }
   
}
