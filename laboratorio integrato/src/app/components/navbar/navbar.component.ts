import { Component } from "@angular/core";


@Component({
    selector: "app-navbar",
    templateUrl: "./navbar.component.html",
    styleUrls: ["./navbar.component.scss"],
})
export class NavbarComponent {
    nameUser = localStorage.getItem("name");
    scadenzaTokenLocalStorage = localStorage.getItem("scadenzaToken");
    /* scadenzaTokenLocalStorage = "2024-01-17T12:41:15"; */

    ngOnInit() {
        if (this.scadenzaTokenLocalStorage) {
            let dataAttuale = new Date();
            let scadenzaTokenDate = new Date(this.scadenzaTokenLocalStorage);
            if (dataAttuale.getTime() > scadenzaTokenDate.getTime()) {
                localStorage.clear();
            }
        }
        }
}
