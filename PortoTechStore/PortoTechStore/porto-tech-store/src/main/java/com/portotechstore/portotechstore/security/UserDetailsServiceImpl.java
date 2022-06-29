package com.portotechstore.portotechstore.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.portotechstore.portotechstore.model.UsuarioModel;
import com.portotechstore.portotechstore.repository.UsuarioRepository;

public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private UsuarioRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<UsuarioModel> user = userRepository.findByUsername(username);
		user.orElseThrow(() -> new UsernameNotFoundException(username+ "not found"));
		System.out.println("Load User By UserName -> Usando método");
		return user.map(UserDetailsImpl::new).get();
	}

}
