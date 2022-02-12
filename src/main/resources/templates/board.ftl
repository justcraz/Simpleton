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
<button><a href="/ui/give/cards/to/player">Give cards for player</a></button>
<button><a href="/ui/give/cards/to/dealer">Give cards for dealer</a></button>
<button><a href="/ui/shuffle">shuffle</a></button>
<button><a href="/ui/move/to/trash">move to trash</a></button>
<button><a href="/ui/dealer/move">dealer moves</a></button>
<button><a href="/ui/give/up">give up</a></button>
<h1>${turn}</h1>
<div class="allcards">
    <div class="trumpCard">
        <img src="${trumpCard.image}" alt="">
    </div>
    <div class="deck">
        <#list deck as card>
            <img src="${card.image}" id="card${card.id}" alt="">
        </#list>
         <h3 class="cardsNumb">cards: ${cardsSize}</h3>
    </div>
</div>
<div class="dealerCards">
    <#list dealerCards as card>
        <img src="${card.image}" alt="">
    </#list>
</div>
<div class="table">
    <div class="dealermoves">
        <#list dealerMoves as card>
            <img src="${card.image}" alt="">
        </#list>
    </div>
    <div class="playerMoves">
        <#list playerMoves as card>
            <img src="${card.image}" alt="">
        </#list>
    </div>
</div>
<div class="playerCards">
    <#list playerCards as card>
        <button onclick="window.location.href='/ui/player/throw/${card.id}'"><img src="${card.image}" alt=""></button>
    </#list>
</div>
</body>
</html>