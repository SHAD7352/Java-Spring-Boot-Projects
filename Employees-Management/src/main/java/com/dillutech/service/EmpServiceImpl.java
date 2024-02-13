package com.dillutech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.dillutech.entity.Employee;
import com.dillutech.repository.EmpRepository;

import jakarta.servlet.http.HttpSession;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpRepository empRepository;

    @SuppressWarnings("null")
    @Override
    public Employee saveEmployee(Employee employee) {

        Employee newEmp = empRepository.save(employee);
        return newEmp;
    }

    @Override
    public List<Employee> getAllEmployees() {

        List<Employee> listOfEmps = empRepository.findAll();
        return listOfEmps;
    }

    @Override
    public Employee getEmployeeById(int id) {

        return empRepository.findById(id).get();

    }

    @Override
    public boolean deleteEmpById(int id) {

        Employee dEmployee = empRepository.findById(id).get();
        if (dEmployee != null) {
            empRepository.delete(dEmployee);
            return true;
        }
        return false;
    }

    @SuppressWarnings("null")
    public void removeSessionMessage() {

        HttpSession session = ((ServletRequestAttributes) (RequestContextHolder.getRequestAttributes())).getRequest()
                .getSession();
        session.removeAttribute("msg");
    }

}
