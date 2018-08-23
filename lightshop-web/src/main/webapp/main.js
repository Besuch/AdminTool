var rootURL = "http://localhost:8080";

$('#btnGetUsers').click(function() {
    getUsers();
    return false;
});

function getUsers() {
    console.log('findAll');
    $.ajax({
        type: 'GET',
        url: rootURL + "/users",
        dataType: "json",
        success:function(data){
            var parsedData = JSON.stringify(data[0]);
            alert(parsedData);
        }
    });
}
$(document).ready(function(){
    $("#btn1").click(function(){
        $("table").append("<tr>\n" +
            "        <td align=\"center\" bgcolor=\"#9acd32\">Apple</td>\n" +
            "        <td align=\"center\">5$</td>\n" +
            "    </tr>");
    });

    $("#btn2").click(function(){
        alert("button2");
    });
});