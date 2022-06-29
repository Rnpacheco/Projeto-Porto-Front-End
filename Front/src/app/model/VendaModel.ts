import { UserModel } from './UserModel';
import { ProdutoModel } from "./ProdutoModel";
import { UserLogin } from "./UserLogin";

export class VendaModel{
  id!:number;
  produto!:ProdutoModel;
  idCarrinho!:number;
  qtdeProduto!:number;
  formaPagamento!:string;
  usuario!:UserModel;


}
