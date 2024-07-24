<%@ include file="common/header.jspf"%>
<c:url value="/login" var="loginUrl" />
<div class="container">
	<div class="row justify-content-center">
		<div class="col-5">
			<div class="card mt-5 shadow">
				<div class="card-header bg-primary">
					<h5 class="text-center text-white mb-0">Login</h5>
				</div>
				<div class="card-body">
					<c:if test="${param.error != null}">
						<div class="alert alert-danger" role="alert">Invalid
							username or password.</div>
					</c:if>
					<c:if test="${param.logout != null}">
						<div class="alert alert-danger" role="alert">You have been
							logged out.</div>
					</c:if>
					<form action="${loginUrl}" method="POST">
						<input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" />
						<div class="mb-3">
							<label for="usernameInput" class="form-label">Username</label> <input
								type="text" class="form-control" id="usernameInput"
								required="required" name="username" />
						</div>

						<div class="mb-3">
							<label for="passwordInput" class="form-label">Password</label> <input
								type="password" class="form-control" id="passwordInput"
								required="required" name="password" />
						</div>

						<div class="d-flex justify-content-center mt-3">
							<input type="submit" class="btn btn-primary" value="Sign in">
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>
<%@ include file="common/footer.jspf"%>