import { Component, OnInit } from '@angular/core';
import { CabecalhoComponent } from '../cabecalho/cabecalho.component';
import { RodapeComponent } from "../rodape/rodape.component";
import { ChamadasService } from '../chamadas.service';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-listagem',
  standalone: true,
  imports: [CabecalhoComponent, RodapeComponent, CommonModule, FormsModule],
  templateUrl: './listagem.component.html',
  styleUrl: './listagem.component.scss'
})
export class ListagemComponent implements OnInit {
  sugestoes: any[] = [];
  filtradas: any[] = [];

  pesquisaTermo: string = '';
  isLoading = true;

  constructor(private chamadasService: ChamadasService) {}
    ngOnInit(): void {
      this.chamadasService.getSugestoes().subscribe({
        next: (data) => {
          this.sugestoes = data;
          this.filtradas = data;
          this.isLoading = false;
        },
        error: (err) => {
          console.error('Erro ao carregar sugestões', err);
          this.isLoading = false;
        }
      });
    }

    pesquisar(): void {
      if (this.pesquisaTermo.trim()) {
        this.filtradas = this.sugestoes.filter(s =>
          s.titulo.toLowerCase().includes(this.pesquisaTermo.toLowerCase())
        );
      } else {
        this.filtradas = this.sugestoes;
      }
    }
}
