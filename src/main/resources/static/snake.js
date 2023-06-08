var canvas = document.getElementById("canvas");
var ctx = canvas.getContext("2d");
var snake = [
    {x: 200, y: 200},
    {x: 190, y: 200},
    {x: 180, y: 200},
    {x: 170, y: 200},
    {x: 160, y: 200}
];
var food = {x: 0, y: 0};
var direction = "right";
function drawSnake() {
    for (var i = 0; i < snake.length; i++) {
        ctx.fillStyle = (i == 0) ? "black" : "gray";
        ctx.fillRect(snake[i].x, snake[i].y, 10, 10);
    }
}
function createFood() {
    food.x = Math.floor(Math.random() * 39) * 10;
    food.y = Math.floor(Math.random() * 39) * 10;
}
function drawFood() {
    ctx.fillStyle = "red";
    ctx.fillRect(food.x, food.y, 10, 10);
}
function moveSnake() {
    var headX = snake[0].x;
    var headY = snake[0].y;
    if (direction == "right") headX += 10;
    else if (direction == "left") headX -= 10;
    else if (direction == "up") headY -= 10;
    else if (direction == "down") headY += 10;
    var tail = snake.pop();
    tail.x = headX;
    tail.y = headY;
    snake.unshift(tail);
}
function keyDown(event) {
    if (event.keyCode == 37 && direction != "right") direction = "left";
    else if (event.keyCode == 38 && direction != "down") direction = "up";
    else if (event.keyCode == 39 && direction != "left") direction = "right";
    else if (event.keyCode == 40 && direction != "up") direction = "down";
}
function update() {
    ctx.clearRect(0, 0, canvas.width, canvas.height);
    drawSnake();
    drawFood();
    moveSnake();
    if (snake[0].x == food.x && snake[0].y == food.y) {
        snake.push({});
        createFood();
    }
    if (snake[0].x < 0 || snake[0].x >= canvas.width ||
        snake[0].y < 0 || snake[0].y >= canvas.height) {
        alert("游戏结束！");
        location.reload();
    }
    for (var i = 1; i < snake.length; i++) {
        if (snake[0].x == snake[i].x && snake[0].y == snake[i].y) {
            alert("游戏结束！");
            location.reload();
        }
    }
    setTimeout(update, 100);
}
createFood();
document.addEventListener("keydown", keyDown);
update();