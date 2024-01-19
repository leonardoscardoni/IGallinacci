export interface TypeHome {
    logged: boolean;
    pastGames: PastGame[];
    favTeamsPastGame: any[];
    nextGames: NextGame[];
    favTeamsNextGame: any[];
    eastStandings: any[];
    westStandings: any[];
    blogs: any[];
}

export interface NextGame {
    id: number;
    time: string;
    homeTeam: Team;
    visitorTeam: Team;
}

export interface Team {
    id: number;
    nickname: string;
    logo: string;
    points?: number;
}

export interface PastGame {
    id: number;
    homeTeam: Team;
    visitorTeam: Team;
}
