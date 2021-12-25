<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Board</title>
    <link rel="stylesheet" href="/css/main.css">
</head>
<body>
<h1>GAME</h1>
<#list deck as cards>
    <img src="${cards.image}" alt="">
</#list>

</body>
</html>