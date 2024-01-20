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
   
isFavourite! : boolean
    squadraSelezionata: any;
    ruoloSelezionato: any;
    idGiocatore: any;
data3:any

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
      console.log(this.ruoloSelezionato)
      
      this.apiService.getPlayerFilter(idTeam).subscribe((data) => {
        this.data2 = data;
        console.log(this.data2)
        
      });
    }
    

    toggleFavourite(id:any) {

      this.apiService.getFavouritePlayer(id).subscribe((data) => {
          this.data3 = data;
          console.log(this.data);
          console.log(id);
      });
      this.isFavourite = !this.isFavourite;
  }

    
}
