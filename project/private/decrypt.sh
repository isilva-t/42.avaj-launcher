#!/bin/bash

# Colors for output
GREEN='\033[0;32m'
NC='\033[0m'

# Prompt for password once
echo "Enter decryption password:"
read -s PASSWORD

# Decrypt each file in private/
for file in *.enc; do
    if [ -f "$file" ]; then
        filename=$(basename "$file" .enc)
        echo "Decrypting: $filename"
        echo "$PASSWORD" | openssl enc -aes-256-cbc -d -in "$file" -out "${filename}" -pbkdf2 -pass stdin
        echo -e "${GREEN}✓ Decrypted: ${filename}${NC}"
    fi
done

echo -e "\n${GREEN}All files decrypted!${NC}"
