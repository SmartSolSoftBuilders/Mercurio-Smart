window.onload=disable();
function disable() {

	//below javascript is used for Disabling right-click on HTML page
	document.oncontextmenu=new Function("return false");//Disabling right-click
	
	 
	//below javascript is used for Disabling text selection in web page
	document.onselectstart=new Function ("return false"); //Disabling text selection in web page
	if (window.sidebar){
	document.onmousedown=new Function("return false"); 
	document.onclick=new Function("return true"); 
	 
	 
	//Disable Cut into HTML form using Javascript 
	document.oncut=new Function("return false");
	 
	 
	//Disable Copy into HTML form using Javascript 
	document.oncopy=new Function("return false"); 
	 
	 
	//Disable Paste into HTML form using Javascript  
	document.onpaste=new Function("return false"); 
	}
}
