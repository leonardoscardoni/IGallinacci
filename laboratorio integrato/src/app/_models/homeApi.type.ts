export interface TypeHome {
    logged: boolean;
    pastGames: PastGame[];
    favTeamsPastGame: PastGame[];
    nextGames: NextGame[];
    favTeamsNextGame: NextGame[];
    eastStandings: any[];
    westStandings: WestStanding[];
    blogs: Blog[];
}

export interface Blog {
    idBlog: number;
    title: string;
    subtitle: string;
    img: string;
    date: Date;
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

export interface WestStanding {
    idTeam: number;
    nickname: string;
    logo: string;
    rank: number;
}
