$(document).on("click","#btnregistrarManicura",function(){
    $("#txtusuariomaquillaje").val();
    $("#cboLugarmaquillaje").empty();
        listarCboLugar(0);
    $("#cboEmpleadomaquillaje").empty();
        listarCboEmpleado(0);
    $("#cboMaquillaje").empty();
        listarCboPeinado(0);
    $("#txtfechamaquillaje").val("");
    $("#hddcodreMaqui").val("0");
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
function listarCboMaquillaje(id_maquillaje){
    $.ajax({
        type: "GET",
        url: "/maquillaje/listar",
        dataType: "json",
        success: function(resultado){
            $.each(resultado, function(index, value){
                $("#cboMaquillaje").append(
                    `<option value="${value.id_maquillaje}">${value.descripcion}</option>`
                )
            });
            if(id_peinado > 0){
                $("#cboMaquillaje").val(id_maquillaje);
                }
         }
            });
        }
