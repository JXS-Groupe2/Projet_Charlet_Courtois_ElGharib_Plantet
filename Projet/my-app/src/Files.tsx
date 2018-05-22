//classe File
export class File{
    private name:string;
    private tailleoctet:number;
    private source:string;
    private URI:string;

    constructor(name:string, taille:number, src:string, addr:string){
        this.name = name;
        this.tailleoctet = taille;
        this.source = src;
        this.URI = addr;
    }

    public getName(){
        return this.name;
    }

    public getTaille(){
        return this.tailleoctet;
    }

    public getSource(){
        return this.source;
    }

    public getURI(){
        return this.URI;
    }
}

//Classe contanant tous kes files
export class Files{
    list:Array<File> = [];

    public addfile(name:string, taille:number, src:string, addr:string){
        this.list.push(new File(name, taille, src, addr));
    }
}

/*
export class Folder{
    private files:Files;

    constructor(listfiles:Files){
        this.files = listfiles;
    }
    
    public addfile(name:string, taille:number, src:string, addr:string){
        this.files.addfile(name, taille, src, addr)
    }

}
*/