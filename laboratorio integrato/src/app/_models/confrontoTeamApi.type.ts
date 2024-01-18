export interface ConfrontoTeamType {
    team1: Team;
    team2: Team;
    dataCompareTeamNba: DataCompareTeamNba[];
    lastFourGamesTeam1: LastFourGamesTeam;
    lastFourGamesTeam2: LastFourGamesTeam;
    lastFourHtHTeam1: LastFourHtHTeam;
    lastFourHtHTeam2: LastFourHtHTeam;
}

export interface LastFourHtHTeam {
    idTeam: number;
    code: string;
    logo: string;
    headToHeads: HeadToHeadGame[];
}

export interface HeadToHeadGame {
    idGame: number;
    points: number;
}

export interface LastFourGamesTeam {
    idTeam: number;
    code: string;
    logo: string;
    lastGames: LastGame[];
}
export interface LastGame {
    idGame: number;
    result: boolean;
}

export interface DataCompareTeamNba {
    dataName: string;
    dataTeam1: number;
    datateam2: number;
}

export interface Team {
    name: string;
    logo: string;
    conference: string;
    rankConference: number;
}
