

$(document).on("click","#btnregistrarPeinado",function(){
    $("#txtusuario").val();
    $("#cboLugar").empty();
        listarCboLugar(0);
    $("#cboEmpleado").empty();
        listarCboEmpleado(0);
    $("#cboPeinado").empty();
    $("#txtfecha").val("");
    $("#hddcodrePe").val("0");
    $("#modalNuevo").modal("show");
});

function listarCboLugar(id_lugar){
    $.ajax({
        type: "GET",
        url: "/lugar/listar",
        dataType: "json",
        success: function(resultado){
            $.each(resultado, function(index, value){
                $("#cboLugar").append(
                    `<option value="${value.id_lugar}">${value.distrito}</option>`
                )
            });
            if(id_lugar > 0){
                $("#cboLugar").val(id_lugar);
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
                $("#cboEmpleado").append(
                    `<option value="${value.id_empleado}">${value.nomEmpleado}</option>`
                )
            });
            if(id_lugar > 0){
                $("#cboEmpleado").val(id_empleado);
            }
        }
    });
}

function listarCboLugar(id_lugar){
    $.ajax({
        type: "GET",
        url: "/lugar/listar",
        dataType: "json",
        success: function(resultado){
            $.each(resultado, function(index, value){
                $("#cboLugar").append(
                    `<option value="${value.id_lugar}">${value.distrito}</option>`
                )
            });
            if(id_lugar > 0){
                $("#cboLugar").val(id_lugar);
            }
        }
    });
}