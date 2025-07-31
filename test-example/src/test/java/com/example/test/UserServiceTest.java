package com.example.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

	@Mock
	private UserRepository userRepository;
	
	@InjectMocks
	private UserService userService;
	
	@Test
	void shouldGetUserById()
	{
		String[] values = {"zero", "one", "two", "three", "four", "five", "six",
						   "seven", "eight", "nine"};
		
		when(userRepository.findUserById(anyInt())).thenAnswer(x -> 
			values[x.getArgument(0, Integer.class)]);
		
		for (int i = 0; i < 10; i++)
			assertEquals(values[i], userService.getUserName(i));
	}
	
}
