<?php
require_once("BBDD_CTRLR.php");

if (isset($_REQUEST['peticion'])) {
    switch ($_REQUEST['peticion']) {
        case "cargar_temas":
            $sql = "SELECT * FROM productos ORDER BY id_producto";
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
