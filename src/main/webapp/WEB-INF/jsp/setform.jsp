<!-- 
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN"
    "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<body>
<%@ page contentType="application/xhtml+xml; charset=UTF-8" %>
-->
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
        <form:form method="get" onsubmit="return register(this);" commandName="secretNumberForm">
                    <p>Your name: <form:input path="name" /> <form:errors path="name" /></p>
                    <p>Number: <form:input path="number"/> <form:errors path="number" /></p>
                    <input type="submit" value="Register" />
        </form:form>
<!-- 
</body>
</html>
 -->