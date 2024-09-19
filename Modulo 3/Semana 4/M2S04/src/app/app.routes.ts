import { Routes } from '@angular/router';
import { ListagemComponent } from './listagem/listagem.component';

export const routes: Routes = [
    {
		path: 'listagem',
		component: ListagemComponent
	},
	{ path: '', redirectTo: '/listagem', pathMatch: 'full' },
    { path: '**', redirectTo: 'listagem'}
];
