package com.pedidos.api.controller;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pedidos.api.dao.PyItemsFavoritosDao;
import com.pedidos.api.model.User;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@CrossOrigin("*")
@Component
@RestController
public class UserController {
	
	@Autowired
	private PyItemsFavoritosDao pyItemsFavoritosDao;

	@PostMapping("user")
	public User login(@RequestParam("user") String username, @RequestParam("password") String pwd) {
		
		String token = getJWTToken(username);
		User user = new User();
		user.setUser(username);
		user.setToken(token);		
		return user;
		
	}
	
	@PostMapping("eliminaFavoritosCloud")
	public String test(@RequestParam(required = true) long cliente, @RequestParam(required = true) String itemNum) {		
		System.out.println("SQL TEST ElimnaFav: ");
		return pyItemsFavoritosDao.eliminaFavorito(cliente, itemNum);
	}

	private String getJWTToken(String username) {
		String secretKey = "mySecretKey";
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils
				.commaSeparatedStringToAuthorityList("ROLE_USER");
		
		String token = Jwts
				.builder()
				.setId("pedidosJWT")
				.setSubject(username)
				.claim("authorities",
						grantedAuthorities.stream()
								.map(GrantedAuthority::getAuthority)
								.collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 600000))
				.signWith(SignatureAlgorithm.HS512,
						secretKey.getBytes()).compact();

		return "Bearer " + token;
	}
}
