import { Component, ElementRef, Input, ViewChild } from "@angular/core";
import { PastGame, TypeHome } from "src/app/_models/homeApi.type";

@Component({
    selector: "app-ultimi-risultati-home",
    templateUrl: "./ultimi-risultati-home.component.html",
    styleUrls: ["./ultimi-risultati-home.component.scss"],
})
export class UltimiRisultatiHomeComponent {
    @Input() data: any;
    @Input() title: string = "";
    @Input() clicloFor: string = "";

    getBackgroundColor(point1: number | undefined, point2: number | undefined): string {
        // Imposta un valore predefinito di 0 se il valore è undefined
        const p1 = point1 ?? 0;
        const p2 = point2 ?? 0;

        // Ora puoi effettuare la comparazione senza problemi di tipi
        return p1 > p2 ? " " : "opacity-[40%]";
    }

    @ViewChild("carouselContent") carouselContent!: ElementRef;

    scrollAmount = 200; // Regola la quantità di scorrimento

    scroll(direction: number) {
        const currentScrollLeft = this.carouselContent.nativeElement.scrollLeft;
        const newScrollLeft = currentScrollLeft + direction * this.scrollAmount;
        this.carouselContent.nativeElement.scrollTo({
            left: newScrollLeft,
            behavior: "smooth",
        });
    }
}
