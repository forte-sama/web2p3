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
    <h2 class="center-align">Login</h2>
    <div class="row">
        <form class="col s6 offset-s3" role="form" action="/login" method="post">
            <div class="row">
                <div class="input-field col s12">
                    <input id="nombre" type="text" name="username" class="validate">
                    <label for="nombre">Nombre</label>
                </div>
            </div>
            <div class="row">
                <div class="input-field col s12">
                    <input id="pass" type="password" name="password" class="validate">
                    <label for="pass">Password</label>
                </div>
            </div>
            <div class="divider"></div>
            <div class="row">
                <div class="col m12">
                    <p class="right-align">
                        <button class="btn btn-large waves-effect waves-light" type="submit" name="submit">Login</button>
                    </p>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>