package com.deadside.bot.utils;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;

import java.awt.Color;
import java.time.Instant;

/**
 * Utility class for creating Discord message embeds
 * Uses Deadside-themed emerald color palette for consistency
 */
public class EmbedUtils {
    // Deadside themed color palette
    public static final Color DEADSIDE_PRIMARY = new Color(39, 174, 96);      // Primary emerald green
    public static final Color DEADSIDE_SECONDARY = new Color(46, 204, 113);   // Secondary emerald green
    public static final Color DEADSIDE_DARK = new Color(24, 106, 59);         // Darker emerald shade
    public static final Color DEADSIDE_LIGHT = new Color(88, 214, 141);       // Lighter emerald shade
    public static final Color DEADSIDE_ACCENT = new Color(26, 188, 156);      // Accent turquoise
    
    // Standard colors for different embed types (using Deadside palette)
    private static final Color SUCCESS_COLOR = DEADSIDE_SECONDARY;            // Success green
    private static final Color ERROR_COLOR = new Color(231, 76, 60);          // Error red
    private static final Color INFO_COLOR = DEADSIDE_PRIMARY;                 // Info emerald
    private static final Color WARNING_COLOR = new Color(243, 156, 18);       // Warning orange
    
    /**
     * Create a success embed
     */
    public static MessageEmbed successEmbed(String title, String description) {
        EmbedBuilder embed = new EmbedBuilder()
                .setTitle("✅ " + title)
                .setDescription(description)
                .setColor(SUCCESS_COLOR)
                .setFooter("Powered by Discord.gg/EmeraldServers", null)
                .setTimestamp(Instant.now());
        
        // Add logo thumbnail
        embed.setThumbnail(ResourceManager.getAttachmentString(ResourceManager.MAIN_LOGO));
        
        return embed.build();
    }
    
    /**
     * Create an error embed
     */
    public static MessageEmbed errorEmbed(String title, String description) {
        EmbedBuilder embed = new EmbedBuilder()
                .setTitle("❌ " + title)
                .setDescription(description)
                .setColor(ERROR_COLOR)
                .setFooter("Powered by Discord.gg/EmeraldServers", null)
                .setTimestamp(Instant.now());
        
        // Add logo thumbnail
        embed.setThumbnail(ResourceManager.getAttachmentString(ResourceManager.MAIN_LOGO));
        
        return embed.build();
    }
    
    /**
     * Create an info embed
     */
    public static MessageEmbed infoEmbed(String title, String description) {
        EmbedBuilder embed = new EmbedBuilder()
                .setTitle("ℹ️ " + title)
                .setDescription(description)
                .setColor(INFO_COLOR)
                .setFooter("Powered by Discord.gg/EmeraldServers", null)
                .setTimestamp(Instant.now());
        
        // Add logo thumbnail
        embed.setThumbnail(ResourceManager.getAttachmentString(ResourceManager.MAIN_LOGO));
        
        return embed.build();
    }
    
    /**
     * Create a warning embed
     */
    public static MessageEmbed warningEmbed(String title, String description) {
        EmbedBuilder embed = new EmbedBuilder()
                .setTitle("⚠️ " + title)
                .setDescription(description)
                .setColor(WARNING_COLOR)
                .setFooter("Powered by Discord.gg/EmeraldServers", null)
                .setTimestamp(Instant.now());
        
        // Add logo thumbnail
        embed.setThumbnail(ResourceManager.getAttachmentString(ResourceManager.MAIN_LOGO));
        
        return embed.build();
    }
    
    /**
     * Create a custom colored embed
     */
    public static MessageEmbed customEmbed(String title, String description, Color color) {
        return new EmbedBuilder()
                .setTitle(title)
                .setDescription(description)
                .setColor(color)
                .setTimestamp(Instant.now())
                .build();
    }
    
    /**
     * Create a custom colored embed with thumbnail
     */
    public static MessageEmbed customEmbedWithThumbnail(String title, String description, 
                                                       Color color, String thumbnailUrl) {
        return new EmbedBuilder()
                .setTitle(title)
                .setDescription(description)
                .setColor(color)
                .setThumbnail(thumbnailUrl)
                .setTimestamp(Instant.now())
                .build();
    }
    
    /**
     * Create a player stats embed
     */
    public static EmbedBuilder playerStatsEmbed(String playerName) {
        EmbedBuilder embed = new EmbedBuilder()
                .setTitle("📊 Stats for " + playerName)
                .setColor(DEADSIDE_ACCENT) // Accent color for stats
                .setFooter("Powered by Discord.gg/EmeraldServers", null)
                .setTimestamp(Instant.now());
                
        // Add logo thumbnail
        embed.setThumbnail(ResourceManager.getAttachmentString(ResourceManager.WEAPON_STATS_LOGO));
        
        return embed;
    }
    
    /**
     * Create a killfeed embed
     */
    public static MessageEmbed killfeedEmbed(String title, String description) {
        EmbedBuilder embed = new EmbedBuilder()
                .setTitle(title)
                .setDescription(description)
                .setColor(new Color(204, 0, 0)) // Dark red for killfeed (kept for visibility)
                .setFooter("Powered by Discord.gg/EmeraldServers", null)
                .setTimestamp(Instant.now());
                
        // Add logo thumbnail
        embed.setThumbnail(ResourceManager.getAttachmentString(ResourceManager.KILLFEED_LOGO));
        
        return embed.build();
    }
    
    /**
     * Create a faction embed
     */
    public static MessageEmbed factionEmbed(String title, String description, Color color) {
        EmbedBuilder embed = new EmbedBuilder()
                .setTitle("🛡️ " + title)
                .setDescription(description)
                .setColor(color != null ? color : DEADSIDE_PRIMARY)
                .setFooter("Powered by Discord.gg/EmeraldServers", null)
                .setTimestamp(Instant.now());
                
        // Add logo thumbnail
        embed.setThumbnail(ResourceManager.getAttachmentString(ResourceManager.FACTION_LOGO));
        
        return embed.build();
    }
    
    /**
     * Create an economy embed
     */
    public static MessageEmbed economyEmbed(String title, String description) {
        EmbedBuilder embed = new EmbedBuilder()
                .setTitle("💰 " + title)
                .setDescription(description)
                .setColor(DEADSIDE_SECONDARY)
                .setFooter("Powered by Discord.gg/EmeraldServers", null)
                .setTimestamp(Instant.now());
                
        // Add logo thumbnail
        embed.setThumbnail(ResourceManager.getAttachmentString(ResourceManager.TRADER_LOGO));
        
        return embed.build();
    }
    
    /**
     * Create a premium feature embed
     */
    public static MessageEmbed premiumEmbed(String title, String description) {
        EmbedBuilder embed = new EmbedBuilder()
                .setTitle("✨ " + title)
                .setDescription(description)
                .setColor(DEADSIDE_ACCENT)
                .setFooter("Powered by Discord.gg/EmeraldServers", null)
                .setTimestamp(Instant.now());
                
        // Add logo thumbnail  
        embed.setThumbnail(ResourceManager.getAttachmentString(ResourceManager.MAIN_LOGO));
        
        return embed.build();
    }
    
    /**
     * Create a server event embed
     */
    public static MessageEmbed eventEmbed(String title, String description) {
        EmbedBuilder embed = new EmbedBuilder()
                .setTitle("🔔 " + title)
                .setDescription(description)
                .setColor(DEADSIDE_DARK)
                .setFooter("Powered by Discord.gg/EmeraldServers", null)
                .setTimestamp(Instant.now());
                
        // Add logo thumbnail
        embed.setThumbnail(ResourceManager.getAttachmentString(ResourceManager.HELICRASH_LOGO));
        
        return embed.build();
    }
    
