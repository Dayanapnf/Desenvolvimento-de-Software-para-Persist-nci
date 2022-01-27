package com.persi.trabalho02.DAO;

import com.persi.trabalho02.Repository.HasNamedEmail;
import com.persi.trabalho02.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface StudentDAO extends JpaRepository<Student, Integer> {
    //Query
    @Query("SELECT A FROM Student A WHERE A.dateN > :data")
    public List<Student> findData(Date data);
    @Query("SELECT A FROM Student A WHERE A.name LIKE %:str%")
    public List<Student> findNomeS(String str);

    //Spring data JPA
    @Override
    public void deleteById(Integer id);
    public Student findFirstByCpf(String str);
    public Student findFirstById(Integer inte);

    //Named Query
    @Query(name = "nomeEemail")
    public List<HasNamedEmail> findCodee(Integer matricula);

}
