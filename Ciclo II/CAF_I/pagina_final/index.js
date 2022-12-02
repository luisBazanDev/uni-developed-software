require("dotenv").config();
const socketIO = require("socket.io");
const { SerialPort } = require("serialport");
const express = require("express");
const app = express();
const server = require("http").createServer(app);
const io = new socketIO.Server(server);
const arduino = new SerialPort({
  path: process.env.SERIAL_PORT,
  baudRate: 9600,
});

app.use(express.static("public"));

io.on("connection", (client) => {
  console.log("New connection");
  client.on("angle", (data) => {
    if (!data.angle) return;
    if (data.angle < 0 || data.angle > 180) return;
    arduino.write(`ANGLE ${data.angle}`);
  });
  client.on("gun", () => {
    console.log("gun");
    arduino.write("GUN");
  });
});

server.listen(3000, () => {
  console.log("Server on port 3000");
});
