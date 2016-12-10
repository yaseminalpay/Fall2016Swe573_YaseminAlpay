<%--
  User: Yase
  Date: 20.11.2016
  Time: 21:17
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script type="text/javascript">
            $(document).ready(function() {
                bind()
            });

            function bind() {
                $("#search_button").click(function(){
                    var keyword = $("#search_box").val();
                    show_list(keyword)
                })
            }
            function show_list(keyword) {
                $.ajax({
                    url: "/foodList/?keyword=" + keyword,
                    datatype: 'json',
                    success: function(data)
                    {
                        render_list(data);
                        console.log(data.toString())
                    }

                    /*success: function (response) {
                        jsonData = response;
                        render_list(jsonData)
                        console.log("success")
                    }*/
                }).done(function(jsonData){
                    render_list(jsonData);
                    console.log("completed")
                });
                console.log("show_list sonu")
            }

            function render_list(data) {
                var container = $("#results");
                console.log(data.toString());
                container.html("");
                jsonData = JSON.parse(data);

                for (var i = 0; i < jsonData.length -1;  i++) {
                    var food = jsonData[i];
                    var template = "<option>" + food.name + "</option>";
                    container.append(template);
                }
            }
        </script>
    </head>

    <body>

        <input type = "text" id = "search_box">
        <input type="button" id="search_button" value="Search Food">

        <select id="results">

        </select>
        <input type = "number" >

        <select id="units">

        </select>


    </body>
</html>
