package com.training.demo.restfulworks.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class UserDAOService {
	private static List<User> users = new ArrayList<>();
	private static int userCount = 103;
	static {
		users.add(new User(101, "Birendra", new Date()));
		users.add(new User(102, "Akshay", new Date()));
		users.add(new User(103, "Ankit", new Date()));

	}

	public List<User> getAllUsers() {
		return users;
	}

	public User saveUser(User user) {
		if (user.getUserId() == null) {
			user.setUserId(++userCount);
		}
		users.add(user);
		return user;
	}

	public User getUser(int userId) {
		for (User user : users) {
			if (user.getUserId() == userId) {
				return user;
			}
		}
		return null;
	}

	public User deleteUSer(int userId) {
		//TODO
		return null;
	}

	public User updateUser(User user) {
		//TODO
		return user;

	}
}
