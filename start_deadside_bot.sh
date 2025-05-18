#!/bin/bash

echo "=== Starting Deadside Discord Bot ==="

# Make sure config.properties has the required environment variables
if [ -f "config.properties" ]; then
  # Add environment variables to config.properties if they don't exist
  if ! grep -q "discord.token=" config.properties || grep -q "discord.token=$" config.properties; then
    sed -i "s|discord.token=.*|discord.token=${BOT_TOKEN}|g" config.properties
    echo "Updated discord.token in config.properties"
  fi
  
  if ! grep -q "mongodb.uri=" config.properties || grep -q "mongodb.uri=$" config.properties; then
    sed -i "s|mongodb.uri=.*|mongodb.uri=${MONGO_URI}|g" config.properties
    echo "Updated mongodb.uri in config.properties"
  fi
fi

# Verify environment variables are set
if [ -z "$BOT_TOKEN" ]; then
  echo "ERROR: BOT_TOKEN environment variable is not set!"
  echo "Please add your Discord bot token in Replit Secrets."
  exit 1
fi

if [ -z "$MONGO_URI" ]; then
  echo "ERROR: MONGO_URI environment variable is not set!"
  echo "Please add your MongoDB connection string in Replit Secrets."
  exit 1
fi

echo "Environment variables verified."

# Try to run the bot with the RunBot class first
echo "Attempting to start the bot..."
if [ -f "RunBot.class" ]; then
  echo "Found RunBot.class, running directly..."
  java -cp .:./lib/* RunBot
elif [ -f "com/deadside/bot/Main.class" ]; then
  echo "Found Main.class, running directly..."
  java -cp .:./lib/* com.deadside.bot.Main
else
  echo "Compiled classes not found, checking for JAR files..."
  if [ -f "target/deadside-discord-bot-1.0-SNAPSHOT.jar" ]; then
    echo "Found JAR file, running..."
    java -jar target/deadside-discord-bot-1.0-SNAPSHOT.jar
  else
    echo "No executable JAR found. Compiling with java..."
    if [ -f "com/deadside/bot/Main.java" ]; then
      echo "Compiling Main.java..."
      javac -cp .:./lib/* com/deadside/bot/Main.java
      echo "Running compiled Main class..."
      java -cp .:./lib/* com.deadside.bot.Main
    else
      echo "ERROR: Could not find Main.java to compile and run."
      echo "Please ensure the code is properly structured."
      exit 1
    fi
  fi
fi