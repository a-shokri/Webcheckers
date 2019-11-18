<!DOCTYPE html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"></meta>
    <title>${title} | Web Checkers</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
	<link rel="stylesheet" type="text/css" href="/css/signin.css">
</head>
<body>
  <div class="page">

    <h1>Web Checkers</h1>

    <div class="body">
		<div class="signin-wrapper">
			<div class="signin">
				<form action="./signin" method="GET">
		          <h3>Sign In </h3>
		          <div>Username: <input required name="user" /></div>
				  		<div>Password: <input required name="password" /></div>
							<#if invalidSignIn??>
      					<div class="message error">${invalidSignIn}</div>
      				</#if>
		          <button type="submit">Sign In</button>
        </form>
			</div>
			<div class="divider"></div>
			<div class="signup">
				<form action="./signup" method="GET">
		          <h3>Sign Up </h3>
				  <div>E-mail Address: <input required name="email" <#if email??> value="${email}"</#if>/></div>
          <div>Username: <input required name="user" <#if user??> value="${user}"</#if>/></div>
				  <div>Password: <input required name="password" type="password"/></div>
					<div>Confirm Password: <input required name="confirm" type="password"/></div>
					<#if signupError??>
						<div class="message error">${message}</div>
					</#if>
          <button type="submit">Sign Up</button>
        </form>
			</div>
		</div>

    </div>

  </div>
</body>
</html>
