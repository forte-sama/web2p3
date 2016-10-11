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
            <#if grupos?size=0>
                <h1>No hay familias...</h1>
                <p><a href="/equipos/crear_grupo/" class="btn btn-large blue darken-4">crear una</a></p>
            <#else>
                <h1>Formulario Sub-Grupo</h1>
            <form action="/equipos/processSubGrupo/" method="post">
                <div class="row">
                    <div class="input-field col s12">
                        <i class="material-icons prefix">receipt</i>
                        <input id="nombre" type="text" name="nombre">
                        <label for="nombre">Nombre</label>
                    </div>
                </div>
                <div class="row">
                    <div class="input-field col s12">
                        <i class="material-icons prefix">supervisor_account</i>
                        <select id="familia" name="padre">
                            <option value="" disabled selected>Elige Familia</option>
                            <#list grupos as grupo>
                                <option value="${grupo.id}">${grupo.nombre}</option>
                            </#list>
                        </select>
                        <label for="familia">Familia</label>
                    </div>
                </div>
                <div class="row">
                    <div class="col s12">
                        <p class="right-align">
                            <button class="btn btn-large waves-effect waves-light" type="submit" name="submit">Submit</button>
                        </p>
                    </div>
                </div>
            </form>
            </#if>
        </div>
    </div>
</div>
</body>
</html>