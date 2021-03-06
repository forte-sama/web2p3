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
            <h1>Alquilar equipo</h1>
            <#if errorfecha?? || errorcliente?? || errorcantidad??>
                <#if errorfecha??><h5 class="red-text">Hubo un error: ${errorfecha}</h5></#if>
                <#if errorcliente??><h5 class="red-text">Hubo un error: ${errorcliente}</h5></#if>
                <#if errorcantidad??>
                    <h5 class="red-text">Hubo un error con los equipos:</h5>
                    <#list errorcantidad as mensaje>
                        <h6 class="red-text">${mensaje}</h6>
                    </#list>
                </#if>
            </#if>
            <form action="/alquiler/processAlquiler" method="post">
                <div class="row">
                    <div class="col s12">
                        <div class="row">
                            <div class="input-field col s12">
                                <i class="material-icons prefix">contacts</i>
                                <input type="text" id="cliente" name="cliente">
                                <label for="cliente">Cliente</label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="input-field col s12">
                                <i class="material-icons prefix">schedule</i>
                                <input type="text" id="fechaEntrega" name="fechaEntrega" class="datepicker">
                                <label for="fechaEntrega">Fecha de Entrega</label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="input-field col s12">
                                <i class="material-icons prefix">shopping_cart</i>
                                <select id="equipo" name="equipos" class="icons" multiple>
                                    <option value="" disabled selected>Elige Equipo</option>
                                    <#list equipos as equipo>
                                        <#if equipo.foto??>
                                            <option value="${equipo.id}"
                                                    data-icon="data:image/png;base64,${equipo.foto}"
                                                    precio="${equipo.precio}"
                                                    class="left circle item_equipo">
                                                ${equipo.nombre + " RD$" + equipo.precio}
                                            </option>
                                        <#else>
                                            <option value="${equipo.id}" precio="${equipo.precio}">
                                                <i class="material-icons blue-grey left circle item_equipo">shopping_basket</i>
                                                ${equipo.nombre + " RD$" + equipo.precio}
                                            </option>
                                        </#if>
                                    </#list>
                                </select>
                                <label for="equipo">Equipo</label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col s12">
                                <p class="right-align">
                                    <button class="btn btn-large waves-effect waves-light" type="submit" name="submit">Submit</button>
                                </p>
                            </div>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<script>
    $(document).ready(function() {
        $('.datepicker').pickadate({
            selectMonths: true, // Creates a dropdown to control month
            selectYears: 15 // Creates a dropdown of 15 years to control year
        });
    });
</script>
</body>
</html>