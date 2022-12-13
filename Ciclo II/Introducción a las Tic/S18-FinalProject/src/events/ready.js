// Exportamos nuestro evento "ready" para cuando el bot ya este conectado con la API de Discord
// Acá se ve el formato necesario para la librería "node-handlers"
module.exports = {
  name: "ready",
  once: true,
  execute: () => {
    console.log("Bot ready!");
  },
};
