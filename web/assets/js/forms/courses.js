function clearForm(listOfInputsId){
    listOfInputsId.forEach(function(val){
       document.getElementById(val).value = "";
    });
}

function saveCourseRequest(){
    var courseId = document.getElementById("courses_id").value;
    var courseName = document.getElementById("courses_name").value;
   
    if(courseId === '' || courseId === undefined || courseName === '' || courseName === undefined){
        alert("Fields still empty");
    }else{
         baseXhrRequest({
            method : "PosT",
            url : "http://localhost:8080/CommonDBCPTest2/form/courses",
            success : function(data){
                console.log(data);
                clearForm(["courses_id","courses_name"]);
            },
            error : function(data){
                console.log(data);
                alert("Data exists in our database");
            },
            data : "id="+courseId+"&name="+courseName
        });
    }
   
}