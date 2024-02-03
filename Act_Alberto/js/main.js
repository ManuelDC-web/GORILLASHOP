function cargarDatos() {
    const URL = 'php/servidor.php?peticion=lista_temas';
    fetch(URL)
    .then((response) => response.json())
    .then((data) => {
        console.log(data);
        let html = "<ul class='temas-lista'>";
        data.forEach(item => {
            html += `<div>${item.descripcion}</div>`;
            html += `<div>${item.marca}</div>`;
        });
        html += "</ul>";
        document.querySelector("section").innerHTML = html;
    })
    .catch((error) => {
        console.error('Error en la solicitud fetch:', error);
    });
}