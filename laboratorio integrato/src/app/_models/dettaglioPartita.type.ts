export interface DettaglioPartitaType {
    gameDetails: GameDetails;
    viewLastFourGamesHome: LastFourHTHHome;
    viewLastFourGamesVisitor: LastFourHTHHome;
    lastFourHtHGameDetailsHome: LastFourHTHHome;
    lastFourHtHGameDetailsVisitor: LastFourHTHHome;
    players: Players;
    statistics: Statistic[];
    bestPlayers: BestPlayers;
    quartersPerTeam: QuartersPerTeam;
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
    points: number;
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

export interface Players {
    homeTeam: PlayersTeam[];
    visitorTeam: PlayersTeam[];
}

export interface PlayersTeam {
    idPlayer: number;
    firstname: string;
    lastname: string;
    number: number | null;
    role: string;
}

export interface Statistic {
    statsType: string;
    homeTeamStats: number;
    visitorTeamStats: number;
}

export interface BestPlayers {
    homeTeam: BestPlayersHomeTeam[];
    visitorTeam: BestPlayersHomeTeam[];
}

export interface BestPlayersHomeTeam {
    idPlayer: number;
    firstname: string;
    lastname: string;
    number: number;
    data: number;
    type: string;
}

export interface QuartersPerTeam {
    homeTeam: QuartersPerTeamHomeTeam;
    visitorTeam: QuartersPerTeamHomeTeam;
}

export interface QuartersPerTeamHomeTeam {
    quarters: number[];
}
