// Requerimos o importamos las librerías que vamos a usar en este archivo
const { EmbedBuilder } = require("discord.js");
const config = require("../../config.json");

// Exportamos nuestro evento "guildMemberAdd" que se ejecutara cada vez que el bot
// detecte un nuevo cliente en nuestro servidor.
// Acá se ve el formato necesario para la librería "node-handlers"
module.exports = {
  name: "guildMemberAdd",
  execute: async (member) => {
    const welcomeChannel = await member.guild.channels.fetch(
      config.channels.welcome
    );

    const embed = new EmbedBuilder();
    embed.setThumbnail(member.displayAvatarURL());
    embed.setTitle("Bienvenido @" + member.displayName);
    embed.setDescription("Bienvenidos al mercado mundial de NFTS");
    embed.setColor("Green");
    embed.setImage("https://i.imgur.com/R88GDzV.jpg");
    embed.setAuthor({
      name: "Capybara Store",
      iconURL: member.guild.iconURL(),
      url: "https://capybara.com",
    });

    welcomeChannel.send({
      embeds: [embed],
    });
  },
};