    /**
     * Create a bounty embed
     */
    public static MessageEmbed bountyEmbed(String title, String description) {
        EmbedBuilder embed = new EmbedBuilder()
                .setTitle("🏆 " + title)
                .setDescription(description)
                .setColor(DEADSIDE_SECONDARY)
                .setFooter("Powered by Discord.gg/EmeraldServers", null)
                .setTimestamp(Instant.now());
                
        // Add logo thumbnail
        embed.setThumbnail(ResourceManager.getAttachmentString(ResourceManager.BOUNTY_LOGO));
        
        return embed.build();
    }
    
    /**
     * Create an airdrop embed
     */
    public static MessageEmbed airdropEmbed(String title, String description) {
        EmbedBuilder embed = new EmbedBuilder()
                .setTitle("📦 " + title)
                .setDescription(description)
                .setColor(DEADSIDE_LIGHT)
                .setFooter("Powered by Discord.gg/EmeraldServers", null)
                .setTimestamp(Instant.now());
                
        // Add logo thumbnail
        embed.setThumbnail(ResourceManager.getAttachmentString(ResourceManager.AIRDROP_LOGO));
        
        return embed.build();
    }
    
    /**
     * Create a mission embed
     */
    public static MessageEmbed missionEmbed(String title, String description) {
        EmbedBuilder embed = new EmbedBuilder()
                .setTitle("🎯 " + title)
                .setDescription(description)
                .setColor(new Color(204, 51, 51)) // Red for missions
                .setFooter("Powered by Discord.gg/EmeraldServers", null)
                .setTimestamp(Instant.now());
                
        // Add logo thumbnail
        embed.setThumbnail(ResourceManager.getAttachmentString(ResourceManager.MISSION_LOGO));
        
        return embed.build();
    }
    
    /**
     * Create a connections embed
     */
    public static MessageEmbed connectionsEmbed(String title, String description) {
        EmbedBuilder embed = new EmbedBuilder()
                .setTitle("🔗 " + title)
                .setDescription(description)
                .setColor(DEADSIDE_ACCENT)
                .setFooter("Powered by Discord.gg/EmeraldServers", null)
                .setTimestamp(Instant.now());
                
        // Add logo thumbnail
        embed.setThumbnail(ResourceManager.getAttachmentString(ResourceManager.CONNECTIONS_LOGO));
        
        return embed.build();
    }
    
    /**
     * Create a standard PvP killfeed embed with themed messaging
     * Enhanced with PvP aesthetic integration as part of Embed System Excellence Sweep
     *
     * @param killer The name of the player who made the kill
     * @param victim The name of the player who was killed
     * @param weapon The weapon used in the kill
     * @param distance The distance of the kill in meters
     * @return A styled killfeed embed following latest theming guidelines
     */
    public static MessageEmbed pvpKillfeedEmbed(String killer, String victim, String weapon, int distance) {
        // Dynamic titles with stronger combat focus for PvP aesthetics
        String[] titles = {
            "ELIMINATION CONFIRMED",
            "NO SURVIVORS", 
            "PRECISION ELIMINATED",
            "DEADSIDE CASUALTY",
            "HOSTILE NEUTRALIZED",
            "TARGET SILENCED"
        };
        
        // Dynamic descriptions for killfeed with enhanced PvP aesthetics
        String[] messages = {
            String.format("Clean headshot at %dm.", distance),
            String.format("%s never saw it coming from %dm away.", victim, distance),
            String.format("One %s round was all it took.", weapon),
            String.format("%dm shot with perfect accuracy.", distance),
            String.format("%s's aim with the %s was lethal.", killer, weapon),
            String.format("No chance to react at %dm range.", distance)
        };
        
        String[] contextMessages = {
            "The wasteland claims another victim.",
            "Another survivor's journey ends.",
            "Clean shot. No time to react.",
            "Deadside demands blood tribute.",
            "There is no hiding in the wasteland.",
            "Survival requires constant vigilance."
        };
        
        // Random selection for variety
        int titleIndex = (int)(Math.random() * titles.length);
        int msgIndex = (int)(Math.random() * messages.length);
        int contextIndex = (int)(Math.random() * contextMessages.length);
        
        // Server information
        String serverName = "Emerald EU"; // Default server name
        String time = java.time.LocalDateTime.now().format(java.time.format.DateTimeFormatter.ofPattern("HH:mm:ss"));
        
        // Create embed with the correct styling per design guidelines
        // Updated with darker shade for better visual impact in PvP focused aesthetics
        EmbedBuilder embed = new EmbedBuilder()
                .setTitle(titles[titleIndex])
                .setDescription(killer + "\neliminated " + victim + " with " + weapon)
                .setColor(new Color(20, 20, 20)) // Even darker gray background for dramatic effect
                .addField("", messages[msgIndex], false)
                .addField("", contextMessages[contextIndex], false)
                .setFooter("Server: " + serverName + " | discord.gg/EmeraldServers | " + time)
                .setTimestamp(Instant.now());
                
        // Add thumbnail logo - enhanced with consistent resource loading
        embed.setThumbnail(ResourceManager.getAttachmentString(ResourceManager.KILLFEED_LOGO));
                
        return embed.build();
    }
    
    /**
     * Create a specialized PvP achievement embed that highlights combat excellence
     * Enhanced as part of the PvP aesthetic integration to create a consistent visual theme
     *
     * @param playerName Name of the player being highlighted
     * @param achievement The specific PvP achievement being recognized
     * @param stats Optional statistics to showcase with the achievement
     * @return A styled embed focused on PvP achievements
     */
    public static MessageEmbed pvpAchievementEmbed(String playerName, String achievement, String stats) {
        EmbedBuilder embed = new EmbedBuilder()
                .setTitle("⚔️ COMBAT EXCELLENCE: " + achievement.toUpperCase())
                .setDescription(playerName + " has achieved **" + achievement + "**")
                .setColor(new Color(77, 25, 25)) // Dark red for combat focus
                .addField("ACHIEVEMENT DETAILS", stats, false)
                .addField("DEADSIDE ELITE", "High-performance combat recognition", false)
                .setFooter("Powered by Discord.gg/EmeraldServers")
                .setTimestamp(Instant.now());
                
        // Add thumbnail logo with improved resource handling
        embed.setThumbnail(ResourceManager.getAttachmentString(ResourceManager.WEAPON_STATS_LOGO));
                
        return embed.build();
    }
    
    /**
     * Create a kill streak notification embed
     * This is trackable through our system by counting consecutive kills for a player
     * Enhanced as part of the PvP aesthetic integration
     *
     * @param playerName Name of the player on a kill streak
     * @param streakCount Number of consecutive kills
     * @return A styled embed focusing on the kill streak achievement
     */
    public static MessageEmbed killStreakEmbed(String playerName, int streakCount) {
        // Different titles based on streak level
        String title;
        String description;
        Color color;
        
        if (streakCount >= 10) {
            title = "🔥 UNSTOPPABLE FORCE";
            description = playerName + " is **DOMINATING** with a " + streakCount + " kill streak!";
            color = new Color(153, 0, 0); // Deep red for high streaks
        } else if (streakCount >= 5) {
            title = "🔥 RAMPAGE";
            description = playerName + " is on a **" + streakCount + " KILL STREAK**!";
            color = new Color(204, 51, 0); // Orange-red for medium streaks
        } else if (streakCount >= 3) {
            title = "🔥 KILL STREAK";
            description = playerName + " has eliminated " + streakCount + " survivors in succession!";
            color = new Color(255, 102, 0); // Orange for starting streaks
        } else {
            // We shouldn't be calling this for streaks less than 3
            title = "MULTI-KILL";
            description = playerName + " has eliminated " + streakCount + " survivors!";
            color = DEADSIDE_ACCENT;
        }
        
        EmbedBuilder embed = new EmbedBuilder()
                .setTitle(title)
                .setDescription(description)
                .setColor(color)
                .addField("WASTELAND DOMINANCE", 
                       "The wasteland trembles at the approach of " + playerName + "\n" +
                       "Current victims: **" + streakCount + "**", false)
                .setFooter("Powered by Discord.gg/EmeraldServers")
                .setTimestamp(Instant.now());
                
        // Use weapon stats logo for kill streaks
        embed.setThumbnail(ResourceManager.getAttachmentString(ResourceManager.WEAPON_STATS_LOGO));
                
        return embed.build();
    }
    
