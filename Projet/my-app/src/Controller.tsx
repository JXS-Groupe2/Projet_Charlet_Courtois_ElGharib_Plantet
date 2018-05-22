/*
import {Login} from "./Model";
export class Main{
    
    protected log:Login = new Login()

    protected btn = document.getElementById("loginButton");
    
    constructor(){
        
        console.log("constructeur login");
        
        (document.getElementById("debug") as HTMLElement).setAttribute("innerHTML","je fais des trucs");
        if(this.btn != null){
            this.btn.addEventListener("click", (e:Event) => this.login());
        }else{
            console.log("pas d'event listener !")
        }

        this.log.addUser("Jules","pass123")
        this.log.addUser("Loic", "azerty")
    }
    
    public login(){
        console.log("login function")

        const login = (document.getElementById("inputEmail") as HTMLInputElement).value;
        const pass = (document.getElementById("inputPassword") as HTMLInputElement).value;

        this.log.login(login, pass);
        
    }
}
*/
