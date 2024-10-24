input_data = ""
while True:
    try:
        line = input()
        input_data += line 
    except EOFError:  
        break
numbers = map(int, input_data.split(','))

total_sum = sum(numbers)

print(total_sum)
