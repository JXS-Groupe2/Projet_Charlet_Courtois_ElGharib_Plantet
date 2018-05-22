export class User{

    id:String;
    password:String;

    google:[String,String]

    dropbox:[String,String]

    oneDrive:[String,String]

    constructor(id:String, password:String){
        this.id = id;
        this.password = password;
    }


    checkPasswd(pass:String):boolean {
        return (pass == this.password);
    }

}


export class Login{

    users:User[];

 
    
    

    constructor(){        
    }

    addUser(id:String, password:String){
        this.users.push(new User(id, password))
    }

    login(id:String, password:String){
        let i:number = 0
       for(; i < this.users.length;){
           ++i
           if(this.users[i].id == id){
               if(this.users[i].checkPasswd(password)){
                   console.log("connexion succeeded");
               }
               else{
                   console.log("Connexion error");
               }
           }
       } 
    }


}