    // We've removed the PvP headshot embed since headshots are not trackable in our system

    /**
     * Create a long-range kill embed for highlighting impressive distance shots
     * Enhanced as part of the PvP aesthetic integration for visual consistency
     * 
     * @param shooter Player who made the long shot
     * @param victim Player who was eliminated
     * @param weapon Weapon used for the elimination
     * @param distance Distance of the shot
     * @param serverName Optional server name for footer
     * @return A stylized embed focused on long-range achievements
     */
    public static MessageEmbed longRangeKillEmbed(String shooter, String victim, String weapon, int distance, String serverName) {
        // Verify we're only celebrating truly impressive distances (over 200m)
        if (distance < 200) {
            // Fall back to standard PvP killfeed for non-impressive distances
            return pvpKillfeedEmbed(shooter, victim, weapon, distance);
        }
        
        // Impressive long shot messages with stronger PvP aesthetic
        String[] longShotMessages = {
            "EXTREME RANGE ELIMINATION",
            "SHARPSHOOTER EXCELLENCE", 
            "LETHAL PRECISION",
            "DISTANCE DOMINATION",
            "DEADSIDE SNIPER ELITE",
            "STRATEGIC ELIMINATION"
        };
        
        // Distance classification with enhanced PvP focus
        String rangeClass;
        String additionalContext;
        
        if (distance > 500) {
            rangeClass = "LEGENDARY";
            additionalContext = "This shot has entered Deadside history.";
        } else if (distance > 350) {
            rangeClass = "EXCEPTIONAL";
            additionalContext = "Few can match this level of precision.";
        } else {
            rangeClass = "IMPRESSIVE";
            additionalContext = "A display of superior marksmanship.";
        }
        
        // Random title selection
        int titleIndex = (int)(Math.random() * longShotMessages.length);
        
        // Server info for footer
        if (serverName == null || serverName.isEmpty()) {
            serverName = "Emerald EU"; // Default if not provided
        }
        String time = java.time.LocalDateTime.now().format(java.time.format.DateTimeFormatter.ofPattern("HH:mm:ss"));
        
        // Create a visually distinct embed for long range kills with enhanced styling
        EmbedBuilder embed = new EmbedBuilder()
                .setTitle("🔭 " + longShotMessages[titleIndex])
                .setDescription(shooter + " eliminated " + victim + " from\n" +
                               "**" + distance + " METERS** away with " + weapon)
                .setColor(new Color(0, 51, 102)) // Deep blue for long range
                .addField(rangeClass + " RANGE", 
                          "Distance: **" + distance + "m**\n" +
                          "Weapon: " + weapon + "\n" +
                          additionalContext, false)
                .addField("TACTICAL SUPERIORITY", 
                          "Long-range mastery is the mark of an elite survivor.\n" +
                          shooter + " has demonstrated exceptional skill.", false)
                .setFooter("Server: " + serverName + " | discord.gg/EmeraldServers | " + time)
                .setTimestamp(Instant.now());
                
        // Add thumbnail logo with consistent resource handling
        embed.setThumbnail(ResourceManager.getAttachmentString(ResourceManager.WEAPON_STATS_LOGO));
                
        return embed.build();
    }
    
    /**
     * Overloaded method for backward compatibility
     */
    public static MessageEmbed longRangeKillEmbed(String shooter, String victim, String weapon, int distance) {
        return longRangeKillEmbed(shooter, victim, weapon, distance, null);
    }

    /**
     * Create a suicide embed (including menu suicide) with themed messaging
     * Enhanced with PvP aesthetic integration as part of Embed System Excellence Sweep
     *
     * @param victim The name of the player who committed suicide
     * @param cause The cause of death (e.g., "Menu Suicide")
     * @param serverName Optional server name for footer
     * @return A styled suicide embed following updated theming guidelines
     */
    public static MessageEmbed suicideEmbed(String victim, String cause, String serverName) {
        // Normalize "Suicide_by_relocation" to "Menu Suicide" as per Phase 5 requirements
        if (cause.equalsIgnoreCase("Suicide_by_relocation")) {
            cause = "Menu Suicide";
        }
        
        // Dynamic titles enhanced for PvP aesthetic integration
        String[] titles = {
            "SELF-TERMINATION LOGGED",
            "SILENT EXIT",
            "COMBAT RESOLUTION",
            "WASTELAND DEPARTURE",
            "FINAL SOLUTION",
            "TACTICAL RETREAT"
        };
        
        // Dynamic descriptions based on cause, enhanced for PvP aesthetic integration
        String[] descriptions;
        String[] messages;
        String[] contextMessages;
        
        if (cause.equalsIgnoreCase("Menu Suicide")) {
            descriptions = new String[] {
                "found the ultimate exit strategy",
                "chose a permanent solution",
                "couldn't handle the wasteland anymore",
                "left the battlefield temporarily",
                "executed a tactical disconnect"
            };
            
            messages = new String[] {
                "Menu navigation claimed another victim.",
                "Sometimes the biggest threat is yourself.",
                "They chose the easy way out.",
                "The Deadside claims all eventually.",
                "Even the menu can be deadly in this world."
            };
        } else {
            descriptions = new String[] {
                "chose to end their journey",
                "returned to the void",
                "decided their time was up",
                "embraced the wasteland's darkness",
                "succumbed to inner demons"
            };
            
            messages = new String[] {
                "Self-elimination confirmed.",
                "Sometimes the biggest threat is yourself.",
                "Another soul lost to their own demons.",
                "The wasteland doesn't forgive weakness.",
                "Only the strongest survive in Deadside."
            };
        }
        
        contextMessages = new String[] {
            "In the wasteland, your worst enemy is often yourself.",
            "The mind breaks before the body in this harsh world.",
            "No rescue. No respawn. Just the void.",
            "Survival requires both physical and mental strength.",
            "Every death is a lesson in the art of survival."
        };
        
        // Random selection for variety
        int titleIndex = (int)(Math.random() * titles.length);
        int descIndex = (int)(Math.random() * descriptions.length);
        int msgIndex = (int)(Math.random() * messages.length);
        int contextIndex = (int)(Math.random() * contextMessages.length);
        
        // Server information
        if (serverName == null || serverName.isEmpty()) {
            serverName = "Emerald EU"; // Default if not provided
        }
        String time = java.time.LocalDateTime.now().format(java.time.format.DateTimeFormatter.ofPattern("HH:mm:ss"));
        
        // Create embed with enhanced styling for PvP aesthetic integration
        return new EmbedBuilder()
                .setTitle(titles[titleIndex])
                .setDescription(victim + "\n" + descriptions[descIndex])
                .setColor(new Color(20, 20, 20)) // Darker gray background for more dramatic effect
                .addField("", messages[msgIndex], false)
                .addField("", contextMessages[contextIndex], false)
                .setFooter("Server: " + serverName + " | discord.gg/EmeraldServers | " + time)
                .setTimestamp(Instant.now())
                .setThumbnail(ResourceManager.getAttachmentString(ResourceManager.KILLFEED_LOGO))
                .build();
    }
    
