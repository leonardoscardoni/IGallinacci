import { Component, OnInit, Input } from "@angular/core";

@Component({
    selector: "app-bio-giocatore",
    templateUrl: "./bio-giocatore.component.html",
    styleUrls: ["./bio-giocatore.component.scss"],
})
export class BioGiocatoreComponent implements OnInit {
    @Input() nomeGiocatore!: string;
    @Input() eta!: number;
    @Input() peso!: number;
    @Input() stato!: string;
    @Input() altezza!: string;
    @Input() squadra!: string;
    @Input() annoIngressoNBA!: number;
    @Input() college!: string;
    @Input() affiliation!: string;

    ngOnInit() {}
}
