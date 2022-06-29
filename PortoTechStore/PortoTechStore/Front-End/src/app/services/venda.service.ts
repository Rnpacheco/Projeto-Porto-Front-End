import { VendaModel } from './../model/VendaModel';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class VendaService {
  private url = 'http://localhost:8080/vendasitem'
  token = {
    headers: new HttpHeaders().set('Authorization',environment.token)
  }
  constructor(private httpClient: HttpClient) { }

  ultimoIdCarrinho(): Observable<VendaModel> {
    return this.httpClient.get<VendaModel>(this.url + '/ultimocarrinho');
  }

  criarVenda(venda: VendaModel): Observable<VendaModel> {
    //return this.httpClient.post<VendaModel>(this.url, venda,this.token)
    return this.httpClient.post<VendaModel>(this.url, venda);
  }
}
