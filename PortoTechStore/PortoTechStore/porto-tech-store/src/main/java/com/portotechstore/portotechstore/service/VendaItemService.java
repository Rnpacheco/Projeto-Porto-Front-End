package com.portotechstore.portotechstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.portotechstore.portotechstore.model.ProdutoModel;
import com.portotechstore.portotechstore.model.UsuarioModel;
import com.portotechstore.portotechstore.model.VendaItemModel;
import com.portotechstore.portotechstore.repository.ProdutoRepository;
import com.portotechstore.portotechstore.repository.UsuarioRepository;
import com.portotechstore.portotechstore.repository.VendaItemRepository;
@Service
public class VendaItemService {
	@Autowired
	ProdutoRepository produtoRepository;
	
	@Autowired
	ProdutoService produtoService;
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	VendaItemRepository vendaRepository;
	
	public VendaItemModel criarVenda(VendaItemModel venda){
		ProdutoModel produto = produtoRepository.getById(venda.getProduto().getIdProduto());
		UsuarioModel usuario = usuarioRepository.getById(venda.getUsuario().getId());
		//Nome cliente e produto
		venda.setNomeUsuario(usuario.getNome());
		venda.setNomeProduto(produto.getNomeProduto());
		venda.setValorUnitarioProduto(produto.getPrecoVendaProduto());
		//Total vendido
		double precoVendaProduto = produto.getPrecoVendaProduto();
		venda.setTotal(calcularTotalVendido(precoVendaProduto,venda.getQtdeProduto(),venda.getDescontoProduto()));
		//Baixando produto
		produtoService.addOrRemoveProduto(produto, venda.getQtdeProduto(), false);
		
		return vendaRepository.save(venda);
		
	}
	
	
	public double calcularTotalVendido(double precoVendaProduto,double  qtdeVendida, Double desconto) {
		
		if(desconto == null) {
			desconto = 0.0;
		}
		return (precoVendaProduto * qtdeVendida) - desconto;
	}
	
	//Criar no service do produto
	
	
}