function baseXhrRequest(config){
    var xhr = new XMLHttpRequest();
    
    xhr.open(config.method,config.url);
    
    if(config.method.toString().toLowerCase() === 'post'){
        xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    }
    
    xhr.onreadystatechange = function (){
        if(this.readyState === 4 && this.status === 200){
            config.success(this.responseText);
        }else if(this.readyState === 4 && this.status === 500){
            config.error(this.responseText);
        }
    };
    
    if(config.method.toString().toLowerCase() === 'post'){
        xhr.send(config.data);
    }else{
        xhr.send();
    }
    
}