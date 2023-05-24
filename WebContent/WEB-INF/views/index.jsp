<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="head.jsp" />
<body>
	<form action="${Action}" method="post">
		<div class="container">
			<div class="row bg-success p-2 text-light">
				<div class="col-md-12">
					<h2>${Title}</h2>
				</div>
			</div>
			<div class="row">
				<div class="col-md-6 bg-info p-3 text-light">
					<div class="row p-2">
						<div class="col-md-3">Name</div>
						<div class="col-md-5">
							<input type="hidden" name="id" class="form-control" value="${IdValue}"/>
							<input type="text" name="name" class="form-control" value="${NameValue}" />
						</div>
						<div class="col-md-4 text-danger">${NameError}</div>
					</div>
					<div class="row p-2">
						<div class="col-md-3">Age</div>
						<div class="col-md-5">
							<input type="text" name="age" class="form-control" value="${AgeValue}" />
						</div>
						<div class="col-md-4 text-danger">${AgeError}</div>
					</div>
					<div class="row p-2">
						<div class="col-md-3">Phone</div>
						<div class="col-md-5">
							<input type="text" name="phone" class="form-control" value="${PhoneValue}" />
						</div>
						<div class="col-md-4 text-danger">${PhoneError}</div>
					</div>
					<div class="row p-2">
						<div class="col-md-3">
							<input type="submit" value="${ButtonValue}" class="btn btn-warning" />
						</div>
						<div class="col-md-9">
							<div class="text-success">${SuccessMessage}</div>
							<div class="text-danger">${ErrorMessage}</div>
						</div>
					</div>
				</div>

				<div class="col-md-6 bg-warning">
					<table class="table">
						<tr>
							<th>ACTION</th>
							<th>ID</th>
							<th>NAME</th>
							<th>AGE</th>
							<th>PHONE</th>
						</tr>
						<c:forEach var="person" items="${PersonList}">
							<tr>
								<td><a href="./getPersonDelete?id=${person.id}"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-trash3-fill" viewBox="0 0 16 16">
  <path d="M11 1.5v1h3.5a.5.5 0 0 1 0 1h-.538l-.853 10.66A2 2 0 0 1 11.115 16h-6.23a2 2 0 0 1-1.994-1.84L2.038 3.5H1.5a.5.5 0 0 1 0-1H5v-1A1.5 1.5 0 0 1 6.5 0h3A1.5 1.5 0 0 1 11 1.5Zm-5 0v1h4v-1a.5.5 0 0 0-.5-.5h-3a.5.5 0 0 0-.5.5ZM4.5 5.029l.5 8.5a.5.5 0 1 0 .998-.06l-.5-8.5a.5.5 0 1 0-.998.06Zm6.53-.528a.5.5 0 0 0-.528.47l-.5 8.5a.5.5 0 0 0 .998.058l.5-8.5a.5.5 0 0 0-.47-.528ZM8 4.5a.5.5 0 0 0-.5.5v8.5a.5.5 0 0 0 1 0V5a.5.5 0 0 0-.5-.5Z"/>
</svg></a>&nbsp&nbsp&nbsp&nbsp&nbsp
<a href="./getPersonEdit?id=${person.id}">"<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-eyedropper" viewBox="0 0 16 16">
  <path d="M13.354.646a1.207 1.207 0 0 0-1.708 0L8.5 3.793l-.646-.647a.5.5 0 1 0-.708.708L8.293 5l-7.147 7.146A.5.5 0 0 0 1 12.5v1.793l-.854.853a.5.5 0 1 0 .708.707L1.707 15H3.5a.5.5 0 0 0 .354-.146L11 7.707l1.146 1.147a.5.5 0 0 0 .708-.708l-.647-.646 3.147-3.146a1.207 1.207 0 0 0 0-1.708l-2-2zM2 12.707l7-7L10.293 7l-7 7H2v-1.293z"/>
</svg></a></td>
								<td>${person.id}</td>
								<td>${person.name}</td>
								<td>${person.age}</td>
								<td>${person.phone}</td>
							</tr>
						</c:forEach>
					</table>
				</div>

			</div>
		</div>

	</form>

</body>
</html>