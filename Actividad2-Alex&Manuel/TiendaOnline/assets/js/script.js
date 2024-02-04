function fClick() {
    alert("¡Bienvenido a Gorilla Shop!");
    window.location.href = 'index.html';
}

let urlFetchAll = "http://localhost:8085/apirest/familias/todas";

let divFamilia = document.getElementById("productos");

function cargarProductosPorFamilia(idFamilia) {
    // Realizar redirección a la nueva página pasando el ID de la familia
    window.location.href = `productos.html?idFamilia=${idFamilia}`;
}

fetch(urlFetchAll)
    .then((res) => res.json())
    .then((familias) => {
        familias.forEach((familia) => {
            let divProducto = document.createElement("div");
            divProducto.classList.add("divProductos");
            let pID = document.createElement("p");
            let pDescripcion = document.createElement("p");

            divProducto.addEventListener("click", () => {
                cargarProductosPorFamilia(familia.idFamilia);
            });

            pID.innerHTML = `${familia.idFamilia}`;
            pDescripcion.innerHTML = familia.descripcion;


            divProducto.appendChild(pDescripcion);
            divProducto.style.border = "solid black 2px";

            divFamilia.appendChild(divProducto);
        });
    });

const urlParams = new URLSearchParams(window.location.search);
const idFamilia = urlParams.get("idFamilia");

if (idFamilia) {
    let urlProductosPorFamilia = `http://localhost:8085/apirest/productos/pofamilia/${idFamilia}`;
    let divProductos = document.getElementById("productosPorFamilia");

    fetch(urlProductosPorFamilia)
        .then((res) => res.json())
        .then((productos) => {
            productos.forEach((producto) => {
                let divProducto = document.createElement("div");
                let pDescripcion = document.createElement("p");
                let pMarca = document.createElement("p");
                let pPrecioUnitario = document.createElement("p");

                pDescripcion.innerHTML = `${producto.descripcion}`;
                pMarca.innerHTML = `Marca: ${producto.marca}`;
                pPrecioUnitario.innerHTML = `Precio: ${producto.precioUnitario}€`;

                divProducto.appendChild(pDescripcion);
                divProducto.appendChild(pMarca);
                divProducto.appendChild(pPrecioUnitario);
                divProducto.style.border = "solid black 2px";

                divProductos.appendChild(divProducto);
            });
        })
        .catch((error) => {
            console.error(
                "Hubo un error al obtener los productos por familia:",
                error
            );
        });
} else {
    console.error("No se proporcionó un ID de familia en la URL.");
}

function cerrar() {
    document.getElementById('cerrar').addEventListener('click', function () {
        window.location.href = 'index.html';
    })
}