package com.portotechstore.portotechstore.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portotechstore.portotechstore.model.ProdutoModel;
import com.portotechstore.portotechstore.model.UsuarioLogin;
import com.portotechstore.portotechstore.model.UsuarioModel;
import com.portotechstore.portotechstore.model.VendaItemModel;
import com.portotechstore.portotechstore.repository.UsuarioRepository;
import com.portotechstore.portotechstore.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins= "*",allowedHeaders = "*")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private UsuarioRepository usuarioRepository;
	@GetMapping
	public ResponseEntity<List<UsuarioModel>>getAll(){
		return ResponseEntity.ok(usuarioRepository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UsuarioModel> GetByIdUser(@PathVariable long id){ // @PathVariable transforma o parametro id em uma variavel para ser usada em (return repository.findById(id))
		return usuarioRepository.findById(id)
				///retorno de resposta se encontra ok, se nao encontra notFound
				.map(resp -> {
					return ResponseEntity.ok(resp); 
					})// caso encontra o id na base de dados retorna cod 200 ok
				.orElse(ResponseEntity.notFound().build());//caso nao encontre o id retorna o notFound 
	}
	
	
	@PostMapping("/logar")
	public ResponseEntity<UsuarioLogin>Autentication(@RequestBody Optional<UsuarioLogin> userLogin){
		System.out.println("Passando aqui");
		return usuarioService.Logar(userLogin).map(resp->ResponseEntity.ok(resp))
				.orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
		
	}
	
	@PostMapping("/cadastrar")
	public ResponseEntity<Optional<UsuarioModel>> Post(@RequestBody UsuarioModel usuarioModel){
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(usuarioService.CadastrarUsuario(usuarioModel));
	}
	@PutMapping
	public ResponseEntity<Optional<UsuarioModel>> put (@RequestBody UsuarioModel usuarioModel){
		return ResponseEntity.status(HttpStatus.OK).body(usuarioService.atualizarUsuario(usuarioModel));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		usuarioRepository.deleteById(id);
	}
}