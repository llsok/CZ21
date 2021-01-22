function post(url,param,callback){
	var xhr;
	try{
		xhr=new XMLHttpRequest();	
	}catch(e){
		xhr=new ActiveXObject("xxxxxx");
	}
	xhr.onreadystatechange=function(){
		//console.info(xhr.readyState);
		if(xhr.readyState==4&&xhr.status==200){
			callback(xhr.responseText);
		}
	};
	xhr.open("POST",url);
	if(! (param instanceof FormData)){
		xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");

	}
	console.info(param);
	xhr.send(param);
}
