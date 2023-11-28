$(document).on("click","#btnagregar",function(){
    $("#txttiempo").val("");
    $("#txtprecio").val("");
    $("#cbodesc").empty();
    $("#txtdescripcion").val("");
    $("#hddcodmasa").val("0");
        listarCbo(0);
    $("#modalNuevo").modal("show");
});

$(document).on("click", ".btnactualizar", function(){
    $("#txttiempo").val($(this).attr("data-masaname"));
    $("#txtprecio").val($(this).attr("data-masaprice"));
     $("#cbodesc").empty();
         listarCbo($(this).attr("data-masaDescMasa"));
    $("#txtdescripcion").val($(this).attr("data-masaDesc"));
    $("#hddcodmasa").val($(this).attr("data-masacod"));
    $("#modalNuevo").modal("show");
});

$(document).on("click","#btnguardar",function(){
    $.ajax({
        type:"Post",
        url:"/masaje/guardar",
        contentType:"application/json",
        data: JSON.stringify({
            id_masaje: $("#hddcodmasa").val(),
             tiempo_masaje: $("#txttiempo").val(),
            precio_masaje: $("#txtprecio").val(),
            id_desc_masaje: $("#cbodesc").val(),
             descripcion: $("#txtdescripcion").val()
        }),
        success: function(resultado){
         if(resultado.respuesta){
             listarMasaje();
        }
             alert(resultado.mensaje);
        }
    });
     $("#modalNuevo").modal("hide");
});

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

function listarMasaje(){
    $.ajax({
        type: "GET",
        url: "/masaje/listar",
        dataType: "json",
        success: function(resultado){
            $("#tblmasaje > tbody").html("");
            $.each(resultado, function(index, value){
                $("#tblmasaje > tbody").append("<tr>"+
                    "<td>"+value.id_masaje+"</td>"+
                    "<td>"+value.tiempo_masaje+"</td>"+
                    "<td>"+value.precio_masaje+"</td>"+
                    "<td>"+value.descmasaje.desc_masaje+"</td>"+
                    "<td>"+value.descripcion+"</td>"+
                    "<td>"+
                        "<button type='button' class='btn btn-warning btnactualizar'"+
                                     "data-masacod='"+value.id_masaje+"'"+
                                     "data-masaname='"+value.tiempo_masaje+"'"+
                                     "data-masaprice='"+value.precio_masaje+"'"+
                                     "data-masaDescMasa='"+value.descmasaje.id_desc_masaje+"'"+
                                     "data-masaDesc='"+value.descripcion+"'"+
                                     "><i class='fas fa-edit'></i></button>"+
                    "</td></tr>");
            })
        }
    })
}