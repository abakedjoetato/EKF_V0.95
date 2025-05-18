#!/bin/bash

echo "=== Building and running complete Deadside Discord Bot ==="

# Export environment variables
export DISCORD_TOKEN="${BOT_TOKEN}"
export MONGODB_URI="${MONGO_URI}"

# Ensure resources directory exists
mkdir -p src/main/resources/images

# Copy any images from attached_assets to resources
if [ -d "attached_assets" ]; then
  echo "Copying logo images to resources directory..."
  cp -f attached_assets/*.png src/main/resources/images/ 2>/dev/null || :
fi

# Build with Maven
echo "Building with Maven..."
mvn clean compile

# Run the bot with all classes and dependencies
echo "Starting the complete bot..."
mvn exec:java -Dexec.mainClass="com.deadside.bot.Main"