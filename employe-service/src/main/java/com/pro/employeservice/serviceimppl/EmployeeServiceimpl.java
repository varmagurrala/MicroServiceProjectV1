package com.pro.employeservice.serviceimppl;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pro.employeservice.dto.EmployeeDto;
import com.pro.employeservice.entity.Empolyee;
import com.pro.employeservice.exception.EmpNotFound;
import com.pro.employeservice.repository.EmployeeRepository;
import com.pro.employeservice.service.EmployeeService;


@Service
public class EmployeeServiceimpl implements EmployeeService  {

	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public EmployeeDto saveEmployee(EmployeeDto empolyee) {
		
		Empolyee emp= modelMapper.map(empolyee, Empolyee.class);
		
		Empolyee savedemp = employeeRepository.save(emp);
		
		return modelMapper.map(savedemp, EmployeeDto.class);
	}
	
	@Override
	public EmployeeDto getById(Long empid) {
		
		Empolyee emp = employeeRepository.findById(empid).orElseThrow(()-> new EmpNotFound(String.format("the %d not found", empid)) );
		
		
		
	
		
		return  modelMapper.map(emp, EmployeeDto.class);
	}
	
}
	


