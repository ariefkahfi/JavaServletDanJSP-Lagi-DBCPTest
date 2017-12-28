var selectStudent = document.getElementById("select_student_id");
var selectCourses = document.getElementById("select_courses_id");


function initToSelectTagForStudent(callbackData){
    baseXhrRequest({
       method : "get",
       url : "http://localhost:8080/CommonDBCPTest2/list/get/student",
       success : function(data){
           callbackData(data);
       },
       error : function(errMessage){
           console.log(errMessage);
       }
    });
}
function initToSelectTagForCourses(callbackData){
    baseXhrRequest({
        method : "GeT",
        url : "http://localhost:8080/CommonDBCPTest2/list/get/courses",
        success : function(data){
            callbackData(data);
        },
        error : function(dataErr){
            console.log(dataErr);
        }
    });
}

initToSelectTagForStudent(function(data){
    var jsonStudent = JSON.parse(data);
    jsonStudent.forEach(function(val){
       var optionTag = document.createElement("option");
       
       optionTag.value = val.id;
       optionTag.innerHTML = val.name;
       
       selectStudent.append(optionTag);
    });
});

initToSelectTagForCourses(function(data){
    var jsonCourses = JSON.parse(data);
    jsonCourses.forEach(function(val){
       var optionTag = document.createElement("option");
       
       optionTag.value = val.id;
       optionTag.innerHTML = val.name;
       
       selectCourses.append(optionTag);
    });
});


function saveStudentCourses(){
    var selectedStudentId = selectStudent.value;
    var selectedCoursesId = selectCourses.value;
    
    if(selectedCoursesId === '' || selectedStudentId === ''
            || selectedCoursesId === undefined || selectedStudentId === undefined){
        alert("Field still empty");
    }else{
        baseXhrRequest({
            method : "POST",
            url : "http://localhost:8080/CommonDBCPTest2/form/student-courses",
            success : function(data){
                if(data === 'save'){
                    alert('data save into our database');
                }else if(data === 'not_save'){
                    alert("you've taken this course before ");
                }
            },
            error : function(errData){
                console.log(errData);
            },
            data : "student_id="+selectedStudentId+"&courses_id="+selectedCoursesId
        });
    }
    
}