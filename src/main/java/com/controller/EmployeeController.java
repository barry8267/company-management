package com.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.entity.Department;
import com.entity.Employee;
import com.service.DepartmentService;
import com.service.EmployeeService;

import net.minidev.json.JSONObject;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Resource
	private EmployeeService employeeService;
	
	@Resource
	private DepartmentService departmentService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	@ResponseBody
	public List<Employee> getAll() {
		return employeeService.findAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Employee getOne(@PathVariable Integer id) {
		System.out.println("get id : " + id);
		return employeeService.findById(id);
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	@ResponseBody
	public String create(@RequestBody Employee employee) {
		System.out.println("get employee : " + employee.toString());

		Date createTime = new Date();
		employee.setCreateTime(createTime);
		employee.setUpdateTime(createTime);
		employee = employeeService.save(employee);
		if (employee == null) {
			return "failed: employee is already exit";
		} else {
			System.out.println("sava employee to db : " + employee.toString());
			return "success add employee : " + employee.getId();
		}
	}

	@RequestMapping(value = "/{employeeId}", method = RequestMethod.PUT)
	@ResponseBody
	public String update(@PathVariable Integer employeeId, @RequestBody Employee employee) {
		System.out.println("get id : " + employeeId);
		System.out.println("get employee : " + employee.toString());

		if (employeeId.intValue() != employee.getId().intValue()) {
			return "Error: id is incorrect";
		}

		Date updateTime = new Date();
		employee.setUpdateTime(updateTime);
		employee = employeeService.update(employee);
		if (employee == null) {
			return "failed: employeeId not found";
		} else {
			return "success update employeeId : " + employee.getId();
		}
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public String delete(@PathVariable Integer id) {
		System.out.println("get id : " + id);

		if (id <= 0) {
			return "Error: id is incorrect";
		}

		Integer result = employeeService.delete(id);
		if (result.intValue() == 0) {
			return "success delete : " + id;
		} else {
			return "failed : " + result;
		}
	}
	
	@RequestMapping(value = "/advancedQuery", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject advancedQuery(@RequestBody Employee employee) {
		
		System.out.println("advancedQuery employee : " + employee);
		
		JSONObject result = new JSONObject();
		List<Employee> employeeList = employeeService.findAll();
		Employee em = null;
		Department de = null;
		for (Employee e : employeeList) {
			if (employee.getId() != null) {
				if (!employee.getId().equals(e.getId())) {
					continue;
				}
			}
			if (employee.getName() != null) {
				if (!employee.getName().equals(e.getName())) {
					continue;
				}
			}
			if (employee.getDepartmentId() != null) {
				if (!employee.getDepartmentId().equals(e.getDepartmentId())) {
					continue;
				}
			}
			if (employee.getGender() != null) {
				if (!employee.getGender().equals(e.getGender())) {
					continue;
				}
			}
			if (employee.getTel() != null) {
				if (!employee.getTel().equals(e.getTel())) {
					continue;
				}
			}
			if (employee.getAddress() != null) {
				if (!employee.getAddress().equals(e.getAddress())) {
					continue;
				}
			}
			if (employee.getAge() != null) {
				if (!employee.getAge().equals(e.getAge())) {
					continue;
				}
			}
			
			em = e;
		}

		if(em!=null) {
			de = departmentService.findById(em.getDepartmentId());
		}
		
		result.put("employee", em);
		result.put("department", de);
		return result;
		
	}

}
