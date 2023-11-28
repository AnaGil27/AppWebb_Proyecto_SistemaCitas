$(document).on("click","#btnagregar",function(){
    $("#txttiempo").val("");
    $("#txtprecio").val("");
    $("#cbodesc").empty();
    $("#txtdescripcion").val("");
    $("#hddcodman").val("0");
        listarCbo(0);
    $("#modalNuevo").modal("show");
});

$(document).on("click", ".btnactualizar", function(){
    $("#txttiempo").val($(this).attr("data-manname"));
    $("#txtprecio").val($(this).attr("data-manprice"));
     $("#cbodesc").empty();
         listarCbo($(this).attr("data-manDescMan"));
    $("#txtdescripcion").val($(this).attr("data-manDesc"));
    $("#hddcodman").val($(this).attr("data-mancod"));
    $("#modalNuevo").modal("show");
});

$(document).on("click","#btnguardar",function(){
    $.ajax({
        type:"Post",
        url:"/manicura/guardar",
        contentType:"application/json",
        data: JSON.stringify({
            id_manicura: $("#hddcodman").val(),
             tiempo_manicura: $("#txttiempo").val(),
            precio_manicura: $("#txtprecio").val(),
            id_desc_manicura: $("#cbodesc").val(),
            descripcion: $("#txtdescripcion").val()
        }),
        success: function(resultado){
         if(resultado.respuesta){
             listarManicura();
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

function listarManicura(){
    $.ajax({
        type: "GET",
        url: "/manicura/listar",
        dataType: "json",
        success: function(resultado){
            $("#tblmanicura > tbody").html("");
            $.each(resultado, function(index, value){
                $("#tblmanicura > tbody").append("<tr>"+
                    "<td>"+value.id_manicura+"</td>"+
                    "<td>"+value.tiempo_manicura+"</td>"+
                    "<td>"+value.precio_manicura+"</td>"+
                    "<td>"+value.descmanicura.desc_manicura+"</td>"+
                    "<td>"+value.descripcion+"</td>"+
                    "<td>"+
                        "<button type='button' class='btn btn-info btnactualizar'"+
                                     "data-mancod='"+value.id_manicura+"'"+
                                     "data-manname='"+value.tiempo_manicura+"'"+
                                     "data-manprice='"+value.precio_manicura+"'"+
                                     "data-manDescMan='"+value.descmanicura.id_desc_manicura+"'"+
                                     "data-manDesc='"+value.descripcion+"'"+
                                     "><i class='fas fa-edit'></i></button>"+
                    "</td></tr>");
            })
        }
    })
}