import React, { useState, useEffect } from 'react';
import { Link, useNavigate } from 'react-router-dom';
import tecsupLogo from "./img/tecsup.png";
import "./css/registro.css";
import axios from 'axios';

export const Registrar = () => {
  const navigate = useNavigate();

  const obtenerRegistros = () => {
    var datos = localStorage.getItem("registroslogin");
    if(datos){
      return JSON.parse(datos);
    }else{
      return [];
    }
  }

  const [registroslogin, setRegistrosLogin] = useState(obtenerRegistros());

  const [nombres, setNombres] = useState("");
  const [apellidos, setApellidos] = useState("");
  const [dni, setDni] = useState("");
  const [carrera, setCarrera] = useState("");
  const [ciclo, setCiclo] = useState("");
  const [telefono, setTelefono] = useState("");
  const [email, setCorreo] = useState("");
  const [password, setPassword] = useState("");

  const botonRegistrar = (e) => {
    e.preventDefault();
    var miObjeto = { nombres, apellidos, dni, carrera, ciclo, telefono, email, password };
    axios.post('http://localhost:8080/api/v1/usuario/save', miObjeto)
      .then(response => {
        console.log(response.data);
        setRegistrosLogin([...registroslogin, miObjeto]);
        limpiarFormulario();
        navigate('/'); // Redirige a la vista 'inicio.js' después de un registro exitoso
      })
      .catch(error => {
        console.error(error);
      });
  };

  useEffect(() => {
    localStorage.setItem("registroslogin", JSON.stringify(registroslogin))
  }, [registroslogin] );

  const limpiarFormulario = () => {
    setNombres("");
    setApellidos("");
    setDni("");
    setCarrera("");
    setCiclo("");
    setTelefono("");
    setCorreo("");
    setPassword("");
    document.getElementById("miFormulario").reset();
  }

  return (
    <div className="container col-6"> 
      <div className="formContainer">
        <img src={tecsupLogo} alt="Logo de Tecsup" className="mb-4 mt-5" />
        <h1>CitasTec</h1><br/>
        <form id="miFormulario" onSubmit={botonRegistrar}>
          <div className="row">
            <div className="col-6">
              <input className="form-control form-control-lg text-center" type="text" placeholder="Nombres" onChange={(e) => setNombres(e.target.value)} required />
            </div>
            <div className="col-6">
              <input className="form-control form-control-lg text-center" type="text" placeholder="Apellidos" onChange={(e) => setApellidos(e.target.value)} required />
            </div>
          </div>
          <div className="row">
            <div className="col-6 mt-4">
              <input className="form-control form-control-lg text-center" type="text" placeholder="DNI" onChange={(e) => setDni(e.target.value)} required />
            </div>
            <div className="col-6 mt-4">
              <select className="form-select form-select-lg text-center" onChange={(e) => setCarrera(e.target.value)} required>
                <option value="">Carrera</option>
                <option value="DiseñoD">Diseño y desarrollo de software</option>
                <option value="Maquinaria">Maquinaria Pesada</option>
                <option value="Videojuegos">Desarrollo de videojuegos</option>
              </select>
            </div>
          </div>
          <div className="row">
            <div className="col-6 mt-4">
              <select className="form-select form-select-lg text-center"  onChange={(e) => setCiclo(e.target.value)} required>
                <option value="">Ciclo</option>
                <option value="I">I</option>
                <option value="II">II</option>
                <option value="III">III</option>
                <option value="IV">IV</option>
                <option value="IV">IV</option>
                <option value="VI">VI</option>
              </select>
            </div>
            <div className="col-6 mt-4">
              <input className="form-control form-control-lg text-center" type="text" placeholder="Telefono" onChange={(e) => setTelefono(e.target.value)} required />
            </div>
          </div>
          <div className="row">
            <div className="col-6 mt-4">
              <input className="form-control form-control-lg text-center" type="email" placeholder="Correo electronico" onChange={(e) => setCorreo(e.target.value)} required />
            </div>
            <div className="col-6 mt-4">
              <input className="form-control form-control-lg text-center" type="password" placeholder="Password" onChange={(e) => setPassword(e.target.value)} required />
            </div>
          </div>
          <div className="row mb-5">
            <div  class="d-grid gap-2 col-8 mx-auto mt-5">
              <input type="submit" className="btn btn-primary btn-lg" value="Registrar" />
              <Link className="btn btn-outline-secondary btn-lg" to="/">Regresar</Link>
            </div>
          </div>
        </form>
      </div>
    </div>
  );
};
