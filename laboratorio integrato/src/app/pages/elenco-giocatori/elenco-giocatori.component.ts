import { Component, OnInit } from "@angular/core";
import { PlayerTeamFilteredType } from "src/app/_models/PlayerTeamFilteredApi.type";
import { TeamPlayerFilterType } from "src/app/_models/teamPlayerFilter.type";
import { ApiService } from "src/app/api.service";

@Component({
    selector: "app-elenco-giocatori",
    templateUrl: "./elenco-giocatori.component.html",
    styleUrls: ["./elenco-giocatori.component.scss"],
})
export class ElencoGiocatoriComponent implements OnInit {
    a = {
        squadre: ["squadrettina", "squadrona"],
        ruoli: ["attaccante", "difensore"],
        giocatori: [
            {
                logoSquadra: "/assets/s-l1200.webp",
                nomeGiocatore: "Clara Cosentino",
                nomeSquadra: "squadrettina",
                ruolo: "attaccante",
                provenienza: "italia",
                preferiti: false,
            },
            {
                logoSquadra: "/assets/s-l1200.webp",
                nomeGiocatore: "Lisa Bertinotti",
                nomeSquadra: "squadrona",
                ruolo: "difensore",
                provenienza: "italia",
                preferiti: false,
            },
            {
                logoSquadra: "/assets/s-l1200.webp",
                nomeGiocatore: "Nomignolino",
                nomeSquadra: "squadrettina",
                ruolo: "difensore",
                provenienza: "italia",
                preferiti: false,
            },
        ],
    };

    squadraSelezionata: any;
    ruoloSelezionato: any;



    constructor(private apiService: ApiService) {}
  data: TeamPlayerFilterType = {} as TeamPlayerFilterType
  ngOnInit() {
      this.apiService.getTeamRolePlayerFilter().subscribe((data) => {
        this.data = data;
        console.log(this.data)
      });
    }
    data2: PlayerTeamFilteredType = {} as PlayerTeamFilteredType
  PlayerFilter(idTeam:number) {
      this.apiService.getPlayerFilter(idTeam).subscribe((data) => {
        this.data2 = data;
        console.log(this.data2)

      });
    }
}
