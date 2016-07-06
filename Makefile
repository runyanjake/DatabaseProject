#
# Makefile for DataBaseProject
# Author: Jake Runyan
# Date: Last Update: Jun 12 2016
#

# Macros
JARFILE		= DatabaseProject
MAINCLASS	= DatabaseProject.java
SOURCES		= DatabaseProject.java DBWindow.java FileCredentials.java FileIO.java HashTableDatabase.java LinkedListTableDatabase.java TableDatabase.java DBPage.java DBTitlePage.java DBLoginPage.java DBHomePage.java
CLASSES		= DatabaseProject.class DBWindow.class FileCredentials.class FileIO.class HashTableDatabase.class LinkedListTableDatabase.class TableDatabase.class DBPage.class DBTitlePage.class DBLoginPage.class DBHomePage.class

# Build Targets

all: $(JARFILE)

$(JARFILE) : $(CLASSES)
	echo Main-class: $(MAINCLASS) > Manifest
	jar cvfm $(JARFILE) Manifest $(CLASSES)
	rm Manifest
	chmod +x $(JARFILE)

$(CLASSES): $(SOURCES)
	javac -Xlint $(SOURCES)  

run:
	java $(JARFILE)

clean:
	rm -f *.class $(JARFILE) Manifest

test:
	make clean
	make
	make run
