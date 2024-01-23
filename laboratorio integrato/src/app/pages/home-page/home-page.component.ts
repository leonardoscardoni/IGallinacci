import { Component, ElementRef, ViewChild } from "@angular/core";
import { ApiService } from "../../api.service";
import { TypeHome } from "../../_models/homeApi.type";
import { ActivatedRoute } from "@angular/router";
import dayjs from "dayjs";
import localizedFormat from "dayjs/plugin/localizedFormat"; // Importa il plugin per il formato localizzato
import "dayjs/locale/it";

@Component({
    selector: "app-home-page",
    templateUrl: "./home-page.component.html",
    styleUrls: ["./home-page.component.scss"],
})
export class HomePageComponent {
    @ViewChild("carouselContent") carouselContent!: ElementRef;

    scrollAmount = 450; // Regola la quantità di scorrimento

    scroll(direction: number) {
        const currentScrollLeft = this.carouselContent.nativeElement.scrollLeft;
        const newScrollLeft = currentScrollLeft + direction * this.scrollAmount;
        this.carouselContent.nativeElement.scrollTo({
            left: newScrollLeft,
            behavior: "smooth",
        });
    }
    constructor(private route: ActivatedRoute, private apiService: ApiService) {}
    data: TypeHome = {} as TypeHome;

    ngOnInit() {
        this.route.paramMap.subscribe((params) => {
            this.route.data.subscribe(({ getHome }) => {
                this.data = getHome;
                console.log(this.data);
            });
        });
    }

    convertDate(data: Date) {
        const dateDayJs = dayjs(data).locale("it");
        return dateDayJs.format("D MMMM");
    }
}
