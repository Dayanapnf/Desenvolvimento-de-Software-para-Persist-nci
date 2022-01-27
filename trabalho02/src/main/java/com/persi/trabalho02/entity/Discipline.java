package com.persi.trabalho02.entity;

import java.io.Serializable;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@NamedQueries(
        {
                @NamedQuery(name = "findPorId", query = "SELECT D FROM Discipline D WHERE D.id = :id")

        }
)

@Entity
@Table(name = "disciplines")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Discipline implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true, name = "codeDiscipline")
    private Integer code;

    @Column(name = "nameDiscipline")
    private String name;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "StuDisc",
            joinColumns = @JoinColumn(name = "disciplineID"),
            inverseJoinColumns = @JoinColumn(name = "studentId"))
    
    private List<Student> students;

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("IdDiscipline: ").append(id).append(", CodeDiscipline: ").append(code).append(", NameDiscipline: ").append(name).append("\n");
        return sb.toString();
    }

}
