import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
@Component({
  selector: 'app-prova-api',
  templateUrl: './prova-api.component.html',
  styleUrls: ['./prova-api.component.scss']
})
export class ProvaApiComponent {
// URL dell'API che vuoi chiamare
private apiUrl = 'http://localhost:8090/games/getHomeUnLogged';

// Inietta il modulo HttpClient nel costruttore
constructor(private http: HttpClient) {}

// Implementa il metodo OnInit per eseguire azioni all'inizializzazione del componente
ngOnInit(): void {
this.fetchData()
}

// Metodo per effettuare la chiamata API e visualizzare la risposta nella console
fetchData(): void {
  // Utilizza il metodo get del modulo HttpClient
  // L'URL completo sarà https://jsonplaceholder.typicode.com/todos/1
  this.http.get(this.apiUrl).subscribe(
    (data) => {
      // Visualizza la risposta della chiamata API nella console
      console.log('Data from API:', data);
    }
  );
}
}
