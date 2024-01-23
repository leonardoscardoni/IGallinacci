import { Component, OnInit, Input } from "@angular/core";

@Component({
    selector: "app-card-confronto-dati",
    templateUrl: "./card-confronto-dati.component.html",
    styleUrls: ["./card-confronto-dati.component.scss"],
})
export class CardConfrontoDatiComponent implements OnInit {
    @Input() titoloCard!: string;
    @Input() nomeSquadra1!: string;
    @Input() cognome1!: string;
    @Input() cognome2!: string;
    @Input() nomeSquadra2!: string;
    @Input() logoSquadra1!: string;
    @Input() logoSquadra2!: string;
    @Input() datoSquadra1!: number;
    @Input() datoSquadra2!: number;

    ngOnInit() {}

    getBackgroundColor(point1: number | undefined, point2: number | undefined): string {
        // Imposta un valore predefinito di 0 se il valore è undefined
        const p1 = point1 ?? 0;
        const p2 = point2 ?? 0;

        // Ora puoi effettuare la comparazione senza problemi di tipi
        return p1 > p2 ? " " : "opacity-[40%]";
    }
}
