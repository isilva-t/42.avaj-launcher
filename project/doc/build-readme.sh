#!/bin/bash

DOC_DIR="$(cd "$(dirname "$0")" && pwd)"
PROJECT_ROOT="$(cd "$DOC_DIR/../.." && pwd)"
TEMPLATE="$DOC_DIR/README.md"
MERMAID="$DOC_DIR/develop.mermaid"
OUTPUT="$PROJECT_ROOT/README.md"

if [ ! -f "$TEMPLATE" ]; then
    echo "❌ Erro: README.md não encontrado em $TEMPLATE"
    exit 1
fi

if [ ! -f "$MERMAID" ]; then
    echo "❌ Erro: develop.mermaid não encontrado em $MERMAID"
    exit 1
fi

MERMAID_CONTENT=$(cat "$MERMAID")

MERMAID_BLOCK="\`\`\`mermaid
$MERMAID_CONTENT
\`\`\`"

awk -v mermaid="$MERMAID_BLOCK" '{
    if ($0 == "MERMAID_HERE") {
        print mermaid
    } else {
        print $0
    }
}' "$TEMPLATE" > "$OUTPUT"

echo "✅ README.md gerado com sucesso em: $OUTPUT"
