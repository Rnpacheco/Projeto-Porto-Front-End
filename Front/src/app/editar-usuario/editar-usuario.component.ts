import { environment } from './../environments/environment';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AuthService } from '../services/auth.service';
import { ViaCEPService } from '../services/viacep.service';
import { UserModel } from '../model/UserModel';

@Component({
  selector: 'app-editar-usuario',
  templateUrl: './editar-usuario.component.html',
  styleUrls: ['./editar-usuario.component.css']
})
export class EditarUsuarioComponent implements OnInit {
  idUser:number | undefined;
  usuario: UserModel = new UserModel();
  constructor(private viacepService : ViaCEPService , private auth: AuthService,private router:Router,private acRoute: ActivatedRoute) { }

  ngOnInit(): void {
    this.idUser = Number(this.acRoute.snapshot.params['id']);
    this.auth.buscarUserById(this.idUser).subscribe(resp=>{
      this.usuario = resp;
    });
  }
  buscarEndereco(cep:any){
    this.viacepService.buscarCEP(cep.value).subscribe((resposta)=>{
      this.prencherEndereco(resposta);
    })
  }

  prencherEndereco(enderecoModel: any){
    this.usuario.endereco = enderecoModel.logradouro;
    this.usuario.bairro = enderecoModel.bairro;
    this.usuario.cidade = enderecoModel.localidade;
    this.usuario.estado = enderecoModel.uf;
  }
  isLogado(){
   return environment.token!='';
  }

  atualizarPessoa(){
    this.auth.atualizar(this.usuario).subscribe(resp=>{});
  }
}
