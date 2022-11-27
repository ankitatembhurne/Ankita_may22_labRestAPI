package com.ankita.ems.serviceimpl;

import com.ankita.ems.entity.User;
import com.ankita.ems.repository.UserRepository;
import com.ankita.ems.security.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.getUserByUsername(username);
		if (user == null) {
			System.out.println("Could not find user..." + username);
			throw new UsernameNotFoundException("Could not find user");
		}
		return new MyUserDetails(user);
	}
}