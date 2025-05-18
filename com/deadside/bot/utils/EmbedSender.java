package com.deadside.bot.utils;

import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.InteractionHook;
import net.dv8tion.jda.api.utils.FileUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Utility class for sending embeds with attached logos
 * Enhanced as part of the Embed System Excellence Sweep for PvP aesthetic integration
 */
public class EmbedSender {
    private static final Logger logger = LoggerFactory.getLogger(EmbedSender.class);
    private static final Pattern ATTACHMENT_PATTERN = Pattern.compile("attachment://([\\w\\d.]+)");

    /**
     * Send a reply to a slash command with an embed and all necessary attachments
     * Enhanced to support multiple attachments and better fallback mechanisms
     * 
     * @param event The slash command event
     * @param embed The embed to send
     * @param ephemeral Whether the reply should be ephemeral
     */
    public static void replyEmbed(SlashCommandInteractionEvent event, MessageEmbed embed, boolean ephemeral) {
        try {
            // Extract all attachment filenames from the embed
            List<String> attachmentFilenames = extractAttachmentFilenames(embed);
            
            // If there are no attachments, just send the embed
            if (attachmentFilenames.isEmpty()) {
                event.replyEmbeds(embed).setEphemeral(ephemeral).queue();
                return;
            }
            
            // Build list of FileUpload objects for all needed attachments
            List<FileUpload> fileUploads = new ArrayList<>();
            for (String fileName : attachmentFilenames) {
                FileUpload upload = getLogoFileUpload(fileName);
                if (upload != null) {
                    fileUploads.add(upload);
                }
            }
            
            // If we have attachments, send with them
            if (!fileUploads.isEmpty()) {
                // Send with attachments
                event.replyEmbeds(embed)
                     .addFiles(fileUploads)
                     .setEphemeral(ephemeral)
                     .queue(
                         success -> logger.debug("Successfully sent embed with {} attachments", fileUploads.size()),
                         error -> {
                             logger.error("Failed to send embed with attachments: {}", error.getMessage());
                             // Fallback to just the embed on error
                             event.replyEmbeds(embed).setEphemeral(ephemeral).queue();
                         }
                     );
            } else {
                // Fallback to just the embed without attachments
                logger.warn("No valid attachments found for embed, sending without thumbnails");
                event.replyEmbeds(embed).setEphemeral(ephemeral).queue();
            }
        } catch (Exception e) {
            logger.error("Error sending embed with attachments: {}", e.getMessage(), e);
            
            // Fallback to just the embed
            event.replyEmbeds(embed).setEphemeral(ephemeral).queue();
        }
    }
    
    /**
     * Send an embed via an interaction hook with all necessary attachments
     * Enhanced to support multiple attachments and better fallback mechanisms
     * 
     * @param hook The interaction hook
     * @param embed The embed to send
     */
    public static void sendEmbed(InteractionHook hook, MessageEmbed embed) {
        try {
            // Extract all attachment filenames from the embed
            List<String> attachmentFilenames = extractAttachmentFilenames(embed);
            
            // If there are no attachments, just send the embed
            if (attachmentFilenames.isEmpty()) {
                hook.sendMessageEmbeds(embed).queue();
                return;
            }
            
            // Build list of FileUpload objects for all needed attachments
            List<FileUpload> fileUploads = new ArrayList<>();
            for (String fileName : attachmentFilenames) {
                FileUpload upload = getLogoFileUpload(fileName);
                if (upload != null) {
                    fileUploads.add(upload);
                }
            }
            
            // If we have attachments, send with them
            if (!fileUploads.isEmpty()) {
                // Send with attachments
                hook.sendMessageEmbeds(embed)
                    .addFiles(fileUploads)
                    .queue(
                        success -> logger.debug("Successfully sent embed with {} attachments", fileUploads.size()),
                        error -> {
                            logger.error("Failed to send embed with attachments: {}", error.getMessage());
                            // Fallback to just the embed on error
                            hook.sendMessageEmbeds(embed).queue();
                        }
                    );
            } else {
                // Fallback to just the embed without attachments
                logger.warn("No valid attachments found for embed, sending without thumbnails");
                hook.sendMessageEmbeds(embed).queue();
            }
        } catch (Exception e) {
            logger.error("Error sending embed with attachments: {}", e.getMessage(), e);
            
            // Fallback to just the embed
            hook.sendMessageEmbeds(embed).queue();
        }
    }
    
