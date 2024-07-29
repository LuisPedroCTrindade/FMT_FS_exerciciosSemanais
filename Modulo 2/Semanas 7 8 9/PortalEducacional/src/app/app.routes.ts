import { Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { AlunosComponent } from './alunos/alunos.component';
import { CadastroAlunoComponent } from './cadastro-aluno/cadastro-aluno.component';
import { DisciplinasComponent } from './disciplinas/disciplinas.component';
import { LoginComponent } from './login/login.component';

export const routes: Routes = [
    {
        path: 'home',
        component: HomeComponent
    },
    {
        path: 'alunos',
        component: AlunosComponent
    },
    {
        path: 'cadastro-aluno',
        component: CadastroAlunoComponent
    },
    {
        path: 'disciplinas',
        component: DisciplinasComponent
    },
    {
        path: 'login',
        component: LoginComponent
    },
    { path: '**', redirectTo: 'home'}
];
