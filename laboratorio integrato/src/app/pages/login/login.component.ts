import { HttpClient } from "@angular/common/http";
import { Component, ElementRef, ViewChild } from "@angular/core";
import { Router } from "@angular/router";

@Component({
    selector: "app-login",
    /* templateUrl: "./login.component.html",
    styleUrls: ["./login.component.scss"], */
    templateUrl: "./login.component.html",
    styleUrls: ["./login.component.scss"],
})
export class LoginComponent {
    loginObj: any = {
        email: "",
        password: "",
    };
    mostraPassword: boolean = false;

    @ViewChild("passwordInput", { static: true }) passwordInput!: ElementRef;
    toggleMostraPassword(): void {
        this.mostraPassword = !this.mostraPassword;

        // Aggiorna il tipo dell'input a seconda dello stato
        const inputElement = this.passwordInput.nativeElement as HTMLInputElement;
        inputElement.type = this.mostraPassword ? "text" : "password";
    }

    constructor(private http: HttpClient, private router: Router) {}

    onLogin() {
        this.http
            /* this.loginObj contiene i dati inseriti dall'utente nel form e infatti sono i dati che vengono inviati in post a quell url */
            .post("http://localhost:8090/user/login", this.loginObj)
            /* Il response body è questo in caso di pw sbagliata
            {
                "message": "UserName or Password is Wrong",
                "result": false,
                "data": null
            }
            Invece questo in caso di pw corretta
            {
                "message": "Login Success",
                "result": true,
                "data": {
                    "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE3MDQ0OTY2MTAsImlzcyI6IlRlc3QuY29tIiwiYXVkIjoiVGVzdC5jb20ifQ.hcL2zJQCr9BEvqYRj4Gxu1KIyA3PuNsVyasZmFlHMao"
                }
            }
            Con questa api, per avere result true bisogna mettere
            {
                "EmailId": "chetan@gmail.com",
                "Password": "admin"
            }
            */
            .subscribe((res: any) => {
                if (res.success) {
                    console.log("entraaaa");
                    alert("login ok");
                    console.log(res);
                    /* In questo modo ti salvi nel local storage il token che hai nel response body e lo chiami loginToken.
                    Per vedere il loginToken salvato vado in ispeziona, application, localstorage, localhost*/
                    localStorage.setItem("loginToken", res.token);
                    localStorage.setItem("name", res.name);
                    localStorage.setItem("scadenzaToken", res.expireDate);
                    /* Ti porta alla route home */
                    this.router.navigateByUrl("/home");
                } else {
                    alert(res.message);
                }
            });
    }
}
