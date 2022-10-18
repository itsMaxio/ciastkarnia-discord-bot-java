package net.ciastkarnia;

import io.github.cdimascio.dotenv.Dotenv;
import net.ciastkarnia.listenerModule.Listener;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;

public class App {
    public static void main(String[] args) throws Exception {
            Dotenv dotenv = Dotenv.load();
            String token = dotenv.get("TOKEN");

            JDA bot = JDABuilder.createDefault(token, GatewayIntent.MESSAGE_CONTENT, GatewayIntent.GUILD_MESSAGES)
            .addEventListeners(new Listener())
            .build();
    }
}
