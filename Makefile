# Makefile for the OS part 1 assignment
# Songeziwe S. Soboois
# April 16, 2019

JAVAC=/usr/bin/javac

barrierSize=5
numberOfThreads=5

package=BarrierS/

.SUFFIXES: .java .class

.java.class:
	$(JAVAC) $<

classes: $(package)Barrier.class $(package)BThread.class $(package)BarrierTest.class 

default: $(CLASSES)

run:
	java $(package)BarrierTest $(barrierSize) $(numberOfThreads)

clean:
	rm -f $(package)*.class