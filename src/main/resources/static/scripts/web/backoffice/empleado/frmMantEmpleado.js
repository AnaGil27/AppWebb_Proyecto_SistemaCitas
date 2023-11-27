$(document).on("click","#btnagregar",function(){
    $("#txtNombre").val("");
    $("#txtApellido").val("");
       $("#txtCelular").val("");
    $("#hddcodEmp").val("0");
    $("#modalNuevo").modal("show");
});

$(document).on("click", ".btnactualizar", function(){
    $("#txtNombre").val($(this).attr("data-nom"));
    $("#txtApellido").val($(this).attr("data-ape"));
    $("#txtCelular").val($(this).attr("data-cel"));
     $("#hddcodEmp").empty();
    $("#hddcodEmp").val($(this).attr("data-cod"));
    $("#modalNuevo").modal("show");
});

$(document).on("click","#btnguardar",function(){
    $.ajax({
        type:"Post",
        url:"/empleado/guardar",
        contentType:"application/json",
        data: JSON.stringify({
            IdEmpleado: $("#hddcodEmp").val(),
             NomEmpleado: $("#txtNombre").val(),
            ApeEmpleado: $("#txtApellido").val(),
             CelularEmpleado: $("#txtCelular").val(),

        }),
        success: function(resultado){
         if(resultado.respuesta){
             listarEmpleado();
        }
             alert(resultado.mensaje);
        }
    });
     $("#modalNuevo").modal("hide");
});


function listarEmpleado(){
    $.ajax({
        type: "GET",
        url: "/empleado/listar",
        dataType: "json",
        success: function(resultado){
            $("#tblEmpleado > tbody").html("");
            $.each(resultado, function(index, value){
                $("#tblEmpleado > tbody").append("<tr>"+
                    "<td>"+value.id_empleado+"</td>"+
                    "<td>"+value.nom_empleado+"</td>"+
                    "<td>"+value.ape_empleado+"</td>"+
                    "<td>"+value.celular_empleado+"</td>"+
                    "<td>"+value.lugar.distrito+"</td>"+
                    "<td>"+
                        "<button type='button' class='btn btn-info btnactualizar'"+
                                     "data-cod='"+value.id_empleado+"'"+
                                     "data-nom='"+value.nom_empleado+"'"+
                                     "data-ape='"+value.ape_empleado+"'"+
                                    "data-cel='"+value.celular_empleado+"'"+
                                    "data-lug='"+value.lugar.id_lugar+"'"+
                                     "><i class='fas fa-edit'></i></button>"+
                    "</td></tr>");
            })
        }
    })
}

