import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Observable, map } from "rxjs";
import { TypeHome } from "./_models/homeApi.type";
import { TeamType } from "./_models/divisionTeamApi.type";
import { CalendarType } from "./_models/calendarApi.type";
import { TeamDetailType } from "./_models/TeamDetailApi.type";
import { ConfrontoTeamType } from "./_models/confrontoTeamApi.type";
import { ElencoTeamType } from "./_models/elencoTeam.type";
import { PlayerMatchType } from "./_models/playerMatchApi.type";
import { TeamPlayerFilterType } from "./_models/teamPlayerFilter.type";
import { PlayerTeamFilteredType } from "./_models/PlayerTeamFilteredApi.type";
import { PlayerDetailIndType } from "./_models/PlayerDetailInd.type";
import { DettaglioPartitaType } from "./_models/dettaglioPartita.type";
import { ConfrontoPlayerType } from "./_models/confrotoPlayerApi.type";

@Injectable({
    providedIn: "root",
})
export class ApiService {
    private baseURL = "http://localhost:8090/";
    private homeUrl = "games/getHomeUnLogged";
    private elencoTeam = "team/getTeams";
    private divisione = "team/getTeams";
    private calendar = "game/getCalendar?date=";
    private team = `${'team/getTeamsDetails?idTeam='}`;
    private confrontoTeam = `${"team/getCompareTeam?idTeam1="}`;
    private confrontoPlayer = `${"player/getPlayerCompare?idPlayer1="}`;
    private playerMatch = "player/getPlayerDetailsByGame?idGame=11058&idPlayer=4";
    private TeamRolesPlayerFilter = "player/getTeamRolesPlayerFilter";
    private playerIndipendente = `${"player/getPlayerDetails?idPlayer="}`;
    private PlayerFilter = `${"player/getPlayerTeamFiltered?idTeam="}`;
    private dettaglioPartita = "game/getGameDetails?idGame=";

    constructor(private http: HttpClient) {}
    getHomeApi() {
        return this.http.get(`${this.baseURL}${this.homeUrl}`).pipe(
            map((response: any) => {
                return response as TypeHome;
            })
        );
    }

    getDivisionApi() {
        return this.http.get(`${this.baseURL}${this.divisione}`).pipe(
            map((response: any) => {
                return response as TeamType;
            })
        );
    }

    getPlayerDetailInd(id: string) {
        return this.http
            .get(`${this.baseURL}${this.playerIndipendente}${id}${"&season=2023"}`)
            .pipe(
                map((response: any) => {
                    return response as PlayerDetailIndType;
                })
            );
    }

    getTeamDetailApi(id:string) {
        return this.http.get(`${this.baseURL}${this.team}${id}${'&season=2022'}`).pipe(
            map((response: any) => {
                return response as TeamDetailType;
            })
        );
    }

    getTeamRolePlayerFilter() {
        return this.http.get(`${this.baseURL}${this.TeamRolesPlayerFilter}`).pipe(
            map((response: any) => {
                return response as TeamPlayerFilterType;
            })
        );
    }

    getPlayerFilter(idTeam: number) {
        return this.http.get(`${this.baseURL}${this.PlayerFilter}${idTeam}${"&season=2022"}`).pipe(
            map((response: any) => {
                return response as PlayerTeamFilteredType;
            })
        );
    }

    getPlayerMatchApi() {
        return this.http.get(`${this.baseURL}${this.playerMatch}`).pipe(
            map((response: any) => {
                return response as PlayerMatchType;
            })
        );
    }

    getConfrontoTeamApi(id1: string, id2: string) {
        return this.http
            .get(`${this.baseURL}${this.confrontoTeam}${id1}${"&idTeam2="}${id2}${"&season=2022"}`)
            .pipe(
                map((response: any) => {
                    return response as ConfrontoTeamType;
                })
            );
    }
    getConfrontoPlayerApi(id1: string, id2: string) {
        return this.http
            .get(`${this.baseURL}${this.confrontoPlayer}${id1}${"&idPlayer2="}${id2}${"&season=2022"}`)
            .pipe(
                map((response: any) => {
                    return response as ConfrontoPlayerType;
                })
            );
    }

    getCalendarApi(data: string) {
        return this.http.get(`${this.baseURL}${this.calendar}${data}`).pipe(
            map((response: any) => {
                return response as CalendarType;
            })
        );
    }

    getElencoTeam() {
        return this.http.get(`${this.baseURL}${this.elencoTeam}`).pipe(
            map((response: any) => {
                return response as ElencoTeamType;
            })
        );
    }
    

    getDettaglioPartita(idPartita: string) {
        return this.http.get(`${this.baseURL}${this.dettaglioPartita}${idPartita}`).pipe(
            map((response: any) => {
                return response as DettaglioPartitaType;
            })
        );
    }
}
