<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>KT</title>
</head>
<body>

<h1>Hello World</h1>


<#list customers as customer>
    <div>
        <h3>${customer.id}</h3>
        <p>${customer.name}</p>
    </div>
</#list>


<div>
    <form action="/create" method="post">

        <input type="text" name="id" placeholder="Type id..." required>
        <input type="text" name="name" placeholder="Type name..." required>

        <button type="submit">Create new customer</button>
    </form>
</div>

</body>
</html>