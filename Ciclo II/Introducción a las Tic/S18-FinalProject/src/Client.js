// Requerimos o importamos las librerías que vamos a usar en este archivo
const { Client } = require("discord.js");
const EventHandler = require("node-handlers");

// Instanciamos un nuevo Objeto "Cliente" y le pasamos la configuración
// En la configuración usamos le expresamos a la API de Discord nuestras intenciones
// o parametros que vamos a procesar de la API
const client = new Client({
  intents: [
    "Guilds",
    "DirectMessageTyping",
    "GuildMembers",
    "GuildMessages",
    "GuildMessageTyping",
    "GuildInvites",
    "MessageContent",
  ],
});

// Usamos la librería node-handlers para registrar los eventos y los comandos del bot
EventHandler.dc.events(__dirname + "/events", client);
EventHandler.dc.commands(__dirname + "/commands", client);

// Le decimos al cliente que se conecte usando el token especificado
client.login(process.env.discord_token);

// Exportamos el cliente para llamarlo en nuestro archivo principal
module.exports = client;
