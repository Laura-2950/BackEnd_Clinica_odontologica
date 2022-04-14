import React from "react";
import { useEffect, useState } from "react";

function PacientesList() {
  const [arrayPacientes, setArrayPacientes] =useState([]);

  useEffect(() => {
    let url = "http://192.168.56.1:8080/pacientes";
    const getData = async (url) => {
      try {
        let res = await fetch(url);
        let data = await res.json();
        setArrayPacientes(data);
    } catch (err) {
      setArrayPacientes(null);
      }
    };
    getData(url);
  }, []);


  
  return (
    <div>
      <h1>Listado de Pacientes</h1>
      <form className="d-flex p-5 container-md">
            <input
                className="form-control me-2"
                type="search"
                placeholder="Buscar por id"
                aria-label="Search"
            />
            <button className="btn btn-outline-success" type="submit">
                Buscar
            </button>
        </form>
      <table className="table table-striped table-hover">
        <thead className="table-dark">
          <tr>
            <th scope="col">#Id</th>
            <th scope="col">Nombre</th>
            <th scope="col">Apellido</th>
            <th scope="col">DNI</th>
            <th scope="col">Fecha de Ingreso</th>
            <th scope="col">Domicilio</th>
            <th scope="col">Acciones</th>
          </tr>
        </thead>
        <tbody>
          {arrayPacientes.map((paciente, i) => (
                <tr key={i}>
                  <th scope="row">{paciente.id}</th>
                  <td>{paciente.nombre}</td>
                  <td>{paciente.apellido}</td>
                  <td>{paciente.dni}</td>
                  <td>{paciente.fechaIngreso}</td>
                  <td>{paciente.domicilio.calle} N° {paciente.domicilio.numero} - {paciente.domicilio.localidad}, {paciente.domicilio.provincia}</td>
                  <td>
                    <button className="btn btn-sm btn-outline-warning" type="button">Modificar</button>
                    <button className="btn btn-sm btn-outline-danger m-2" type="button">Eliminar</button>
                  </td>
                </tr>
              ))
          }
        </tbody>
      </table>
    </div>
  );
}

export default PacientesList;