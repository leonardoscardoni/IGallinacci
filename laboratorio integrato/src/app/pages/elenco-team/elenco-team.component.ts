import { Component } from "@angular/core";
import { ElencoTeamType } from "src/app/_models/elencoTeam.type";
import { ApiService } from "../../api.service";

@Component({
    selector: "app-elenco-team",
    templateUrl: "./elenco-team.component.html",
    styleUrls: ["./elenco-team.component.scss"],
})
export class ElencoTeamComponent {
    constructor(private apiService: ApiService) {}
    data: ElencoTeamType = {} as ElencoTeamType;

    ngOnInit() {
        this.apiService.getElencoTeam().subscribe((data: ElencoTeamType) => {
            this.data = data;
            console.log(this.data);
        });
    }
}
