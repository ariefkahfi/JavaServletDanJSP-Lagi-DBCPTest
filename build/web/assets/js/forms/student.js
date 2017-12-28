

function clearInputText(a){
    a.forEach(function(val){
       document.getElementById(val).value = "";
    });
}
function clearInputRadio(r){
    for(var i = 0 ; i<r.length; i++){
        r[i].checked = false;
    }
}

function clearForm(a,r){
    clearInputText(a);
    clearInputRadio(r);
}


function saveStudent(){
    var studentName = document.getElementById("student_name").value;
    var listOfRadios = document.getElementsByClassName("form-input-radio");
    
    var checkedValue = "";
    
    for(var i =0; i<listOfRadios.length; i++){
        if(listOfRadios[i].checked){
            checkedValue = listOfRadios[i].value;
        }
    }
    
    
    if(studentName.toString().trim() ===  '' || studentName === undefined 
            || checkedValue === '' || checkedValue === undefined){
        alert("Field still empty");
    }else{
        baseXhrRequest({
           method : "POST",
           url : "http://localhost:8080/CommonDBCPTest2/form/student",
           success : function(val){
               console.log(val);
               clearForm(["student_name"],listOfRadios);       
           },
           error : function(val){
               console.log(val);
           },
           data : "name="+studentName+"&gender="+checkedValue
        });
        
    }
    
      
      
}