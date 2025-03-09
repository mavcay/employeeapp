package com.gabriel.empms.serviceimpl;

import com.gabriel.empms.entity.EmployeeData;
import com.gabriel.empms.model.Employee;
import com.gabriel.empms.repository.EmployeeDataRepository;
import com.gabriel.empms.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDataRepository employeeDataRepository;

    @Override
    public Employee[] getEmployees() {
        List<Employee> employeeList = new ArrayList<>();
        Iterable<EmployeeData> employeeDataList = employeeDataRepository.findAll();

        for (EmployeeData employeeData : employeeDataList) {
            Employee employee = new Employee();
            employee.setId(employeeData.getId());
            employee.setName(employeeData.getName());
            employee.setPosition(employeeData.getPosition());
            employee.setEmail(employeeData.getEmail());
            employee.setSalary(employeeData.getSalary());
            employeeList.add(employee);
        }

        return employeeList.toArray(new Employee[0]);
    }

    @Override
    public Employee getEmployee(Integer id) throws Exception {
        return null;
    }

    @Override
    public Employee getEmployee(int id) {
        Optional<EmployeeData> optionalEmployee = employeeDataRepository.findById(id);
        if (optionalEmployee.isPresent()) {
            EmployeeData employeeData = optionalEmployee.get();
            Employee employee = new Employee();
            employee.setId(employeeData.getId());
            employee.setName(employeeData.getName());
            employee.setPosition(employeeData.getPosition());
            employee.setEmail(employeeData.getEmail());
            employee.setSalary(employeeData.getSalary());
            return employee;
        } else {
            return null;
        }
    }

    @Override
    public Employee create(Employee employee) {
        EmployeeData employeeData = new EmployeeData();
        employeeData.setName(employee.getName());
        employeeData.setPosition(employee.getPosition());
        employeeData.setEmail(employee.getEmail());
        employeeData.setSalary(employee.getSalary());

        EmployeeData savedEmployee = employeeDataRepository.save(employeeData);

        employee.setId(savedEmployee.getId());
        return employee;
    }

    @Override
    public Employee update(Employee employee) {
        Optional<EmployeeData> optionalEmployee = employeeDataRepository.findById(employee.getId());
        if (optionalEmployee.isPresent()) {
            EmployeeData employeeData = optionalEmployee.get();
            employeeData.setName(employee.getName());
            employeeData.setPosition(employee.getPosition());
            employeeData.setEmail(employee.getEmail());
            employeeData.setSalary(employee.getSalary());

            EmployeeData updatedEmployee = employeeDataRepository.save(employeeData);

            employee.setId(updatedEmployee.getId());
            return employee;
        } else {
            return null;
        }
    }

    @Override
    public void delete(Integer id) throws Exception {

    }

    @Override
    public void delete(int id) {
        employeeDataRepository.deleteById(id);
    }
}
