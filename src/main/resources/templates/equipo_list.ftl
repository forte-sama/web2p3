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
            <#if equipos?size=0>
                <h1>No hay equipos...</h1>
                <p><a href="/equipos/crear/" class="btn btn-large blue darken-4">crear uno</a></p>
            <#else>
                <br>
                <a class='dropdown-button btn' href='#' data-activates='dropdown1'>nuevo</a>
                <ul id='dropdown1' class='dropdown-content'>
                    <li><a href="/equipos/crear/">equipo</a></li>
                    <li><a href="/equipos/crear_grupo/">grupo</a></li>
                    <li><a href="/equipos/crear_subgrupo/">sub-grupo</a></li>
                </ul>
                <br>
                <ul class="collection">
                    <#list equipos as equipo>
                        <li class="collection-item avatar">
                            <#if equipo.foto??>
                                <img src="data:image/png;base64,${equipo.foto}" alt="" class="circle">
                            <#else>
                                <i class="material-icons circle blue-grey">shopping_basket</i>
                            </#if>
                            <span class="title">${equipo.nombre}</span>
                            <p>
                                Existencia: ${equipo.cantidad}
                            </p>
                            <span class="secondary-content">
                                <a href="/equipos/editar/${equipo.id}" class="btn-flat waves-effect waves-teal">Editar</a>
                                <a href="/equipos/borrar/${equipo.id}" class="btn-flat waves-effect waves-teal">Borrar</a>
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