// Requerimos o importamos las librerías que vamos a usar en este archivo
const recomendarEmbed = require("../utils/recomendarEmbed.js");

// Exportamos nuestro comando "recomendar"
// Acá se ve el formato necesario para la librería "node-handlers"
module.exports = {
  name: "recomendar",
  description: "Un comando para recomendar un producto",
  type: 1,
  execute: async (interaction) => {
    interaction.reply({
      embeds: [await recomendarEmbed()],
      ephemeral: true,
    });
  },
};
