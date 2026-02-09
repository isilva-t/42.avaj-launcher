#!/bin/bash

GREEN='\033[0;32m'
RED='\033[0;31m'
YELLOW='\033[1;33m'
NC='\033[0m'


echo "=========================================="
echo "Testing Invalid Filenames"
echo "=========================================="

echo -e "\n${YELLOW}Test: No extension (scenario)${NC}"
java pt.isilvat.avaj.aircraft.Simulator scenario

echo -e "\n${YELLOW}Test: Wrong extension (.csv)${NC}"
java pt.isilvat.avaj.aircraft.Simulator scenario.csv

echo -e "\n${YELLOW}Test: Just .txt (no filename)${NC}"
java pt.isilvat.avaj.aircraft.Simulator .txt

echo -e "\n${YELLOW}Test: Non-existent file${NC}"
java pt.isilvat.avaj.aircraft.Simulator nonexistent.txt

echo -e "\n${YELLOW}Test: pt/.txt filename${NC}"
java pt.isilvat.avaj.aircraft.Simulator pt/.txt

echo "=========================================="
echo "Testing Invalid number of arguments"
echo "=========================================="

echo -e "\n${YELLOW}Test: Without arguments${NC}"
java pt.isilvat.avaj.aircraft.Simulator

echo -e "\n${YELLOW}Test: More than one argument${NC}"
java pt.isilvat.avaj.aircraft.Simulator one two

echo "=========================================="
echo "Testing Without file read permissions or no file"
echo "=========================================="

echo -e "\n${YELLOW}Test: Reading file without permissions${NC}"
java pt.isilvat.avaj.aircraft.Simulator without_permission.txt

echo -e "\n${YELLOW}Test: This file doesn't exist${NC}"
java pt.isilvat.avaj.aircraft.Simulator unknown_file.txt