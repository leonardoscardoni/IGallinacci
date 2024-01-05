import { HttpClient } from "@angular/common/http";
import { Component } from "@angular/core";
import { Router } from "@angular/router";

@Component({
    selector: "app-login",
    templateUrl: "./login.component.html",
    styleUrls: ["./login.component.scss"],
})
export class LoginComponent {
    loginObj: any = {
        EmailId: "",
        Password: "",
    };

    constructor(private http: HttpClient, private router: Router) {}

    onLogin() {
        this.http
            /* this.loginObj contiene i dati inseriti dall'utente nel form e infatti sono i dati che vengono inviati in post a quell url */
            .post("https://freeapi.miniprojectideas.com/api/User/Login", this.loginObj)
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
                if (res.result) {
                    alert("login ok");
                    /* In questo modo ti salvi nel local storage il token che hai nel response body e lo chiami loginToken.
                    Per vedere il loginToken salvato vado in ispeziona, application, localstorage, localhost*/
                    localStorage.setItem("loginToken", res.data.token);
                    /* Ti porta alla route home */
                    this.router.navigateByUrl("/home");
                } else {
                    alert(res.message);
                }
            });
    }
}
