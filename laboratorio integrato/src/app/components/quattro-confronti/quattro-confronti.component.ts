import { Component, OnInit, Input } from "@angular/core";

@Component({
    selector: "app-quattro-confronti",
    templateUrl: "./quattro-confronti.component.html",
    styleUrls: ["./quattro-confronti.component.scss"],
})
export class QuattroConfrontiComponent implements OnInit {
    @Input() quarti!: boolean;
    @Input() numeri!: boolean;

    a = {
        squadre: [
            {
                nome: "STK",
                logo: "/assets/s-l1200.webp",
                punteggio: [
                    {
                        quarter: "Q1",
                        points: 120,
                    },
                    {
                        quarter: "Q2",
                        points: 130,
                    },
                    {
                        quarter: "Q3",
                        points: 135,
                    },
                    {
                        quarter: "Q4",
                        points: 160,
                    },
                ],
                vittorie: [true, false, true, true],
            },
            {
                nome: "CUL",
                logo: "/assets/s-l1200.webp",
                punteggio: [
                    {
                        quarter: "Q1",
                        points: 100,
                    },
                    {
                        quarter: "Q2",
                        points: 120,
                    },
                    {
                        quarter: "Q3",
                        points: 125,
                    },
                    {
                        quarter: "Q4",
                        points: 200,
                    },
                ],
                vittorie: [false, false, true, true],
            },
        ],
    };

    ngOnInit() {}
}
