package com.deadside.bot.utils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Utility class for managing access to bot resources like images
 * Enhanced as part of the Embed System Excellence Sweep
 */
public class ResourceManager {
    private static final Logger logger = LoggerFactory.getLogger(ResourceManager.class);
    
    // Base path for resources (multiple options for failover)
    private static final String[] RESOURCE_PATHS = {
        "src/main/resources/images/",
        "attached_assets/",
        "com/deadside/bot/resources/images/",
        "target/classes/images/",
        "images/"
    };
    
    // Image file names - all transparent PNGs for Deadside-themed consistency
    public static final String MAIN_LOGO = "Mainlogo.png";
    public static final String KILLFEED_LOGO = "Killfeed.png";
    public static final String BOUNTY_LOGO = "Bounty.png";
    public static final String FACTION_LOGO = "Faction.png";
    public static final String TRADER_LOGO = "Trader.png";
    public static final String AIRDROP_LOGO = "Airdrop.png";
    public static final String HELICRASH_LOGO = "Helicrash.png";
    public static final String MISSION_LOGO = "Mission.png";
    public static final String WEAPON_STATS_LOGO = "WeaponStats.png";
    public static final String CONNECTIONS_LOGO = "Connections.png";
    
    // Cache to avoid repeated file lookups
    private static final Map<String, File> fileCache = new HashMap<>();
    private static final Map<String, String> attachmentCache = new HashMap<>();
    
    /**
     * Get the URL for a resource image with improved file location logic
     * 
     * @param imageName The image filename to locate
     * @return The URL for the resource, or fallback to main logo if not found
     */
    public static String getImageUrl(String imageName) {
        try {
            // Check cache first
            if (fileCache.containsKey(imageName)) {
                File cachedFile = fileCache.get(imageName);
                if (cachedFile.exists()) {
                    return cachedFile.toURI().toString();
                } else {
                    // Remove invalid cache entry
                    fileCache.remove(imageName);
                }
            }
            
            // Try all resource paths in order
            for (String path : RESOURCE_PATHS) {
                File file = new File(path + imageName);
                if (file.exists() && file.isFile() && file.canRead()) {
                    // Cache the result
                    fileCache.put(imageName, file);
                    logger.debug("Found image in {}: {}", path, file.getAbsolutePath());
                    return file.toURI().toString();
                }
            }
            
            // Try classpath resources
            URL url = ResourceManager.class.getClassLoader().getResource("images/" + imageName);
            if (url != null) {
                logger.debug("Found image in classpath: {}", url);
                return url.toString();
            }
            
            // If we can't find the specific image, use the main logo as a fallback
            logger.warn("Image not found: {}. Using main logo as fallback.", imageName);
            
            // Try to find the main logo in any location
            for (String path : RESOURCE_PATHS) {
                File file = new File(path + MAIN_LOGO);
                if (file.exists() && file.isFile() && file.canRead()) {
                    return file.toURI().toString();
                }
            }
            
            // Absolute last resort - never display embeds without images
            return "attachment://Mainlogo.png";
        } catch (Exception e) {
            logger.error("Error getting image URL for {}: {}", imageName, e.getMessage());
            return "attachment://Mainlogo.png";
        }
    }
    
    /**
     * Get the main logo URL
     */
    public static String getMainLogoUrl() {
        return getImageUrl(MAIN_LOGO);
    }
    
    /**
     * Get the killfeed logo URL
     */
    public static String getKillfeedLogoUrl() {
        return getImageUrl(KILLFEED_LOGO);
    }
    
    /**
     * Get the bounty logo URL
     */
    public static String getBountyLogoUrl() {
        return getImageUrl(BOUNTY_LOGO);
    }
    
    /**
     * Get the faction logo URL
     */
    public static String getFactionLogoUrl() {
        return getImageUrl(FACTION_LOGO);
    }
    
    /**
     * Get the trader logo URL
     */
    public static String getTraderLogoUrl() {
        return getImageUrl(TRADER_LOGO);
    }
    
    /**
     * Get the airdrop logo URL
     */
    public static String getAirdropLogoUrl() {
        return getImageUrl(AIRDROP_LOGO);
    }
    
    /**
     * Get the helicrash logo URL
     */
    public static String getHelicrashLogoUrl() {
        return getImageUrl(HELICRASH_LOGO);
    }
    
    /**
     * Get the mission logo URL
     */
    public static String getMissionLogoUrl() {
        return getImageUrl(MISSION_LOGO);
    }
    
    /**
     * Get the weapon stats logo URL
     */
    public static String getWeaponStatsLogoUrl() {
        return getImageUrl(WEAPON_STATS_LOGO);
    }
    
    /**
     * Get the connections logo URL
     */
    public static String getConnectionsLogoUrl() {
        return getImageUrl(CONNECTIONS_LOGO);
    }
    
