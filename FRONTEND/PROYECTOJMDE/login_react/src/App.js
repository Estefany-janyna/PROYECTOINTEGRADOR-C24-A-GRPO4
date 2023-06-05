import logo from './logo.svg';
import './App.css';
import {BrowserRouter, Routes, Route} from "react-router-dom"
import {Login} from './components/Login'
import {Inicio} from './components/Inicio'
import { Registrar } from './components/Registrar'

function App() {
  return (
    <div className="App">

      <BrowserRouter>
      <Routes>
        <Route exact path="/" element={<Login/>}/>
        <Route exact path="/Inicio" element={<Inicio/>}/>
        <Route exact path="/Registrar" element={<Registrar/>}/>
      </Routes>
      </BrowserRouter> 
    </div>
  );
}

export default App;
