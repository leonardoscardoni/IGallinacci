import { Component } from "@angular/core";
import dayjs from "dayjs";
import localizedFormat from "dayjs/plugin/localizedFormat"; // Importa il plugin per il formato localizzato
import "dayjs/locale/it"; // Importa la lingua italiana

@Component({
    selector: "app-dettaglio-articolo",
    templateUrl: "./dettaglio-articolo.component.html",
    styleUrls: ["./dettaglio-articolo.component.scss"],
})
export class DettaglioArticoloComponent {
    a = {
        idArticolo: 1,
        header: {
            titolo: "Draymond Green torna in campo",
            sottotitolo:
                "La sua assenza ha pesato sui Warriors, ma il suo ritorno può cambiare le cose",
            data: "2024-12-22T20:30:00.000Z",
            autore: "clara",
        },
        body: {
            img: "/assets/header-articolo.jpg",
            paragrafi: [
                {
                    titoloParagrafo: "Lorem Ipsum",
                    testoParagrafo:
                        "Lorem ipsum dolor sit amet consectetur adipisicing elit. Eum, debitis hic! Ut natus impedit sit vel eius consectetur, enim quisquam amet illo nisi aliquam illum sequi rerum omnis quis fugiat culpa quaerat quas voluptates cum velit eos modi, reiciendis dolorem? Molestias, est assumenda. Accusamus explicabo incidunt neque quisquam eius minima!",
                },
                {
                    titoloParagrafo: "Lorem Ipsum",
                    testoParagrafo:
                        "Lorem ipsum dolor sit amet consectetur adipisicing elit. Eum, debitis hic! Ut natus impedit sit vel eius consectetur, enim quisquam amet illo nisi aliquam illum sequi rerum omnis quis fugiat culpa quaerat quas voluptates cum velit eos modi, reiciendis dolorem? Molestias, est assumenda. Accusamus explicabo incidunt neque quisquam eius minima!",
                },
            ],
        },
        leggiAnche: [
            {
                titolo: "Jaime Jaquez Jr. parteciperà allo Slam Dunk Contest.",
                sottotitolo: "Lorem Ipsum",
                data: "2024-12-22T20:30:00.000Z",
                img: "/assets/header-articolo.jpg",
                tags: ["tag1", "tag2"],
            },
            {
                titolo: "La prima tripla doppia in NBA di Paolo Banchero.",
                sottotitolo: "Lorem Ipsum",
                data: "2024-12-22T20:30:00.000Z",
                img: "/assets/header-articolo.jpg",
                tags: ["tag1", "tag2"],
            },
            {
                titolo: "L’infortunio di Haliburton. I Pacers saranno in difficoltà?",
                sottotitolo: "Lorem Ipsum",
                data: "2024-12-22T20:30:00.000Z",
                img: "/assets/header-articolo.jpg",
                tags: ["tag1", "tag2"],
            },
        ],
    };

    convertiData(data: string) {
        return dayjs(data).locale("it").format("D MMM, YYYY");
    }
}
