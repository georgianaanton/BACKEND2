package com.georgiana.certification.convertor;

import org.springframework.stereotype.Component;

import com.georgiana.certification.dto.User1Dto;
import com.georgiana.certification.entity.User1;

@Component
public class UserConvertor implements Convertor<User1, User1Dto>{

	@Override
	public User1Dto convert(User1 source) {
		User1Dto dto = new User1Dto();
		dto.setId(source.getId());
		dto.setFirstName(source.getFirstName());
		dto.setLastName(source.getLastName());
	
		return dto;
	}

}
