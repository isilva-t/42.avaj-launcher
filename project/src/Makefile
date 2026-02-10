all:
	find pt -name "*.java" > sources.txt
	javac @sources.txt

run:
	java pt.isilvat.avaj.aircraft.Simulator scenario.txt

sub: all
	java pt.isilvat.avaj.aircraft.Simulator scenario_subject.txt
	$(MAKE) clean

cycles: all
	java pt.isilvat.avaj.aircraft.Simulator scenario_invalid_cycles.txt
	$(MAKE) clean

clean:
	rm -f sources.txt
	find . -name "*.class" -delete

q:	all run clean

t: all
	./tester.sh 
	$(MAKE) clean

r:
	rm simulation.txt
