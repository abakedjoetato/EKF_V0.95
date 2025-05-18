#!/bin/bash

echo "=== Starting Deadside Discord Bot with environment variables ==="

# Export environment variables for the bot
export DISCORD_TOKEN="${BOT_TOKEN}"
export MONGODB_URI="${MONGO_URI}"

echo "Environment variables set."
echo "Starting the bot..."

# Run the bot with the appropriate classpath
java -cp .:./lib/*:./target/classes RunBot