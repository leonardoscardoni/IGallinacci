import { Component, OnInit, Input } from "@angular/core";

@Component({
    selector: "app-bio-giocatore",
    templateUrl: "./bio-giocatore.component.html",
    styleUrls: ["./bio-giocatore.component.scss"],
})
export class BioGiocatoreComponent implements OnInit {
    @Input() nomeGiocatore!: any;
    @Input() eta!: any;
    @Input() peso!: any;
    @Input() stato!: any;
    @Input() altezza!: any;
    @Input() squadra!: any;
    @Input() annoIngressoNBA!: any;
    @Input() college!: any;
    @Input() affiliation!: any;

    ngOnInit() {}
}
