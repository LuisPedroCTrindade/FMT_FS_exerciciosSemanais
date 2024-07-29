import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms'

@Component({
  selector: 'app-cadastro-aluno',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './cadastro-aluno.component.html',
  styleUrl: './cadastro-aluno.component.scss'
})
export class CadastroAlunoComponent {
  nome: string = '';
  cpf: string = '';
  email: string = '';
  celular: string = '';
  curso: string = '';

  constructor(private router: Router) {}

  onCadastroAluno() {
    if (this.nome && this.cpf && this.email && this.celular && this.curso) {

      const aluno = {
        nome: this.nome,
        cpf: this.cpf,
        email: this.email,
        celular: this.celular,
        curso: this.curso
      };

      const alunos = JSON.parse(localStorage.getItem('alunos') || '[]');

      alunos.push(aluno);

      localStorage.setItem('alunos', JSON.stringify(alunos));

      alert('Usuário salvo com sucesso');

      this.router.navigate(['/alunos']);

    } else {
      alert('Por favor, preencha todos os campos obrigatórios.');
    }
  }
}
