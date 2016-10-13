<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0"/>

    <!-- CSS  -->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link href="/webjars/materializecss/0.97.7/css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection"/>
    <link href="/css/custom.css" rel="stylesheet" >

    <!-- JS Scripts -->
    <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
    <script src="/webjars/materializecss/0.97.7/js/materialize.js"></script>
    <script src="/js/custom.js"></script>

    <title>web2p3</title>
</head>
<body>
<#include "nav.ftl">
<div class="container">
    <div class="row">
        <div class="col s8 offset-s2">
            <h1>Devolucion de Equipo</h1>
            <#if !a??>
                <h4>No se ha indicado ningun equipo a devolver...</h4>
                <a href="/" class="btn btn-large waves-effect waves-teal orange darken-3">Volver a inicio</a>
            <#else>
                <a href="/alquiler/pendientes" class="btn waves-effect waves-teal yellow darken-4">Volver a lista de pendientes</a>
                <h3>El cliente ${a.cliente.nombre} ${a.cliente.apellido}, debe pagar un monto de  RD$ ${a.getMontoHastaLaFecha()?string["0.##"]}</h3>
                <form role="form" action="/alquiler/devolucion" method="post">
                    <input name="id" type="hidden" value="${a.id}">
                    <input name="cliente" type="hidden" value="${a.cliente.id}">
                    <input name="fechaEntrega" type="hidden" value="${a.fechaEntrega}">
                    <input name="fechaRealizacion" type="hidden" value="${a.fechaRealizacion}">
                    <input name="equipo" type="hidden" value="${a.equipo.id}">
                    <button type="submit" name="submit" class="btn btn-large waves-effect waves-teal red darken-4">Procesar devolucion</button>
                </form>
            </#if>
        </div>
    </div>
</div>
</body>
</html>