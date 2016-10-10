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
            <#if subgrupos?size=0>
                <h1>No hay subgrupos...</h1>
                <p><a href="/equipos/crear_subgrupo/" class="btn btn-large blue darken-4">crear uno</a></p>
            <#else>
                <h1>Formulario Equipo</h1>
                <form enctype="multipart/form-data" action="/equipos/processEquipo/" method="post">
                    <#if equipo??>
                        <input type="hidden" name="id" value="${equipo.id}" readonly>
                    </#if>
                    <div class="row">
                        <div class="input-field col s12">
                            <input id="nombre" type="text" name="nombre" <#if equipo??>value="${equipo.nombre}"</#if>>
                            <label for="nombre">Nombre</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="input-field col s12">
                            <input id="cantidad" type="text" name="cantidad" <#if equipo??>value="${equipo.cantidad}"</#if>>
                            <label for="cantidad">Cantidad</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="input-field col s12">
                            <select id="subgrupo" name="subGrupo">
                                <option value="" disabled selected>Elige Sub Familia</option>
                                <#list subgrupos as sgrupo>
                                    <option value="${sgrupo.id}">${sgrupo.nombre}</option>
                                </#list>
                            </select>
                            <label for="subgrupo">Sub Familia</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="file-field input-field">
                            <div class="btn">
                                <span>Foto</span>
                                <input name="fotox" type="file">
                            </div>
                            <div class="file-path-wrapper">
                                <input class="file-path validate" type="text">
                            </div>
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