import { Component, Input } from "@angular/core";
import { ActivatedRoute } from "@angular/router";
import { TeamDetailType } from "src/app/_models/TeamDetailApi.type";

@Component({
    selector: "app-container-dati-generali",
    templateUrl: "./container-dati-generali.component.html",
    styleUrls: ["./container-dati-generali.component.scss"],
})
export class ContainerDatiGeneraliComponent {
    @Input() data: TeamDetailType = {} as TeamDetailType

    constructor(private route: ActivatedRoute) {}
}
