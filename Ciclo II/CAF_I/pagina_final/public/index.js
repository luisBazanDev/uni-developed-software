var socket = io();
function gun() {
  socket.emit("gun", {});
}

function changeAngle(angle) {
  console.log(angle);
  socket.emit("angle", { angle });
}

document.getElementById("angle").addEventListener("change", (event) => {
  console.log(event);
  changeAngle(event.target.value);
});
