package com.persi.trabalho02.Controller;

import com.persi.trabalho02.DAO.DisciplineDAO;
import com.persi.trabalho02.DAO.StudentDAO;
import com.persi.trabalho02.Repository.HasNamedEmail;
import com.persi.trabalho02.entity.Discipline;
import com.persi.trabalho02.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;

import javax.swing.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@ComponentScan("com.persi.trabalho02")

public class OperacionsCRUD implements CommandLineRunner {

    @Autowired
    StudentDAO studentDAO;

    @Autowired
    DisciplineDAO disciplineDAO;

    Student student;
    Discipline discipline;
    List<Student> students;
    List<Discipline> disciplines;
    SimpleDateFormat formato = new SimpleDateFormat("dd/mm/yyyy");

    public static void main(String[] args) {
        SpringApplicationBuilder builder = new SpringApplicationBuilder(OperacionsCRUD.class);
        builder.headless(false).run(args);
    }

    @Override
    public void run(String... args) throws Exception {
        String op = null;
        do {
            {
                try {
                    op = JOptionPane.showInputDialog(null,
                            "'1' - Inserir Aluno\n"
                                    + "'2' - Inserir Disciplina\n"
                                    + "'3' - Associacao Aluno - Disciplina\n"
                                    + "'4' - Atualizar Aluno\n"
                                    + "'5' - Atualizar Disciplina\n"
                                    + "'6' - Deletar Aluno\n"
                                    + "'7' - Deletar Disciplina\n"
                                    + "'8' - Buscar Aluno (nome) \n"
                                    + "'9' - Alunos de uma determinada disciplina(codigo)\n"
                                    + "'10' - Aluno e a quantidade de disciplina\n"
                                    + "'11' - Matricula, nome e email do Aluno\n"
                                    + "'12' - Students after a date(estudantes que nasceram depois de uma data)\n"
                                    + "'13' - sair da execução\n",
                            "Menu", JOptionPane.QUESTION_MESSAGE);
                    if (op.equalsIgnoreCase("1")) {
                        String cpf = JOptionPane.showInputDialog(null, "Cpf");
                        String matricula = JOptionPane.showInputDialog(null, "Mat");
                        String nome = JOptionPane.showInputDialog(null, "name");
                        String email = JOptionPane.showInputDialog(null, "email");
                        String data = JOptionPane.showInputDialog(null, "date");

                        inserirA(cpf, nome, matricula, email, data);
                    }
                    else if (op.equalsIgnoreCase("2")) {
                        String nome = JOptionPane.showInputDialog(null, "name", "name of student", JOptionPane.QUESTION_MESSAGE);
                        String cod = JOptionPane.showInputDialog(null, "code", "code of student", JOptionPane.QUESTION_MESSAGE);

                        inserirD(nome, cod);
                    }
                    else if (op.equalsIgnoreCase("3")) {
                        String idAluno = JOptionPane.showInputDialog(null, "ID of Student");
                        String disc = JOptionPane.showInputDialog(null, "ID of Discipline");
                        addDisciplinaAaluno(idAluno, disc);
                    }
                    else if (op.equalsIgnoreCase("4")) {
                        String idAluno = JOptionPane.showInputDialog(null, "ID of the Student");
                        updateA(idAluno);
                    }
                    else if (op.equalsIgnoreCase("5")) {
                        String idDisciplina = JOptionPane.showInputDialog(null, "ID of the Discipline");
                        updateD(idDisciplina);
                    }
                    else if (op.equalsIgnoreCase("6")) {
                        String idAluno = JOptionPane.showInputDialog(null, "ID of the student");
                        deleteA(idAluno);
                    }
                    else if (op.equalsIgnoreCase("7")) {
                        String idDisciplina = JOptionPane.showInputDialog(null, "ID of the Discipline");
                        deleteD(idDisciplina);
                    }
                    else if (op.equalsIgnoreCase("8")) {
                        String subs = JOptionPane.showInputDialog(null, "Name");
                        nameDisp(subs);
                    }
                    else if (op.equalsIgnoreCase("9")) {
                        String idd = JOptionPane.showInputDialog(null, "Code of the Discipline");
                        studetDisp(idd);
                    }
                    else if (op.equalsIgnoreCase("10"))
                        studentCountD();
                    else if (op.equalsIgnoreCase("11")) {
                        String mat = JOptionPane.showInputDialog(null, "Matrícula of the Student");
                        matName(mat);
                    }
                    else if (op.equalsIgnoreCase("12")) {
                        String data = JOptionPane.showInputDialog(null, "date");
                        shecOfDate(data);
                    }
                    else if (op.equalsIgnoreCase("13"))
                        JOptionPane.showMessageDialog(null, "Exit", "Exit", JOptionPane.INFORMATION_MESSAGE);
                    else
                        JOptionPane.showMessageDialog(null, "Digite uma opção válida", "Opção inválida", JOptionPane.ERROR_MESSAGE);

                } catch (NullPointerException z) {
                    op = "13";
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.toString());
                }
            }
        } while (!op.equalsIgnoreCase("13"));
    }

    public void inserirD(String nome, String cod) throws Exception {
        discipline = disciplineDAO.findFirstByCode(Integer.parseInt(cod));
        if (!ExceptionController.DisciplineHasNull(discipline))
            throw new Exception("Discipline is Present");
        Discipline d = new Discipline();
        d.setName(nome);
        d.setCode(Integer.parseInt(cod));
        disciplineDAO.save(d);
        JOptionPane.showMessageDialog(null, "Adicionado!");
    }

    public void inserirA(String cpf, String nome, String matricula, String email, String data) throws Exception {
        student = studentDAO.findFirstByCpf(cpf);
        if (!ExceptionController.StudentHasNull(student))
            throw new Exception("Student Is present!");
        Student a = new Student();
        a.setCpf(cpf);
        a.setName(nome);
        a.setMatricula(Integer.parseInt(matricula));
        Date dataa = formato.parse(data);
        a.setDateN(dataa);
        a.setEmail(email);
        studentDAO.save(a);
        JOptionPane.showMessageDialog(null, "Adicionado!");
    }

    public void addDisciplinaAaluno(String idAluno, String disc) throws Exception {
        discipline = disciplineDAO.buscaPrimeiraDisciplina(Integer.parseInt(disc));
        student = studentDAO.findFirstById(Integer.parseInt(idAluno));
        discipline.getStudents().add(studentDAO.findFirstById(Integer.parseInt(idAluno)));
        if (ExceptionController.DisciplineHasNull(discipline) || ExceptionController.StudentHasNull(student))
            throw new Exception("Not Found");
        disciplineDAO.save(discipline);
        JOptionPane.showMessageDialog(null, "Associated!");
    }

    public void deleteA(String idAluno) throws Exception {
        if (!studentDAO.findById(Integer.parseInt(idAluno)).isPresent())
            throw new Exception("Aluno não encontrado");
        studentDAO.deleteById(Integer.parseInt(idAluno));
    }

    public void deleteD(String idDisciplina) {
        if (!disciplineDAO.findById(Integer.parseInt(idDisciplina)).isPresent())
            throw new RuntimeException("Disciplina não encontrada");
        disciplineDAO.deleteById(Integer.parseInt(idDisciplina));
    }

    public void updateA(String idAluno) throws Exception {
        student = studentDAO.findFirstById(Integer.parseInt(idAluno));
        if (!studentDAO.findById(Integer.parseInt(idAluno)).isPresent())
            throw new Exception("Student Not Found");
        obterAluno(student);
        studentDAO.save(student);
    }

    public void updateD(String idDisciplina) throws Exception {
        discipline = disciplineDAO.buscaPrimeiraDisciplina(Integer.parseInt(idDisciplina));
        if (!disciplineDAO.findById(Integer.parseInt(idDisciplina)).isPresent())
            throw new Exception("Discipline Not Found");
        obterDisciplina(discipline);
        disciplineDAO.save(discipline);
    }

    public void obterAluno(Student al) throws ParseException {
        String cpf = JOptionPane.showInputDialog(null, "Cpf", al.getCpf());
        String matricula = JOptionPane.showInputDialog(null, "Mat", al.getMatricula());
        String nome = JOptionPane.showInputDialog(null, "nome", al.getName());
        String email = JOptionPane.showInputDialog(null, "email", al.getEmail());
        String data = JOptionPane.showInputDialog(null, "data", al.getDateN());

        al.setCpf(cpf);
        al.setMatricula(Integer.parseInt(matricula));
        al.setEmail(email);
        al.setName(nome);
        Date dataa = formato.parse(data);
        al.setDateN(dataa);
    }

    public void obterDisciplina(Discipline di) {
        String nome = JOptionPane.showInputDialog(null, "nome", di.getName());
        String cod = JOptionPane.showInputDialog(null, "codigo", di.getCode());

        di.setName(nome);
        di.setCode(Integer.parseInt(cod));
    }

    public void nameDisp(String subs) {
        students = studentDAO.findNomeS(subs);
        StringBuilder sb = new StringBuilder();
        students.forEach(a -> {
            sb.append("Nome: ").append(a.getName()).append(", Disciplinas:\n").append("  ")
                    .append(a.getDisciplines()).append("\n");
        });
        JOptionPane.showMessageDialog(null, sb.toString());
        students.clear();
    }

    public void studetDisp(String ide) throws Exception {
        students = disciplineDAO.findCode(Integer.parseInt(ide));
        if (ExceptionController.StudentHasNull(students.get(0)))
            throw new Exception("Student not fund");
        StringBuilder sb = new StringBuilder();
        sb.append("Alunos que fazem parte da disciplina de código ").append(ide).append("\n");
        students.forEach(a -> {
            sb.append("\tNome: ").append(a.getName()).append(", CPF: ").append(a.getCpf())
                    .append(", Matricula: ").append(a.getMatricula()).append(", Data de Nascimento: ").append(a.getDateN()).append("\n");
        });
        JOptionPane.showMessageDialog(null, sb.toString());
        students.clear();
    }

    public void studentCountD() {
        students = studentDAO.findAll();
        StringBuilder sb = new StringBuilder();
        students.forEach(a -> {
            sb.append("Nome: ").append(a.getName()).append(", Número de Disciplinas: ")
                    .append(a.getDisciplines().size()).append("\n");
        });
        JOptionPane.showMessageDialog(null, sb.toString());
        students.clear();
    }

    public void matName(String mat) {
        List<HasNamedEmail> nae = (List<HasNamedEmail>) studentDAO.findCodee(Integer.parseInt(mat));
        StringBuilder sb = new StringBuilder();
        nae.forEach(a -> {
            sb.append("Nome: ").append(a.getName()).append(", Email: ").append(a.getEmail()).append("\n");
        });
        JOptionPane.showMessageDialog(null, sb.toString());
        nae.clear();
    }

    public void shecOfDate(String data) throws ParseException {
        Date dataa = formato.parse(data);
        students = studentDAO.findData(dataa);
        StringBuilder sb = new StringBuilder();
        students.forEach(a -> {
            sb.append("ID: ").append(a.getId()).append(", Nome: ").append(a.getName()).append(", Matricula: ").append(a.getMatricula()).append(", Data de Nascimento: ").append(a.getDateN())
                    .append("\n");
        });
        JOptionPane.showMessageDialog(null, sb.toString());
        students.clear();
    }

}
