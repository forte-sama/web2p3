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
        <div class="col s6 offset-s3">
            <#if alquileres?size=0>
                <h1>No hay equipos pendientes...</h1>
            <#else>
                <ul class="collection">
                    <#list alquileres as a>
                        <li class="collection-item avatar">
                            <#if a.equipo.foto??>
                                <img src="data:image/png;base64,${a.equipo.foto}" alt="" class="circle">
                            <#else>
                                <i class="material-icons circle blue-grey">shopping_basket</i>
                            </#if>
                            <span class="title"><b>${a.equipo.nombre}</b></span>
                            <p>
                                <b>Fecha Alquiler:</b> ${a.fechaRealizacion}
                                <br>
                                <b>Fecha Entrega:</b> ${a.fechaEntrega}
                                <br>
                                <b>Monto a pagar:</b> RD$ ${a.getMontoHastaLaFecha()?string["0.##"]}
                            </p>
                            <span class="secondary-content">
                                <a href="/alquiler/devolverform/${a.id}" class="btn-flat waves-effect waves-teal">Devolver</a>
                            </span>
                        </li>
                    </#list>
                </ul>
            </#if>
        </div>
    </div>
</div>
</body>
</html>