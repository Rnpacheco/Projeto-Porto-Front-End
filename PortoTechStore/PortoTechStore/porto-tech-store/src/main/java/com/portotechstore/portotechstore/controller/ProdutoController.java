package com.portotechstore.portotechstore.controller;

import java.util.List;

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
import com.portotechstore.portotechstore.repository.ProdutoRepository;


@RestController //INFORMA AO SPRING QUE ESSA CLASSE É UM CONTROLADOR, isto é, a camada de controlador gera várias EXECUCOES de metodos para executar na saída no BD.Controla o fluxo de entrada e saída de metodos/execucoes   
@RequestMapping("/produtos")//URI e parametro /produtos, quando vir a requisicao /produtos ira consumir essa classe
@CrossOrigin("*") //aceita requisicoes de qualquer origem (front-end)
public class ProdutoController {

	
	@Autowired //coloca o spring para executar e gerenciar essa classe, isto é passa a responsabilidade do spring em instanciar e executar os metodos de uma classe do tipo interface
	private ProdutoRepository repository;
	//usando o contrato findAll -> seleciona tudo 
	
	
	//Criação dos métodos GET,POST,PUT e DELETE
	

	
	@GetMapping("/marca/{marca}")
	public ResponseEntity<List<ProdutoModel>> findAllByMarcaProdutoContainingIgnoreCase(@PathVariable String marca){ //
		return ResponseEntity.ok(repository.findAllByMarcaProdutoContainingIgnoreCase(marca));
	}
	
	@GetMapping("/categoria/{categoria}")
	public ResponseEntity<List<ProdutoModel>> findAllByCategoriaProdutoContainingIgnoreCase(@PathVariable String categoria){ //
		return ResponseEntity.ok(repository.findAllByCategoriaProdutoContainingIgnoreCase(categoria));
	}
	
	
	
	@GetMapping//toda vez que tiver uma requisicao da api /produtos, verificara o metodo que chama, se for o GET disparara este metodo
	public ResponseEntity<List<ProdutoModel>>GetAll()
	{
		return ResponseEntity.ok(repository.findAll());//.ok resposta do http 
	}
			
	@GetMapping("/{id}") // qual metodo http vou enviar a api - nesse caso o getmapping com parametro do id, para executar esse metodo
	public ResponseEntity<ProdutoModel> GetByIdProduto(@PathVariable long id){ // @PathVariable transforma o parametro id em uma variavel para ser usada em (return repository.findById(id))
		System.out.println(id);
		return repository.findById(id)
				///retorno de resposta se encontra ok, se nao encontra notFound
				.map(resp -> {
					System.out.println(resp.getNomeProduto());
					return ResponseEntity.ok(resp); 
					})// caso encontra o id na base de dados retorna cod 200 ok
				.orElse(ResponseEntity.notFound().build());//caso nao encontre o id retorna o notFound 
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<ProdutoModel>> GetByCadastro(@PathVariable String nome){ //
		return ResponseEntity.ok(repository.findAllByNomeProdutoContainingIgnoreCase(nome));
	}
	
	@PostMapping
	public ResponseEntity<ProdutoModel> post (@RequestBody ProdutoModel produto){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(produto));
	}
	
	@PutMapping
	public ResponseEntity<ProdutoModel> put (@RequestBody ProdutoModel produto){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(produto));
	}

	//Deleta produto por id
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}	
		
}
