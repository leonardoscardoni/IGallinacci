import { Component, OnInit, Input } from "@angular/core";

@Component({
    selector: "app-card-confronto-dati",
    templateUrl: "./card-confronto-dati.component.html",
    styleUrls: ["./card-confronto-dati.component.scss"],
})
export class CardConfrontoDatiComponent implements OnInit {
    @Input() titoloCard!: string;
    @Input() nomeSquadra1!: string;
    @Input() nomeSquadra2!: string;
    @Input() logoSquadra1!: string;
    @Input() logoSquadra2!: string;
    @Input() datoSquadra1!: number;
    @Input() datoSquadra2!: number;

    ngOnInit() {}
}
