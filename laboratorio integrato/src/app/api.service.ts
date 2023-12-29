import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Observable, map } from "rxjs";
import { TypeHome } from "./_models/homeApi.type";

@Injectable({
  providedIn: "root",
})
export class ApiService {
  private baseURL = "http://localhost:8090/";

  private homeUrl = "games/getHomeUnLogged";

  private divisione = "teams/getTeams"

  constructor(private http: HttpClient) {}
  getHomeApi() {
    return this.http.get(`${this.baseURL}${this.homeUrl}`)
    .pipe(map((response:any) => {
        return response as TypeHome}));
  }
  getDivisionApi() {
    return this.http.get(`${this.baseURL}${this.divisione}`)
    .pipe(map((response:any) => {
        return response as any}));
  }
}
