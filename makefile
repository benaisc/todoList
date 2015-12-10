CXX = javac
CXXFLAGS =
EXEC = Main
SRC = $(wildcard *.java)

all: $(EXEC)

$(EXEC): $(SRC)
	$(CXX) $(CXXFLAGS) $^

clean:
	rm *.class categories taches taches_archivees

SRCsup = $(wildcard *.java)
NAME = todoList_src.tar.gz

archive:
	tar -czf $(NAME) $(SRCsup) $(SRC) makefile
