$(document).on("click","#btnregistrarManicura",function(){
    $("#txtusuariomanicura").val();
    $("#cboLugarmanicura").empty();
        listarCboLugar(0);
    $("#cboEmpleadomanicura").empty();
        listarCboEmpleado(0);
    $("#cboManicura").empty();
        listarCboManicura(0);
    $("#txtPreciomanicura").val("");
    $("#txtfechamanicura").val("");
    $("#hddcodman").val("0");
    $("#modalNuevoManicura").modal("show");
});

function listarCboLugar(id_lugar){
    $.ajax({
        type: "GET",
        url: "/lugar/listar",
        dataType: "json",
        success: function(resultado){
            $.each(resultado, function(index, value){
                $("#cboLugarmanicura").append(
                    `<option value="${value.id_lugar}">${value.distrito}</option>`
                )
            });
            if(id_lugar > 0){
                $("#cboLugarmanicura").val(id_lugar);
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
                $("#cboEmpleadomanicura").append(
                    `<option value="${value.id_empleado}">${value.nom_empleado}</option>`
                )
            });
            if(id_empleado > 0){
                $("#cboEmpleadomanicura").val(id_empleado);
            }
        }
    });
}


function listarCboManicura(id_manicura) {
    $.ajax({
        type: "GET",
        url: "/manicura/listar",
        dataType: "json",
        success: function(resultado) {
            $.each(resultado, function(index, value) {
                $("#cboManicura").append(
                    `<option value="${value.id_manicura}" data-precio="${value.precio_manicura}">${value.descripcion}</option>`
                );
            });

            if (id_manicura > 0) {
                $("#cboManicura").val(id_manicura);
            }

            // Manejar el evento de cambio en el select para mostrar el precio
            $("#cboManicura").change(function() {
                var precioSeleccionado = $("option:selected", this).data("precio");
                if (precioSeleccionado) {
                    $("#txtPreciomanicura").val(precioSeleccionado);
                }
            });
        }
    });
}

$(document).on("click","#btnReservamanicura",function(){
    $.ajax({
        type:"Post",
        url:"/reservamanicura/guardar",
        contentType:"application/json",
        data: JSON.stringify({
            id_reserva_manicura: $("#hddcodman").val(),
            idusuario: $("#txtusuariomanicura").val(),
            id_lugar: $("#cboLugarmanicura").val(),
            id_empleado: $("#cboEmpleadomanicura").val(),
            id_manicura: $("#cboManicura").val(),
            fechaM: $("#txtfechamanicura").val()

        }),
        success: function(resultado){
         if(resultado.respuesta){
             listarManicura();
        }
             alert(resultado.mensaje);
        }
    });
     $("#modalNuevoManicura").modal("hide");
});