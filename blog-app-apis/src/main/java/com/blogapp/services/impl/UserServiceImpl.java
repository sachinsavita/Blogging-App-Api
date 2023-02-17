package com.blogapp.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogapp.entity.User;
import com.blogapp.exceptions.ResourceNotFoundException;
import com.blogapp.payloads.UserDto;
import com.blogapp.repos.UserRepo;
import com.blogapp.services.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ModelMapper modelMapper;     //Bean in the main application class

	@Override
	public UserDto createUser(UserDto userDto) {
		
		User user = this.dtoToUser(userDto);
		User savedUser = this.userRepo.save(user);
		return this.userToDto(savedUser);
	}

	@Override
	public UserDto updateUser(UserDto userDto, Integer userId) {
		User user = this.userRepo.findById(userId)
				.orElseThrow(()-> new ResourceNotFoundException("User", "Id",userId));
		
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setAbout(userDto.getAbout());
		user.setPassword(userDto.getPassword());
		
			User updatedUser = this.userRepo.save(user);
			UserDto updatedUserDto = this.userToDto(updatedUser);
		return updatedUserDto;
	}

	@Override
	public UserDto getUserById(Integer userId) {
		User user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","id", userId));
		
		return this.userToDto(user);
	}

	@Override
	public List<UserDto> getAllUsers() {
		List<User> users= this.userRepo.findAll();
		List<UserDto> usersDtos = users.stream()
				.map(user->this.userToDto(user))
				.collect(Collectors.toList());
		return usersDtos;
	}

	@Override
	public UserDto deleteUser(Integer userId) {
		User user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","id", userId));
		this.userRepo.delete(user);
		UserDto deletedUser = this.userToDto(user);
		return deletedUser;
	}
	
	public User dtoToUser(UserDto userDto)
	{
//		User user = new User();
		
		User user = this.modelMapper.map(userDto, User.class);
//		user.setId(userDto.getId());
//		user.setName(userDto.getName());
//		user.setEmail(userDto.getEmail());
//		user.setAbout(userDto.getAbout());
//		user.setPassword(userDto.getPassword());
		return user;
	}

	public UserDto userToDto(User user)
	{
//		UserDTO userDTO = new UserDTO();
		
		UserDto userDto = this.modelMapper.map(user, UserDto.class);
		
//		userDTO.setId(user.getId());
//		userDTO.setName(user.getName());
//		userDTO.setEmail(user.getEmail());
//		userDTO.setAbout(user.getAbout());
//		userDTO.setPassword(user.getPassword());
		return userDto;
	}
}
