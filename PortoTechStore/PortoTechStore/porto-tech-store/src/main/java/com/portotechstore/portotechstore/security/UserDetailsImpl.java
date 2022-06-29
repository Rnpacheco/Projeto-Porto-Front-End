package com.portotechstore.portotechstore.security;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.portotechstore.portotechstore.model.UsuarioModel;

public class UserDetailsImpl implements UserDetails {
	
	private static final long serialVersionUID =1L;//Controle interno, serialização - [estudar serialização] -> Transforme um objeto em uma sequencia de bytes
	private  String username;
	private String password;
	private List<GrantedAuthority> authorities;

	public UserDetailsImpl(UsuarioModel user ) {
		this.username = user.getUsername();
		this.password = user.getPassword();
	}
	
	public UserDetailsImpl() {
		
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.username;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
