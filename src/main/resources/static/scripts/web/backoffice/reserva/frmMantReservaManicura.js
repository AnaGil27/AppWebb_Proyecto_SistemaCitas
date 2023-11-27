$(document).on("click","#btnregistrarManicura",function(){
    $("#txtusuariomanicura").val();
    $("#cboLugarmanicura").empty();
        listarCboLugar(0);
    $("#cboEmpleadomanicura").empty();
        listarCboEmpleado(0);
    $("#cboManicura").empty();
        listarCboPeinado(0);
    $("#txtfechamanicura").val("");
    $("#hddcodreMa").val("0");
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
function listarCboManicura(id_manicura){
    $.ajax({
        type: "GET",
        url: "/manicura/listar",
        dataType: "json",
        success: function(resultado){
            $.each(resultado, function(index, value){
                $("#cboManicura").append(
                    `<option value="${value.id_manicura}">${value.descripcion}</option>`
                )
            });
            if(id_peinado > 0){
                $("#cboManicura").val(id_manicura);
                }
         }
            });
        }
