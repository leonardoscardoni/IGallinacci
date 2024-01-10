import { Component, Input } from "@angular/core";
import { TeamDetailType } from "src/app/_models/TeamDetailApi.type";
@Component({
    selector: "app-contenitore-card-confronto-dati",
    templateUrl: "./contenitore-card-confronto-dati.component.html",
    styleUrls: ["./contenitore-card-confronto-dati.component.scss"],
})
export class ContenitoreCardConfrontoDatiComponent {
    @Input() data: TeamDetailType = {} as TeamDetailType
    logo= "/assets/s-l1200.webp"
    titoli = [
        'PUNTEGGIO',
        'RIMBALZI',
        'ASSIST',
        'TIRI DA CAMPO SEGNATI',
        'TIRI DA 2 SEGNATI',
        'TIRI DA 3 SEGNATI',
    ]
    arrotondaPerDifetto(valore: number): number {
        return valore = Math.floor(valore);
      }
}
