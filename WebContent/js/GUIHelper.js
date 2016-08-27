
/**************************************************************/
/***************Función de invocación a Helper.****************/
function launch(nombre, titulo, campos, parametros, width, height) {
	
	launch(nombre, titulo, campos, parametros, width, height,"");
}

function launch(nombre, titulo, campos, parametros, width, height,funcionNotificacion){
	
	urlBase     = '../app/generarHelper';
    propiedades = 'width='+width+',height='+height+',toolbar=no,directories=no,menubar=no,resizable=yes,status=yes,dependent=yes,scrollbars=yes';
    params = 'nombre='+nombre+'&titulo='+titulo+'&campos='+campos+'&parametros='+parametros+'&funcionNotificacion='+funcionNotificacion;
    url    = urlBase + '?' + params;
    //alert('url: ' + url);
    vent   = window.open(url, nombre, propiedades);
    isOpen = true;
	
}


function toDecimal(numero){
	if(numero == "" || isNaN(numero)){
		return 0.0;
	}else{
		return parseFloat(numero);
	}
}

function abrirVentana(url,width, height){
	propiedades = 'width='+width+',height='+height+',toolbar=no,directories=no,menubar=no,resizable=yes,status=yes,dependent=yes,scrollbars=no';
	vent   = window.open(url, "", propiedades);
   
}