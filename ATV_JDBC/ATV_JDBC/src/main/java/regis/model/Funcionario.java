/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regis.model;
import lombok.*;
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
/**
 *
 * @author daypn
 */
public class Funcionario {

    @NonNull @Getter @Setter private Integer id;
    @NonNull @Getter @Setter private String cpf;
    @NonNull @Getter @Setter private Integer matricula;
    @NonNull @Getter @Setter private String nome;
    @Getter @Setter private String email;
    @Getter @Setter private String telefone;

}
