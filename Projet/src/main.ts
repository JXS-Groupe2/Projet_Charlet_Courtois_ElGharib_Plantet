import {User,Login} from "./Login";
console.log("fichier main")



export class main{
    
    log:Login = new Login()
    btn = document.getElementById("loginButton");
    
    
    constructor(){
        console.log("constructeur login")
        this.btn.addEventListener("click", (e:Event) => this.login());
        
        this.log.addUser("Jules","pass123")
        this.log.addUser("Loic", "azerty")
    }
    
    login(){
        console.log("login function")
        var id = (<HTMLInputElement>document.getElementById("inputEmail")).value
        var pass = (<HTMLInputElement>document.getElementById("inputPassword")).value
        this.log.login(id, pass)
    }
}

new main();