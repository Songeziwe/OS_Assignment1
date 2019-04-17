# Makefile for the OS part 1 assignment
# Songeziwe S. Soboois
# April 16, 2019

JAVAC=/usr/bin/javac

.SUFFIXES: .java .class

.java.class:
	$(JAVAC) $<
classes: Barrier.class BThread.class BarrierTest.class 

default: $(CLASSES)

run:
	java BarrierTest 5 5
clean:
	rm *.class