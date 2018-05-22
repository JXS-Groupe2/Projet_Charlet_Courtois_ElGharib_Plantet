import * as React from 'react';
import * as ReactDOM from 'react-dom';
import '../node_modules/bootstrap/dist/css/bootstrap.min.css';
import App from './App';
//import {Loginview} from './Login';
import './index.css';
import registerServiceWorker from './registerServiceWorker';
// import {Main} from "./Controller";


ReactDOM.render(
  <App />,
  document.getElementById('root') as HTMLElement
);
registerServiceWorker();
// new Main();
