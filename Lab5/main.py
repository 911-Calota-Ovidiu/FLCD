from Grammar import Grammar

if __name__ == '__main__':
    g1=Grammar()
    g2 = Grammar()
    g1.readFromFile("g1.txt")
    g2.readFromFile("g2.txt")

    while True:
        print("Select file:\n1.g1.txt\n2.g2.txt\n0.Exit\n")
        option=input()
        if option=="1":
            print(str(g1))
            if g1.checkCFG():
                print("Grammar g1 is a CFG")
            else:
                print("Grammar g1 is not a CFG")
        elif option=="2":
            print(str(g2))
            if g2.checkCFG():
                print("Grammar g2 is a CFG")
            else:
                print("Grammar g2 is not a CFG")
        elif option=="0":
            print("All is good 👍")
            break
        else:
            print("Invalid option")