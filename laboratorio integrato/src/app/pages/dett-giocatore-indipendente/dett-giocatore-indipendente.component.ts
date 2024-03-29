import { Component } from "@angular/core";
import { ActivatedRoute } from "@angular/router";
import { PlayerDetailIndType } from "src/app/_models/PlayerDetailInd.type";
import { ApiService } from "src/app/api.service";

@Component({
    selector: "app-dett-giocatore-indipendente",
    templateUrl: "./dett-giocatore-indipendente.component.html",
    styleUrls: ["./dett-giocatore-indipendente.component.scss"],
})
export class DettGiocatoreIndipendenteComponent {
    constructor(private route: ActivatedRoute, private apiService: ApiService) {}
    data: PlayerDetailIndType = {} as PlayerDetailIndType;
    data2: any = {} as any;
    isFavourite!: boolean;
    id: any;

    ngOnInit() {
        this.route.paramMap.subscribe((params) => {
            this.id = params.get("id");
            this.route.data.subscribe(({ getPlayerDetailInd }) => {
                this.data = getPlayerDetailInd;
                console.log(this.data);
                console.log("qeust", this.data);
            });
        });
    }

    toggleFavourite(id: any) {
        this.apiService.getFavouritePlayer(id).subscribe((data) => {
            this.data2 = data;
            console.log(this.data);
            console.log(id);
        });
        this.isFavourite = !this.isFavourite;
    }
}
