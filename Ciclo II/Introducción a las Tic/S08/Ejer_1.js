const nombres = ["Luis", "Andy", "Fernando", "Francisco", "Raul"];

console.log(
  `Ganador del sorteo: ${nombres[Math.floor(Math.random() * nombres.length)]}`
);
