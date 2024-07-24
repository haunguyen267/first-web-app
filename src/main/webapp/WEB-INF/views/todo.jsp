<%@ include file="common/header.jspf"%>
<%@ include file="common/nav.jspf"%>
<div class="container">
	<div class="row justify-content-center">
		<div class="col-7">
			<div class="card mt-5 shadow">
				<div class="card-header bg-primary">
					<h5 class="text-center text-white mb-0">
						<spring:message code="${type.equals('update') ? 'update.title' : 'create.title'}"/>
					</h5>
				</div>
				<div class="card-body">
					<form:form method="POST" commandName="todo">
						<div class="mb-3">
							<form:label path="description" for="nameInput" class="form-label"><spring:message code="desc" /></form:label>
							<form:input path="description" type="text" class="form-control"
								id="nameInput"/>
							<form:errors path="description" cssClass="text-danger" />
						</div>
						<div class="row">
							<div class="col-6">
								<div class="mb-3 date">
									<form:label path="dueDate" for="dueDateInput" class="form-label"><spring:message code="dueDate" /></form:label>
									<div class="input-group">
										<form:input path="dueDate" type="text" class="form-control"
											id="dueDateInput"/>
										<span class="input-group-text"> <i
											class="fa-solid fa-calendar-days"></i>
										</span>
									</div>
									<form:errors path="dueDate" cssClass="text-danger" />
								</div>
							</div>
							<div class="col-6">
								<div class="mb-3">
									<label class="form-label"><spring:message code="status" /></label>
									<div class="form-check form-switch">
									  <form:label path="done" class="form-check-label" for="isDoneSwitch"><spring:message code="done" /></form:label>
									  <form:checkbox path="done" class="form-check-input" id="isDoneSwitch" />
									</div>
									<form:errors path="done" cssClass="text-danger" />
								</div>
							</div>
						</div>
						
						<div class="d-flex justify-content-end">
							<input type="submit" class="btn btn-primary" value="<spring:message code="submit" />" />
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</div>
<%@ include file="common/footer.jspf"%>
<script>
	$('#dueDateInput').datepicker({
		format : 'dd/mm/yyyy'
	});
</script>