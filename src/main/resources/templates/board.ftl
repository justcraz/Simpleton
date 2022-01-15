<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Board</title>
    <link rel="stylesheet" href="/css/main.css">
    <#list deck as card>
        <style>
            #card${card.id}{
                position: absolute;
                left: ${card.value}px;
            }
        </style>
    </#list>
</head>
<body>
<h1>GAME</h1>
<button><a href="/give/cards/to/player">Give cards for player</a></button>
<div class="allcards">
    <div class="trumpCard">
        <img src="${trumpCard.image}" alt="">
    </div>
    <#list deck as card>
        <img src="${card.image}" id="card${card.id}" alt="">
    </#list>
</div>
<div class="playerCards">
    <#list playerCards as card>
        <img src="${card.image}" alt="">
    </#list>
</div>

</body>
</html>