$(document).on("click","#btnregistrarPeinado",function(){
    console.log("Ingresó el btn registrar peinado");

    $("#txtusuario").val();
    console.log("txt en vacio?");

    $("#cboLugar").empty();
    $("#cboMaquillaje").empty();
    $("#cboEmpleado").empty();
    $("#cboPeinado").empty();
    $("#txtfecha").val("");
        listarCbo(0);
});

function listarCboLugar(id_lugar){
    $.ajax({
        type: "GET",
        url: "/lugar/listar",
        dataType: "json",
        success: function(resultado){
            $.each(resultado, function(index, value){
                $("#cboLugar").append(
                    `<option value="${value.id_lugar}">${value.Distrito}</option>`
                )
            });
            if(id_lugar > 0){
                $("#cboLugar").val(id_lugar);
            }
        }
    });
}