    /**
     * Overloaded method for suicide embed backward compatibility
     */
    public static MessageEmbed suicideEmbed(String victim, String cause) {
        return suicideEmbed(victim, cause, null);
    }
    
    /**
     * Create a falling death embed with themed messaging
     * Enhanced as part of the PvP aesthetic integration
     *
     * @param victim The name of the player who died from falling
     * @param height The height of the fall (optional, can be 0 if unknown)
     * @param serverName Optional server name for footer
     * @return A styled falling death embed following updated theming guidelines
     */
    public static MessageEmbed fallingDeathEmbed(String victim, int height, String serverName) {
        // Dynamic titles enhanced for PvP aesthetic integration
        String[] titles = {
            "TERMINAL VELOCITY",
            "GRAVITY CLAIMED ANOTHER",
            "DEADLY ENCOUNTER",
            "VERTICAL FATALITY",
            "FAILED DESCENT",
            "WASTELAND GRAVITY CHECK"
        };
        
        // Dynamic descriptions with expanded options
        String[] descriptions = {
            "took the easy way out",
            "fell from a great height",
            "discovered gravity's unforgiving nature",
            "misjudged a tactical descent",
            "made a faulty landing calculation",
            "forgot parachutes don't exist in Deadside"
        };
        
        // Dynamic messages with enhanced theming
        String[] messages = {
            "Gravity: 1, Player: 0.",
            "They didn't fall. They descended.",
            "The ground doesn't negotiate.",
            "Even elite survivors respect the physics of Deadside.",
            "Altitude awareness is a survival skill too.",
            "High ground advantage: lost."
        };
        
        String[] contextMessages = {
            "Sometimes the most dangerous weapon is the one in your hands.",
            "The wasteland claims victims in many ways.",
            "No safety nets in Deadside.",
            "Tactical movement requires knowing your limitations.",
            "Elevation changes require proper planning.",
            "Even the environment is hostile in the wasteland."
        };
        
        // Add height context if available
        if (height > 0) {
            messages = new String[] {
                String.format("Gravity: 1, Player: 0. (Fell %dm)", height),
                String.format("They didn't fall. They descended %dm.", height),
                String.format("The %dm drop proved fatal.", height),
                String.format("A %dm drop is beyond human endurance.", height),
                String.format("Terminal velocity reached at %dm.", height),
                String.format("%dm free fall - no survivors.", height)
            };
        }
        
        // Random selection for variety
        int titleIndex = (int)(Math.random() * titles.length);
        int descIndex = (int)(Math.random() * descriptions.length);
        int msgIndex = (int)(Math.random() * messages.length);
        int contextIndex = (int)(Math.random() * contextMessages.length);
        
        // Server information
        if (serverName == null || serverName.isEmpty()) {
            serverName = "Emerald EU"; // Default if not provided
        }
        String time = java.time.LocalDateTime.now().format(java.time.format.DateTimeFormatter.ofPattern("HH:mm:ss"));
        
        // Create embed with enhanced styling for PvP aesthetic integration
        return new EmbedBuilder()
                .setTitle(titles[titleIndex])
                .setDescription(victim + "\n" + descriptions[descIndex])
                .setColor(new Color(20, 20, 20)) // Even darker gray background for dramatic effect
                .addField("", messages[msgIndex], false)
                .addField("", contextMessages[contextIndex], false)
                .setFooter("Server: " + serverName + " | discord.gg/EmeraldServers | " + time)
                .setTimestamp(Instant.now())
                .setThumbnail(ResourceManager.getAttachmentString(ResourceManager.KILLFEED_LOGO))
                .build();
    }
    
    /**
     * Overloaded method for backward compatibility
     */
    public static MessageEmbed fallingDeathEmbed(String victim, int height) {
        return fallingDeathEmbed(victim, height, null);
    }
    
    /**
     * Create a server-wide PvP leaderboard embed
     * Part of the PvP aesthetic integration
     * 
     * @param topPlayers List of top players (max 10)
     * @param serverName Optional server name for footer
     * @return A styled embed showing server leaderboard
     */
    public static MessageEmbed pvpLeaderboardEmbed(List<Map<String, Object>> topPlayers, String serverName) {
        // Validate and limit player list
        if (topPlayers == null) {
            topPlayers = new ArrayList<>();
        }
        
        int playerCount = Math.min(topPlayers.size(), 10); // Max 10 players
        
        // Server information
        if (serverName == null || serverName.isEmpty()) {
            serverName = "Emerald EU"; // Default if not provided
        }
        String time = java.time.LocalDateTime.now().format(java.time.format.DateTimeFormatter.ofPattern("HH:mm:ss"));
        
        // Build the leaderboard content
        StringBuilder leaderboardText = new StringBuilder();
        
        if (playerCount == 0) {
            leaderboardText.append("No player data available yet.");
        } else {
            for (int i = 0; i < playerCount; i++) {
                Map<String, Object> player = topPlayers.get(i);
                String playerName = (String)player.get("name");
                int kills = player.get("kills") instanceof Integer ? (Integer)player.get("kills") : 0;
                int deaths = player.get("deaths") instanceof Integer ? (Integer)player.get("deaths") : 0;
                double kdr = deaths > 0 ? (double)kills / deaths : kills;
                
                leaderboardText.append(String.format("**%d.** %s - **%d** kills - KDR: **%.2f**\n", 
                                                   i+1, playerName, kills, kdr));
            }
        }
        
        // Create embed with enhanced styling for PvP aesthetic integration
        EmbedBuilder embed = new EmbedBuilder()
                .setTitle("🏆 DEADSIDE DOMINANCE LEADERBOARD")
                .setDescription("Top survivors ranked by combat performance")
                .setColor(DEADSIDE_ACCENT) // Use our brand color
                .addField("ELITE COMBATANTS", leaderboardText.toString(), false)
                .addField("COMBAT INTELLIGENCE", 
                          "Rankings are updated in real-time based on verified kills.\n" +
                          "Only the strongest survive in the wasteland.", false)
                .setFooter("Server: " + serverName + " | discord.gg/EmeraldServers | " + time)
                .setTimestamp(Instant.now())
                .setThumbnail(ResourceManager.getAttachmentString(ResourceManager.WEAPON_STATS_LOGO));
        
        return embed.build();
    }
    
    /**
     * Overloaded method for backward compatibility
     */
    public static MessageEmbed pvpLeaderboardEmbed(List<Map<String, Object>> topPlayers) {
        return pvpLeaderboardEmbed(topPlayers, null);
    }
    
