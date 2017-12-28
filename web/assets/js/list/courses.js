
var coursesUpdateFormContainer = document.getElementById("courses-update-form-container");
var coursesId = document.getElementById("_courses_id");
var coursesName = document.getElementById("_courses_name");

function toggleForm(isHidden){
    coursesUpdateFormContainer.hidden = isHidden;
}

toggleForm(true);

function updateData(coursesId,coursesName){
    if(coursesUpdateFormContainer.hidden){
        toggleForm(false);
        
        document.getElementById("_courses_id").value = coursesId;
        document.getElementById("_courses_name").value = coursesName;
    }else{
        toggleForm(true);
    }
}


function clearInputTextUpdate(idsOfInputText){
    idsOfInputText.forEach(function(val){
       document.getElementById(val).value = "";
    });
}

function submitUpdate(){
    var updatedCoursesId = document.getElementById("_courses_id").value;
    var updatedCoursesName = document.getElementById("_courses_name").value;
    
    if(updatedCoursesId === '' || updatedCoursesName === '' || updatedCoursesId === undefined || updatedCoursesName === undefined){
        alert("Field still empty");
    }else{
        baseXhrRequest({
            method : "POST",
            url : "http://localhost:8080/CommonDBCPTest2/form/update/courses",
            success : function(data){
                console.log(data);
                window.location.reload();
                clearInputTextUpdate(["_courses_id","_courses_name"]);  
            },
            error : function(errData){
                console.log(errData);
            },
            data : "_courses_id="+updatedCoursesId+"&_courses_name="+updatedCoursesName
        });
    }
    
}