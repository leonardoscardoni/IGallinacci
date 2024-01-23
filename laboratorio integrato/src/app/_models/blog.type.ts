export interface BlogType {
    logged: boolean;
    emailAuthor: string;
    title: string;
    subTitle: string;
    img: string;
    date: string;
    paragraphs: Paragraph[];
    tagPlayer: any[];
    tagTeam: TagTeam[];
}

export interface Paragraph {
    title: string;
    content: string;
}

export interface TagTeam {
    idTeam: number;
    name: string;
    nickname: string;
    code: string;
    logo: string;
}
