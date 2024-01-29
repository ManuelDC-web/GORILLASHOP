function fClick() {
    alert("¡Bienvenido a Gorilla Shop!");
    window.location.href = 'pantalla2.html';
}

function fInicio() {
    fCargarTemas();
}

function fCargarTemas() {
    let URL = "assets/php/servidor.php?peticion=fCargarTemas";
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
    window.location.href = 'pantalla2.html';

    var nombre = document.getElementById("agregarTema_nombre").value;
    var marca = document.getElementById("agregarTema_marca").value;
    var stock = document.getElementById("agregarTema_stock").value;
    var precio = document.getElementById("agregarTema_precio").value;
    var fecha_de_alta = document.getElementById("agregarTema_fecha_de_alta").value;
    var id_familia = document.getElementById("agregarTema_id_familia").value;

    const URL = `assets/php/servidor.php?peticion=AgregarTema&nombre=${nombre}&marca=${marca}
    &stock=${stock}&precio=${precio}&fecha_de_alta=${fecha_de_alta}&id_familia=${id_familia}` ;
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

