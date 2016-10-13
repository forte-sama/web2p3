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
            <form enctype="multipart/form-data" action="/usuarios/processForm/" method="post">
                <div class="row">
                    <div class="input-field col s12">
                        <i class="material-icons prefix">contacts</i>
                        <input id="username" type="text" name="username"  <#if u??>value="${u.username}" readonly</#if>>
                        <label for="username">Username</label>
                    </div>
                </div>
                <div class="row">
                    <div class="input-field col s12">
                        <i class="material-icons prefix">contacts</i>
                        <input id="password" type="password" name="password" required>
                        <label for="password">Password</label>
                    </div>
                </div>
                <div class="row">
                    <div class="input-field col s12">
                        <i class="material-icons prefix">person_pin</i>
                        <input id="nombre" type="text" name="nombre" <#if u??>value="${u.nombre}"</#if> required>
                        <label for="nombre">Nombre</label>
                    </div>
                </div>
                <div class="row">
                    <div class="input-field col s12">
                        <i class="material-icons prefix">person_pin</i>
                        <input id="apellido" type="text" name="apellido" <#if u??>value="${u.apellido}"</#if> required>
                        <label for="apellido">Apellido</label>
                    </div>
                </div>
                <div class="row">
                    <div class="input-field col s12">
                        <i class="material-icons prefix">lock_outline</i>
                        <select id="permiso" name="permiso">
                            <option value="" disabled selected>Elige nivel</option>
                        <#list permisos as perm>
                            <option value="${perm}">${perm}</option>
                        </#list>
                        </select>
                        <label for="permiso">Nive de autorizacion</label>
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