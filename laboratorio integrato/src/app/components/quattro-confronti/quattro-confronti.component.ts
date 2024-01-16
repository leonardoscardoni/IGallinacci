import { Component, OnInit, Input } from "@angular/core";

@Component({
    selector: "app-quattro-confronti",
    templateUrl: "./quattro-confronti.component.html",
    styleUrls: ["./quattro-confronti.component.scss"],
})
export class QuattroConfrontiComponent implements OnInit {
    @Input() tipologia!: "headToHead" | "quarti" | "ultimi4Incontri";
    @Input() data?: any;
    @Input() dataHome?: any;
    @Input() dataVisitor?: any;
    @Input() homeTeamLogo!: string;
    @Input() visitorTeamLogo!: string;
    @Input() homeTeamName!: string;
    @Input() visitorTeamName!: string;

    ngOnInit() {}
}
