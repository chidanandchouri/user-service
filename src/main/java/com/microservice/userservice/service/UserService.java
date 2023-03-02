package com.microservice.userservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.microservice.userservice.entity.User;
import com.microservice.userservice.repository.UserRepository;
import com.mocroservice.userservice.VO.Department;
import com.mocroservice.userservice.VO.ResponseTemplateVO;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RestTemplate restTemplate;

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public User getUser(long id) {
		return userRepository.findById(id).get();
	}

	public User saveUser(User user) {
		return userRepository.save(user);
	}

	public User updateUser(User user) {
		return userRepository.save(user);
	}

	public ResponseTemplateVO getUserWithDepartment(long id) {
		ResponseTemplateVO vo = new ResponseTemplateVO();
		
		User user = userRepository.findById(id).get();
		Department dept = restTemplate
								.getForObject("http://DEPARTMENT-SERVICE/departments/"+ user.getDeptId()
								, Department.class);
		
		vo.setUser(user);
		vo.setDepartment(dept);
		return vo;
	}

}
