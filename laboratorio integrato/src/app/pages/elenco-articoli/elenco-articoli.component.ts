import { Component, Input } from "@angular/core";

@Component({
    selector: "app-elenco-articoli",
    templateUrl: "./elenco-articoli.component.html",
    styleUrls: ["./elenco-articoli.component.scss"],
})
export class ElencoArticoliComponent {
    a = {
        ultimoArticolo: {
            titolo: "Jaime Jaquez Jr. parteciperà allo Slam Dunk Contest.",
            sottotitolo:
                "Lorem ipsum più lungo Jaime Jaquez Jr. parteciperà allo Slam Dunk Contest.",
            img: "/assets/Blog-1.jpg",
            tags: ["tag1", "tag2"],
        },
        articoli: [
            {
                data: "2024-12-22T20:30:00.000Z",
                img: "/assets/Blog-1.jpg",
                titolo: "Jaime Jaquez Jr. parteciperà allo Slam Dunk Contest.",
                sottotitolo:
                    "Lorem ipsum più lungo Jaime Jaquez Jr. parteciperà allo Slam Dunk Contest.",
                tags: ["tag1", "tag2"],
            },
            {
                data: "2024-12-23T20:30:00.000Z",
                img: "/assets/Blog-1.jpg",
                titolo: "La prima tripla doppia in NBA di Paolo Banchero.",
                sottotitolo: "Lorem ipsum più lungo La prima tripla",
                tags: ["tag1", "tag2"],
            },
            {
                data: "2024-12-24T20:30:00.000Z",
                img: "/assets/Blog-1.jpg",
                titolo: "La prima tripla doppia in NBA di Paolo Banchero.",
                sottotitolo: "Lorem ipsum più lungo La prima tripla doppia in NBA di ",
                tags: ["tag1", "tag2"],
            },
        ],
    };
}