    /**
     * Create a PvP statistics embed for displaying player performance
     * Part of the PvP aesthetic integration
     * 
     * @param playerName Player whose stats are being displayed
     * @param kills Number of kills
     * @param deaths Number of deaths
     * @param kdr Kill/death ratio
     * @param weapon Most used weapon (if available, can be null)
     * @param serverName Optional server name for footer
     * @return A styled embed focusing on PvP statistics
     */
    /**
     * Create a detailed PvP player profile embed with comprehensive stats
     * Enhanced as part of the PvP aesthetic integration
     *
     * @param player The Player object containing all player statistics
     * @param serverName Optional server name for footer
     * @return A styled embed with detailed player combat profile
     */
    public static MessageEmbed detailedPvpProfileEmbed(com.deadside.bot.db.models.Player player, String serverName) {
        if (player == null) {
            return errorEmbed("Player Profile Error", "No player data available.");
        }
        
        String playerName = player.getName();
        int kills = player.getKills();
        int deaths = player.getDeaths();
        int suicides = player.getSuicides();
        double kdr = player.getKdRatio();
        int score = player.getScore();
        
        // Get weapon expertise info
        String weaponInfo;
        if (player.getMostUsedWeapon() != null && !player.getMostUsedWeapon().isEmpty()) {
            weaponInfo = "**" + player.getMostUsedWeapon() + "**\n" +
                         kills > 0 ? 
                           String.format("%.1f%% of kills (%d)", 
                               (float) player.getMostUsedWeaponKills() * 100 / kills,
                               player.getMostUsedWeaponKills()) :
                           "No confirmed kills yet";
        } else {
            weaponInfo = "No specialized weapon yet";
        }
        
        // Get player rivalry info
        String rivalryInfo = "";
        if (player.getMostKilledPlayer() != null && !player.getMostKilledPlayer().isEmpty()) {
            rivalryInfo += "Top Victim: **" + player.getMostKilledPlayer() + "** (" + 
                          player.getMostKilledPlayerCount() + " eliminations)\n";
        }
        
        if (player.getKilledByMost() != null && !player.getKilledByMost().isEmpty()) {
            rivalryInfo += "Main Adversary: **" + player.getKilledByMost() + "** (" + 
                          player.getKilledByMostCount() + " deaths)";
        }
        
        if (rivalryInfo.isEmpty()) {
            rivalryInfo = "No established rivalries yet";
        }
        
        // Competitive ranking determination based on KDR and total kills
        String rankTitle;
        String rankDescription;
        Color rankColor;
        
        if (kdr >= 3.0 && kills >= 20) {
            rankTitle = "APEX PREDATOR";
            rankDescription = "Elite tier wasteland hunter with overwhelming dominance";
            rankColor = new Color(153, 0, 0); // Deep red for top players
        } else if (kdr >= 2.0 || (kdr >= 1.5 && kills >= 15)) {
            rankTitle = "VETERAN HUNTER";
            rankDescription = "Highly skilled combatant with notable kill record";
            rankColor = new Color(204, 51, 0); // Orange-red for skilled players
        } else if (kdr >= 1.0 || (kdr >= 0.8 && kills >= 10)) {
            rankTitle = "DEADSIDE WARRIOR";
            rankDescription = "Competent survivor with positive elimination record";
            rankColor = DEADSIDE_ACCENT; // Standard brand color
        } else if (kdr >= 0.5 || kills >= 5) {
            rankTitle = "SURVIVOR";
            rankDescription = "Learning the wasteland's dangers through experience";
            rankColor = DEADSIDE_DARK; // Darker brand color
        } else {
            rankTitle = "RECRUIT";
            rankDescription = "Still finding their footing in the unforgiving wasteland";
            rankColor = DEADSIDE_SECONDARY; // Secondary brand color
        }
        
        // Calculate combat efficiency (kills per death, excluding suicides)
        String efficiencyRating;
        if (deaths == 0) {
            efficiencyRating = "∞ (Flawless)";
        } else {
            double efficiency = (double) kills / deaths;
            if (efficiency >= 2.5) efficiencyRating = "S+ (Elite)";
            else if (efficiency >= 2.0) efficiencyRating = "S (Exceptional)";
            else if (efficiency >= 1.5) efficiencyRating = "A (Superior)";
            else if (efficiency >= 1.0) efficiencyRating = "B (Proficient)";
            else if (efficiency >= 0.7) efficiencyRating = "C (Average)";
            else if (efficiency >= 0.4) efficiencyRating = "D (Developing)";
            else efficiencyRating = "E (Novice)";
        }
        
        // Server information
        if (serverName == null || serverName.isEmpty()) {
            serverName = "Emerald EU"; // Default if not provided
        }
        String time = java.time.LocalDateTime.now().format(java.time.format.DateTimeFormatter.ofPattern("HH:mm:ss"));
        
        // Create embed with enhanced styling for PvP aesthetic integration
        EmbedBuilder embed = new EmbedBuilder()
                .setTitle("⚔️ COMBAT PROFILE: " + playerName.toUpperCase())
                .setDescription(playerName + " - **" + rankTitle + "**")
                .setColor(rankColor)
                .addField("COMBAT STATISTICS", 
                          "Eliminations: **" + kills + "**\n" +
                          "Deaths: **" + deaths + "**\n" +
                          "Suicides: **" + suicides + "**\n" +
                          "K/D Ratio: **" + String.format("%.2f", kdr) + "**\n" +
                          "Score: **" + score + "**", true)
                .addField("WEAPON EXPERTISE", weaponInfo, true)
                .addField("COMBAT ASSESSMENT", rankDescription + "\n" +
                          "Efficiency Rating: **" + efficiencyRating + "**", false)
                .addField("RIVALRIES", rivalryInfo, false)
                .setFooter("Server: " + serverName + " | discord.gg/EmeraldServers | " + time)
                .setTimestamp(Instant.now())
                .setThumbnail(ResourceManager.getAttachmentString(ResourceManager.WEAPON_STATS_LOGO));
        
        return embed.build();
    }
    
    /**
     * Create a basic PvP statistics embed for displaying player performance
     * Part of the PvP aesthetic integration
     *
     * @param playerName Player whose stats are being displayed
     * @param kills Number of kills
     * @param deaths Number of deaths
     * @param kdr Kill/death ratio
     * @param weapon Most used weapon (if available, can be null)
     * @param serverName Optional server name for footer
     * @return A styled embed focusing on PvP statistics
     */
    public static MessageEmbed pvpStatisticsEmbed(String playerName, int kills, int deaths, 
                                                 double kdr, String weapon, String serverName) {
        // Optional weapon info
        String weaponInfo = (weapon != null && !weapon.isEmpty()) ? 
                            "Weapon of Choice: " + weapon : 
                            "Varied arsenal deployed";
        
        // Competitive ranking determination based on KDR
        String rankTitle;
        String rankDescription;
        
        if (kdr >= 3.0) {
            rankTitle = "APEX PREDATOR";
            rankDescription = "Elite tier wasteland hunter";
        } else if (kdr >= 2.0) {
            rankTitle = "VETERAN HUNTER";
            rankDescription = "Highly skilled combatant";
        } else if (kdr >= 1.0) {
            rankTitle = "DEADSIDE WARRIOR";
            rankDescription = "Competent survivor";
        } else if (kdr >= 0.5) {
            rankTitle = "SURVIVOR";
            rankDescription = "Learning the wasteland's dangers";
        } else {
            rankTitle = "RECRUIT";
            rankDescription = "Still finding their footing";
        }
        
        // Server information
        if (serverName == null || serverName.isEmpty()) {
            serverName = "Emerald EU"; // Default if not provided
        }
        String time = java.time.LocalDateTime.now().format(java.time.format.DateTimeFormatter.ofPattern("HH:mm:ss"));
        
        // Create embed with enhanced styling for PvP aesthetic integration
        EmbedBuilder embed = new EmbedBuilder()
                .setTitle("⚔️ COMBAT RECORD: " + playerName.toUpperCase())
                .setDescription(playerName + " - " + rankTitle)
                .setColor(DEADSIDE_ACCENT) // Use our brand color
                .addField("COMBAT STATISTICS", 
                          "Eliminations: **" + kills + "**\n" +
                          "Deaths: **" + deaths + "**\n" +
                          "K/D Ratio: **" + String.format("%.2f", kdr) + "**\n" +
                          weaponInfo, false)
                .addField("ASSESSMENT", 
                          rankDescription + "\n" +
                          "Continue monitoring for performance changes.", false)
                .setFooter("Server: " + serverName + " | discord.gg/EmeraldServers | " + time)
                .setTimestamp(Instant.now())
                .setThumbnail(ResourceManager.getAttachmentString(ResourceManager.WEAPON_STATS_LOGO));
        
        return embed.build();
    }
    
