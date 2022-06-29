import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { carrinho } from '../environments/carrinho';
import { ItemCarrinho } from '../model/ItemCarrinhoModel';
import { ProdutoModel } from '../model/ProdutoModel';
import { ProdutoService } from '../services/produto.service';

@Component({
  selector: 'app-busca',
  templateUrl: '../inicio/inicio.component.html',
  styleUrls: ['../inicio/inicio.component.css']
})
export class BuscaCategoriaComponent implements OnInit {

  public listaProdutos: ProdutoModel[] = [];
  private categoria: string = '';
  constructor(private router: Router, private acRoute: ActivatedRoute, private produtoService: ProdutoService) {
    // force route reload whenever params change;
    //this.router.routeReuseStrategy.shouldReuseRoute = () => false;
  }

  ngOnInit(): void {
    //mudar parametro e atualizar página
    this.acRoute.params.subscribe(resp=>{
      this.categoria = (resp['categoria']);
      if(this.categoria == 'foneouvido')this.categoria ='Fones de Ouvido';
      this.produtoService.buscarProdutosByCategoria(this.categoria).subscribe((resp: ProdutoModel[]) => {
        this.listaProdutos = resp;
      });
    });



  }

  adicionarCarrinho(produto: ProdutoModel) {
    const itemCarrinho: ItemCarrinho = new ItemCarrinho();
    itemCarrinho.produto = produto;
    itemCarrinho.qtde = 1;
    carrinho.push(itemCarrinho);
  }

  exibirCarrossel(): Boolean {

    return false;
  }

}
