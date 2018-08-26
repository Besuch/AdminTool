var rootURL = "http://localhost:8080";

$('#btnGetUsers').click(function() {
    getUsers();
    return false;
});

var parsedData;
function getUsers() {
    console.log('findAll');
    $.ajax({
        type: 'GET',
        url: rootURL + "/users",
        dataType: "json",
        async:false,
        accept: {
            json: 'application/json'
        },
        success:function(data){
            parsedData = data;
        }
    });
    return parsedData;
}

var parsedData2;
function getUsers2() {
    console.log('findAll');
    $.ajax({
        type: 'GET',
        url: rootURL + "/users",
        dataType: "json",
        success:function(data){
            parsedData2 = data[0];
            alert(JSON.stringify(data));
        }
    });
    return parsedData2;
}

function addUser() {
    console.log('addUser');
    $.ajax({
        type: 'POST',
        contentType: 'application/json',
        url: rootURL + '/users',
        data: formToJSON()
    });
}

function deleteUser() {
    console.log('deleteUser');
    $.ajax({
        type: 'DELETE',
        url: rootURL + '/users/' + $('#userId').val()
    });
}

function formToJSON() {
    return JSON.stringify({
        "firstName": $('#inName').val(),
        "lastName": $('#inSurname').val(),
        "age": $('#inAge').val()
    });
}

function showUsers(){
    var users = getUsers();
    for (var key in users){
        $("table").append("<tr>\n" +
            "        <td align=\"center\" bgcolor=\"#00ffff\">"+(parseInt(key, 10)+1)+"</td>\n" +
            "        <td align=\"center\" bgcolor=\"#00ffff\">"+users[key].firstName+"</td>\n" +
            "        <td align=\"center\" bgcolor=\"#00ffff\">"+users[key].lastName+"</td>\n" +
            "        <td align=\"center\" bgcolor=\"#00ffff\">"+users[key].age+"</td>\n" +
            "    </tr>");
    }
}

$(document).ready(function(){
    showUsers();
    $("#btn1").click(function(){
        addUser();
        location.reload();
    });

    $("#btnDelete").click(function(){
        deleteUser();
        location.reload();
    });

    $("#btn2").click(function(){
        showUsers();
    });

    $("#btn3").click(function(){
        var user = getUsers2();
        $("table").append("<tr>\n" +
            "        <td align=\"center\" bgcolor=\"#00ffff\">"+user.firstName+"</td>\n" +
            "        <td align=\"center\" bgcolor=\"#00ffff\">"+user.lastName+"</td>\n" +
            "        <td align=\"center\" bgcolor=\"#00ffff\">"+user.age+"</td>\n" +
            "    </tr>");
    });
});

