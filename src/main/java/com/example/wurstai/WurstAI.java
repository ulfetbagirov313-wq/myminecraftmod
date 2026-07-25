package com.example.wurstai;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.message.v1.ServerMessageEvents;
import net.minecraft.network.message.SignedMessage;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.Locale;

public class WurstAI implements ModInitializer {
    public static final String MOD_ID = "wurstai";

    @Override
    public void onInitialize() {
        ServerMessageEvents.CHAT_MESSAGE.register((SignedMessage message, ServerPlayerEntity sender, net.minecraft.network.message.MessageType.Parameters params) -> {
            String msgContent = message.getContent().getString().toLowerCase(Locale.ROOT);

            if (msgContent.contains("wurstai")) {
                String response = generateAIResponse(msgContent, sender.getName().getString());
                
                if (response != null) {
                    Text aiText = Text.literal("[wurstAI] " + response)
                            .formatted(Formatting.GREEN, Formatting.BOLD);
                    
                    if (sender.getServer() != null) {
                        sender.getServer().getPlayerManager().broadcast(aiText, false);
                    }
                }
            }
        });
    }

    private String generateAIResponse(String input, String playerName) {
        if (input.contains("salam") || input.contains("hello") || input.contains("hi") || input.contains("hey")) {
            return "Hello " + playerName + "! How can I assist you today?";
        } else if (input.contains("who are you") || input.contains("kimsin") || input.contains("what are you")) {
            return "I am wurstAI, your artificial intelligence assistant in Minecraft!";
        } else if (input.contains("help") || input.contains("komek") || input.contains("kömək")) {
            return "Need help? Just ask your question with 'wurstAI' in the chat!";
        } else if (input.contains("bye") || input.contains("sag ol") || input.contains("sağol")) {
            return "Goodbye " + playerName + "! Happy crafting!";
        } else if (input.contains("how are you") || input.contains("necesen") || input.contains("necəsən")) {
            return "I am functioning at full capacity! How are you doing, " + playerName + "?";
        } else {
            return "Hello " + playerName + "! I heard you mention my name. How is your Minecraft world?";
        }
    }
                        }
                        
