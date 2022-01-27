package com.persi.trabalho02.DAO;

import com.persi.trabalho02.entity.Discipline;
import com.persi.trabalho02.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DisciplineDAO extends JpaRepository<Discipline, Integer> {
    //Query
    @Query("SELECT D.students as students FROM Discipline D WHERE D.code = :cod")
    public List<Student> findCode(Integer cod);

    //Spring data JPA

    /**
     *
     * @param id
     */
    @Override
    public void deleteById(Integer id);
    public Discipline findFirstByCode(Integer inter);

    //Named Querye

    @Query(name = "findPorId")
    public Discipline buscaPrimeiraDisciplina(Integer id);
}
