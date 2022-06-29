import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { environment } from '../environments/environment';
import { UserLogin } from '../model/UserLogin';
import { AuthService } from '../services/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  userLogin: UserLogin = new UserLogin();
  constructor(private auth: AuthService, private router: Router) {

  }

  ngOnInit(): void {
  }
  isLogado():boolean{
    return environment.token !='';
  }
  entrar(){
    this.auth.entrar(this.userLogin).subscribe((resp:UserLogin)=>{
        this.userLogin = resp;
        console.log(this.userLogin);

        environment.id = this.userLogin.id;
        environment.nome= this.userLogin.nome;
        environment.username = this.userLogin.username;
        environment.token = this.userLogin.token;
        environment.isAdmin = this.userLogin.isAdmin;
        environment.endereco+=this.userLogin.endereco+',';
        environment.endereco+=this.userLogin.numero+' ';
        environment.endereco+=this.userLogin.complemento+' ';
        environment.endereco+=this.userLogin.bairro+' - ';
        environment.endereco+=this.userLogin.cidade+', ';
        environment.endereco+=this.userLogin.estado+' - ';
        environment.endereco+=this.userLogin.cep;

        if(this.userLogin.isAdmin == true){
          this.router.navigate(['/gerenciadorprodutos']);
        }else{

          this.router.navigate(['/inicio']);
        }
        console.log(environment);
    });
  }
}
