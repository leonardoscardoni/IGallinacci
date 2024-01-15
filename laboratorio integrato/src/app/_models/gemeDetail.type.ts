export interface GameDetail {
    gameDetails: GameDetails;
    viewLastFourGamesHome: LastFourHTHHome;
    viewLastFourGamesVisitor: LastFourHTHHome;
    lastFourHtHHome: LastFourHTHHome;
    lastFourHtHVisitor: LastFourHTHHome;
}

export interface GameDetails {
    id: number;
    arena: string;
    city: string;
    date: Date;
    time: string;
    homeTeam: Team;
    visitorTeam: Team;
}

export interface Team {
    id: number;
    nickname: string;
    logo: string;
}

export interface LastFourHTHHome {
    idTeam: number;
    code: string;
    logo: string;
    headToHeads?: HeadToHead[];
    lastGames?: LastGame[];
}

export interface HeadToHead {
    idGame: number;
    points: number;
}

export interface LastGame {
    idGame: number;
    result: boolean;
}
