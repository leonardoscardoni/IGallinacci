export interface PlayerMatchType {
    idGame:           number;
    header:           Header;
    homeTeam:         Team;
    visitorTeam:      Team;
    player:           Player;
    stats:            Stats;
    shots:            Shots;
    assistRebounds:   AssistRebounds;
    foulsBallsBlocks: FoulsBallsBlocks;
}

export interface AssistRebounds {
    reboundsOffensive: number;
    reboundsDefensive: number;
    totalRebounds:     number;
    assists:           number;
}

export interface FoulsBallsBlocks {
    foulsCommitted: number;
    steals:         number;
    turnovers:      number;
    blocks:         number;
}

export interface Header {
    nameArena: string;
    city:      string;
    date:      Date;
    time:      string;
}

export interface Team {
    name:   string;
    logo:   string;
    points: number;
}

export interface Player {
    idTeam:    number;
    firstname: string;
    lastname:  string;
    logo:      string;
    pos:       string;
}

export interface Shots {
    fieldGoalsMade:          number;
    fieldGoalsAttempted:     number;
    fieldGoalsPercentage:    number;
    freeThrowsMade:          number;
    freeThrowsAttempted:     number;
    freeThrowsPercentage:    number;
    threePointersMade:       number;
    threePointersAttempted:  number;
    threePointersPercentage: number;
}

export interface Stats {
    min:           number;
    score:         number;
    totalRebounds: number;
    assists:       number;
}
