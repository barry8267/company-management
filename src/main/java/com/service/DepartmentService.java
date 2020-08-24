package com.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.entity.Department;
import com.repository.DepartmentRepository;

@Service("DepartmentService")
public class DepartmentService {

	@Resource
	private DepartmentRepository departmentRepository;

	public List<Department> findAll() {
		return departmentRepository.findAll();
	}

	public Department findById(Integer id) {
		return departmentRepository.findById(id).orElse(null);
	}

	public Department save(Department Department) {
		Department temp = departmentRepository.findById(Department.getId()).orElse(null);
		if (temp != null) {
			return null;
		}
		return departmentRepository.save(Department);
	}

	public Department update(Department Department) {
		Department temp = departmentRepository.findById(Department.getId()).orElse(null);
		if (temp == null) {
			return null;
		}

		
		temp.setName(Department.getName());

		return departmentRepository.save(temp);
	}

	public Integer delete(Integer id) {

		Department temp = departmentRepository.findById(id).orElse(null);
		if (temp == null) {
			return -1;
		} else {
			departmentRepository.deleteById(id);
			return 0;
		}

	}

}
