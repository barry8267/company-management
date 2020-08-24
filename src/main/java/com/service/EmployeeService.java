package com.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.entity.Employee;
import com.repository.EmployeeRepository;

@Service("EmployeeService")
public class EmployeeService {

	@Resource
	private EmployeeRepository employeeRepository;
	
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	public Employee findById(Integer id) {
		return employeeRepository.findById(id).orElse(null);
	}

	public Employee save(Employee employee) {
		Employee temp = employeeRepository.findById(employee.getId()).orElse(null);
		if (temp != null) {
			return null;
		}
		return employeeRepository.save(employee);
	}

	public Employee update(Employee employee) {
		Employee temp = employeeRepository.findById(employee.getId()).orElse(null);
		if (temp == null) {
			return null;
		}

		temp.setName(employee.getName());
		temp.setDepartmentId(employee.getDepartmentId());
		temp.setGender(employee.getGender());
		temp.setTel(employee.getTel());
		temp.setAddress(employee.getAddress());
		temp.setCreateTime(employee.getCreateTime());
		temp.setUpdateTime(employee.getUpdateTime());

		return employeeRepository.save(temp);
	}

	public Integer delete(Integer id) {

		Employee temp = employeeRepository.findById(id).orElse(null);
		if (temp == null) {
			return -1;
		} else {
			employeeRepository.deleteById(id);
			return 0;
		}

	}

}
