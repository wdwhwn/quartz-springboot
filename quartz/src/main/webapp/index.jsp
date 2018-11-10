<%@page isELIgnored="false" pageEncoding="UTF-8" contentType="text/html;UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
</head>
<body>
<h2>任务调度管理系统</h2></br>
<form action="test" >
任务名 <input name="jobName" type="text"/>
任务组 <input name="jobGroup" type="text"/>
触发器名<input name="triggerName" type="text"/>
触发组组<input name="triggerGroup" type="text"/>
cron表达式<input name="cronExpression" type="text"/>
    <input type="submit" value="提交"/>
</form>

</body>
</html>
