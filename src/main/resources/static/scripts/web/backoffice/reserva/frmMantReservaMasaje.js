$(document).on("click","#btnregistrarMasaje",function(){
    $("#txtusuarioMasaje").val();
    $("#cboLugarMasaje").empty();
        listarCboLugar(0);
    $("#cboEmpleadoMasaje").empty();
        listarCboEmpleado(0);
    $("#cboMasaje").empty();
        listarCboMasaje(0);
    $("#txtfechaMasaje").val("");
    $("#hddcodreMasaje").val("0");
    $("#modalNuevoMasaje").modal("show");
});

function listarCboLugar(id_lugar){
    $.ajax({
        type: "GET",
        url: "/lugar/listar",
        dataType: "json",
        success: function(resultado){
            $.each(resultado, function(index, value){
                $("#cboLugarMasaje").append(
                    `<option value="${value.id_lugar}">${value.distrito}</option>`
                )
            });
            if(id_lugar > 0){
                $("#cboLugarMasaje").val(id_lugar);
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
                $("#cboEmpleadoMasaje").append(
                    `<option value="${value.id_empleado}">${value.nom_empleado}</option>`
                )
            });
            if(id_empleado > 0){
                $("#cboEmpleadoMasaje").val(id_empleado);
            }
        }
    });
}

function listarCboMasaje(id_masaje) {
    $.ajax({
        type: "GET",
        url: "/masaje/listar",
        dataType: "json",
        success: function(resultado) {
            $.each(resultado, function(index, value) {
                $("#cboMasaje").append(
                    `<option value="${value.id_masaje}" data-precio="${value.precio_masaje}">${value.descripcion}</option>`
                );
            });

            if (id_masaje > 0) {
                $("#cboMasaje").val(id_masaje);
            }

            // Manejar el evento de cambio en el select para mostrar el precio
            $("#cboMasaje").change(function() {
                var precioSeleccionado = $("option:selected", this).data("precio");
                if (precioSeleccionado) {
                    $("#txtPrecioMasa").val(precioSeleccionado);
                }
            });
        }
    });
}