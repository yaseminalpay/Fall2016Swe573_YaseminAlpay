<%--
  User: Yase
  Date: 20.11.2016
  Time: 21:17
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <script src="/js/jquery-3.1.1.js"></script>
        <script type="text/javascript">
            $(document).ready(function() {
                bind()
            })

            function bind() {
                $("#search_button").click(function(){
                    var keyword = $("#search_box").val()
                    show_list(keyword)
                })
            }
            function show_list(keyword) {
                $.ajax({
                    url: "/foodList/" + keyword
                }).done(function(res){
                    render_list(res)
                    console.log("completed")
                })
                console.log("show_list sonu")
            }

            function render_list(data) {
                var template = "<li></li>";
                var container = $("#results");
                container.html("")
                for (var i = data.length - 1; i >= 0; i--) {
                    var food = data[i];
                    var template = "<li>" + food.name + "</li>";
                    container.append(template);
                };
            }
        </script>
    </head>
    <body>
        <input type="text" id="search_box" />
        <button id="search_button">Search</button>
        <ul id="results">
        </ul>

        <form method="POST" action="/foodSearch" modelAttribute="keyword">
            Name:<input type="text" name="keyword"><br>
            <input type="submit" value="Search">
        </form>
</body>
</html>
