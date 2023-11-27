$(document).on("click","#btnregistrarPeinado",function(){
    $("#txtusuario").val("");
    $("#cboLugar").empty();
          listarCboLugar(0);
    $("#cboMaquillaje").empty();
    $("#cboEmpleado").empty();
    $("#cboPeinado").empty();
    $("#txtfecha").val("");
    $("#hddcodrePe").val("0");
    $("#modalNuevo").modal("show");
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