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
        success:function(data){
            parsedData = JSON.stringify(data[0]);
            // alert(parsedData);
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
            // alert(parsedData);
        }
    });
    return parsedData2;
}

$(document).ready(function(){
    $("#btn1").click(function(){
        $("table").append("<tr>\n" +
            "        <td align=\"center\" bgcolor=\"#9acd32\">"+getUsers()+"</td>\n" +
            "        <td align=\"center\">5$</td>\n" +
            "    </tr>");
    });

    $("#btn2").click(function(){
        alert("button2");
    });
    $("#btn3").click(function(){
        $("table").append("<tr>\n" +
            "        <td align=\"center\" bgcolor=\"#9acd32\">"+getUsers2().firstName+"</td>\n" +
            "        <td align=\"center\">5$</td>\n" +
            "    </tr>");
    });
});