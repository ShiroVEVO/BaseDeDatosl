$(document).ready(function () {
  function programa(data) {
    const btnEnviar = document.getElementById('btnEnviar');
    btnEnviar.addEventListener('click', (event) => {
      //event.preventDefault();
      const usuario = document.getElementById('usuario').value.trim();
      if (!validarEmail(usuario)) {
        alert("Por favor ingrese un email válido en el campo 'usuario'.");
        return;
      }
      const nombre = document.getElementById('nombre').value.trim();
      if (!nombre) {
        alert("Por favor ingrese un dato en el campo 'Nombre'");
        return; 
      }
      const apellido = document.getElementById('apellido').value.trim();
      if (!apellido) {
        alert("Por favor ingrese un dato en el campo 'Apellido'");
        return; 
      }
      const fecha_nac = document.getElementById('fecha_nac').value;
      if (!fecha_nac) {
        alert("Por favor ingrese un dato en el campo 'Fecha Nacimiento'");
        return; 
      }
      const tipo_buscado = document.getElementById('tipo_doc').value.trim();
      const n_doc = document.getElementById('n_doc').value;
      if (!n_doc) {
        alert("Por favor ingrese un dato en el campo 'Número Documento'.");
        return; 
      }else if(n_doc <= 0){
        alert("Por favor ingrese un dato válido en el campo 'Número Documento'.");
        return; 
      }
      const URL = "http://localhost:8023/candidato/" + usuario

      let tipoDoc = tiposDoc.find(tipoDoc => {
        return tipoDoc.id_tipo_doc === tipo_buscado;
      });

      let candidato = {
        usuario,
        nombre,
        apellido,
        fecha_nac,
        n_doc,
        tipoDoc
      }
      fetch(URL)
        .then(response => {
          if (!response.ok) {
            fetch('http://localhost:8023/candidato/guardar', {
              method: 'POST',
              body: JSON.stringify(candidato),
              headers: {
                'Content-Type': 'application/json'
              }
            })
              .then(response => {
                let label = document.getElementById("labelResultado");
                if (response.status === 201) {
                  label.textContent = "El candidato se guardó exitosamente";
                } else {
                  label.textContent = "revise la petición";
                }
              })
              .catch(error => console.error(error));
          }
        })
        .then(data => {
          let label = document.getElementById("labelResultado");
          label.textContent = "El candidato ya se encuentra registrado";
        })
        .catch(error => console.error(error));
    });
  }

  function validarEmail(email) {
    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    return emailRegex.test(email);
  }

  let tiposDoc = [];
  fetch('http://localhost:8023/tipoDoc')
    .then(response => response.json())
    .then(data => {
      tiposDoc = data.map(tipoDoc => {
        return {
          id_tipo_doc: tipoDoc.id_tipo_doc,
          desc_tipo_doc: tipoDoc.desc_tipo_doc
        };
      });
      console.log(tiposDoc);
    }).then(programa())
    .catch(error => console.error(error));
});