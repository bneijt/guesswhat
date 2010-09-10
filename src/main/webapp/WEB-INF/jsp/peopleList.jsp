<%@ page session="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!--  UGLY FIX!: There is something wrong with my JSP container version? http://forums.sun.com/thread.jspa?threadID=683007 -->
<html>
<body>
<ul>
  <c:forEach items="${people}" var="person">
    <li><span><c:out value="${person}" /></span> <input
      type="text" class="guessfield" /></li>
  </c:forEach>
</ul>
</body>
</html>