
import {User} from "./User";

//tuto +install oauth : https://www.npmjs.com/package/simple-oauth2 
//Essai pour le login abandonné
export class Login{

    private users:Array<User> = [];

    // private authurl = "http://localhost:9999/myapp/db/unsorted";


    public addUser(id:string, password:string){
        this.users.push(new User(id, password))
    }

    //public login(id:string, password:string){
    public login(){
        console.log("login function model")
        //let id = document.getElementById("inputEmail");
        //let pass = document.getElementById("inputPassword")
        
       for(let i:number = 0; i < this.users.length; ++i){
           
           /*if(this.users[i].id == id{
               if(this.users[i].checkPasswd(password)){
                   
                   (document.getElementById("debug")as HTMLElement).setAttribute("innerHTML","connexion succeeded");
                   console.log("connexion succeeded");
               }
               else{
                    (document.getElementById("debug")as HTMLElement).setAttribute("innerHTML","connexion error");
                   console.log("Connexion error id correct");
               }
           }
           else{
            (document.getElementById("debug")as HTMLElement).setAttribute("innerHTML","connexion error");
           console.log("Connexion error");
            }*/
       } 
    }


}