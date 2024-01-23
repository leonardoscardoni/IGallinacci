import { Component } from "@angular/core";
import { ElencoTeamType } from "src/app/_models/elencoTeam.type";
import { ApiService } from "../../api.service";
import { ActivatedRoute } from "@angular/router";

@Component({
    selector: "app-elenco-team",
    templateUrl: "./elenco-team.component.html",
    styleUrls: ["./elenco-team.component.scss"],
})
export class ElencoTeamComponent {
    constructor(private route: ActivatedRoute, private apiService: ApiService) {}
    data: ElencoTeamType = {} as ElencoTeamType;

    ngOnInit() {
        this.route.paramMap.subscribe((params) => {
            this.route.data.subscribe(({ getElencoTeam }) => {
                this.data = getElencoTeam;
                console.log(this.data);
            });
        });
    }
}
