import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-alunos',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './alunos.component.html',
  styleUrl: './alunos.component.scss'
})
export class AlunosComponent {

  alunos: any[] = JSON.parse(localStorage.getItem('alunos') || '[]');
  alunosFiltrados: any[] = this.alunos;
  pesquisa: string = '';

  constructor(private router: Router) {}

  filtrarAlunos() {
    const query = this.pesquisa.toLowerCase();
    this.alunosFiltrados = this.alunos.filter(aluno => {
      return aluno.nome.toLowerCase().includes(query) || aluno.email.toLowerCase().includes(query);
    });
  }

  editarAluno(aluno: any) {
    //TODO: LÓGICA DE EDIÇÃO
  }

  excluirAluno(aluno: any) {
    if (confirm('Tem certeza que deseja excluir este aluno?')) {
      this.alunos = this.alunos.filter(a => a !== aluno);
      localStorage.setItem('alunos', JSON.stringify(this.alunos));
      this.filtrarAlunos();
      alert('Aluno excluído com sucesso.')
    }
  }
}
