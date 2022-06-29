import { DEFAULT_CURRENCY_CODE, NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MenuComponent } from './menu/menu.component';
import { RodapeComponent } from './rodape/rodape.component';
import { InicioComponent } from './inicio/inicio.component';
import { HttpClientModule } from '@angular/common/http';
import { CabecalhoComponent } from './cabecalho/cabecalho.component';
import { CadastroProdutoComponent } from './cadastro-produto/cadastro-produto.component';
import { CarrinhoComponent } from './carrinho/carrinho.component';
import { ProdutoComponent } from './produto/produto.component';
import { LoginComponent } from './login/login.component';
import { GerenciarProdutosComponent } from './gerenciar-produtos/gerenciar-produtos.component';
import { CadastrarUsuarioComponent } from './cadastrar-usuario/cadastrar-usuario.component';
import { EditarProdutoComponent } from './editar-produto/editar-produto.component';
import { SobreComponent } from './sobre/sobre.component';
import { FaleConoscoComponent } from './fale-conosco/fale-conosco.component';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { BuscaNomeComponent } from './busca-nome/busca-nome.component';
import { BuscaCategoriaComponent } from './busca-categoria/busca.component';
import { BuscaMarcaComponent } from './busca-marca/busca-marca.component';
import { EditarUsuarioComponent } from './editar-usuario/editar-usuario.component';

@NgModule({
  declarations: [
    AppComponent,
    MenuComponent,
    RodapeComponent,
    CadastrarUsuarioComponent,
    InicioComponent,
    CabecalhoComponent,
    CadastroProdutoComponent,
    CarrinhoComponent,
    ProdutoComponent,
    LoginComponent,
    GerenciarProdutosComponent,
    EditarProdutoComponent,
    SobreComponent,
    FaleConoscoComponent,
    BuscaCategoriaComponent,
    BuscaNomeComponent,
    BuscaMarcaComponent,
    EditarUsuarioComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [
    
    
  {provide: DEFAULT_CURRENCY_CODE,
    useValue: 'BRL'}],
bootstrap: [AppComponent]
})
export class AppModule { }
