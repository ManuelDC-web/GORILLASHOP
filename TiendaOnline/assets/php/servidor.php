<?php
require_once("BBDD_CTRLR.php");

if (isset($_REQUEST['peticion'])) {
    switch ($_REQUEST['peticion']) {
        case 'fCargarTemas':
            // Verificar si se proporcionó un término de búsqueda
            $where = "";
            if (isset($_REQUEST['termino'])) {
                $termino = $_REQUEST['termino'];
                $where = " WHERE tema_tema LIKE '%$termino%'";
            }

            $sql = "SELECT * FROM temas $where ORDER BY tema_tema";
            $datos = BBDD_CTRLR::Consultas($sql);
            echo json_encode($datos);
            break;
        case "AgregarTema":
            $tema = $_REQUEST["tema"];
            $sql = "INSERT INTO temas VALUES (null,'$tema')";
            $datos = BBDD_CTRLR::Consultas($sql);
            echo json_encode($datos);
            break;
    }   
}      
?>
