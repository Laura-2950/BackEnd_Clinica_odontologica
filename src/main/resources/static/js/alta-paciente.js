import React from "react";
import { useEffect, useState } from "react";


function PacienteAlta() {
    const [nombre , setNombre] = useState([]);
  
    useEffect(() => {
      let url = "http://192.168.56.1:8080/pacientes";
      const getData = async (url) => {
        try {
          let res = await fetch(url);
          let data = await res.json();
          
        } catch (err) {
          
        }
      };
      //getData(url);
    }, []);
  
    function validacion() {
      //'use strict'
    
      // Fetch all the forms we want to apply custom Bootstrap validation styles to
      var forms = document.querySelectorAll('.needs-validation')
    
      // Loop over them and prevent submission
      Array.prototype.slice.call(forms)
        .forEach(function (form) {
          form.addEventListener('submit', function (event) {
            if (!form.checkValidity()) {
              event.preventDefault()
              event.stopPropagation()
            }
    
            form.classList.add('was-validated')
          }, false)
        })
    }
  
    return (
      <div>
        <h1>Alta Paciente</h1>
        <p>Complete los siguientes campos del formulario para dar de alta a nuevo paciente.</p>
        <form className="row justify-content-center g-5 m-5">
    <div className="col-md-5 m-2">
      <label htmlFor="validationDefault01" className="form-label">Nombre</label>
      <input type="text" className="form-control" id="#validationDefault01" name="nombre" placeholder="Juan" required/>
    </div>
    <div className="col-md-5 m-2">
      <label htmlFor="validationDefault02" className="form-label">Apellido</label>
      <input type="text" className="form-control" id="#validationDefault02" name="apellido" placeholder="Perez" required/>
    </div>
    <div className="col-md-3 m-2">
      <label htmlFor="validationDefault03" className="form-label">D.N.I. N°</label>
      <input type="text" className="form-control" id="#validationDefault03" name="dni" placeholder="34.222.689" required/>
    </div>
    <div className="col-md-3 m-2">
      <label htmlFor="validationDefault04" className="form-label">Fecha de Ingreso</label>
      <input type="text" className="form-control" id="#validationDefault04" name="fecha-ingreso" placeholder="2022-04-02" required/>
    </div>
    <div className="col-md-5 m-2">
      <label htmlFor="validationDefault05" className="form-label">Domicilio - Calle</label>
      <input type="text" className="form-control" id="#validationDefault05" name="calle" placeholder="San Martín" required/>
    </div>
    <div className="col-md-3 m-2">
      <label htmlFor="validationDefault06" className="form-label">Calle Número</label>
      <input type="text" className="form-control" id="#validationDefault06" name="numero" placeholder="202" required/>
    </div>
    <div className="col-md-3 m-2">
      <label htmlFor="validationDefault07" className="form-label">Localidad</label>
      <input type="text" className="form-control" id="#validationDefault07" name="localidad" placeholder="Santa Rosa" required/>
    </div>
    <div className="col-md-3 m-2">
      <label htmlFor="validationDefault08" className="form-label">Provincia</label>
      <input type="text" className="form-control" id="#validationDefault08" name="provincia" placeholder="La Pampa" required/>
    </div>
    <div className="col-12 m-2">
      <button className="btn btn-outline-primary m-5" type="submit">Registrar</button>
    </div>
  </form>
      </div>
    );
  }
  
  export default PacienteAlta;
  