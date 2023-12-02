$(document).on("click","#btnregistrarMaquillaje",function(){
    $("#txtusuariomaquillaje").val();
    $("#cboLugarmaquillaje").empty();
        listarCboLugar(0);
    $("#cboEmpleadomaquillaje").empty();
        listarCboEmpleado(0);
    $("#cboMaquillaje").empty();
        listarCboMaquillaje(0);
    $("#txtPrecioMaqui").val("");
    $("#txtfechamaquillaje").val("");
    $("#hddcodreMaq").val("0");
    $("#modalNuevoMaquillaje").modal("show");

});

function listarCboLugar(id_lugar){
    $.ajax({
        type: "GET",
        url: "/lugar/listar",
        dataType: "json",
        success: function(resultado){
            $.each(resultado, function(index, value){
                $("#cboLugarmaquillaje").append(
                    `<option value="${value.id_lugar}">${value.distrito}</option>`
                )
            });
            if(id_lugar > 0){
                $("#cboLugarmaquillaje").val(id_lugar);
            }
        }
    });
}

function listarCboEmpleado(id_empleado){
    $.ajax({
        type: "GET",
        url: "/empleado/listar",
        dataType: "json",
        success: function(resultado){
            $.each(resultado, function(index, value){
                $("#cboEmpleadomaquillaje").append(
                    `<option value="${value.id_empleado}">${value.nom_empleado}</option>`
                )
            });
            if(id_empleado > 0){
                $("#cboEmpleadomaquillaje").val(id_empleado);
            }
        }
    });
}


function listarCboMaquillaje(idmaquillaje) {
    $.ajax({
        type: "GET",
        url: "/maquillaje/listar",
        dataType: "json",
        success: function(resultado) {
            $.each(resultado, function(index, value) {
                $("#cboMaquillaje").append(
                    `<option value="${value.idmaquillaje}" data-precio="${value.preciomaquillaje}">${value.descripcion}</option>`
                );
            });

            if (idmaquillaje > 0) {
                $("#cboMaquillaje").val(idmaquillaje);
            }

            // Manejar el evento de cambio en el select para mostrar el precio
            $("#cboMaquillaje").change(function() {
                var precioSeleccionado = $("option:selected", this).data("precio");
                if (precioSeleccionado) {
                    $("#txtPrecioMaqui").val(precioSeleccionado);
                }
            });
        }
    });
}