    /**
     * Get the attachment string for an image
     * Format: attachment://filename.png
     * This is the proper format for Discord embed thumbnails
     * Enhanced with caching to improve performance and reduce redundant operations
     * 
     * @param filename The image filename
     * @return The formatted attachment string
     */
    public static String getAttachmentString(String filename) {
        // Check cache first for performance
        if (attachmentCache.containsKey(filename)) {
            return attachmentCache.get(filename);
        }
        
        // For uniform appearance, make sure all filenames end with .png
        if (!filename.toLowerCase().endsWith(".png")) {
            filename = filename + ".png";
        }
        
        String attachmentString = "attachment://" + filename;
        attachmentCache.put(filename, attachmentString);
        
        return attachmentString;
    }
    
    /**
     * Ensures an image file is available for attachment to embeds
     * If the image doesn't exist, returns a File object for the main logo instead
     * This method is crucial for the PvP aesthetic integration in embeds
     * 
     * @param imageName The image filename to locate
     * @return File object for the requested image or fallback to main logo
     */
    public static File ensureImageFile(String imageName) {
        // Already has extension? If not, add .png
        if (!imageName.toLowerCase().endsWith(".png")) {
            imageName = imageName + ".png";
        }
        
        // Check cache first
        if (fileCache.containsKey(imageName)) {
            File cachedFile = fileCache.get(imageName);
            if (cachedFile.exists()) {
                return cachedFile;
            } else {
                // Remove invalid cache entry
                fileCache.remove(imageName);
            }
        }
        
        // Try all resource paths in order
        for (String path : RESOURCE_PATHS) {
            File file = new File(path + imageName);
            if (file.exists() && file.isFile() && file.canRead()) {
                // Cache the result
                fileCache.put(imageName, file);
                return file;
            }
        }
        
        // Fallback to main logo if specific image not found
        logger.warn("Image file not found: {}. Using main logo as fallback.", imageName);
        
        // Try to find main logo in any of our resource paths
        for (String path : RESOURCE_PATHS) {
            File file = new File(path + MAIN_LOGO);
            if (file.exists() && file.isFile() && file.canRead()) {
                fileCache.put(imageName, file); // Cache the fallback for this filename
                return file;
            }
        }
        
        // If all else fails, return null and log the error
        logger.error("Critical error: Could not find main logo for fallback!");
        return null;
    }
    
    /**
     * Get input stream for a resource image
     * Enhanced version with better resource location and fallback mechanisms
     * This is used to attach images to embed messages
     * 
     * @param imageName The image filename
     * @return InputStream for the image or null if not found
     */
    public static InputStream getResourceAsStream(String imageName) {
        try {
            // Get the actual file using our enhanced ensureImageFile method
            File imageFile = ensureImageFile(imageName);
            
            // If we have a valid file, return its input stream
            if (imageFile != null && imageFile.exists() && imageFile.canRead()) {
                return Files.newInputStream(imageFile.toPath());
            }
            
            // Last resort - try classpath resources with multiple paths
            for (String path : new String[] {
                "images/", 
                "resources/images/", 
                RESOURCE_PATHS[0],
                RESOURCE_PATHS[2]
            }) {
                InputStream stream = ResourceManager.class.getClassLoader().getResourceAsStream(path + imageName);
                if (stream != null) {
                    return stream;
                }
            }
            
            // If we can't find the specific image, try the main logo
            if (!imageName.equals(MAIN_LOGO)) {
                logger.warn("Image not found: {}. Attempting to use main logo as fallback.", imageName);
                return getResourceAsStream(MAIN_LOGO);
            }
            
            logger.error("Critical error: Failed to load any images including main logo!");
            return null;
        } catch (Exception e) {
            logger.error("Error getting image resource for {}: {}", imageName, e.getMessage());
            
            // If this wasn't already the main logo, try it as a last resort
            if (!imageName.equals(MAIN_LOGO)) {
                try {
                    return getResourceAsStream(MAIN_LOGO);
                } catch (Exception ignored) {
                    // If even this fails, we have to give up
                }
            }
            
            return null;
        }
    }
    
    /**
     * Validate all image resources and ensure they are available
     * This helps identify missing images at startup rather than during runtime
     * 
     * @return True if all critical images are available, false otherwise
     */
    public static boolean validateImageResources() {
        boolean allValid = true;
        String[] criticalImages = {
            MAIN_LOGO, KILLFEED_LOGO, BOUNTY_LOGO, FACTION_LOGO, 
            TRADER_LOGO, AIRDROP_LOGO, HELICRASH_LOGO, MISSION_LOGO, 
            WEAPON_STATS_LOGO, CONNECTIONS_LOGO
        };
        
        logger.info("Validating image resources...");
        
        for (String image : criticalImages) {
            File file = ensureImageFile(image);
            if (file == null || !file.exists() || !file.canRead()) {
                logger.warn("Critical image resource not found: {}", image);
                allValid = false;
            } else {
                logger.debug("Validated image resource: {}", image);
            }
        }
        
        if (allValid) {
            logger.info("All image resources validated successfully");
        } else {
            logger.warn("Some image resources could not be validated - embeds may not display correctly");
        }
        
        return allValid;
    }
}