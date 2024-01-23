export interface AllBlogsType {
    logged: boolean;
    blogsAboutYourInterests: Blog[];
    blogs: Blog[];
}

export interface Blog {
    idBlog: number;
    title: string;
    subtitle: string;
    img: string;
    date: Date;
    tagPlayer: TagPlayer[];
    tagTeam: TagTeam[];
}

export interface TagPlayer {
    idPlayer: number;
    firstname: string;
    lastname: string;
}

export interface TagTeam {
    idTeam: number;
    name: string;
    nickname: string;
    code: string;
    logo: string;
}
