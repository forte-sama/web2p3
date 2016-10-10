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
<div class="container">
    <div class="row">
        <div class="col s6 offset-s3">
            <#if clientes?size=0>
                <h1>No hay clientes...</h1>
                <p><a href="/clientes/crear/" class="btn btn-large blue darken-4">crear uno</a></p>
            <#else>
                <a href="/clientes/crear/" class="btn btn-large green darken-4">crear nuevo cliente</a>
                <br>
                <ul class="collection">
                    <#list clientes as client>
                        <li class="collection-item avatar">
                            <#if client.foto??>
                                <img src="data:image/png;base64,${client.foto}" alt="" class="circle">
                            <#else>
                                <i class="material-icons circle blue-grey">assignment_ind</i>
                            </#if>
                            <span class="title">${client.cedula}</span>
                            <p>
                                Nombre: ${client.nombre}
                                <br>
                                Apellido: ${client.apellido}
                                <br>
                                Direccion: ${client.direccion}
                            </p>
                            <span class="secondary-content">
                                <a href="/clientes/editar/${client.id}" class="btn-flat waves-effect waves-teal">Editar</a>
                                <a href="/clientes/borrar/${client.id}" class="btn-flat waves-effect waves-teal">Borrar</a>
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