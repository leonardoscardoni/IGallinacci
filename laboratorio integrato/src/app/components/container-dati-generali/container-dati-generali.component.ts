import { Component, Input } from "@angular/core";

@Component({
    selector: "app-container-dati-generali",
    templateUrl: "./container-dati-generali.component.html",
    styleUrls: ["./container-dati-generali.component.scss"],
})
export class ContainerDatiGeneraliComponent {
    @Input() data: any;
}
