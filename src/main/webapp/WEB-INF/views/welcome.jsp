<%@ include file="common/header.jspf"%>
<%@ include file="common/nav.jspf"%>
<div class="container pt-4">
	<h2>
		<spring:message code="welcome.title" arguments="${name}" />
	</h2>
	<a href="/todos">
		<spring:message code="todo.title" />
	</a>
</div>
<%@ include file="common/footer.jspf"%>