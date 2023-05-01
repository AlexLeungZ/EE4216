<html>
    <head>
        <title><?= isset($_REQUEST['title']) ? $_REQUEST['title'] : 'HTML Injection Example' ?></title>
    </head>
    <body>
		<h1>Welcome to the Internet</h1>
		<br>
		
		Hello, <?= isset($_REQUEST['name']) ? $_REQUEST['name'] : 'newbie' ?>
		
		<p>We are glad to see you here. </p>	
	<body>
<html>

<!--

Try this urls and decode the query string to see the urlenconded content via https://www.urldecoder.org/

http://localhost:8000/injection.php

http://localhost:8000/injection.php?name=Peter%20Wong

http://localhost:8000/injection.php?name=%3C%68%31%3E%57%41%52%4E%49%4E%47%21%21%21%21%3C%2F%68%31%3E

http://localhost:8000/injection.php?name=%3Cscript%3Econfirm%28%22Malware%20is%20detected%21%20Click%20to%20remove%20the%20virus.%22%29%3B%20window.location.href%20%3D%20%22http%3A%2F%2Fwww.cityu.edu.hk%22%3B%3C%2Fscript%3E%0D%0A%0D%0A

http://localhost:8000/injection.php?name=%3Cbr%3ESign%20in%20here%3A%0A%3Cform%20action%3D%22unknown.php%22%20method%3D%22post%22%3E%0AUsername%3A%3Cinput%20type%3D%22text%22%20name%3D%22username%22%3E%3Cbr%3E%0APassword%3A%3Cinput%20type%3D%22password%22%20name%3D%22password%22%3E%3Cbr%3E%0A%3Cinput%20type%3D%22submit%22%20value%3D%22Login%22%3E%0A%3C%2Fform%3E%0A%0A

http://localhost:8000/injection.php?title=%3C%2Ftitle%3E%3Cbody%3EWelcome%20to%20the%20dark%20world!%3C%2Fbody%3E%3C%2Fhtml%3E%3C!--%0A%0A

http://localhost:8000/injection.php?title=%3C%2Ftitle%3E%3Cimg%20src%3Dx%20onerror%3Dalert(9)%3E%0A%0A


-->