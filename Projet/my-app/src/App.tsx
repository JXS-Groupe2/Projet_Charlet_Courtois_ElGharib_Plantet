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



    //const files = ["docA","docB","DocC"];
    //On récupère les inforlations du drive
    let json = require('./Result.json');

    //tableau contenant les fichiers
    let filesArray:Files = new Files();

    //Essai utilisation des dossiers
    //let folderArray:Folder = new Folder(new Files());
    //filesArray.list=[];

    //On boucle sur les fichiers dans "items[]" pour y récupérer les informations de base
    for(var file in json.items){
      console.log(json.items[file].name);

        filesArray.addfile(json.items[file].title, json.items[file].fileSize, "Google Drive", json.items[file].webContentLink)


    }
    console.log(filesArray.list[1].getName());

    //let truc = JSON.parse(json);
   // console.log(truc.Name);
   


   
    //console.log(json.name);


    //Affichage des boutons avec les inforlations récuoérées sur le json
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