    /**
     * Overloaded method for backward compatibility
     */
    public static MessageEmbed pvpStatisticsEmbed(String playerName, int kills, int deaths, double kdr, String weapon) {
        return pvpStatisticsEmbed(playerName, kills, deaths, kdr, weapon, null);
    }
    
    /**
     * Create a weapon mastery embed showing player's proficiency with specific weapons
     * Part of the PvP aesthetic integration
     * 
     * @param playerName Player whose weapon stats are being displayed
     * @param weaponStats Map of weapon names to kill counts
     * @param totalKills Total number of player kills
     * @param serverName Optional server name for footer
     * @return A styled embed focusing on weapon mastery
     */
    public static MessageEmbed weaponMasteryEmbed(String playerName, Map<String, Integer> weaponStats, 
                                                 int totalKills, String serverName) {
        if (weaponStats == null || weaponStats.isEmpty()) {
            return simpleEmbed("Weapon Mastery", 
                              "No weapon statistics available for " + playerName + " yet.", 
                              DEADSIDE_ACCENT);
        }
        
        // Find the most used weapon
        String topWeapon = "";
        int topWeaponKills = 0;
        
        for (Map.Entry<String, Integer> entry : weaponStats.entrySet()) {
            if (entry.getValue() > topWeaponKills) {
                topWeapon = entry.getKey();
                topWeaponKills = entry.getValue();
            }
        }
        
        // Sort weapons by kill count
        List<Map.Entry<String, Integer>> sortedWeapons = new ArrayList<>(weaponStats.entrySet());
        sortedWeapons.sort((a, b) -> b.getValue().compareTo(a.getValue()));
        
        // Build weapon statistics display
        StringBuilder weaponDisplay = new StringBuilder();
        int displayCount = Math.min(5, sortedWeapons.size()); // Top 5 weapons
        
        for (int i = 0; i < displayCount; i++) {
            Map.Entry<String, Integer> entry = sortedWeapons.get(i);
            double percentage = totalKills > 0 ? (entry.getValue() * 100.0) / totalKills : 0;
            
            weaponDisplay.append(String.format("**%s**: %d kills (%.1f%%)\n", 
                                             entry.getKey(), entry.getValue(), percentage));
        }
        
        // Weapon mastery assessment
        String masteryTitle;
        String masteryDescription;
        
        if (topWeaponKills >= 25) {
            masteryTitle = "WEAPON MASTER";
            masteryDescription = "Expert marksman with exceptional lethality";
        } else if (topWeaponKills >= 15) {
            masteryTitle = "EXPERIENCED MARKSMAN";
            masteryDescription = "Highly proficient with their weapon of choice";
        } else if (topWeaponKills >= 10) {
            masteryTitle = "COMPETENT SHOOTER";
            masteryDescription = "Shows good understanding of their chosen armament";
        } else if (topWeaponKills >= 5) {
            masteryTitle = "DEVELOPING GUNNER";
            masteryDescription = "Beginning to show preference for specific loadouts";
        } else {
            masteryTitle = "VERSATILE SURVIVOR";
            masteryDescription = "Uses whatever weapons the wasteland provides";
        }
        
        // Server information
        if (serverName == null || serverName.isEmpty()) {
            serverName = "Emerald EU"; // Default if not provided
        }
        String time = java.time.LocalDateTime.now().format(java.time.format.DateTimeFormatter.ofPattern("HH:mm:ss"));
        
        // Create embed with enhanced styling for PvP aesthetic integration
        EmbedBuilder embed = new EmbedBuilder()
                .setTitle("🎯 ARSENAL ANALYSIS: " + playerName.toUpperCase())
                .setDescription(playerName + " - **" + masteryTitle + "**")
                .setColor(DEADSIDE_ACCENT)
                .addField("PRIMARY LOADOUT", 
                         !topWeapon.isEmpty() ? 
                         "Signature Weapon: **" + topWeapon + "**\n" +
                         String.format("Confirmed Kills: **%d** (%.1f%% of total)", 
                                     topWeaponKills, 
                                     totalKills > 0 ? (topWeaponKills * 100.0) / totalKills : 0) :
                         "No preferred weapon identified", false)
                .addField("WEAPON STATISTICS", weaponDisplay.toString(), false)
                .addField("COMBAT ASSESSMENT", masteryDescription, false)
                .setFooter("Server: " + serverName + " | discord.gg/EmeraldServers | " + time)
                .setTimestamp(Instant.now())
                .setThumbnail(ResourceManager.getAttachmentString(ResourceManager.WEAPON_STATS_LOGO));
        
        return embed.build();
    }
    
    /**
     * Overloaded method for backward compatibility
     */
    public static MessageEmbed weaponMasteryEmbed(String playerName, Map<String, Integer> weaponStats, int totalKills) {
        return weaponMasteryEmbed(playerName, weaponStats, totalKills, null);
    }
    
    /**
     * Create a player rivalry embed showing a detailed breakdown of a specific player vs player relationship
     * Part of the PvP aesthetic integration
     * 
     * @param player1Name First player name
     * @param player2Name Second player name
     * @param player1Kills Number of times player1 killed player2
     * @param player2Kills Number of times player2 killed player1
     * @param serverName Optional server name for footer
     * @return A styled embed showing player rivalry statistics
     */
    public static MessageEmbed rivalryEmbed(String player1Name, String player2Name, 
                                          int player1Kills, int player2Kills, String serverName) {
        // Determine who has the advantage
        String dominantPlayer;
        String challengerPlayer;
        int dominantKills;
        int challengerKills;
        String rivalryStatus;
        
        if (player1Kills > player2Kills) {
            dominantPlayer = player1Name;
            challengerPlayer = player2Name;
            dominantKills = player1Kills;
            challengerKills = player2Kills;
            rivalryStatus = "DOMINATING";
        } else if (player2Kills > player1Kills) {
            dominantPlayer = player2Name;
            challengerPlayer = player1Name;
            dominantKills = player2Kills;
            challengerKills = player1Kills;
            rivalryStatus = "DOMINATING";
        } else {
            // It's a tie
            dominantPlayer = player1Name;
            challengerPlayer = player2Name;
            dominantKills = player1Kills;
            challengerKills = player2Kills;
            rivalryStatus = "DEADLOCKED";
        }
        
        int killDifferential = Math.abs(player1Kills - player2Kills);
        double killRatio = challengerKills > 0 ? 
                          (double) dominantKills / challengerKills : 
                          dominantKills;
        
        // Server information
        if (serverName == null || serverName.isEmpty()) {
            serverName = "Emerald EU"; // Default if not provided
        }
        String time = java.time.LocalDateTime.now().format(java.time.format.DateTimeFormatter.ofPattern("HH:mm:ss"));
        
        // Rivalry intensity description
        String intensityDesc;
        if (killDifferential >= 10) {
            intensityDesc = "One-sided massacre";
        } else if (killDifferential >= 5) {
            intensityDesc = "Significant advantage";
        } else if (killDifferential >= 3) {
            intensityDesc = "Clear edge";
        } else if (killDifferential >= 1) {
            intensityDesc = "Slight advantage";
        } else {
            intensityDesc = "Perfect balance";
        }
        
        // Total engagements and intensity
        int totalEngagements = player1Kills + player2Kills;
        String rivalryIntensity;
        
        if (totalEngagements >= 20) {
            rivalryIntensity = "LEGENDARY FEUD";
        } else if (totalEngagements >= 10) {
            rivalryIntensity = "BITTER ENEMIES";
        } else if (totalEngagements >= 5) {
            rivalryIntensity = "EMERGING RIVALRY";
        } else {
            rivalryIntensity = "FIRST ENCOUNTERS";
        }
        
        // Create embed with enhanced styling for PvP aesthetic integration
        EmbedBuilder embed = new EmbedBuilder()
                .setTitle("⚡ PLAYER RIVALRY: " + player1Name.toUpperCase() + " vs " + player2Name.toUpperCase())
                .setDescription("**" + rivalryIntensity + "** - " + intensityDesc)
                .setColor(new Color(153, 0, 51)) // Deep red for rivalries
                .addField("RIVALRY STATISTICS", 
                          player1Name + " eliminations: **" + player1Kills + "**\n" +
                          player2Name + " eliminations: **" + player2Kills + "**\n" +
                          "Total engagements: **" + totalEngagements + "**\n" +
                          "Differential: **" + killDifferential + "**", false)
                .addField("CURRENT STATUS", 
                         rivalryStatus.equals("DEADLOCKED") ?
                         "The hunters are evenly matched." :
                         "**" + dominantPlayer + "** is " + rivalryStatus + " with a " + 
                         String.format("%.1f", killRatio) + ":1 ratio", false)
                .setFooter("Server: " + serverName + " | discord.gg/EmeraldServers | " + time)
                .setTimestamp(Instant.now())
                .setThumbnail(ResourceManager.getAttachmentString(ResourceManager.KILLFEED_LOGO));
        
        return embed.build();
    }
    
