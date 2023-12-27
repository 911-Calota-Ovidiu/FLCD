import copy

from Parser import Parser


class ParserOutput:
    def __init__(self, parser: Parser):
        self.parser = parser
        self.derivation_list = []

    def getDerivationString(self):
        self.derivation_list = []
        current_derivation = [self.parser.grammar.S]
        parser_output = copy.deepcopy(self.parser.working_stack)
        while parser_output:
            symbol = parser_output[0][0]
            index=-1
            if symbol in self.parser.grammar.N:
                current_derivation_copy=copy.deepcopy(current_derivation)
                self.derivation_list.append(current_derivation_copy)
                for item in parser_output:
                    if item[0]==symbol:
                        index=parser_output.index(item)
                production = self.parser.grammar.getProduction(parser_output[0])
                current_derivation = current_derivation[:index] + [production] + current_derivation[index + 1:]
            parser_output.pop(0)

        if current_derivation:
            self.derivation_list.append(current_derivation)
        resultString = ""
        for production in self.derivation_list:
            if not resultString:
                resultString = ''.join(production)
            else:
                resultString =str(resultString) + " -> " + ''.join(str(production))
        return resultString

    def write_derivation_list_to_file(self, is_accepted, filename='output.txt'):
        if len(self.derivation_list) > 0:
            with open(filename, "w") as myfile:
                for production in self.derivation_list[:-1]:
                    myfile.write(' '.join(str(production)) + " ->")
                myfile.write(' '.join(str(self.derivation_list[-1])))
                myfile.write('\nis accepted: ' + str(is_accepted))