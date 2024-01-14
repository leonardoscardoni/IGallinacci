import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Observable, map } from "rxjs";
import { TypeHome } from "./_models/homeApi.type";
import { TeamType } from "./_models/divisionTeamApi.type";
import { CalendarType } from "./_models/calendarApi.type";
import { TeamDetailType } from "./_models/TeamDetailApi.type";
import { ConfrontoTeamType } from "./_models/confrontoTeamApi.type";
import { PlayerMatchType } from "./_models/playerMatchApi.type";
import { TeamPlayerFilterType } from "./_models/teamPlayerFilter.type";
import { PlayerTeamFilteredType } from "./_models/PlayerTeamFilteredApi.type";
import { PlayerDetailIndType } from "./_models/PlayerDetailInd.type";

@Injectable({
  providedIn: "root",
})
export class ApiService {
  private baseURL = "http://localhost:8090/";

  private homeUrl = "games/getHomeUnLogged";

  private divisione = "team/getTeams"
  private calendar = "game/getCalendar?date="
  private team = "team/getTeamsDetails?idTeam=5&season=2022"
  private confrontoTeam = `${'team/getCompareTeam?idTeam1='}`
  private playerMatch = "player/getPlayerDetailsByGame?idGame=11058&idPlayer=4"
  private TeamRolesPlayerFilter = "player/getTeamRolesPlayerFilter"
  private playerIndipendente = "player/getPlayerDetails?idPlayer=18&season=2023"
  private PlayerFilter = `${'player/getPlayerTeamFiltered?idTeam='}`

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
  getPlayerDetailInd() {
    return this.http.get(`${this.baseURL}${this.playerIndipendente}`)
    .pipe(map((response:any) => {
        return response as PlayerDetailIndType}));
  }
  getTeamDetailApi() {
    return this.http.get(`${this.baseURL}${this.team}`)
    .pipe(map((response:any) => {
        return response as TeamDetailType}));
  }
  getTeamRolePlayerFilter() {
    return this.http.get(`${this.baseURL}${this.TeamRolesPlayerFilter}`)
    .pipe(map((response:any) => {
        return response as TeamPlayerFilterType}));
  }
  getPlayerFilter(idTeam:number) {
    return this.http.get(`${this.baseURL}${this.PlayerFilter}${idTeam}${'&season=2022'}`)
    .pipe(map((response:any) => {
        return response as PlayerTeamFilteredType}));
  }
  getPlayerMatchApi() {
    return this.http.get(`${this.baseURL}${this.playerMatch}`)
    .pipe(map((response:any) => {
        return response as PlayerMatchType}));
  }
  getConfrontoTeamApi(id1:string,id2:string) {
    return this.http.get(`${this.baseURL}${this.confrontoTeam}${id1}${'&idTeam2='}${id2}${'&season=2022'}`)
    .pipe(map((response:any) => {
        return response as ConfrontoTeamType}));
  }

  getCalendarApi(data: string) {
    return this.http.get(`${this.baseURL}${this.calendar}${data}`)
      .pipe(
        map((response: any) => {
          return response as CalendarType;
        })
      );
  }
}
