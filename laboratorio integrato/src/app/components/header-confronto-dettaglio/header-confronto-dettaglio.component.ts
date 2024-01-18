import { Component, Input } from "@angular/core";

@Component({
    selector: "app-header-confronto-dettaglio",
    templateUrl: "./header-confronto-dettaglio.component.html",
    styleUrls: ["./header-confronto-dettaglio.component.scss"],
})
export class HeaderConfrontoDettaglioComponent {
    @Input() bgImg!: string;
    @Input() nome1!: string;
    @Input() nome2!: string;
    @Input() logo1!: string;
    @Input() logo2!: string;
}
