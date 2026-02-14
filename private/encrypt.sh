#!/bin/bash

# Colors for output
GREEN='\033[0;32m'
NC='\033[0m' # No Color

# Prompt for password once
echo "Enter encryption password:"
read -s PASSWORD

# Create private folder if doesn't exist
mkdir -p enc

# Encrypt each file in toencrypt/
for file in data/*; do
    if [ -f "$file" ]; then
        filename=$(basename "$file")
        echo "Encrypting: $filename"
        echo "$PASSWORD" | openssl enc -aes-256-cbc -salt -in "$file" -out "enc/${filename}.enc" -pbkdf2 -pass stdin
        echo -e "${GREEN}✓ Created: ${filename}.enc${NC}"
    fi
done

echo -e "\n${GREEN}All files encrypted!${NC}"
