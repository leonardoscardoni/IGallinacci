import { Component } from "@angular/core";
import { ActivatedRoute } from "@angular/router";
import { ConfrontoTeamType } from "src/app/_models/confrontoTeamApi.type";
import { ConfrontoPlayerType } from "src/app/_models/confrotoPlayerApi.type";
import { ApiService } from "src/app/api.service";

@Component({
    selector: "app-dett-confronto-giocatori",
    templateUrl: "./dett-confronto-giocatori.component.html",
    styleUrls: ["./dett-confronto-giocatori.component.scss"],
})
export class DettConfrontoGiocatoriComponent {
    a = {
        bgImg: "/assets/confronto-giocatori-header.jpg",
        nome1: "Clara Cosentino",
        nome2: "Alessio Strano",
        logo1: "/assets/s-l1200.webp",
        logo2: "/assets/s-l1200.webp",
        confrontoGiocatori: [
            {
                nomeGiocatore: "Clara Cosentino",
                eta: 25,
                peso: 50,
                stato: "Italia",
                altezza: "160",
                squadra: "nome squadra",
                annoIngressoNBA: 2000,
                college: "Torino",
                affiliation: "Bo",
                ruolo: "attaccante",
            },
            {
                nomeGiocatore: "Alessio Strano",
                eta: 25,
                peso: 50,
                stato: "Italia",
                altezza: "160",
                squadra: "nome squadra",
                annoIngressoNBA: 2000,
                college: "Torino",
                affiliation: "Bo",
                ruolo: "difensore",
            },
        ],
    };



    constructor(private route: ActivatedRoute ,private apiService: ApiService) {}
    data: ConfrontoPlayerType = {} as ConfrontoPlayerType
    id1: any;
    id2: any;
    
    ngOnInit() {
      this.route.paramMap.subscribe((params) => {
        this.id1 = params.get('id1');
        this.id2 = params.get('id2');
        console.log('id1:', this.id1);
        console.log('id2:', this.id2);
        this.apiService.getConfrontoPlayerApi(this.id1, this.id2).subscribe((data) => {
          this.data = data
          console.log('qeust',data);
        });
      });
    }


  bgImg= "/assets/confronto-giocatori-header.jpg"
  logo= "/assets/s-l1200.webp"
  titoli = [
      'PUNTEGGIO',
      'RIMBALZI',
      'ASSIST',
      'TIRI DA CAMPO SEGNATI',
      'TIRI DA 2 SEGNATI',
      'TIRI DA 3 SEGNATI',
  ]
}
