package by.academy.it.service;

import by.academy.it.company.pojo.Employee;
import by.academy.it.dao.EmployeeDao;
import by.academy.it.dao.PayslipDao;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private final EmployeeDao employeeDao;
    private final PayslipDao payslipDao;

    public EmployeeService(EmployeeDao employeeDao,
                           PayslipDao payslipDao) {
        this.employeeDao = employeeDao;
        this.payslipDao = payslipDao;
    }

    public boolean save(Employee employee) {
        //Check employee input value

        return employeeDao.saveEmployee(employee);
    }
}