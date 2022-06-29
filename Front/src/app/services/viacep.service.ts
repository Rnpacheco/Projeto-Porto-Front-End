import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http'
@Injectable({
  providedIn: 'root'
})
export class ViaCEPService {
  private url:string  ='https://viacep.com.br/ws/';

  constructor(private httpClient: HttpClient) { }


  buscarCEP(cep:string){
    return this.httpClient.get(this.url+cep+'/json/');
  }

}
