#!/bin/bash

DOC_DIR="$(cd "$(dirname "$0")" && pwd)"
PROJECT_ROOT="$(cd "$DOC_DIR/.." && pwd)"
TEMPLATE="$DOC_DIR/README.md"
MERMAID="$DOC_DIR/develop.mermaid"
INIT="$DOC_DIR/sequence_1_init.mermaid"
SIMULATION="$DOC_DIR/sequence_2_simulation.mermaid"

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
INIT_CONTENT=$(cat "$INIT")
SIMULATION_CONTENT=$(cat "$SIMULATION")

INIT_BLOCK="\`\`\`mermaid
$INIT_CONTENT
\`\`\`"

SIMULATION_BLOCK="\`\`\`mermaid
$SIMULATION_CONTENT
\`\`\`"

MERMAID_BLOCK="\`\`\`mermaid
$MERMAID_CONTENT
\`\`\`"

awk -v mermaid="$MERMAID_BLOCK" \
    -v init="$INIT_BLOCK" \
    -v simulation="$SIMULATION_BLOCK" '{
    if ($0 == "MERMAID_HERE") {
        print mermaid
    } else if ($0 == "INITIALIZATION_HERE") {
        print init
    } else if ($0 == "SIMULATION_HERE") {
        print simulation
    } else {
        print $0
    }
}' "$TEMPLATE" > "$OUTPUT"

echo "✅ README.md gerado com sucesso em: $OUTPUT"
