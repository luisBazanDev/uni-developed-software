// Exportamos nuestro evento "interactionCreate" que se ejecutara cada vez que el bot
// detecte una nueva interacción de un cliente con nuestra aplicación.
// Acá se ve el formato necesario para la librería "node-handlers"
module.exports = {
  name: "interactionCreate",
  once: false,
  async execute(interaction, client) {
    if (interaction.isCommand()) {
      const command = client.slashcmds.find((cmd) => {
        return cmd.name === interaction.commandName;
      });

      if (!command) return;

      try {
        await command.execute(interaction);
      } catch (error) {
        console.error(error);
        await interaction.reply({
          content: "There was an error while executing this command!",
          ephemeral: true,
        });
      }
    }
  },
};
