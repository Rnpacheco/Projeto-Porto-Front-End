import { ProdutoService } from './../services/produto.service';
import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { ProdutoModel } from '../model/ProdutoModel';
import { environment } from '../environments/environment';

@Component({
  selector: 'app-gerenciar-produtos',
  templateUrl: './gerenciar-produtos.component.html',
  styleUrls: ['./gerenciar-produtos.component.css']
})
export class GerenciarProdutosComponent implements OnInit {

  public listaProdutos: ProdutoModel[] = []
  constructor(private router: Router, private produtoService: ProdutoService) {

  }
  ngOnInit() {
    this.produtoService.buscarProdutos().subscribe((lista: ProdutoModel[]) => {
      this.listaProdutos = lista;
    });
  }
  chamarPagProduto() {
    this.router.navigate(['/cadastroproduto']);
  }

  deletarProduto(id:number|string){

    this.produtoService.deleteProduto(Number(id)).subscribe(resp=>{

      this.ngOnInit();
    });
  }


  isAdmin(){
    return environment.isAdmin == true ;
  }


}
