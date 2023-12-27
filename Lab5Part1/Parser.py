class Parser:
    def __init__(self, grammar, input_string):
        self.grammar = grammar
        self.s = 'q'
        self.i = 0
        self.working_stack = []
        self.input_stack = [self.grammar.S]
        self.input_string = input_string
        self.input_string_initial_length = len(input_string)
        self.accepted = False

    def parse(self):
        while self.s != 'f' and self.s != 'e':
            print(self)
            if self.s == 'q':
                if self.i == self.input_string_initial_length or not self.input_stack:
                    self.success()
                else:
                    if self.input_stack[0] in self.grammar.N:
                        self.expand()
                    elif self.input_stack[0] == self.input_string[self.i]:
                        self.advance()
                    else:
                        self.momentary_insuccess()
            else:
                if self.s == 'b':
                    if self.working_stack[-1][0] in self.grammar.E:
                        self.back()
                    else:
                        self.another_try()

        if self.s == 'e':
            print('error!')
        else:
            print('message accepted!')
            self.accepted=True

        return self.working_stack

    def expand(self):
        print("expand")
        head = self.input_stack[0]
        if head in self.grammar.N:
            self.input_stack.pop(0)
            self.working_stack.append((head, 0))
            if head in self.grammar.P:
                production = self.grammar.P[head][0]  # Considering the first production rule
                self.input_stack = production + self.input_stack
        else:
            print('Head of input stack is not a nonterminal!')
    def advance(self):
        print("advance")
        if self.i < self.input_string_initial_length and self.input_stack[0] == self.input_string[self.i]:
            self.input_stack.pop(0)
            self.working_stack.append((self.input_string[self.i], self.i + 1))
            self.i += 1
        else:
            print("Cannot perform advance!")

    def momentary_insuccess(self):
        head = self.input_stack[0]
        if head != self.input_string[self.i]:
            print("momentary insuccess")
            self.s = "b"

    def back(self):
        if len(self.working_stack) > 0:
            head, index = self.working_stack[-1]
            if head in self.grammar.E:
                print("back")
                self.i = index - 1
                self.input_stack = [head] + self.input_stack
                self.working_stack.pop()
            else:
                print("Cannot perform back!")

    def another_try(self):
        if len(self.working_stack) > 0:
            head, production_index = self.working_stack[-1]
            if head in self.grammar.N:
                print('another try')
                if production_index < len(self.grammar.P[head]) - 1:
                    productions = self.grammar.P[head]
                    production_index += 1
                    production = productions[production_index]
                    self.working_stack[-1] = (head, production_index)
                    self.input_stack = production + self.input_stack
                    self.s = 'q'
                else:
                    print('No other productions left for this nonterminal!')
                    self.s = 'b'  # Set to backtrack if no other productions available
            else:
                print("Cannot perform another try!")

    def success(self):
        if self.s == 'q' and self.i == self.input_string_initial_length or len(self.input_stack) == 0:
            print('Success')
            self.s = 'f'


    def is_accepted(self):
        return self.accepted

    def __str__(self):
        return f"({self.s}, {self.i}, {self.working_stack}, {self.input_stack})"
