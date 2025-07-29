package com.example.test;

public class UserService {
	
	private final UserRepository testRepository;
	
	public UserService(UserRepository testRepository)
	{
		this.testRepository = testRepository;
	}
	
	public String getUserName(int userId)
	{
		return testRepository.findUserById(userId);
	}

}
