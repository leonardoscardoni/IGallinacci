import { Component, OnInit, Input } from "@angular/core";
import { ActivatedRoute } from "@angular/router";
import { ApiService } from "src/app/api.service";

@Component({
    selector: "app-nome-team-elenco-team",
    templateUrl: "./nome-team-elenco-team.component.html",
    styleUrls: ["./nome-team-elenco-team.component.scss"],
})
export class NomeTeamElencoTeamComponent implements OnInit {
    isFavourite!: boolean;
    constructor(private apiService: ApiService, private route: ActivatedRoute) {}
    data2: any = {} as any;
    @Input() logo: string = "";
    @Input() nomeTeam: string = "";
    @Input() preferito: boolean = false;
    @Input() logged!: boolean;
    @Input() router!: any;
    @Input() idTeam!: any;

    ngOnInit() {}

    toggleFavourite(id:any) {
        this.apiService.getFavouriteTeam(id).subscribe((data) => {
            this.data2 = data;
            console.log(this.data2);
            console.log(id);
        });
        this.isFavourite = !this.isFavourite;
    }
}
