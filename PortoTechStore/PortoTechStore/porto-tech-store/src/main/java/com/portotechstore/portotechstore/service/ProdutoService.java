package com.portotechstore.portotechstore.service;

import java.util.List;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portotechstore.portotechstore.model.ProdutoModel;
import com.portotechstore.portotechstore.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	ProdutoRepository produtoRepository;
public void addOrRemoveProduto(ProdutoModel produto, int quantidade, boolean adicionar) {
		
		if(adicionar) {
			
			produto.setQtdeEstoqueProduto(produto.getQtdeEstoqueProduto() + quantidade);
		}else {
			produto.setQtdeEstoqueProduto(produto.getQtdeEstoqueProduto() - quantidade);
		}
		
		produtoRepository.save(produto);
		
	 }


        

}
