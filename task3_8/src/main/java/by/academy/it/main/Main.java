package by.academy.it.main;

import by.academy.it.data.PersonJoinedDao;
import by.academy.it.data.PersonSingleTableDao;
import by.academy.it.data.PersonTablePerClassDao;
import by.academy.it.entities.personJoined.EmployeeJ;
import by.academy.it.entities.personJoined.PersonJ;
import by.academy.it.entities.personJoined.StudentJ;
import by.academy.it.entities.personSingleTable.EmployeeST;
import by.academy.it.entities.personSingleTable.PersonST;
import by.academy.it.entities.personSingleTable.StudentST;
import by.academy.it.entities.personTablePerClass.EmployeeTPC;
import by.academy.it.entities.personTablePerClass.PersonTPC;
import by.academy.it.entities.personTablePerClass.StudentTPC;

public class Main {
    public static void main(String[] args) {
        //Запуск программы: java -jar D:\work\task3_6-7\target\Main.jar
        final PersonJoinedDao personJoinedDao = new PersonJoinedDao();

        EmployeeJ employeeJ = new EmployeeJ("name1","email1","Epam",1000.0);

        personJoinedDao.saveEmployeeJ(employeeJ);

        EmployeeJ saved1 = personJoinedDao.getEmployeeJ(employeeJ.getId());
        System.out.println(saved1.getId()+" "+saved1.getName());
        //////////////////
        final PersonSingleTableDao personSingleTableDao = new PersonSingleTableDao();

        StudentST studentST = new StudentST("name2","email2","BSU",1.2);

        personSingleTableDao.saveStudentST(studentST);

        StudentST saved2 = personSingleTableDao.getStudentST(studentST.getId());

        //////////////////
        final PersonTablePerClassDao personTablePerClassDao = new PersonTablePerClassDao();

        EmployeeTPC employeeTPC = new EmployeeTPC("name3","email3","Epam",1.3);

        personTablePerClassDao.saveEmployeeTPC(employeeTPC);

        EmployeeTPC saved3 = personTablePerClassDao.getEmployeeTPC(employeeTPC.getId());

        System.out.println(saved1.getId()+" "+saved1.getName());
        System.out.println(saved2.getId()+" "+saved2.getName());
        System.out.println(saved3.getId()+" "+saved3.getName());

    }
}
