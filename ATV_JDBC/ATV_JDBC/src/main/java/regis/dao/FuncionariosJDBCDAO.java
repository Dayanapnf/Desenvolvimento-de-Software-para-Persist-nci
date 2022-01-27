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

/**
 *
 * @author daypn
 */
public class FuncionariosJDBCDAO implements FuncionariosDAO {

    @Override
    public void save(Funcionarios entity) {
        Connection con = null;
            try {
		con = ConnectionFactory.getConnection();
		String insert_sql = "insert into funcioarios (cpf, matricula, nome, email, telefone) values ( ?, ?, ?, ?, ?)";
		String update_sql = "update funcionarios set  cpf = ?, nome = ?, email = ?, telefone = ? where id = ?";
                PreparedStatement pst;
                    if (entity.getId() == 0) {
			pst = con.prepareStatement(insert_sql);
                    } else {
			pst = con.prepareStatement(update_sql);
			pst.setInt(5, entity.getId());
                    }
                    pst.setString(1, entity.getCpf());
                    pst.setInt(2, entity.getMatricula());
                    pst.setString(3, entity.getNome());
                    pst.setString(4, entity.getEmail());
                    pst.setString(5, entity.getTelefone());
                    pst.executeUpdate();
            } catch (SQLException e) {
		throw new DAOException("Operação não realizada com sucesso.", e);
            } finally {
		try {
                    if (con != null)
                        con.close();
                } catch (SQLException e) {
                    throw new DAOException("Não foi possível fechar a conexão.",e);
		}
            }
    }

    @Override
    public void delete(int id) {
        Connection con = null;
		try {
			con = ConnectionFactory.getConnection();
			String sql = "delete from funcionarios where id = ?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, id);
			pst.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException("Operação não realizada com sucesso.", e);
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				throw new DAOException("Não foi possível fechar a conexão.",e);
			}
		}
    }

    @Override
    public Funcionarios find(int id) {
        Connection con = null;
        Funcionarios fc = null;
		try {
                    con = ConnectionFactory.getConnection();
                    String sql = "select id, cpf,matricula, nome, email, telefone from funcionarios where id = ?";
                    PreparedStatement pst = con.prepareStatement(sql);
                    pst.setInt(1, id);
                    ResultSet rs = pst.executeQuery();
                    if (rs.next()) {
                        fc = map(rs);
                    }
		} catch (SQLException e) {
			throw new DAOException("Operação não realizada com sucesso.", e);
		} finally {
			try {
                            if (con != null)
				con.close();
			} catch (SQLException e) {
				throw new DAOException("Não foi possível fechar a conexão.",e);
			}
		}
		return fc;
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

    @Override
    public List<Funcionarios> find() {
        
        Connection con = null;
            List<Funcionarios> result = null;
            try {
		con = ConnectionFactory.getConnection();
                PreparedStatement pst;
		String sql = "select id, cpf, matricula, nome, email, telefone from funcionarios";
		pst = con.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		result = new ArrayList<Funcionarios>();
		while (rs.next()) {
			Funcionarios fc = map(rs);
			result.add(fc);
                }
            } catch (SQLException e) {
			throw new DAOException("Operação não realizada com sucesso.", e);
            } finally {
		try {
                    if (con != null)
                        con.close();
		} catch (SQLException e) {
                    throw new DAOException("Não foi possível fechar a conexão.",e);
			}
		}
		return result;
    }

    @Override
    public Funcionarios findByCpf(String cpf) {
       	Connection con = null;
	Funcionarios fc = null;
            try {
		con = ConnectionFactory.getConnection();
                PreparedStatement pst;
		String sql = "select id, cpf, matricula,nome, email, telefone from funcionarios where cpf = ?";
		pst = con.prepareStatement(sql);
                pst.setString(1, cpf);
		ResultSet rs = pst.executeQuery();
		if (rs.next()) {
                    fc = map(rs);
		}
	} catch (SQLException e) {
            throw new DAOException("Operação não realizada com sucesso.", e);
	} finally {
                try {
                    if (con != null)
                        con.close();
                } catch (SQLException e) {
                    throw new DAOException("Não foi possível fechar a conexão.",e);
                }
            }
            return fc;
	}



    public Funcionarios findByMatricula(int matricula){
        Connection con = null;
	Funcionarios fc = null;
        try {
            con = ConnectionFactory.getConnection();
            PreparedStatement pst;
            String sql = "select id, cpf, matricula, nome, email, telefone from funcionarios where matricula = ?";
            pst = con.prepareStatement(sql);
            pst.setInt(1,matricula);
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {
                fc = map(rs);
            }
	} catch (SQLException e) {
            throw new DAOException("Operação não realizada com sucesso.", e);
        } finally {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                throw new DAOException("Não foi possível fechar a conexão.",e);
            }
        }
            return fc;
    }
    
    public List<Funcionarios> findByNome(String str) {
	Connection con = null;
	List<Funcionarios> result = null;
        try {
            con = ConnectionFactory.getConnection();
            PreparedStatement pst;
            String sql = "select id, cpf, matricula,nome, email, telefone from funcionarios where upper(nome) like ?";
            pst = con.prepareStatement(sql);
            pst.setString(1, "%" + str.toUpperCase() + "%");
            ResultSet rs = pst.executeQuery();
            result = new ArrayList<Funcionarios>();
            while (rs.next()) {
                Funcionarios fc = map(rs);
                result.add(fc);
            }
        } catch (SQLException e) {
            throw new DAOException("Operação não realizada com sucesso.", e);
        } finally {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                throw new DAOException("Não foi possível fechar a conexão.",e);
            }
        }
        return result;
    }
   
}
