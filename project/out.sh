#!/bin/bash

# Script to concatenate partstock project files for code review/sharing

OUTPUT_FILE="backend.txt"

# Clear the output file if it exists
> "$OUTPUT_FILE"

IGNORE_PATTERNS=(
    '!*.sh'
    '!*.gitkeep'
    '!*.cs'
	'!*.html'
    '!*.enc'
	'!*.js'
	'!*.css'
    '!data/**'
    '!srcs/backend/app/scripts/**'
    '!srcs/backend/static/favicon.ico'
    '!data_to_import/**'
    '!venv/**'
    '!env/**'
    '!.venv/**'
    '!__pycache__/**'
    '!node_modules/**'
    '!.git/**'
    '!*.DS_Store'
    '!*.sqlite'
    '!*.sqlite3'
    '!*.db'
    '!*.md'
    '!*.svg'
    '!*out.sh'
	'!deploy.sh'
    '!partstock-out.sh'
    '!*.png'
    '!*.jpg'
    '!*.jpeg'
    '!*.pyc'
    '!*.pyo'
    '!*.pyd'
    '!*.so'
    '!*.log'
	'!*.ico'
    "!$OUTPUT_FILE"
)

GLOB_ARGS=""
for pattern in "${IGNORE_PATTERNS[@]}"; do
    GLOB_ARGS="$GLOB_ARGS --glob '$pattern'"
done

# Run the main search in the background
eval "rg . --line-number --heading $GLOB_ARGS > \"$OUTPUT_FILE\"" &
search_pid=$!

# Wait for ripgrep to finish
wait $search_pid

# Create the file list
eval "rg . --files $GLOB_ARGS" > /tmp/files_list.txt

# Check and sort file list
if [ -s /tmp/files_list.txt ]; then
    tmp_output=$(mktemp)
    while read -r file; do
        if [ -f "$file" ]; then
            lines=$(wc -l < "$file")
            printf "%4d %s\n" "$lines" "$file"
        fi
    done < /tmp/files_list.txt > "$tmp_output"

    echo ""
    echo "Files sorted by line count (ascending):"
    echo "--------------------------------------"
    sort -n "$tmp_output"
    echo "--------------------------------------"

    rm -f "$tmp_output"
fi

rm -f /tmp/files_list.txt

# Append .env if exists
if [ -f ".env" ]; then
    echo "" >> "$OUTPUT_FILE"
    echo "///// END OF OTHER FILES, \".env\" file is next" >> "$OUTPUT_FILE"
    echo ".env" >> "$OUTPUT_FILE"
    cat ".env" >> "$OUTPUT_FILE"
fi

# Summary output
LINE_COUNT=$(wc -l < "$OUTPUT_FILE")
FILE_COUNT=$(rg --files --glob '!data/**' --glob '!venv/**' --glob '!__pycache__/**' --glob '!node_modules/**' --glob '!.git/**' --glob '!*.DS_Store' --glob "!$OUTPUT_FILE" | wc -l)

echo ""
echo "Files processed: $FILE_COUNT"
echo "Total lines in $OUTPUT_FILE: $LINE_COUNT"
