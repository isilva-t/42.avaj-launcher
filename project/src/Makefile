all:
	find pt -name "*.java" > sources.txt
	javac @sources.txt

run:
	java pt.isilvat.avaj.aircraft.Simulator

clean:
	rm -f sources.txt
	find . -name "*.class" -delete

q:	all run clean
