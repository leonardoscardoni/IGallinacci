import { Component, Input } from "@angular/core";

@Component({
    selector: "app-titolo-sezione",
    templateUrl: "./titolo-sezione.component.html",
    styleUrls: ["./titolo-sezione.component.scss"],
})
export class TitoloSezioneComponent {
    @Input() numero!: string;
    @Input() titolo!: string;
    @Input() spiegazione!: string;
    @Input() spanSpiegazione?: string;
}
