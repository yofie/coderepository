<div class="modal" id="Login_Modal">
	<form id="Login_Modal_Form">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
					<h4 class="modal-title">Login</h4>
				</div>
				<div id="Login_Modal_Content">
					<div class="modal-body">
						<div class="row">
							<div id="Login_Table" align="center">
								<form id="validateLogin" method="POST" action="#">
									<table>
										<tr>
											<td>Username:</td>
											<td>
												<input type="text" id="email" name="email" class="form-control" placeholder="Username">
												<span></span>
											</td>
										</tr>
										<tr>
											<td>Password</td>
											<td>
												<input type="password" id="passwd" name="passwd" class="form-control" placeholder="Password" autocomplete="false">
												<span></span>
											</td>
										</tr>
										<tr>
											<td colspan="2"><button type="button" class="btn" onclick="validateLogin()">Submit</button><input type="hidden" id="isvalid" value="<c:out value="${IsValid}"/>"/><input type="hidden" id="role" value="<c:out value="${UserInfo.role}"/>"/></td>
										</tr>
									</table>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</form>
</div>