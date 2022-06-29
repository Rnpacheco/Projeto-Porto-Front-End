import { ItemCarrinho } from '../model/ItemCarrinhoModel';
import { ProdutoService } from './../services/produto.service';
import { Component, OnInit, EventEmitter, Output } from '@angular/core';
import { ProdutoModel } from '../model/ProdutoModel';
import { carrinho } from '../environments/carrinho';
import { Router } from '@angular/router';

@Component({
  selector: 'app-inicio',
  templateUrl: './inicio.component.html',
  styleUrls: ['./inicio.component.css']
})
export class InicioComponent implements OnInit {

  public listaProdutos: ProdutoModel[] = [];
  constructor(private router: Router, private produtoService: ProdutoService) { } //private cabecalho: CabecalhoComponent) { }

  ngOnInit(): void {

    this.produtoService.buscarProdutos().subscribe((lista: ProdutoModel[]) => {
      this.listaProdutos = lista;
    });
  }
  adicionarCarrinho(produto: ProdutoModel) {
    //Verificando se o produto já existe no carinho
    for (let item of carrinho) {
      console.log(produto);
      console.log(item.produto);
      if (produto.idProduto == item.produto.idProduto) {
        item.qtde++;
        return;
      }
    }
    const itemCarrinho: ItemCarrinho = new ItemCarrinho();
    itemCarrinho.produto = produto;
    itemCarrinho.qtde = 1;
    carrinho.push(itemCarrinho);


    //this.cabecalho.ngOnInit();
  }
  exibirCarrossel(): Boolean {

    return true;
  }
}
