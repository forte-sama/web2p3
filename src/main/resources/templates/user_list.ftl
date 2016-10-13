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
            <h1>${titulo}</h1>
            <br>
            <a href="/usuarios/crear/" class="btn btn-large green darken-4">crear nuevo usuario</a>
            <br>
            <#if mensaje??>
                <br>
                <span class="chip green white-text"><b>${mensaje}</b></span>
            </#if>
            <ul class="collection">
                <#list usuarios as u>
                    <li class="collection-item avatar">
                        <span class="title">Username: <b>${u.username}</b></span>
                        <p>
                            <b>Nombre:</b> ${u.nombre}
                            <br>
                            <b>Apellido:</b> ${u.apellido}
                        </p>
                        <p>
                            <a href="/usuarios/editar/${u.username}" class="btn-flat waves-effect waves-teal">Editar</a>
                            <a href="/usuarios/borrar/${u.username}" class="btn-flat waves-effect waves-teal">Borrar</a>
                        </p>
                    </li>
                </#list>
            </ul>
        </div>
    </div>
</div>
</body>
</html>