import * as React from 'react';
import {Login} from './Model';


export class Loginview extends React.Component{
    public render() {
      let log:Login = new Login();
      log.addUser('Jules','Charlet');

      let btn = document.getElementById("loginButton");
      if(btn != null){
        btn.addEventListener("click", (e:Event) => log.login());

      }
      

        return (
          <div className="AppLogin">
    
            <label ><b>Username</b></label>
            <input type="text" placeholder="Enter Username" name="uname" id="inputEmail"/>
    
            <label ><b>Password</b></label>
            <input type="password" placeholder="Enter Password" name="psw" id="inputPassword"/>
            
            <button type="submit" id="loginButton" >Login</button>

            
          </div>
        );
      }

}
// export default App;