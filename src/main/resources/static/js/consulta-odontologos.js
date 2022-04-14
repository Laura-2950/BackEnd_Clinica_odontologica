import React from "react";
import { useEffect, useState } from "react";

function OdontologoList() {
  const [arrayOdonto, setArrayOdonto] =useState([]);

  useEffect(() => {
    let url = "http://192.168.56.1:8080/odontologos";
    const getData = async (url) => {
      try {
        let res = await fetch(url);
        let data = await res.json();
        setArrayOdonto(data);
    } catch (err) {
      setArrayOdonto(null);
      }
    };
    getData(url);
  }, []);


  
  return (
    <div>
      <h1>Listado de Odontólogos</h1>
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
            <th scope="col">Matrícula</th>
            <th scope="col">Acciones</th>
          </tr>
        </thead>
        <tbody>
          {arrayOdonto.map((odontologo, i) => (
                <tr key={i}>
                  <th scope="row">{odontologo.id}</th>
                  <td>{odontologo.nombre}</td>
                  <td>{odontologo.apellido}</td>
                  <td>{odontologo.matricula}</td>
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

export default OdontologoList;
