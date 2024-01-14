import { Component } from "@angular/core";
import { PlayerMatchType } from "src/app/_models/playerMatchApi.type";
import { ApiService } from "src/app/api.service";

@Component({
    selector: "app-dettaglio-giocatore-partita",
    templateUrl: "./dettaglio-giocatore-partita.component.html",
    styleUrls: ["./dettaglio-giocatore-partita.component.scss"],
})
export class DettaglioGiocatorePartitaComponent {
    constructor(private apiService: ApiService) {}
    data: PlayerMatchType = {} as PlayerMatchType
    ngOnInit() {
        this.apiService.getPlayerMatchApi().subscribe((data) => {
          this.data = data;
          console.log(this.data)
        });
      }

    
}
