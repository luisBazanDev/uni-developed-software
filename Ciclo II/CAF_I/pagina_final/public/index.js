var socket = io();
function gun() {
  socket.emit("gun", {});
}

const speed = 62;
const maxDistance = 100;
const gravity = 9.8;

function changeAngle(angle) {
  resetCanvas();
  if (parseInt(angle) != 0) drawTray(parseInt(angle));
  socket.emit("angle", { angle });
}

const canvas = document.getElementById("canvas");
const ctx = canvas.getContext("2d");

function resetCanvas() {
  ctx.fillStyle = "white";
  ctx.fillRect(0, 0, 450, 400);

  ctx.fillStyle = "#ccc";
  for (let i = 0; i <= 450; i = i + 25) {
    ctx.fillRect(i - 2, 0, 4, 400);
  }
  for (let i = 0; i <= 400; i = i + 25) {
    ctx.fillRect(0, i - 2, 450, 4);
  }

  ctx.fillStyle = "#00f";
  ctx.fillRect(47, 0, 6, 400);
  ctx.fillStyle = "#f00";
  ctx.fillRect(0, 400 - 53, 450, 6);
}

function drawTray(angle) {
  const speedX = speed * Math.cos((angle * Math.PI) / 180);
  const speedY = speed * Math.sin((angle * Math.PI) / 180);

  const time = (speedY ^ 2) / (2 * gravity);
  const height = 0.5 * gravity * (time ^ 2);
  const distance = time * speedX;

  console.log(speed, angle, speedX, speedY);
  console.log(time, height, distance);
  ctx.beginPath();
  ctx.lineWidth = 2;
  ctx.strokeStyle = "#000000";
  ctx.moveTo(50, 350);
  ctx.bezierCurveTo(
    calculateX(distance / 2),
    0,
    calculateX(distance),
    350 - height,
    calculateX(distance),
    350
  );
  ctx.stroke();
}

function calculateX(dist) {
  const prop = dist / maxDistance;
  return prop * 400 + 50;
}

resetCanvas();
drawTray(45);

document.getElementById("angle").addEventListener("change", (event) => {
  changeAngle(event.target.value);
  document.getElementById(
    "display-angle"
  ).textContent = `Angulo: ${event.target.value}°`;
});

document.getElementById("angle").addEventListener("cuechange", (event) => {
  document.getElementById(
    "display-angle"
  ).textContent = `Angulo: ${event.target.value}°`;
});
