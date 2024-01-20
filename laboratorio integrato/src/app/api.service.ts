import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Observable, catchError, map } from "rxjs";
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
import { ClassificaType } from "./_models/classificaApi.type";
import { HomeRequestType } from "./_models/postCalls.type";
import { ProfileType } from "./_models/profile.type";

@Injectable({
    providedIn: "root",
})
export class ApiService {
    private baseURL = "http://localhost:8090/";
    private homeUrl = "game/getHome";
    private elencoTeam = "team/getTeams";
    private divisione = "team/getTeams";
    private calendar = "game/getCalendar?date=";
    private team = `${"team/getTeamsDetails?idTeam="}`;
    private confrontoTeam = `${"team/getCompareTeams?idTeam1="}`;
    private confrontoPlayer = `${"player/getComparePlayer?idPlayer1="}`;
    private playerMatch = "player/getPlayerDetailsByGame?idGame=";
    private TeamRolesPlayerFilter = "player/getTeamRolesPlayerFilter";
    private playerIndipendente = `${"player/getPlayerDetails?idPlayer="}`;
    private PlayerFilter = `${'player/getPlayerFilteredByTeam?idTeam='}`;
    private dettaglioPartita = "game/getGameDetails?idGame=";

    private classifica = `${"team/getStandings?season="}`;
    private favouriteTeam = 'favourite/team';
    private favouritePlayer = 'favourite/player';

    private userDetail = `user/getUserProfile`;


    constructor(private http: HttpClient) {}

    token: string | null = "";
    todayDate: string = "";
    HomeRequest: HomeRequestType = {} as HomeRequestType;

    ngOnInit() {
        console.log("entra nell onit di api service");
        this.token = localStorage.getItem("loginToken");
        this.todayDate = "2024-01-19";

        this.HomeRequest = {
            token: this.token || null,
            date: this.todayDate,
        };
    }

    getHomeApi() {
        return this.http
            .post(`${this.baseURL}${this.homeUrl}`, {
                token: localStorage.getItem("loginToken"),
                date: "2024-01-16",
            })
            .pipe(
                map((response: any) => {
                    console.log(response);
                    return response as TypeHome;
                }),
                catchError((error: any) => {
                    console.error("Error:", error);
                    throw error;
                })
            );
    }
    getFavouriteTeam(id:number) {
        return this.http
            .post(`${this.baseURL}${this.favouriteTeam}`,
            {
                token: localStorage.getItem("loginToken"),
                idTeam:id,
            }
            )
           
    }
    getFavouritePlayer(id:number) {
        return this.http
            .post(`${this.baseURL}${this.favouritePlayer}`,
            {
                token: localStorage.getItem("loginToken"),
                idPlayer:id,
            }
            )
           
    }
    getDettaglioPartita(idPartita: string) {
        return this.http
            .post(`${this.baseURL}${this.dettaglioPartita}${idPartita}`, {
                token: localStorage.getItem("loginToken"),
            })
            .pipe(
                map((response: any) => {
                    return response as DettaglioPartitaType;
                })
            );
    }

    getElencoTeam() {
        return this.http
            .post(`${this.baseURL}${this.elencoTeam}`, {
                token: localStorage.getItem("loginToken"),
            })
            .pipe(
                map((response: any) => {
                    return response as ElencoTeamType;
                })
            );
    }

    getTeamDetailApi(id: string) {
        return this.http
            .post(`${this.baseURL}${this.team}${id}${"&season=2022"}`, {
                token: localStorage.getItem("loginToken"),
            })
            .pipe(
                map((response: any) => {
                    return response as TeamDetailType;
                })
            );
    }

    getDivisionApi() {
        return this.http.post(`${this.baseURL}${this.divisione}`,{
            token: localStorage.getItem("loginToken"),
        }).pipe(
            map((response: any) => {
                return response as TeamType;
            })
        );
    }
    getClassifica(stagione: string) {
        return this.http.post(`${this.baseURL}${this.classifica}${stagione}`,{
            token: localStorage.getItem("loginToken"),
        }).pipe(
            map((response: any) => {
                return response as ClassificaType;
            })
        );
    }

    getPlayerDetailInd(id: string) {
        return this.http
            .post(`${this.baseURL}${this.playerIndipendente}${id}${"&season=2022"}`, {
                token: localStorage.getItem("loginToken"),
            })
            .pipe(
                map((response: any) => {
                    return response as PlayerDetailIndType;
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
        return this.http.post(`${this.baseURL}${this.PlayerFilter}${idTeam}${"&season=2022"}`,{
            token: localStorage.getItem("loginToken"),
        }).pipe(
            map((response: any) => {
                return response as PlayerTeamFilteredType;
            })
        );
    }

    getConfrontoTeamApi(id1: string, id2: string) {
        return this.http
            .post(`${this.baseURL}${this.confrontoTeam}${id1}${"&idTeam2="}${id2}${"&season=2022"}`,{
                token: localStorage.getItem("loginToken"),
            })
            .pipe(
                map((response: any) => {
                    return response as ConfrontoTeamType;
                })
            );
    }
    getConfrontoPlayerApi(id1: string, id2: string) {
        return this.http
            .post(
                `${this.baseURL}${
                    this.confrontoPlayer
                }${id1}${"&idPlayer2="}${id2}${"&season=2022"}`,{
                    token: localStorage.getItem("loginToken"),
                }
            )
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

    getPlayerMatchApi(idGame: string, idPlayer: string) {
        return this.http
            .post(`${this.baseURL}${this.playerMatch}${idGame}&idPlayer=${idPlayer}`,{
                token: localStorage.getItem("loginToken"),
            })
            .pipe(
                map((response: any) => {
                    return response as PlayerMatchType;
                })
            );
    }

    getUserDetail() {
        return this.http
            .post(`${this.baseURL}${this.userDetail}`, {
                token: localStorage.getItem("loginToken"),
            })
            .pipe(
                map((response: any) => {
                    return response as ProfileType;
                })
            );
    }
}
