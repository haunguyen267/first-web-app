<%@ include file="common/header.jspf"%>
<%@ include file="common/nav.jspf"%>
<div class="container">
	<div class="row justify-content-center">
		<div class="col-12 text-center pt-3">
			<c:if test="${ successMessage != null }">
				<div class="alert alert-success alert-dismissible fade show text-start" role="alert" id="alert-message">
					<i class="fa-solid fa-circle-check mr-2"></i>
				  ${ successMessage }
				  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
				</div>
			</c:if>
			<h2 class="mt-3 mb-4">
				<spring:message code="todo.title" />
			</h2>
			<div class="table-responsive">
				<div class="d-flex justify-content-end mb-3">
					<a class="btn btn-primary" href="/add-todo"> <i
						class="fa-solid fa-plus"></i> <spring:message code="list.addNew" />
					</a>
				</div>
				<table class="table table-bordered table-hover table-responsive">
					<caption class="text-danger fst-italic"><spring:message code="list.total" /> ${ todos.size() }</caption>
					<thead>
						<tr>
							<th><spring:message code="no" /></th>
							<th><spring:message code="desc" /></th>
							<th><spring:message code="dueDate" /></th>
							<th><spring:message code="createdBy" /></th>
							<th><spring:message code="status" /></th>
							<th><spring:message code="actions" /></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${ todos }" var="todo" varStatus="loop">
							<tr class="align-middle">
								<td>${ loop.index + 1 }</td>
								<td>${ todo.getDescription() }</td>
								<td><fmt:formatDate pattern="dd/MM/yyyy"
										value="${ todo.getDueDate() }" /></td>
								<td><span class="badge bg-secondary">${ todo.getUser() }</span>
								</td>
								<td><c:choose>
										<c:when test="${todo.isDone() == true}">
											<span class="badge bg-primary">
												<spring:message code="done" />
											</span>
										</c:when>
										<c:otherwise>
											<span class="badge bg-danger">
												<spring:message code="undone" />
											</span>
										</c:otherwise>
									</c:choose></td>
								<td>
									<a class="btn btn-success"
										href="/update-todo?id=${ todo.getId() }"
										data-bs-toggle="tooltip" data-bs-placement="top" title="<spring:message code="update" />">
											<i class="fa-solid fa-pen-to-square"></i>
									</a>
									<button class="btn btn-danger btn-delete"
										data-bs-toggle="tooltip" data-bs-placement="top"
										data-todo-id="${ todo.getId() }" data-todo-desc="${ todo.getDescription() }"
										title="<spring:message code="delete" />">
										<i class="fa-solid fa-trash"></i>
									</button></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>
<%@ include file="common/confirm-delete-modal.jspf"%>
<%@ include file="common/footer.jspf"%>
<script>
	// Handle delete todo
	var confirmDeleteModal = new bootstrap.Modal($("#confirm-delete-modal"), {});
	$(".btn-delete").on("click", function() {
		var todoId = $(this).data("todo-id");
		var todoDescription = $(this).data("todo-desc");
		$('#todo-desc').text(todoDescription);
		$('#todo-delete-link').attr("href", "/delete-todo?id=" + todoId); 
		confirmDeleteModal.show();
	});
	
	// Auto hide alert message
	$("#alert-message").fadeTo(1000, 0.75).slideUp(450);
</script>