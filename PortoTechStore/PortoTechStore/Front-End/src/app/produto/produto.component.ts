import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { carrinho } from '../environments/carrinho';
import { ItemCarrinho } from '../model/ItemCarrinhoModel';
import { ProdutoModel } from '../model/ProdutoModel';
import { ProdutoService } from '../services/produto.service';

@Component({
  selector: 'app-produto',
  templateUrl: './produto.component.html',
  styleUrls: ['./produto.component.css']
})
export class ProdutoComponent implements OnInit {
  private idProduto: number | undefined;
  public produto: ProdutoModel = new ProdutoModel;
  constructor(private router: Router, private acRoute: ActivatedRoute, private produtoService: ProdutoService) { }

  ngOnInit() {

    this.idProduto = Number(this.acRoute.snapshot.params['id']);

    this.produtoService.buscarProdutoById(this.idProduto).subscribe((resp: ProdutoModel) => {
      this.produto = resp;
    }
    );
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

  emEstoque() {
    return this.produto.qtdeEstoqueProduto > 0;
  }
}
