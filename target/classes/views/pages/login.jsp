		<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
		<%@ page isELIgnored="false" %>
		<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
		<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
	<form:form method="POST" modelAttribute="user" >
 		<label  for="email">email</label>
                <div >
                    <form:input type="text" path="email" id="email" class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="email" class="help-inline"/>
                    </div>
                </div>
                <label  for="password">Password</label>
                <div >
                    <form:input type="password" path="pass" id="pass" class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="pass" class="help-inline"/>
                    </div>
                </div>
                  <input type="submit" value="Login" class="btn btn-primary btn-sm">
              
                  </form:form>
