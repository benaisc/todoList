CXX = javac
EXEC = Main
SRC = $(wildcard *.java)
SRCc = $(wildcard *.class)
NAME = todoList_src
SRCsup = makefile


all: $(EXEC)

$(EXEC): $(SRC)
	$(CXX) $^

reinit:
	rm taches taches_archivees

clean:
	rm $(SRCc)

archive:
	tar -czf $(NAME) $(SRCsup) $(SRC)

