// Requerimos o importamos las librerías que vamos a usar en este archivo
const Discord = require("discord.js");
const request = require("request-promise");
const config = require("../../config.json");

// Exportamos la función que va a crear nuestro mensaje embed con un producto
module.exports = async () => {
  const term =
    config.terms[Math.floor(Math.random() * (config.terms.length - 1))];

  const item = new Discord.EmbedBuilder();

  const data = JSON.parse(
    await request({
      url: "https://lexica.art/api/v1/search?q=" + term.split(" ").join("-"),
    })
  );
  const elem = data.images.filter((i) => !i.nsfw && !i.grid)[
    Math.floor(Math.random() * (data.images.filter((i) => !i.nsfw).length - 1))
  ];

  if (!elem) return;

  item.setTitle("Te recomiendo este producto!");
  item.addFields([
    {
      name: "Nombre:",
      value: elem.prompt,
      inline: false,
    },
    {
      name: "Precio:",
      value: `${Math.floor(Math.random() * 2)}.${Math.floor(
        Math.random() * 100
      )} ${config.emojis.ethereum}`,
      inline: true,
    },
    {
      name: "Tamaño:",
      value: `${elem.width}x${elem.height}px`,
      inline: true,
    },
    {
      name: "Autor:",
      value: elem.model,
      inline: true,
    },
  ]);

  item.setImage(elem.src);

  return item;
};
