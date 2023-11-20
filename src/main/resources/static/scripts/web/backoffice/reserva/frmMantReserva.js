$(document).on("click","#btnagregar",function(){
    $("#txtUsuario").val("");
    $("#cboManicura").empty();
    $("#cboPeinado").empty();
    $("#cboMasaje").empty();
    $("#cboMaquillaje").empty();
    $("#txtEmpleado").val("");
    $("#txtLugar").val("");
    $("#txtFecha").val("");
    $("#hddcodreser").val("0");
        listarCbo(0);
    $("#modalNuevo").modal("show");
});

$(document).on("click", ".btnactualizar", function(){
    $("#txtUsuario").val($(this).attr("data-usu"));
    $("#cboManicura").empty();
        listarCbo($(this).attr("data-man"));
     $("#cboPeinado").empty();
         listarCbo($(this).attr("data-pei"));
    $("#cboMasaje").empty();
        listarCbo($(this).attr("data-mas"));
    $("#cboMaquillaje").empty();
        listarCbo($(this).attr("data-ma"));
    $("#txtEmpleado").val($(this).attr("data-em"));
    $("#txtLugar").val($(this).attr("data-lug"));
    $("#txtFecha").val($(this).attr("data-fech"));
    $("#hddcodman").val($(this).attr("data-cod"));
    $("#modalNuevo").modal("show");
});

$(document).on("click","#btnguardar",function(){
    $.ajax({
        type:"Post",
        url:"/reserva/guardar",
        contentType:"application/json",
        data: JSON.stringify({
            id_manicura: $("#hddcodreser").val(),
             tiempo_manicura: $("#txtUsuario").val(),
              id_desc_manicura: $("#cboManicura").val(),
              id_desc_manicura: $("#cboPeinado").val(),
              id_desc_manicura: $("#cboMasaje").val(),
              id_desc_manicura: $("#cboMaquillaje").val(),
                precio_manicura: $("#txtEmpleado").val(),
             precio_manicura: $("#txtLugar").val(),
            precio_manicura: $("#txtFecha").val(),
        }),
        success: function(resultado){
         if(resultado.respuesta){
             listarReserva();
        }
             alert(resultado.mensaje);
        }
    });
     $("#modalNuevo").modal("hide");
});

function listarCbo(id_desc_manicura){
    $.ajax({
        type: "GET",
        url: "/descmanicura/listar",
        dataType: "json",
        success: function(resultado){
            $.each(resultado, function(index, value){
                $("#cbodesc").append(
                    `<option value="${value.id_desc_manicura}">${value.desc_manicura}</option>`
                )
            });
            if(id_desc_manicura > 0){
                $("#cbodesc").val(id_desc_manicura);
                }
         }
            });
        }
 function listarCbo(id_desc_peinado){
     $.ajax({
         type: "GET",
         url: "/descpeinado/listar",
         dataType: "json",
         success: function(resultado){
             $.each(resultado, function(index, value){
                 $("#cbodesc").append(
                     `<option value="${value.id_desc_peinado}">${value.desc_peinado}</option>`
                 )
             });
             if(id_desc_peinado > 0){
                 $("#cbodesc").val(id_desc_peinado);
                 }
          }
             });
         }
 function listarCbo(id_desc_masaje){
     $.ajax({
         type: "GET",
         url: "/descmasaje/listar",
         dataType: "json",
         success: function(resultado){
             $.each(resultado, function(index, value){
                 $("#cbodesc").append(
                     `<option value="${value.id_desc_masaje}">${value.desc_masaje}</option>`
                 )
             });
             if(id_desc_masaje > 0){
                 $("#cbodesc").val(id_desc_masaje);
                 }
          }
             });
         }

function listarCbo(id_desc_maquillaje){
    $.ajax({
        type: "GET",
        url: "/descmaquillaje/listar",
        dataType: "json",
        success: function(resultado){
            $.each(resultado, function(index, value){
                $("#cbodesc").append(
                    `<option value="${value.id_desc_maquillaje}">${value.desc_maquillaje}</option>`
                )
            });
            if(id_desc_maquillaje > 0){
                $("#cbodesc").val(id_desc_maquillaje);
                }
         }
            });
        }



function listarManicura(){
    $.ajax({
        type: "GET",
        url: "/reserva/listar",
        dataType: "json",
        success: function(resultado){
            $("#tblmanicura > tbody").html("");
            $.each(resultado, function(index, value){
                $("#tblReserva > tbody").append("<tr>"+
                    "<td>"+value.id_reserva+"</td>"+
                     "<td>"+value.idusuario+"</td>"+
                   "<td>"+value.descmanicura.desc_manicura+"</td>"+
                    "<td>"+value.descpeinado.id_peinado+"</td>"+
                    "<td>"+value.escmasaje.id_masaje+"</td>"+
                    "<td>"+value.descmaquillaje.id_maquillaje+"</td>"+
                    "<td>"+value.id_empleado+"</td>"+
                    "<td>"+value.id_lugar+"</td>"+
                    "<td>"+value.fecha_reserva+"</td>"+
                    "<td>"+
                        "<button type='button' class='btn btn-info btnactualizar'"+
                                     "data-mancod='"+value.id_reserva+"'"+
                                     "data-usu='"+value.idusuario+"'"+
                                     "data-man='"+value.descmanicura.id_desc_manicura+"'"+
                                     "data-pei='"+value.descpeinado.id_peinado+"'"+
                                     "data-mas='"+value.descmasaje.id_masaje+"'"+
                                     "data-ma='"+value.descmaquillaje.id_maquillaje+"'"+
                                     "data-em='"+value.precio_manicura+"'"+
                                     "data-lug='"+value.id_lugar+"'"+
                                     "data-fech='"+value.fecha_reserva+"'"+

                                     "><i class='fas fa-edit'></i></button>"+
                    "</td></tr>");
            })
        }
    })
}