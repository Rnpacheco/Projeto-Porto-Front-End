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
import com.portotechstore.portotechstore.model.VendaItemModel;
import com.portotechstore.portotechstore.repository.ProdutoRepository;
import com.portotechstore.portotechstore.repository.VendaItemRepository;
import com.portotechstore.portotechstore.service.VendaItemService;

@RestController
@RequestMapping("/vendasitem")
@CrossOrigin("*")
public class VendaItemController {

	@Autowired
	VendaItemRepository vendaRepository;
	@Autowired
	ProdutoRepository produtoRepository;
	
	@Autowired
	VendaItemService vendaService;
	
	@GetMapping
	public ResponseEntity<List<VendaItemModel>>GetAll(){
		return ResponseEntity.ok(vendaRepository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<VendaItemModel>GetByIdUsuario(@PathVariable long id){
		return vendaRepository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	@GetMapping("/ultimocarrinho")
	public ResponseEntity<Optional<Long>> getLastIdCarrinho(){
		return ResponseEntity.ok(vendaRepository.findFirstByOrderByIdCarrinhoDesc());
	}
	@PostMapping()
	public ResponseEntity<VendaItemModel>post(@RequestBody VendaItemModel venda){
		
		return ResponseEntity.status(HttpStatus.CREATED).body(vendaService.criarVenda(venda));
	}
	
	@PutMapping
	public ResponseEntity<VendaItemModel> put (@RequestBody VendaItemModel venda){
		return ResponseEntity.status(HttpStatus.OK).body(vendaRepository.save(venda));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		vendaRepository.deleteById(id);
	}	
}