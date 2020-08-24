package com.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.entity.Department;
import com.service.DepartmentService;

@Controller
@RequestMapping("/department")
public class DepartmentController {

	@Resource
	private DepartmentService departmentService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	@ResponseBody
	public List<Department> getAll() {
		return departmentService.findAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Department getOne(@PathVariable Integer id) {
		System.out.println("get id : " + id);
		return departmentService.findById(id);
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	@ResponseBody
	public String create(@RequestBody Department Department) {
		System.out.println("get Department : " + Department.toString());

		Department = departmentService.save(Department);
		if (Department == null) {
			return "failed: Department is already exit";
		} else {
			System.out.println("sava Department to db : " + Department.toString());
			return "success add Department : " + Department.getId();
		}
	}

	@RequestMapping(value = "/{DepartmentId}", method = RequestMethod.PUT)
	@ResponseBody
	public String update(@PathVariable Integer DepartmentId, @RequestBody Department Department) {
		System.out.println("get id : " + DepartmentId);
		System.out.println("get Department : " + Department.toString());

		if (DepartmentId.intValue() != Department.getId().intValue()) {
			return "Error: id is incorrect";
		}

		Department = departmentService.update(Department);
		if (Department == null) {
			return "failed: DepartmentId not found";
		} else {
			return "success update DepartmentId : " + Department.getId();
		}
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public String delete(@PathVariable Integer id) {
		System.out.println("get id : " + id);

		if (id <= 0) {
			return "Error: id is incorrect";
		}

		Integer result = departmentService.delete(id);
		if (result.intValue() == 0) {
			return "success delete : " + id;
		} else {
			return "failed : " + result;
		}
	}

}
