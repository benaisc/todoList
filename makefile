CXX = javac
EXEC = Main
SRC = $(wildcard *.java)
CXXjar = jar cvfe todoList.jar Main
SRCc = $(wildcard *.class)
NAME = todoList_src
SRCsup = makefile


all: $(EXEC)

$(EXEC): $(SRC)
	$(CXX) $^

jar: $(SRCc)
	make
	$(CXXjar) $^

init:
	rm taches taches_archivees

clean:
	rm $(SRCc)

archive:
	tar -czf $(NAME) $(SRCsup) $(SRC)
