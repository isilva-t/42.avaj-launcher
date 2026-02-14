TESTDIR="./tests/"

all:
	find pt -name "*.java" > sources.txt
	javac @sources.txt

run:
	java pt.isilvat.avaj.aircraft.Simulator scenario.txt
	cat simulation.txt

clean:
	rm -f sources.txt
	find . -name "*.class" -delete

fclean:
	rm simulation.txt

q:	all run clean

test: all
	./tester.sh 
