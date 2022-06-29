import { environment } from './../environments/environment';
import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { carrinho } from '../environments/carrinho';

@Component({
  selector: 'app-cabecalho',
  templateUrl: './cabecalho.component.html',
  styleUrls: ['./cabecalho.component.css']
})
export class CabecalhoComponent implements OnInit {

  tamanhoCarrinho = carrinho.length;
  nome = environment.nome;
  buscarNome:string = '';
  idUsuario = environment.id;

  constructor() { }
  ngOnInit(): void {
    this.tamanhoCarrinho = carrinho.length;
  }

  isNotLogado(): boolean{

    return environment.token == '';
  }

  sair(){
    environment.endereco='';
    environment.id=0;
    environment.isAdmin=false;
    environment.username='';
    environment.token=''
    environment.nome = '';
  }

  isAdmin():Boolean{

    return environment.isAdmin;
  }

}
