import { environment } from './environments/environment';
import { Component } from '@angular/core';
import { AuthService } from './services/auth.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  environmentAppComponent = environment;
  title = 'PortoTechStore';
  environmentComponent = environment;
  constructor(public auth: AuthService){
  }
}
