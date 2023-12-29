import { Component } from "@angular/core";
@Component({
    selector: "app-contenitore-card-confronto-dati",
    templateUrl: "./contenitore-card-confronto-dati.component.html",
    styleUrls: ["./contenitore-card-confronto-dati.component.scss"],
})
export class ContenitoreCardConfrontoDatiComponent {
    a = [
        {
            titolo: "Punti da tre",
            squadre: [
                {
                    logo: "/assets/s-l1200.webp",
                    nome: "Trail brazers",
                    dato: "30%",
                },
                {
                    logo: "/assets/s-l1200.webp",
                    nome: "Cavaliers",
                    dato: "10%",
                },
            ],
        },
        {
            titolo: "Tiri da campo",
            squadre: [
                {
                    logo: "/assets/s-l1200.webp",
                    nome: "Trail brazers",
                    dato: "30%",
                },
                {
                    logo: "/assets/s-l1200.webp",
                    nome: "Cavaliers",
                    dato: "10%",
                },
            ],
        },
        {
            titolo: "Palle rubate",
            squadre: [
                {
                    logo: "/assets/s-l1200.webp",
                    nome: "Trail brazers",
                    dato: "12",
                },
                {
                    logo: "/assets/s-l1200.webp",
                    nome: "Cavaliers",
                    dato: "25",
                },
            ],
        },
    ];
}
