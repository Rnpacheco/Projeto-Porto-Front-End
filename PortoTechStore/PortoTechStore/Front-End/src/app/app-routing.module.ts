import { EditarUsuarioComponent } from './editar-usuario/editar-usuario.component';
import { BuscaCategoriaComponent } from './busca-categoria/busca.component';
import { EditarProdutoComponent } from './editar-produto/editar-produto.component';
import { CadastroProdutoComponent } from './cadastro-produto/cadastro-produto.component';
import { GerenciarProdutosComponent } from './gerenciar-produtos/gerenciar-produtos.component';
import { LoginComponent } from './login/login.component';
import { InicioComponent } from './inicio/inicio.component';
import { NgModule } from '@angular/core';
import { CarrinhoComponent } from './carrinho/carrinho.component';
import { CadastrarUsuarioComponent } from './cadastrar-usuario/cadastrar-usuario.component';
import { ProdutoComponent } from './produto/produto.component';
import { RouterModule, Routes } from '@angular/router';
import { FaleConoscoComponent } from './fale-conosco/fale-conosco.component';
import { BuscaNomeComponent } from './busca-nome/busca-nome.component';
import { BuscaMarcaComponent } from './busca-marca/busca-marca.component';

const routes: Routes = [{
  path: '', redirectTo: 'inicio', pathMatch: 'full'
},
{ path: 'inicio', component: InicioComponent },
{path: 'cadastrarusuario',component: CadastrarUsuarioComponent},
{path: 'carrinho',component: CarrinhoComponent},
{path: 'login',component: LoginComponent},
{path:'cadastroproduto',component:CadastroProdutoComponent},
{path:'gerenciadorprodutos', component:GerenciarProdutosComponent},
{path:'produto-editar/:id',component:EditarProdutoComponent},
{path:'produto/:id',component: ProdutoComponent},
{path: 'faleconosco',component: FaleConoscoComponent},
{path:'busca/categoria/:categoria',component:BuscaCategoriaComponent},
{path:'busca/nome/:nome', component:BuscaNomeComponent},
{path:'busca/marca/:marca', component:BuscaMarcaComponent},
{path:'usuario/editar/:id',component:EditarUsuarioComponent}
]

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
