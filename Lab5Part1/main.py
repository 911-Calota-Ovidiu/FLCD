# from Grammar import Grammar
#
# if __name__ == '__main__':
#     g1=Grammar()
#     g2 = Grammar()
#     g1.readFromFile("g1.txt")
#     g2.readFromFile("g2.txt")
#
#     while True:
#         print("Select file:\n1.g1.txt\n2.g2.txt\n0.Exit\n")
#         option=input()
#         if option=="1":
#             print(str(g1))
#             if g1.checkCFG():
#                 print("Grammar g1 is a CFG")
#             else:
#                 print("Grammar g1 is not a CFG")
#         elif option=="2":
#             print(str(g2))
#             if g2.checkCFG():
#                 print("Grammar g2 is a CFG")
#             else:
#                 print("Grammar g2 is not a CFG")
#         elif option=="0":
#             print("All is good 👍")
#             break
#         else:
#             print("Invalid option")
from Grammar import Grammar
from Parser import Parser
from ParserOutput import ParserOutput

def read_sequence_file(file_path):
    try:
        with open(file_path, 'r') as file:
            sequence = file.read().strip().split()  # Read, strip newline characters, and split by spaces
            return sequence
    except FileNotFoundError:
        print(f"File '{file_path}' not found.")
        return []

if __name__ == '__main__':
    g = Grammar()
    g.readFromFile("g1.txt")

    print('test parser: ')
    parser = Parser(g, read_sequence_file("sequence.txt"))
    print(parser)
    parser.parse()
    parser_output = ParserOutput(parser)
    print("Parser output is: ", parser_output.getDerivationString())
    parser_output.write_derivation_list_to_file(parser.is_accepted(), "output.txt")


