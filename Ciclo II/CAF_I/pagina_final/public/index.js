var socket = io();
function gun() {
  socket.emit("gun", {});
}

function changeAngle(angle) {
  drawTray(parseInt(angle));
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
  ctx.fillStyle = "#0f0";
  for (let i = 0; i <= 450; i++) {
    ctx.fillRect(i + 40, calculeY(i), 6, 6);
  }
}

function calculeY(x) {
  const a = 1 / 5;
  const b = 0;
  const c = 0;
  return a * (x ^ 2) + b * x + c;
}

resetCanvas();
drawTray(angle);

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
