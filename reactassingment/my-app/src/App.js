import {BrowserRouter as Router ,Switch,Route} from 'react-router-dom'
import React from 'react';
import './App.css'
import Nav from './components/Nav';
import Home from './components/Home';
import Disp from './components/disp';

function App() {
  return (
    <Router>    
      <div className="App">
      <Nav/>
      <Switch>
      <Route path="/" exact component={this}/> 
      <Route path="/home" exact component={Home}/>
      <Route path="/home/:id"  component={Disp}/>
      </Switch>
      
      
      
    </div>
    </Router>

  );
}


export default App;
