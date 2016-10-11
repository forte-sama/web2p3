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
            <h1>Formulario Cliente</h1>
            <form enctype="multipart/form-data" action="/clientes/processForm/" method="post">
                <#if cliente??>
                    <input type="hidden" name="id" value="${cliente.id}" readonly>
                </#if>
                <div class="row">
                    <div class="input-field col s12">
                        <i class="material-icons prefix">contacts</i>
                        <input id="cedula" type="text" name="cedula" <#if cliente??>value="${cliente.cedula}" readonly</#if>>
                        <label>Cedula</label>
                    </div>
                </div>
                <div class="row">
                    <div class="input-field col s12">
                        <i class="material-icons prefix">person_pin</i>
                        <input id="nombre" type="text" name="nombre" <#if cliente??>value="${cliente.nombre}"</#if>>
                        <label for="nombre">Nombre</label>
                    </div>
                </div>
                <div class="row">
                    <div class="input-field col s12">
                        <i class="material-icons prefix">person_pin</i>
                        <input id="apellido" type="text" name="apellido" <#if cliente??>value="${cliente.apellido}"</#if>>
                        <label for="apellido">Apellido</label>
                    </div>
                </div>
                <div class="row">
                    <div class="input-field col s12">
                        <i class="material-icons prefix">location_on</i>
                        <input id="direccion" type="text" name="direccion" <#if cliente??>value="${cliente.direccion}"</#if>>
                        <label for="direccion">Direccion</label>
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
        </div>
    </div>
</div>
</body>
</html>