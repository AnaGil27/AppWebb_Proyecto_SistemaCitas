$(document).on("click","#btnagregar",function(){
    $("#txttiempo").val("");
    $("#txtprecio").val("");
    $("#cbodesc").empty();
    $("#txtdescripcion").val("");
    $("#hddcodpei").val("0");
        listarCbo(0);
    $("#modalNuevo").modal("show");
});

$(document).on("click", ".btnactualizar", function(){
    $("#txttiempo").val($(this).attr("data-peiname"));
    $("#txtprecio").val($(this).attr("data-peiprice"));
     $("#cbodesc").empty();
         listarCbo($(this).attr("data-peiDescPei"));
    $("#txtdescripcion").val($(this).attr("data-peiDes"));
    $("#hddcodpei").val($(this).attr("data-peicod"));
    $("#modalNuevo").modal("show");
});

$(document).on("click","#btnguardar",function(){
    $.ajax({
        type:"Post",
        url:"/peinado/guardar",
        contentType:"application/json",
        data: JSON.stringify({
            id_peinado: $("#hddcodpei").val(),
            tiempo_peinado: $("#txttiempo").val(),
            precio_peinado: $("#txtprecio").val(),
            id_desc_peinado: $("#cbodesc").val(),
            descripcion: $("#txtdescripcion").val()
        }),
        success: function(resultado){
         if(resultado.respuesta){
             listarPeinado();
        }
             alert(resultado.mensaje);
        }
    });
     $("#modalNuevo").modal("hide");
});

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

function listarPeinado(){
    $.ajax({
        type: "GET",
        url: "/peinado/listar",
        dataType: "json",
        success: function(resultado){
            $("#tblpeinado > tbody").html("");
            $.each(resultado, function(index, value){
                $("#tblpeinado > tbody").append("<tr>"+
                    "<td>"+value.id_peinado+"</td>"+
                    "<td>"+value.tiempo_peinado+"</td>"+
                    "<td>"+value.precio_peinado+"</td>"+
                    "<td>"+value.descpeinado.desc_peinado+"</td>"+
                    "<td>"+value.descripcion+"</td>"+
                    "<td>"+
                        "<button type='button' class='btn btn-info btnactualizar'"+
                                     "data-peicod='"+value.id_peinado+"'"+
                                     "data-peiname='"+value.tiempo_peinado+"'"+
                                     "data-peiprice='"+value.precio_peinado+"'"+
                                     "data-peiDescPei='"+value.descpeinado.id_desc_peinado+"'"+
                                     "data-peiDesc='"+value.descripcion+"'"+
                                     "><i class='fas fa-edit'></i></button>"+
                    "</td></tr>");
            })
        }
    })
}