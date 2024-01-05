import { Injectable } from "@angular/core";
import { HttpRequest, HttpHandler, HttpEvent, HttpInterceptor } from "@angular/common/http";
import { Observable } from "rxjs";

@Injectable()
export class CustomInterceptor implements HttpInterceptor {
    constructor() {}

    /* L'interceptor viene richiamato tutte le volte che viene fatta una chiamata api. Si mette di mezzo tra il client e il server. Quindi appena lancio una chiamata api entra in azione l'interceptor e poi la chiamata raggiunge il link api */

    intercept(request: HttpRequest<unknown>, next: HttpHandler): Observable<HttpEvent<unknown>> {
        /* Durante il login ho ottenuto un token che ho salvato nel local storage. Ora me lo prendo dal local storage e lo metto in questa variabile token  */
        const token = localStorage.getItem("loginToken");

        if (token) {
            /* Clono la richiesta che viene fatta e a questo clone modifico l'header andando ad aggiungere il token */
            const newCloneRequest = request.clone({
                setHeaders: {
                    Authorization: `Bearer ${token}`,
                },
            });

            /* La chiamata che viene fatta è quella con l'aggiunta dell'header, quindi il clone non l'originale */
            return next.handle(newCloneRequest);
        } else {
            return next.handle(request);
        }
    }
}
