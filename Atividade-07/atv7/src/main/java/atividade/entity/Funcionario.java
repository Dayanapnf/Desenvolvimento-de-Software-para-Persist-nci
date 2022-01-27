/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atividade.entity;
import lombok.*;

import javax.persistence.*;

@NamedQueries({
		@NamedQuery(name = "funcionarioPorCpf", query = "select f from funcionario f where f.cpf = :cpf")
})

@Entity
@Table(name = "funcionarios")
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
/**
 *
 * @author daypn
 */
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull @Getter @Setter private int id;

    @NonNull @Getter @Setter private String cpf;
    @NonNull @Getter @Setter private Integer matricula;
    @Getter @Setter private String nome;
    @Getter @Setter private String email;
    @Getter @Setter private String telefone;

}
