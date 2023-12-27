class Grammar:
    EPSILON = "epsilon"

    def __init__(self):
        self.N = []
        self.E = []
        self.S = ""
        self.P = {}

    def __processLine(self, line: str):
        # Get what comes after the '='
        return line.strip().split(' ')[2:]

    def readFromFile(self, file_name: str):
        with open(file_name) as file:
            N = self.__processLine(file.readline())
            E = self.__processLine(file.readline())
            S = self.__processLine(file.readline())[0]

            file.readline()  # P =

            # Get all transitions
            P = {}
            for line in file:
                split = line.strip().split('->')
                source = split[0].strip()
                sequence = split[1].lstrip(' ')
                sequence_list = []
                for c in sequence.split(' '):
                    sequence_list.append(c)

                if source in P.keys():
                    P[source].append(sequence_list)
                else:
                    P[source] = [sequence_list]

            self.N = N
            self.E = E
            self.S = S
            self.P = P

    def checkCFG(self):
        hasStartingSymbol = False
        for key in self.P.keys():
            if key == self.S:
                hasStartingSymbol = True
            if key not in self.N:
                return False
        if not hasStartingSymbol:
            return False
        for production in self.P.values():
            for rhs in production:
                for value in rhs:
                    if value not in self.N and value not in self.E and value != Grammar.EPSILON:
                        return False
        return True

    def getProduction(self, production):
        symbol = production[0]
        index = production[1]
        return self.P[symbol][index]
    def __str__(self):
        result = "NonTerminals = " + str(self.N) + "\n"
        result += "Terminals = " + str(self.E) + "\n"
        result += "Source = " + str(self.S) + "\n"
        result += "Transitions = " + str(self.P) + "\n"
        return result