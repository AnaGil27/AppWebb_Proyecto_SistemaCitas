$(document).on("click","#btnagregar",function(){
    $("#txttiempo").val("");
    $("#txtprecio").val("");
    $("#cbodesc").empty();
    $("#txtdescripcion").val("");
    $("#hddcodmaqui").val("0");
        listarCbo(0);
    $("#modalNuevo").modal("show");
});

$(document).on("click", ".btnactualizar", function(){
    $("#txttiempo").val($(this).attr("data-maquiname"));
    $("#txtprecio").val($(this).attr("data-maquiprice"));
     $("#cbodesc").empty();
         listarCbo($(this).attr("data-maquiDescMaqui"));
    $("#txtdescripcion").val($(this).attr("data-peiDes"));
    $("#hddcodmaqui").val($(this).attr("data-maquicod"));
    $("#modalNuevo").modal("show");
});

$(document).on("click","#btnguardar",function(){
    $.ajax({
        type:"Post",
        url:"/maquillaje/guardar",
        contentType:"application/json",
        data: JSON.stringify({
            id_maquillaje: $("#hddcodmaqui").val(),
             tiempo_maquillaje: $("#txttiempo").val(),
            precio_maquillaje: $("#txtprecio").val(),
            id_desc_maquillaje: $("#cbodesc").val(),
            descripcion: $("#txtdescripcion").val()

        }),
        success: function(resultado){
         if(resultado.respuesta){
             listarMaquillaje();
        }
             alert(resultado.mensaje);
        }
    });
     $("#modalNuevo").modal("hide");
});

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

function listarMaquillaje(){
    $.ajax({
        type: "GET",
        url: "/maquillaje/listar",
        dataType: "json",
        success: function(resultado){
            $("#tblmaquillaje > tbody").html("");
            $.each(resultado, function(index, value){
                $("#tblmaquillaje > tbody").append("<tr>"+
                    "<td>"+value.id_maquillaje+"</td>"+
                    "<td>"+value.tiempo_maquillaje+"</td>"+
                    "<td>"+value.precio_maquillaje+"</td>"+
                    "<td>"+value.descmaquillaje.desc_maquillaje+"</td>"+
                    "<td>"+value.descripcion+"</td>"+
                    "<td>"+
                        "<button type='button' class='btn btn-info btnactualizar'"+
                                     "data-maquicod='"+value.id_maquillaje+"'"+
                                     "data-maquiname='"+value.tiempo_maquillaje+"'"+
                                     "data-maquiprice='"+value.precio_maquillaje+"'"+
                                     "data-maquiDescMaqui='"+value.descmaquillaje.id_desc_maquillaje+"'"+
                                     "data-peiDesc='"+value.descripcion+"'"+
                                     "><i class='fas fa-edit'></i></button>"+
                    "</td></tr>");
            })
        }
    })
}