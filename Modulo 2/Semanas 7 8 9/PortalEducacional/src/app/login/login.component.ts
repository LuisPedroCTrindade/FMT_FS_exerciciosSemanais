import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms'

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.scss'
})
export class LoginComponent {
  email: string = '';
  senha: string = '';

  constructor(private router: Router) {}

  onLogin() {
    if (this.email && this.senha){
      this.router.navigate(['/home']);
    } else {
      alert('Há campos incompletos.')
    }
  }

  esqueciMinhaSenha() {
    alert('Processo de recuperação de senha enviado para o e-mail cadastrado.');
  }

}