    /**
     * Overloaded method for backward compatibility
     */
    public static MessageEmbed rivalryEmbed(String player1Name, String player2Name, int player1Kills, int player2Kills) {
        return rivalryEmbed(player1Name, player2Name, player1Kills, player2Kills, null);
    }
    
    /**
     * Create an embed for player death streaks (multiple deaths without kills)
     * Part of the PvP aesthetic integration
     * 
     * @param playerName The player on a death streak
     * @param deathCount Number of consecutive deaths
     * @param killers List of players who caused the deaths (can be null or empty)
     * @param serverName Optional server name for footer
     * @return A styled embed for death streaks
     */
    public static MessageEmbed deathStreakEmbed(String playerName, int deathCount, 
                                              List<String> killers, String serverName) {
        // Validate death count
        if (deathCount <= 0) {
            deathCount = 1; // Minimum 1 death
        }
        
        // Generate streak description based on severity
        String streakTitle;
        String streakDescription;
        Color streakColor;
        
        if (deathCount >= 10) {
            streakTitle = "CATASTROPHIC COLLAPSE";
            streakDescription = "A truly disastrous series of encounters";
            streakColor = new Color(139, 0, 0); // Dark red
        } else if (deathCount >= 7) {
            streakTitle = "BRUTAL DECIMATION";
            streakDescription = "A merciless sequence of eliminations";
            streakColor = new Color(178, 34, 34); // Firebrick red
        } else if (deathCount >= 5) {
            streakTitle = "SUSTAINED ASSAULT";
            streakDescription = "A challenging series of defeats";
            streakColor = new Color(205, 92, 92); // Indian red
        } else if (deathCount >= 3) {
            streakTitle = "ROUGH PATCH";
            streakDescription = "A difficult stretch of encounters";
            streakColor = new Color(233, 150, 122); // Dark salmon
        } else {
            streakTitle = "SETBACK";
            streakDescription = "A temporary lapse in survival";
            streakColor = new Color(250, 128, 114); // Salmon
        }
        
        // Process killers information
        StringBuilder killersInfo = new StringBuilder();
        if (killers != null && !killers.isEmpty()) {
            // Count occurrences of each killer
            Map<String, Integer> killerCounts = new HashMap<>();
            for (String killer : killers) {
                killerCounts.put(killer, killerCounts.getOrDefault(killer, 0) + 1);
            }
            
            // Sort killers by kill count
            List<Map.Entry<String, Integer>> sortedKillers = new ArrayList<>(killerCounts.entrySet());
            sortedKillers.sort((a, b) -> b.getValue().compareTo(a.getValue()));
            
            // Build killers display (limited to top 3)
            int displayCount = Math.min(3, sortedKillers.size());
            for (int i = 0; i < displayCount; i++) {
                Map.Entry<String, Integer> entry = sortedKillers.get(i);
                killersInfo.append(String.format("**%s**: %d elimination%s\n", 
                                               entry.getKey(), 
                                               entry.getValue(),
                                               entry.getValue() > 1 ? "s" : ""));
            }
            
            // If there are more killers than we displayed
            if (sortedKillers.size() > displayCount) {
                killersInfo.append(String.format("... and %d more\n", sortedKillers.size() - displayCount));
            }
        } else {
            killersInfo.append("Unknown assailants");
        }
        
        // Server information
        if (serverName == null || serverName.isEmpty()) {
            serverName = "Emerald EU"; // Default if not provided
        }
        String time = java.time.LocalDateTime.now().format(java.time.format.DateTimeFormatter.ofPattern("HH:mm:ss"));
        
        // Create embed with enhanced styling for PvP aesthetic integration
        EmbedBuilder embed = new EmbedBuilder()
                .setTitle("💀 DEATH STREAK: " + playerName.toUpperCase())
                .setDescription("**" + streakTitle + "** - " + deathCount + " consecutive deaths")
                .setColor(streakColor)
                .addField("STREAK ANALYSIS", streakDescription + "\n" +
                         "Survival rate has significantly decreased.", false)
                .addField("PRIMARY THREATS", killersInfo.toString(), false)
                .addField("RECOVERY STRATEGY", 
                         "• Reassess tactical approach\n" +
                         "• Consider alternative routes\n" +
                         "• Evaluate loadout effectiveness\n" + 
                         "• Regroup with allies when possible", false)
                .setFooter("Server: " + serverName + " | discord.gg/EmeraldServers | " + time)
                .setTimestamp(Instant.now())
                .setThumbnail(ResourceManager.getAttachmentString(ResourceManager.KILLFEED_LOGO));
        
        return embed.build();
    }
    
    /**
     * Overloaded method for backward compatibility
     */
    public static MessageEmbed deathStreakEmbed(String playerName, int deathCount, List<String> killers) {
        return deathStreakEmbed(playerName, deathCount, killers, null);
    }
    
    /**
     * Create a server event embed for special game events like airdrops or helicrashes
     * Part of the PvP aesthetic integration
     * 
     * @param eventType Type of event (AIRDROP, HELICRASH, etc.)
     * @param location Event location or coordinates
     * @param timestamp Event timestamp (can be null for current time)
     * @param serverName Optional server name for footer
     * @return A styled embed for server events
     */
    public static MessageEmbed serverEventEmbed(String eventType, String location, 
                                              Instant timestamp, String serverName) {
        // Normalize event type
        String normalizedEventType = eventType.toUpperCase().trim();
        
        // Determine event details based on type
        String eventTitle;
        String eventDescription;
        Color eventColor;
        String thumbnailKey;
        
        switch (normalizedEventType) {
            case "AIRDROP":
                eventTitle = "SUPPLY DROP INBOUND";
                eventDescription = "A cargo plane has released valuable supplies";
                eventColor = new Color(65, 105, 225); // Royal blue
                thumbnailKey = ResourceManager.AIRDROP_LOGO;
                break;
            case "HELICRASH":
                eventTitle = "HELICOPTER CRASH SITE";
                eventDescription = "A military helicopter has crashed with valuable equipment";
                eventColor = new Color(178, 34, 34); // Firebrick red
                thumbnailKey = ResourceManager.HELICRASH_LOGO;
                break;
            case "TRADER":
                eventTitle = "TRADER CARAVAN";
                eventDescription = "A wandering merchant has set up shop temporarily";
                eventColor = new Color(218, 165, 32); // Goldenrod
                thumbnailKey = ResourceManager.TRADER_LOGO;
                break;
            case "MISSION":
                eventTitle = "SPECIAL MISSION";
                eventDescription = "A high-value objective has been detected";
                eventColor = new Color(0, 100, 0); // Dark green
                thumbnailKey = ResourceManager.MISSION_LOGO;
                break;
            default:
                eventTitle = normalizedEventType;
                eventDescription = "A special event has been detected";
                eventColor = DEADSIDE_ACCENT;
                thumbnailKey = ResourceManager.MAIN_LOGO;
        }
        
        // Use current time if not provided
        if (timestamp == null) {
            timestamp = Instant.now();
        }
        
        // Server information
        if (serverName == null || serverName.isEmpty()) {
            serverName = "Emerald EU"; // Default if not provided
        }
        String time = java.time.LocalDateTime.now().format(java.time.format.DateTimeFormatter.ofPattern("HH:mm:ss"));
        
        // Create embed with enhanced styling for PvP aesthetic integration
        EmbedBuilder embed = new EmbedBuilder()
                .setTitle("🔔 " + eventTitle)
                .setDescription(eventDescription)
                .setColor(eventColor)
                .addField("LOCATION", location != null && !location.isEmpty() ? 
                         location : "Unknown coordinates", true)
                .addField("EVENT TIME", 
                         DateTimeFormatter.ofPattern("HH:mm:ss").withZone(ZoneId.systemDefault())
                         .format(timestamp), true)
                .addField("STRATEGIC VALUE", 
                         "• High-tier equipment possible\n" +
                         "• Expect significant player convergence\n" +
                         "• Approach with caution", false)
                .setFooter("Server: " + serverName + " | discord.gg/EmeraldServers | " + time)
                .setTimestamp(timestamp)
                .setThumbnail(ResourceManager.getAttachmentString(thumbnailKey));
        
        return embed.build();
    }
    
