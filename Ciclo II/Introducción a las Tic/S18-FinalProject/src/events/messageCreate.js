// Requerimos o importamos las librerías que vamos a usar en este archivo
const recomendarEmbed = require("../utils/recomendarEmbed.js");
const config = require("../../config.json");

// Exportamos nuestro evento "messageCreate" que se ejecutara cada vez que el bot
// detecte un mensaje nuevo.
// Acá se ve el formato necesario para la librería "node-handlers"
module.exports = {
  name: "messageCreate",
  execute: async (msg, client) => {
    if (msg.author.id == client.user.id) return;

    evaluatePreset(msg);

    if (msg.content.includes("recomendar")) {
      msg.reply({
        embeds: [await recomendarEmbed()],
        ephemeral: true,
      });
    }
  },
};

async function evaluatePreset(msg) {
  for (const preset of config.presets) {
    switch (preset.type) {
      case "includes":
        for (const term of preset.terms) {
          if (msg.content.includes(term)) {
            await sendResp(msg, preset);
          }
        }
    }
  }
}

async function sendResp(msg, preset) {
  const resp = preset.resp[Math.floor(Math.random() * preset.resp.length)];

  switch (resp.type) {
    case "text-reply":
      msg.reply({
        content: resp.text,
      });
      break;
    case "recomendacion":
      msg.reply({
        embeds: [await recomendarEmbed()],
      });
      break;
  }
}
