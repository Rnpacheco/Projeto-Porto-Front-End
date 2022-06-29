import { environment } from './../environments/environment';
import { ProdutoService } from './../services/produto.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ProdutoModel } from '../model/ProdutoModel';

@Component({
  selector: 'app-editar-produto',
  templateUrl: './editar-produto.component.html',
  styleUrls: ['./editar-produto.component.css']
})
export class EditarProdutoComponent implements OnInit {

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

  atualizarProduto(produto: ProdutoModel) {
    this.produtoService.putProduto(produto).subscribe(resp => {

    });


  }

  isAdmin(){
    return environment.isAdmin ==true ;
  }

}