    /**
     * Overloaded method for backward compatibility
     */
    public static MessageEmbed serverEventEmbed(String eventType, String location, Instant timestamp) {
        return serverEventEmbed(eventType, location, timestamp, null);
    }
    
    /**
     * Create a kill streak embed for players on a streak of multiple kills without dying
     * Part of the PvP aesthetic integration
     * 
     * @param playerName The player on a kill streak
     * @param killCount Number of consecutive kills
     * @param victims List of victims (can be null or empty)
     * @param weaponsUsed List of weapons used (can be null or empty)
     * @param serverName Optional server name for footer
     * @return A styled embed for kill streaks
     */
    public static MessageEmbed killStreakEmbed(String playerName, int killCount, 
                                             List<String> victims, List<String> weaponsUsed, String serverName) {
        // Validate kill count
        if (killCount <= 0) {
            killCount = 1; // Minimum 1 kill
        }
        
        // Generate streak description based on severity
        String streakTitle;
        String streakDescription;
        Color streakColor;
        
        if (killCount >= 10) {
            streakTitle = "UNSTOPPABLE RAMPAGE";
            streakDescription = "A truly dominating display of deadliness";
            streakColor = new Color(139, 0, 0); // Dark red
        } else if (killCount >= 7) {
            streakTitle = "KILLING SPREE";
            streakDescription = "A merciless sequence of eliminations";
            streakColor = new Color(178, 34, 34); // Firebrick red
        } else if (killCount >= 5) {
            streakTitle = "BLOODBATH";
            streakDescription = "An impressive streak of eliminations";
            streakColor = new Color(205, 92, 92); // Indian red
        } else if (killCount >= 3) {
            streakTitle = "KILLING FRENZY";
            streakDescription = "A focused series of successful hunts";
            streakColor = new Color(220, 20, 60); // Crimson
        } else {
            streakTitle = "DOUBLE KILL";
            streakDescription = "Back-to-back eliminations";
            streakColor = new Color(255, 0, 0); // Red
        }
        
        // Process victims information
        StringBuilder victimsInfo = new StringBuilder();
        if (victims != null && !victims.isEmpty()) {
            // Count occurrences of each victim
            Map<String, Integer> victimCounts = new HashMap<>();
            for (String victim : victims) {
                victimCounts.put(victim, victimCounts.getOrDefault(victim, 0) + 1);
            }
            
            // Sort victims by kill count
            List<Map.Entry<String, Integer>> sortedVictims = new ArrayList<>(victimCounts.entrySet());
            sortedVictims.sort((a, b) -> b.getValue().compareTo(a.getValue()));
            
            // Build victims display (limited to top 3)
            int displayCount = Math.min(3, sortedVictims.size());
            for (int i = 0; i < displayCount; i++) {
                Map.Entry<String, Integer> entry = sortedVictims.get(i);
                victimsInfo.append(String.format("**%s**: %d time%s\n", 
                                               entry.getKey(), 
                                               entry.getValue(),
                                               entry.getValue() > 1 ? "s" : ""));
            }
            
            // If there are more victims than we displayed
            if (sortedVictims.size() > displayCount) {
                victimsInfo.append(String.format("... and %d more\n", sortedVictims.size() - displayCount));
            }
        } else {
            victimsInfo.append("Unknown victims");
        }
        
        // Process weapons information
        StringBuilder weaponsInfo = new StringBuilder();
        if (weaponsUsed != null && !weaponsUsed.isEmpty()) {
            // Count occurrences of each weapon
            Map<String, Integer> weaponCounts = new HashMap<>();
            for (String weapon : weaponsUsed) {
                weaponCounts.put(weapon, weaponCounts.getOrDefault(weapon, 0) + 1);
            }
            
            // Sort weapons by usage count
            List<Map.Entry<String, Integer>> sortedWeapons = new ArrayList<>(weaponCounts.entrySet());
            sortedWeapons.sort((a, b) -> b.getValue().compareTo(a.getValue()));
            
            // Build weapons display (limited to top 3)
            int displayCount = Math.min(3, sortedWeapons.size());
            for (int i = 0; i < displayCount; i++) {
                Map.Entry<String, Integer> entry = sortedWeapons.get(i);
                weaponsInfo.append(String.format("**%s**: %d kill%s\n", 
                                               entry.getKey(), 
                                               entry.getValue(),
                                               entry.getValue() > 1 ? "s" : ""));
            }
            
            // If there are more weapons than we displayed
            if (sortedWeapons.size() > displayCount) {
                weaponsInfo.append("... and other equipment\n");
            }
        } else {
            weaponsInfo.append("Various weapons");
        }
        
        // Server information
        if (serverName == null || serverName.isEmpty()) {
            serverName = "Emerald EU"; // Default if not provided
        }
        String time = java.time.LocalDateTime.now().format(java.time.format.DateTimeFormatter.ofPattern("HH:mm:ss"));
        
        // Create embed with enhanced styling for PvP aesthetic integration
        EmbedBuilder embed = new EmbedBuilder()
                .setTitle("🔥 KILL STREAK: " + playerName.toUpperCase())
                .setDescription("**" + streakTitle + "** - " + killCount + " consecutive kills")
                .setColor(streakColor)
                .addField("STREAK ANALYSIS", streakDescription + "\n" +
                         "Combat efficiency at peak performance!", false)
                .addField("PREFERRED ARMAMENT", weaponsInfo.toString(), true)
                .addField("ELIMINATED TARGETS", victimsInfo.toString(), true)
                .setFooter("Server: " + serverName + " | discord.gg/EmeraldServers | " + time)
                .setTimestamp(Instant.now())
                .setThumbnail(ResourceManager.getAttachmentString(ResourceManager.KILLFEED_LOGO));
        
        return embed.build();
    }
    
    /**
     * Overloaded method for backward compatibility
     */
    public static MessageEmbed killStreakEmbed(String playerName, int killCount, List<String> victims, List<String> weaponsUsed) {
        return killStreakEmbed(playerName, killCount, victims, weaponsUsed, null);
    }
}