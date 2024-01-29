function fClick() {
    alert("¡Bienvenido a Gorilla Shop!");
    window.location.href = 'index.html';
}

let urlFetchAll = "http://localhost:8085/apirest/familias/";
let urlPost = "http://localhost:8085/apirest/familias/"

function fInicio() {
    fCargarTemas();
}

function fCargarTemas() {
    
    fetch(URL)
        .then((response) => response.json())
        .then((data) => {
            console.log(data);
            productos.forEach(producto => {
                html += `<div>
                            <img src="${producto.imagen}" alt="${producto.nombre}">
                            <div class="informacion">
                                <p>${producto.nombre}</p>
                            </div>
                        </div>`;
            });
            document.getElementById("section").innerHTML = html;
        });
}

function AgregarTema() {
    window.location.href = 'index.html';

    var nombre = document.getElementById("agregarTema_nombre").value;
    var marca = document.getElementById("agregarTema_marca").value;
    var stock = document.getElementById("agregarTema_stock").value;
    var precio = document.getElementById("agregarTema_precio").value;
    var fecha_de_alta = document.getElementById("agregarTema_fecha_de_alta").value;
    var id_familia = document.getElementById("agregarTema_id_familia").value;

    fetch(URL)
    .then((response) => response.json())
    .then((data) => {
        if (data.length == 0){ 
            alert("No se puedo registrar el producto");
        }else {
            window.location.href = 'pantalla3.html';
            alert("Producto registrado");
        }
        
    })
    .catch(() => {
        alert("Producto registrado");
        window.location.href = 'pantalla3.html';
    });
}

