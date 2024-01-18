import { Component, Input } from "@angular/core";

@Component({
    selector: "app-header-elenco-articoli",
    templateUrl: "./header-elenco-articoli.component.html",
    styleUrls: ["./header-elenco-articoli.component.scss"],
})
export class HeaderElencoArticoliComponent {
    @Input() data!: any;
}
