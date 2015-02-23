var Script = function () {


    var pieData = [
        {
            value : 90,
            color : "#CC0000"
        },
        {
            value : 200,
            color : "#27ae60"
        }
    ];
 
    new Chart(document.getElementById("pie").getContext("2d")).Pie(pieData);

}();