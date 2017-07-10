
		<form:form method="POST" modelAttribute="user" >
 		<label  for="usertName">User Name</label>
                <div >
                    <form:input type="text" path="userName" id="userName" class="form-control input-sm"/>
                    <div class="has-error" >
                    <span id="usernameErr"></span>
                        <form:errors path="userName" class="help-inline"/>
                    </div>
                </div>
                <label  for="password">password</label>
                <div >
                    <form:input type="password" path="password" id="password" class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="password" class="help-inline"/>
                    </div>
                </div>
                <label  for="password">Confirm password</label>
                <div >
                    <form:input type="password" path="repassword" id="repassword" class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="repassword" class="help-inline"/>
                    </div>
                </div>
                
                <label  for="email">email</label>
                <div >
                    <form:input type="text" path="email" id="email" class="form-control input-sm"/>
                    <div class="has-error">
                    <span id="mailErr"></span>
                        <form:errors path="email" class="help-inline"/>
                    </div>
                </div>
                
                <label  for="birthdate">birthday</label>
                <div >
                    <form:input type="date" path="birthdate" id="birthdate" class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="birthdate" class="help-inline"/>
                    </div>
                </div>
                
                <label  for="sex">sex</label>
                <div >
                   
                  <form:select path="sex">
   						<form:option value="false" label="Erkek"/>
  						 <form:option value="false" label="bayan" />
				</form:select>
                  
                    <div class="has-error">
                        <form:errors path="sex" class="help-inline"/>
                    </div>
                </div>
                
                
                
                  <input type="submit" value="register" class="btn btn-primary btn-sm">
                  </form:form>
