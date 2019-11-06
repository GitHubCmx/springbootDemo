<html>
    <head>
        <title>spring boot spring Data JPA 页面展示</title>
    </head>
    <body>
        <table border="1">
            <tr>
                <th>编号</th>
                <th>用户名</th>
                <th>密码</th>
            </tr>
            <#list userList as user>
                  <tr>
                      <td>${user.uid}</td>
                      <td>${user.uname}</td>
                      <td>${user.pwd}</td>
                  </tr>
            </#list>
        </table>
    </body>
</html>