export class User{

    public id:string;
    private password:string;

    // private google:[String,String]

    // private dropbox:[String,String]

    // private oneDrive:[String,String]

    constructor(id:string, password:string){
        this.id = id;
        this.password = password;
    }


    public checkPasswd(pass:string):boolean {
        return (pass === this.password);
    }

}