    /**
     * Send an embed with multiple attachments to a specific channel
     * New method added for the PvP aesthetic integration
     * 
     * @param channel The channel to send to
     * @param embed The embed to send
     */
    public static void sendEmbedToChannel(net.dv8tion.jda.api.entities.channel.middleman.MessageChannel channel, MessageEmbed embed) {
        try {
            // Extract all attachment filenames from the embed
            List<String> attachmentFilenames = extractAttachmentFilenames(embed);
            
            // If there are no attachments, just send the embed
            if (attachmentFilenames.isEmpty()) {
                channel.sendMessageEmbeds(embed).queue();
                return;
            }
            
            // Build list of FileUpload objects for all needed attachments
            List<FileUpload> fileUploads = new ArrayList<>();
            for (String fileName : attachmentFilenames) {
                FileUpload upload = getLogoFileUpload(fileName);
                if (upload != null) {
                    fileUploads.add(upload);
                }
            }
            
            // If we have attachments, send with them
            if (!fileUploads.isEmpty()) {
                // Send with attachments
                channel.sendMessageEmbeds(embed)
                       .addFiles(fileUploads)
                       .queue(
                           success -> logger.debug("Successfully sent embed to channel with {} attachments", fileUploads.size()),
                           error -> {
                               logger.error("Failed to send embed to channel with attachments: {}", error.getMessage());
                               // Fallback to just the embed on error
                               channel.sendMessageEmbeds(embed).queue();
                           }
                       );
            } else {
                // Fallback to just the embed without attachments
                logger.warn("No valid attachments found for embed, sending without thumbnails");
                channel.sendMessageEmbeds(embed).queue();
            }
        } catch (Exception e) {
            logger.error("Error sending embed to channel: {}", e.getMessage(), e);
            
            // Fallback to just the embed
            channel.sendMessageEmbeds(embed).queue();
        }
    }
    
    /**
     * Extract attachment filenames from an embed
     * This ensures all referenced attachments get loaded correctly
     * 
     * @param embed The embed to extract from
     * @return List of filenames referenced in the embed
     */
    public static List<String> extractAttachmentFilenames(MessageEmbed embed) {
        List<String> filenames = new ArrayList<>();
        
        // Check thumbnail - most important for right-side display
        if (embed.getThumbnail() != null && embed.getThumbnail().getUrl() != null) {
            String url = embed.getThumbnail().getUrl();
            if (url.startsWith("attachment://")) {
                String filename = url.substring("attachment://".length());
                filenames.add(filename);
            }
        }
        
        // Check image
        if (embed.getImage() != null && embed.getImage().getUrl() != null) {
            String url = embed.getImage().getUrl();
            if (url.startsWith("attachment://")) {
                String filename = url.substring("attachment://".length());
                filenames.add(filename);
            }
        }
        
        // Check author icon
        if (embed.getAuthor() != null && embed.getAuthor().getIconUrl() != null) {
            String url = embed.getAuthor().getIconUrl();
            if (url.startsWith("attachment://")) {
                String filename = url.substring("attachment://".length());
                filenames.add(filename);
            }
        }
        
        // Check footer icon
        if (embed.getFooter() != null && embed.getFooter().getIconUrl() != null) {
            String url = embed.getFooter().getIconUrl();
            if (url.startsWith("attachment://")) {
                String filename = url.substring("attachment://".length());
                filenames.add(filename);
            }
        }
        
        return filenames;
    }
    
    /**
     * Get a logo file as a FileUpload
     * Enhanced version with better fallback mechanisms
     * 
     * @param fileName The name of the logo file
     * @return A FileUpload object or null if not found
     */
    private static FileUpload getLogoFileUpload(String fileName) {
        try {
            // Use the file directly if possible
            File imageFile = ResourceManager.ensureImageFile(fileName);
            if (imageFile != null && imageFile.exists() && imageFile.canRead()) {
                return FileUpload.fromData(imageFile, fileName);
            }
            
            // Fallback to stream if file doesn't exist directly
            InputStream logoStream = ResourceManager.getResourceAsStream(fileName);
            if (logoStream != null) {
                return FileUpload.fromData(logoStream, fileName);
            }
            
            // Last resort - always try to send main logo instead of nothing
            if (!fileName.equals(ResourceManager.MAIN_LOGO)) {
                logger.warn("Logo file not found: {}. Using main logo as fallback.", fileName);
                return getLogoFileUpload(ResourceManager.MAIN_LOGO);
            }
            
            logger.error("Critical error: Main logo not found! Embeds will display without thumbnails.");
            return null;
        } catch (Exception e) {
            logger.error("Error getting logo file {}: {}", fileName, e.getMessage());
            
            // Try main logo if this wasn't already
            if (!fileName.equals(ResourceManager.MAIN_LOGO)) {
                try {
                    return getLogoFileUpload(ResourceManager.MAIN_LOGO);
                } catch (Exception ignored) {
                    // If even this fails, we give up
                }
            }
            
            return null;
        }
    }
}