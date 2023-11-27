$(document).on("click","#btnagregar",function(){
    $("#txtDistrito").val("");
    $("#hddcodLug").val("0");
    $("#modalNuevo").modal("show");
});

$(document).on("click", ".btnactualizar", function(){
    $("#txtDistrito").val($(this).attr("data-distrito"));
     $("#hddcodLug").empty();
    $("#hddcodLug").val($(this).attr("data-cod"));
    $("#modalNuevo").modal("show");
});

$(document).on("click","#btnguardar",function(){
    $.ajax({
        type:"Post",
        url:"/lugar/guardar",
        contentType:"application/json",
        data: JSON.stringify({
            id_lugar: $("#hddcodLug").val(),
            Distrito: $("#txtDistrito").val(),


        }),
        success: function(resultado){
         if(resultado.respuesta){
             listarLugar();
        }
             alert(resultado.mensaje);
        }
    });
     $("#modalNuevo").modal("hide");
});


function listarLugar(){
    $.ajax({
        type: "GET",
        url: "/lugar/listar",
        dataType: "json",
        success: function(resultado){
            $("#tbllugar > tbody").html("");
            $.each(resultado, function(index, value){
                $("#tbllugar > tbody").append("<tr>"+
                    "<td>"+value.id_lugar+"</td>"+

                    "<td>"+value.Distrito+"</td>"+
                    "<td>"+
                        "<button type='button' class='btn btn-info btnactualizar'"+
                                     "data-cod='"+value.id_lugar+"'"+

                                     "data-distrito='"+value.Distrito+"'"+

                                     "><i class='fas fa-edit'></i></button>"+
                    "</td></tr>");
            })
        }
    })
}