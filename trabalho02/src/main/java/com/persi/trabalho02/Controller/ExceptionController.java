package com.persi.trabalho02.Controller;

import com.persi.trabalho02.entity.Discipline;
import com.persi.trabalho02.entity.Student;

public class ExceptionController {
    public static boolean DisciplineHasNull(Discipline d){
        return d == null;
    }
    public static boolean StudentHasNull(Student s){
        return s == null;
    }


}
