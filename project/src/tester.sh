#!/bin/bash

GREEN='\033[0;32m'
RED='\033[0;31m'
YELLOW='\033[1;33m'
NC='\033[0m'
WITHOUT="without_permission.txt"
TESTDIR="./tests/"

make
echo "=========================================="
echo "Testing Invalid Filenames"
echo "=========================================="

echo -e "\n${YELLOW}Test: No extension (scenario)${NC}"
java pt.isilvat.avaj.aircraft.Simulator $TESTDIR"01_scenario"

echo -e "\n${YELLOW}Test: Wrong extension (.csv)${NC}"
java pt.isilvat.avaj.aircraft.Simulator $TESTDIR"scenario.csv"

echo -e "\n${YELLOW}Test: Just .txt (no filename)${NC}"
java pt.isilvat.avaj.aircraft.Simulator $TESTDIR".txt"

echo -e "\n${YELLOW}Test: Non-existent file${NC}"
java pt.isilvat.avaj.aircraft.Simulator $TESTDIR"nonexistent.txt"

echo -e "\n${YELLOW}Test: pt/.txt filename${NC}"
java pt.isilvat.avaj.aircraft.Simulator $TESTDIR"pt/.txt"

echo ""
echo "=========================================="
echo "Testing Invalid number of arguments"
echo "=========================================="

echo -e "\n${YELLOW}Test: Without arguments${NC}"
java pt.isilvat.avaj.aircraft.Simulator

echo -e "\n${YELLOW}Test: More than one argument${NC}"
java pt.isilvat.avaj.aircraft.Simulator one two

echo ""
echo "=========================================="
echo "Testing Without file read permissions or no file"
echo "=========================================="

echo -e "\n${YELLOW}Test: Reading file without permissions${NC}"
touch     $WITHOUT
chmod 000 $WITHOUT
java pt.isilvat.avaj.aircraft.Simulator $WITHOUT
chmod 777 $WITHOUT
rm $WITHOUT

echo -e "\n${YELLOW}Test: This file doesn't exist${NC}"
java pt.isilvat.avaj.aircraft.Simulator $TESTDIR"unknown_file.txt"

echo ""
echo "=========================================="
echo "Testing With Invalid Data"
echo "=========================================="

echo -e "\n${YELLOW}Test: Invalid cycles${NC}"
java pt.isilvat.avaj.aircraft.Simulator $TESTDIR"02_invalid_cycles.txt"

echo -e "\n${YELLOW}Test: Invalid Aircraft Type${NC}"
java pt.isilvat.avaj.aircraft.Simulator $TESTDIR"03_invalid_aircraft_type.txt"

echo -e "\n${YELLOW}Test: Invalid longitude${NC}"
java pt.isilvat.avaj.aircraft.Simulator $TESTDIR"04_invalid_longitude.txt"

echo -e "\n${YELLOW}Test: Invalid laitude${NC}"
java pt.isilvat.avaj.aircraft.Simulator $TESTDIR"05_invalid_latitude.txt"

echo -e "\n${YELLOW}Test: Negative height${NC}"
java pt.isilvat.avaj.aircraft.Simulator $TESTDIR"06_negative_height.txt"

echo -e "\n${YELLOW}Test: Height above 100${NC}"
java pt.isilvat.avaj.aircraft.Simulator $TESTDIR"07_height_above_100.txt"

echo -e "\n${YELLOW}Test: Height 0${NC}"
java pt.isilvat.avaj.aircraft.Simulator $TESTDIR"08_height_zero.txt"

echo -e "\n${YELLOW}Test: Height 100${NC}"
java pt.isilvat.avaj.aircraft.Simulator $TESTDIR"09_height_100.txt"

echo ""
echo "=========================================="
echo "Testing Simulation Height Boundaries"
echo "=========================================="

echo -e "\n${YELLOW}Test: Baloon Rain/Snow 0${NC}"
java pt.isilvat.avaj.aircraft.Simulator $TESTDIR"11_baloon_height.txt"

echo -e "\n${YELLOW}Test: Baloon above 100${NC}"
java pt.isilvat.avaj.aircraft.Simulator $TESTDIR"12_baloon_height_2.txt"


echo -e "\n${YELLOW}Test: JetPlane Rain/Snow 0${NC}"
java pt.isilvat.avaj.aircraft.Simulator $TESTDIR"13_jetplane_height.txt"

echo -e "\n${YELLOW}Test: JetPlane above 100${NC}"
java pt.isilvat.avaj.aircraft.Simulator $TESTDIR"14_jetplane_height_2.txt"


echo -e "\n${YELLOW}Test: Helicopter Rain/Snow 0${NC}"
java pt.isilvat.avaj.aircraft.Simulator $TESTDIR"15_helicopter_height.txt"

echo -e "\n${YELLOW}Test: Helicopter above 100${NC}"
java pt.isilvat.avaj.aircraft.Simulator $TESTDIR"16_helicopter_height_2.txt"

echo ""
echo "=========================================="
echo "Testing normal simulations"
echo "=========================================="

echo -e "\n${YELLOW}Test: Another one${NC}"
java pt.isilvat.avaj.aircraft.Simulator $TESTDIR"21_scenario.txt"

echo -e "\n${YELLOW}Test: Another one${NC}"
java pt.isilvat.avaj.aircraft.Simulator $TESTDIR"22_scenario.txt"

echo ""
rm simulation.txt
make clean