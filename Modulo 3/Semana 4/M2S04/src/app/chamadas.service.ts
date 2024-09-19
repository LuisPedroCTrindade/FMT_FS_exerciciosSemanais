import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

interface Sugestao {
  id: number;
  titulo: string;
  descricao: string;
  data_envio: Date;
  data_atualizacao: Date;
}

@Injectable({
  providedIn: 'root'
})
export class ChamadasService {
  private apiUrl = 'http://localhost:8081/sugestoes';

  constructor(private http: HttpClient) { }
  getSugestoes(): Observable<Sugestao[]> {
    return this.http.get<Sugestao[]>(this.apiUrl);
  }
}
