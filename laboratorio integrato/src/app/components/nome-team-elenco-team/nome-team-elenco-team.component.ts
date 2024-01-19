import { Component, OnInit, Input } from "@angular/core";

@Component({
    selector: "app-nome-team-elenco-team",
    templateUrl: "./nome-team-elenco-team.component.html",
    styleUrls: ["./nome-team-elenco-team.component.scss"],
})
export class NomeTeamElencoTeamComponent implements OnInit {
    @Input() logo: string = "";
    @Input() nomeTeam: string = "";
    @Input() preferito: boolean = false;
    @Input() logged!: boolean;

    ngOnInit() {}
}
