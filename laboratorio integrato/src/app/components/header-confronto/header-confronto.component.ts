import { Component, Input } from "@angular/core";

@Component({
    selector: "app-header-confronto",
    templateUrl: "./header-confronto.component.html",
    styleUrls: ["./header-confronto.component.scss"],
})
export class HeaderConfrontoComponent {
    @Input() bgImg!: string;
    @Input() nome1!: string;
    @Input() nome2!: string;
    @Input() logo1!: string;
    @Input() logo2!: string;
}
