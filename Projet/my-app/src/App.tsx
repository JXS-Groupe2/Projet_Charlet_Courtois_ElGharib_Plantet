import * as React from 'react';
import './App.css';
// import {Loginview} from "./Login";
import {Files} from "./Files";
/*declare module "Result.json"{
  const value: any;
  export default value;
}*/

// import logo from './logo.svg';

class App extends React.Component {
  

  public render() {
    /*
    function loadHTML()
    {
      let xhr = new XMLHttpRequest()
      xhr.onreadystatechange=function()
      { 
        if(xhr.readyState == 4)
        {
          if(xhr.status == 200)
          {
            console.log("Test : " + xhr.responseText);
          }
        } 
      }; 
      
      xhr.open("GET", "http://www.google.com" , true);
      xhr.send(null); 
    }

    loadHTML()
    */


    //const files = ["docA","docB","DocC"];
    let json = require('./Result.json');
    let filesArray:Files = new Files();
    //let folderArray:Folder = new Folder(new Files());
    //filesArray.list=[];
    for(var file in json.items){
      console.log(json.items[file].name);

        filesArray.addfile(json.items[file].title, json.items[file].fileSize, "Google Drive", json.items[file].webContentLink)


    }
    console.log(filesArray.list[1].getName());

    //let truc = JSON.parse(json);
   // console.log(truc.Name);
   


   
    //console.log(json.name);


    
    const filesButtons = filesArray.list.map((filename) => {
      
      return (
        <li>
          <button>{filename.getName()+ " " + (filename.getTaille()==undefined?0:filename.getTaille()) + " Octets"}</button>
        </li>
      );
    });
    return(
      <div className="App">
        <div className="game-info">
          <ol>{filesButtons}</ol>

        </div>
      </div>
    );

    
    
  }
}

export default App;
