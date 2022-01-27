package com.persi.trabalho02.entity;

import java.io.Serializable;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@NamedQueries(
        {
                @NamedQuery(name = "nomeEemail", query = "SELECT A.name as name, A.email as email FROM Student A WHERE A.matricula = :matricula"),
        }
)

@Entity
@Table(name = "students")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Student implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "cpfStudent")
    private String cpf;

    @Column(unique = true, name = "matriStudent")
    private Integer matricula;

    @Column(name = "nomeStudent")
    private String name;

    @Column(unique = true, name = "emailStudent")
    private String email;

 
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateN;

    @ManyToMany(mappedBy = "students", fetch = FetchType.EAGER)

    private List<Discipline> disciplines;
}
