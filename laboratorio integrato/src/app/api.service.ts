import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Observable, map } from "rxjs";
import { TypeHome } from "./_models/homeApi.type";
import { TeamType } from "./_models/divisionTeamApi.type";
import { CalendarType } from "./_models/calendarApi.type";

@Injectable({
  providedIn: "root",
})
export class ApiService {
  private baseURL = "http://localhost:8090/";

  private homeUrl = "games/getHomeUnLogged";

  private divisione = "teams/getTeams"
  private calendar = "games/getCalendar?date="

  constructor(private http: HttpClient) {}
  getHomeApi() {
    return this.http.get(`${this.baseURL}${this.homeUrl}`)
    .pipe(map((response:any) => {
        return response as TypeHome}));
  }
  getDivisionApi() {
    return this.http.get(`${this.baseURL}${this.divisione}`)
    .pipe(map((response:any) => {
        return response as TeamType}));
  }
  requestBody = {
    // Inserisci qui i dati che vuoi inviare al server, se necessario
  };
  getCalendarApi(data: string) {
    return this.http.post(`${this.baseURL}${this.calendar}${data}`, this.requestBody)
      .pipe(
        map((response: any) => {
          return response as CalendarType;
        })
      );
  }
}
